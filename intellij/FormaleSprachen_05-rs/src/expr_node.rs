//use ast::{ast_t, new_ast, AST};
//use token;
//use std::fmt;
//
////pub struct ExprNode {
////
////}
//
//pub const T_INVALID: i32 = 0;
//pub const T_INTEGER: i32 = 1;
//pub const T_VECTOR: i32 = 2;
//
//pub struct ExprNode {
//    pub ast: AST,
//    pub eval_type: i32
//}
//
//pub trait expr_node_t: ast_t {
//
//    fn getEvalType(&self) -> i32;
//    fn new(t: token::Token) -> Self;
//
//}
//
//impl expr_node_t for ExprNode {
//    fn getEvalType(&self) -> i32 {
//        self.eval_type
//    }
//
//    fn new(t: token::Token) -> Self {
//        ExprNode { ast: new_ast(Some(t), None) , eval_type: T_INVALID }
//    }
//
//}
//
//impl ast_t for ExprNode {
//    fn get_node_type(&self) -> token::TokenType {
//        self.ast.get_node_type()
//    }
//
//    fn add_child(&mut self, t: Box<ast_t>) {
//        self.ast.add_child(t)
//    }
//
//    fn get_children(&self) -> &Vec<Box<ast_t>> {
//        self.ast.get_children()
//    }
//
//    fn is_nil(&self) -> bool {
//        self.ast.is_nil()
//    }
//}
//
//impl fmt::Display for ExprNode {
//    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
//        if self.eval_type != T_INVALID {
//            let b = if self.eval_type == T_INTEGER { "<type=T_INTEGER>" } else { "<type=T_VECTOR>" };
//            write!(f, "{}{}", self.ast, b)
//        } else {
//            write!(f, "{}", self.ast)
//        }
//
//    }
//}