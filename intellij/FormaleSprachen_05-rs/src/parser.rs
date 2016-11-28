use lexer;
use token;

pub struct Parser<'a> {
    lexer: &'a mut lexer::Lexer,
    lookahead: token::Token
}

impl<'a> Parser<'a> {

    pub fn consume(&mut self) {
        if let Some(x) = self.lexer.next_token() {
            self.lookahead = x.clone();
        }
    }

    pub fn match_token(&mut self, t: token::TokenType) {
        if self.lookahead.token_type == t {
            println!("Matching {}", t);
            self.consume();
        } else {
            println!("Expected {}, found {}", t, self.lookahead.token_type)
        }
    }


    pub fn statlist(&mut self) {
        loop {
            if self.lookahead.token_type != token::TokenType::EOF {
                self.stat();
            } else {
                break;
            }
        }
    }

    pub fn stat(&mut self) {
        if self.lookahead.token_type == token::TokenType::NL {
            self.match_token(token::TokenType::NL);
        } else {
            self.sum();
            self.match_token(token::TokenType::NL);
        }
    }

    pub fn sum(&mut self) {
        self.prod();

        loop {
            match self.lookahead.token_type {
                token::TokenType::ADD => {
                    self.match_token(token::TokenType::ADD);
                    self.prod();
                },
                token::TokenType::SUB => {
                    self.match_token(token::TokenType::SUB);
                    self.prod();
                },
                _ => {
                    break;
                }
            }
        }
    }

    pub fn prod(&mut self) {
        self.term();

        loop {
            match self.lookahead.token_type {
                token::TokenType::MUL => {
                    self.match_token(token::TokenType::MUL);
                    self.term();
                },
                token::TokenType::DIV => {
                    self.match_token(token::TokenType::DIV);
                    self.term();
                },
                _ => {
                    break;
                }
            }
        }
    }

    pub fn term(&mut self) {
        match self.lookahead.token_type {
            token::TokenType::ADD => {
                self.match_token(token::TokenType::ADD);
                self.term();
            },
            token::TokenType::SUB => {
                self.match_token(token::TokenType::SUB);
                self.term();
            },
            token::TokenType::LBRACE => {
                self.match_token(token::TokenType::LBRACE);
                self.sum();
                self.match_token(token::TokenType::RBRACE);
            },
            token::TokenType::INT => {
                self.match_token(token::TokenType::INT);
            }
            _ => {
                println!("Can't handle {} in term", self.lookahead.token_type);
                panic!("Couldn't handle term {}", self.lookahead.token_type);
            }
        }
    }

}


pub fn new_parser(lex: &mut lexer::Lexer) -> Parser {

    let la = lex.next_token().unwrap().clone();

    let parser = Parser {
        lexer: lex, lookahead: la
    };

    parser
}