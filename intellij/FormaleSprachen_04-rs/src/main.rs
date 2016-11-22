use std::fmt;
use std::str::Chars;
use std::io::{stdin,stdout,Write};

#[derive(Debug,PartialEq,Clone)]
enum TokenType {
    Invalid,
    EOF,
    INT,
    NL,
    ADD,
    SUB,
    MUL,
    DIV,
    RBRACE,
    LBRACE
}

impl fmt::Display for TokenType {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "{:?}", self)
    }
}

#[derive(Debug,Clone)]
struct Token {
    token_type: TokenType,
    content: String
}

impl fmt::Display for Token {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "<{}, {}>", self.token_type, self.content)
    }
}

struct Lexer {
    content: String,
    pos: usize,
    tokens: Vec<Token>
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
//            ' ' | '\n' | '\t' => println!("Trash {}", x),
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

fn new_lexer(string: String) -> Lexer {

    Lexer { content: string, pos: 0, tokens: vec![]}

}


struct Parser<'a> {
    lexer: &'a mut Lexer,
    lookahead: Token
}

impl<'a> Parser<'a> {

    pub fn consume(&mut self) {
        if let Some(x) = self.lexer.next_token() {
            self.lookahead = x.clone();
        }
    }

    pub fn match_token(&mut self, t: TokenType) {
        if self.lookahead.token_type == t {
//            println!("Matching {}", t);
            self.consume();
        } else {
            println!("Expected {}, found {}", t, self.lookahead.token_type);
            panic!("Expected {}, found {}", t, self.lookahead.token_type);
        }
    }


    pub fn statlist(&mut self) {
        loop {
            if self.lookahead.token_type != TokenType::EOF {
                self.stat();
            } else {
                break;
            }
        }
    }

    pub fn stat(&mut self) {
        if self.lookahead.token_type == TokenType::NL {
            self.match_token(TokenType::NL);
        } else {
            self.sum();
            self.match_token(TokenType::NL);
        }
    }

    pub fn sum(&mut self) {
        self.prod();

        loop {
            match self.lookahead.token_type {
                TokenType::ADD => {
                    self.match_token(TokenType::ADD);
                    self.prod();
                },
                TokenType::SUB => {
                    self.match_token(TokenType::SUB);
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
                TokenType::MUL => {
                    self.match_token(TokenType::MUL);
                    self.term();
                },
                TokenType::DIV => {
                    self.match_token(TokenType::DIV);
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
            TokenType::ADD => {
                self.match_token(TokenType::ADD);
                self.term();
            },
            TokenType::SUB => {
                self.match_token(TokenType::SUB);
                self.term();
            },
            TokenType::LBRACE => {
                self.match_token(TokenType::LBRACE);
                self.sum();
                self.match_token(TokenType::RBRACE);
            },
            TokenType::INT => {
                self.match_token(TokenType::INT);
            }
            _ => {
                println!("Can't handle {} in term", self.lookahead.token_type);
                panic!("Couldn't handle term {}", self.lookahead.token_type);
            }
        }
    }

}


fn new_parser(lex: &mut Lexer) -> Parser {

    let la = lex.next_token().unwrap().clone();

    let parser = Parser {
        lexer: lex, lookahead: la
    };

    parser
}

fn main() {
    let mut s=String::new();
    print!("Please enter some text: ");
    let _=stdout().flush();
    stdin().read_line(&mut s).expect("Did not enter a correct string");

//    let mut lex = new_lexer("-5-5 + 5 - 3 / 2 \n (5-2)/2 \n 4+ \n".to_string());
    let mut lex = new_lexer(s);
    lex.lex();
    println!("{:?}", lex.tokens);
    while let Some(i) = lex.next_token() {
        println!("{}", i);
    }
    lex.reset_counter();
    let mut parser: Parser = new_parser(&mut lex);
    parser.statlist();
}

#[test]
fn test_lexer() {
    let mut lex = new_lexer("-5-5 \n".to_string());
    lex.lex();
    assert!(lex.tokens[0].token_type == TokenType::SUB);
    assert!(lex.tokens[1].token_type == TokenType::INT);
    assert!(lex.tokens[2].token_type == TokenType::SUB);
    assert!(lex.tokens[3].token_type == TokenType::INT);
    assert!(lex.tokens[4].token_type == TokenType::NL);
    assert!(lex.tokens[5].token_type == TokenType::EOF);

}

#[test]
fn test_parser() {
    let mut lex = new_lexer("-5-5 + 5 - 3 / 2 \n (5-2)/2 \n 4+1 \n".to_string());
    lex.lex();
    let mut parser: Parser = new_parser(&mut lex);
    parser.statlist();
    assert!(true);
}

#[test]
#[should_panic]
fn test_parser_error() {
    let mut lex = new_lexer("-5-5+ \n".to_string());
    lex.lex();
    let mut parser: Parser = new_parser(&mut lex);
    parser.statlist();
}