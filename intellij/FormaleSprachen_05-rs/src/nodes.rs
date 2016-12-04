use ast::{ast_t, new_ast};
use expr_node::{ExprNode, expr_node_t};
use expr_node;
use token;
use std::fmt;

pub struct AddNode {
    expr: ExprNode,
}

pub struct SubNode {
    expr: ExprNode
}

pub struct MulNode {
    expr: ExprNode
}

pub struct DivNode {
    expr: ExprNode
}

pub struct IntNode {
    expr: ExprNode
}

impl expr_node_t for AddNode {
    fn getEvalType(&self) -> i32 {
        self.expr.getEvalType()
    }

    fn new(t: token::Token) -> Self {
        let a = ExprNode {
            ast: new_ast(Some(t), None),
            eval_type: expr_node::T_INTEGER
        };
        AddNode {
            expr: a
        }
    }
}

impl expr_node_t for IntNode {
    fn getEvalType(&self) -> i32 {
        self.expr.getEvalType()
    }

    fn new(t: token::Token) -> Self {
        let a = ExprNode {
            ast: new_ast(Some(t), None),
            eval_type: expr_node::T_INTEGER
        };
        IntNode {
            expr: a
        }
    }
}

impl ast_t for AddNode {
    fn get_node_type(&self) -> token::TokenType {
        self.expr.get_node_type()
    }

    fn add_child(&mut self, t: Box<ast_t>) {
        self.expr.add_child(t)
    }

    fn get_children(&self) -> &Vec<Box<ast_t>> {
        self.expr.get_children()
    }

    fn is_nil(&self) -> bool {
        self.expr.is_nil()
    }
}

impl ast_t for IntNode {
    fn get_node_type(&self) -> token::TokenType {
        self.expr.get_node_type()
    }

    fn add_child(&mut self, t: Box<ast_t>) {
        self.expr.add_child(t)
    }

    fn get_children(&self) -> &Vec<Box<ast_t>> {
        self.expr.get_children()
    }

    fn is_nil(&self) -> bool {
        self.expr.is_nil()
    }
}

impl fmt::Display for AddNode {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "{}", self.expr)
    }
}

impl fmt::Display for IntNode {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "{}", self.expr)
    }
}


fn new_add_node<T: expr_node_t>(left: Box<T>, t: token::Token, right: Box<T>) -> AddNode {
    let a = AddNode::new(t);
    a.add_child(left);
    a.add_child(right);
    a
}