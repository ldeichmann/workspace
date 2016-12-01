use token;
use std::fmt;

pub struct AST<'b> {
    token: Option<token::Token>,
    children: Vec<&'b mut AST<'b>>
}

impl<'b> AST<'b> {

    pub fn get_node_type(&self) -> token::TokenType {
        if let Some(x) = self.token.clone() {
            return x.token_type;
        }
        token::TokenType::Invalid
    }

    pub fn add_child(&mut self, t: &'b mut AST<'b>) {
        self.children.push(t)
    }

    pub fn is_nil(&self) -> bool {
        if let Some(x) = self.token.clone() {
            false
        } else {
            true
        }
    }

    pub fn to_string_tree(&self) -> String {
        let mut return_string = String::from("");

        if self.children.len() == 0 {
            return_string.push_str(self.to_string().as_str())

        } else {
            if !self.is_nil() {
                return_string.push_str("(");
                return_string.push_str(self.to_string().as_str());
                return_string.push_str(" ");
            }

            for i in 0..self.children.len() {

                if i > 0 {
                    return_string.push_str(" ");
                }
                return_string.push_str(self.children[i].to_string_tree().as_str());

            }

                if !self.is_nil() {
                return_string.push_str(")");
            }

        }

        println!("len {}", self.children.len());

        return_string
    }

}

impl<'b> fmt::Display for AST<'b> {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        if let Some(x) = self.token.clone() {
            write!(f, "{}", x)
        } else {
            write!(f, "nil")
        }
    }
}

pub fn new_ast<'b>(tok: Option<token::Token>, tok_type: Option<token::TokenType>) -> AST<'b> {
    if let Some(x) = tok {
        AST {token: Some(x), children: vec![]}
    } else if let Some(x) = tok_type {
        AST {token: Some(token::Token{token_type: x, content: "".to_string()}), children: vec![]}
    } else {
        AST {token: None, children: vec![]}
    }
}