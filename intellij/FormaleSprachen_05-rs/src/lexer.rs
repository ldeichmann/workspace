use token::Token as Token;
use token::TokenType as TokenType;
use std::str::Chars;

pub struct Lexer {
    content: String,
    pos: usize,
    pub tokens: Vec<Token>
}

impl Lexer {

    pub fn lex(&mut self) {
        self.pos = 0;
        let copy = self.content.clone();
        let mut it = copy.chars();

        loop {
            match it.next() {
                Some(x) => {
                    self.match_char(x, &mut it)
                },
                None => { break }
            }
        }
        self.tokens.push(Token { token_type: TokenType::EOF, content: "EOF".to_string() });
    }

    pub fn match_char(&mut self, x: char, iter: &mut Chars) {
        match x {
            ' ' | '\t' => {},
            '\n' => { self.tokens.push(Token { token_type: TokenType::NL, content: "NL".to_string() });  },
            '*' => { self.tokens.push(Token { token_type: TokenType::MUL, content: "*".to_string() });  },
            '/' => { self.tokens.push(Token { token_type: TokenType::DIV, content: "/".to_string() });  },
            '+' => { self.tokens.push(Token { token_type: TokenType::ADD, content: "+".to_string() });  },
            '-' => { self.tokens.push(Token { token_type: TokenType::SUB, content: "-".to_string() }); },
            '(' => { self.tokens.push(Token { token_type: TokenType::LBRACE, content: "(".to_string() });  },
            ')' => { self.tokens.push(Token { token_type: TokenType::RBRACE, content: ")".to_string() }); },
            _ => {
                if self.is_digit(x) {
                    self.int(iter, x);
                } else {
                    self.tokens.push(Token { token_type: TokenType::Invalid, content: x.to_string() });
                }
            }
        }
    }

    pub fn reset_counter(&mut self) {
        self.pos = 0;
    }

    pub fn next_token(&mut self) -> Option<&Token> {
        if self.pos < self.tokens.len() {
            let ref tok = self.tokens[self.pos];
            self.pos = self.pos + 1;
            return Some(tok);
        }
        None
    }

    pub fn is_digit(&self, c: char) -> bool {
        match c.to_string().parse::<i32>() {
            Ok(_) => true,
            Err(_) => false,
        }
    }

    pub fn int(&mut self, iter: &mut Chars, c: char) {
        let mut hello = String::from(c.to_string());
        loop {
            match iter.next() {
                Some(x) => {
                    if self.is_digit(x) {
                        hello.push(x);
                    } else {
                        self.tokens.push(Token { token_type: TokenType::INT, content: hello });
                        self.match_char(x, iter);
                        break;
                    }
                },
                None => {
                    self.tokens.push(Token { token_type: TokenType::INT, content: hello });
                    break;
                }
            }
        }
    }
}

pub fn new_lexer(string: String) -> Lexer {

    Lexer { content: string, pos: 0, tokens: vec![]}

}