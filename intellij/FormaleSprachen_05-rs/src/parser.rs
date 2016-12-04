use lexer;
use token;
use nodes;
use nodes::AstTrait;
use nodes::BinaryTrait;
use nodes::UnaryTrait;

pub struct Parser<'a> {
    lexer: &'a mut lexer::Lexer,
    lookahead: token::Token,
    root: nodes::Nodes
}

impl<'a> Parser<'a> {

    pub fn get_root(self) -> nodes::Nodes {
        self.root
    }

    pub fn consume(&mut self) {
        if let Some(x) = self.lexer.next_token() {
            self.lookahead = x.clone();
        }
    }

    pub fn match_token(&mut self, t: token::TokenType) {
        if self.lookahead.token_type == t {
//            println!("Matching {}", t);
            self.consume();
        } else {
            println!("Expected {}, found {}", t, self.lookahead.token_type)
        }
    }


    pub fn statlist(&mut self) {
        loop {
            if self.lookahead.token_type != token::TokenType::EOF {
                if let Some(x) = self.stat() {
                    self.root.add_child(x);
                }
            } else {
                break;
            }
        }
    }

    pub fn stat(&mut self) -> Option<nodes::Nodes> {
        if self.lookahead.token_type == token::TokenType::NL {
            self.match_token(token::TokenType::NL);
            None
        } else {
            let n = self.sum();
            self.match_token(token::TokenType::NL);
            Some(n)
        }
    }

    pub fn sum(&mut self) -> nodes::Nodes {
        let mut n = self.prod();

        loop {
            match self.lookahead.token_type {
                token::TokenType::ADD => {
                    let t = self.lookahead.clone();
                    self.match_token(token::TokenType::ADD);
                    n = nodes::Nodes::new_bin(n, t, self.prod());
                },
                token::TokenType::SUB => {
                    let t = self.lookahead.clone();
                    self.match_token(token::TokenType::SUB);
                    n = nodes::Nodes::new_bin(n, t, self.prod());
                },
                _ => {
                    break;
                }
            }
        }
        n
    }

    pub fn prod(&mut self) -> nodes::Nodes {
        let mut n = self.term();

        loop {
            match self.lookahead.token_type {
                token::TokenType::MUL => {
                    let t = self.lookahead.clone();
                    self.match_token(token::TokenType::MUL);
                    n = nodes::Nodes::new_bin(n, t, self.term());

                },
                token::TokenType::DIV => {
                    let t = self.lookahead.clone();
                    self.match_token(token::TokenType::DIV);
                    n = nodes::Nodes::new_bin(n, t, self.term());
                },
                _ => {
                    break;
                }
            }
        }
        n
    }

    pub fn term(&mut self) -> nodes::Nodes {
        match self.lookahead.token_type {
            token::TokenType::ADD => {
                let t = self.lookahead.clone();
                self.match_token(token::TokenType::ADD);
                let n = self.term();
                nodes::Nodes::new_un(n, t)
            },
            token::TokenType::SUB => {
                let mut t = self.lookahead.clone();
                t.token_type = token::TokenType::UMINUS;
                self.match_token(token::TokenType::SUB);
                let n = self.term();
                nodes::Nodes::new_un(n, t)
            },
            token::TokenType::LBRACE => {
                self.match_token(token::TokenType::LBRACE);
                let n = self.sum();
                self.match_token(token::TokenType::RBRACE);
                n
            },
            token::TokenType::INT => {
                let t = self.lookahead.clone();
                self.match_token(token::TokenType::INT);
                nodes::Nodes::new(Some(t))
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
        lexer: lex,
        lookahead: la,
        root: nodes::Nodes::new(None)
    };

    parser
}