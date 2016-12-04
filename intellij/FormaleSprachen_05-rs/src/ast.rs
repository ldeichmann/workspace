use token;
use std::fmt;

//pub struct AST<T> {
//    token: Option<token::Token>,
//    children: Vec<Box<ast_t>>
//}
//
//pub trait ast_t: fmt::Display {
//    fn get_node_type(&self) -> token::TokenType;
//    fn add_child(&mut self, t: Box<ast_t>);
//    fn is_nil(&self) -> bool;
//    fn get_children(&self) -> &Vec<Box<ast_t>>;
//    fn to_string_tree(&self) -> String {
//        let mut return_string = String::from("");
//        let children = self.get_children();
//
//        if children.len() == 0 {
//            return_string.push_str(self.to_string().as_str())
//
//        } else {
//            if !self.is_nil() {
//                return_string.push_str("(");
//                return_string.push_str(self.to_string().as_str());
//                return_string.push_str(" ");
//            }
//
//            for i in 0..children.len() {
//
//                if i > 0 {
//                    return_string.push_str(" ");
//                }
//                return_string.push_str(children[i].to_string_tree().as_str());
//
//            }
//
//            if !self.is_nil() {
//                return_string.push_str(")");
//            }
//
//        }
//        return_string
//    }
//}
//
//
//impl ast_t for AST {
//
//    fn get_node_type(&self) -> token::TokenType {
//        if let Some(x) = self.token.clone() {
//            return x.token_type;
//        }
//        token::TokenType::Invalid
//    }
//
//    fn add_child(&mut self, t: Box<ast_t>) {
//        self.children.push(t)
//    }
//
//    fn get_children(&self) -> &Vec<Box<ast_t>> {
//        &self.children
//    }
//
//    fn is_nil(&self) -> bool {
//        if let Some(x) = self.token.clone() {
//            false
//        } else {
//            true
//        }
//    }
//}
//
//impl fmt::Display for AST {
//    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
//        if let Some(x) = self.token.clone() {
//            write!(f, "{}", x)
//        } else {
//            write!(f, "nil")
//        }
//    }
//}
//
//impl AST {
//    pub fn add_child_ast(&mut self, t: AST) {
//        self.add_child(Box::new(t))
//    }
//}
//
//pub fn new_ast(tok: Option<token::Token>, tok_type: Option<token::TokenType>) -> AST {
//    if let Some(x) = tok {
//        AST {token: Some(x), children: vec![]}
//    } else if let Some(x) = tok_type {
//        AST {token: Some(token::Token{token_type: x, content: "".to_string()}), children: vec![]}
//    } else {
//        AST {token: None, children: vec![]}
//    }
//}