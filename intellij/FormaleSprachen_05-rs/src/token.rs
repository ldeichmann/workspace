use std::fmt;

#[derive(Debug, PartialEq, Clone)]
pub enum TokenType {
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

#[derive(Debug, Clone)]
pub struct Token {
    pub token_type: TokenType,
    pub content: String
}

impl fmt::Display for Token {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "<{}, {}>", self.token_type, self.content)
    }
}