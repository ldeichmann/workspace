use token;
use std::fmt;

#[derive(PartialEq, Clone)]
pub enum EvalType {
    T_INVALID,
    T_INTEGER,
    T_VECTOR
}

pub enum Nodes {
    AddNode(Box<Nodes>),
    SubNode(Box<Nodes>),
    MulNode(Box<Nodes>),
    DivNode(Box<Nodes>),
    IntNode(Box<Nodes>),
    ExprNode(EvalType, Box<Nodes>),
    AST(Option<token::Token>, Vec<Box<Nodes>>)
}
//
//pub struct AST {
//    token: Option<token::Token>,
//    children: Vec<Box<Nodes>>
//}

pub trait AstTrait: fmt::Display {
    fn new(Option<token::Token>) -> Self;
    fn get_node_type(&self) -> token::TokenType;
    fn add_child(&mut self, t: Nodes);
    fn is_nil(&self) -> bool;
    fn get_children(&self) -> &Vec<Box<Nodes>>;
    fn to_string_tree(&self) -> String {
        let mut return_string = String::from("");
        let children = self.get_children();

        if children.len() == 0 {
            return_string.push_str(self.to_string().as_str())

        } else {
            if !self.is_nil() {
                return_string.push_str("(");
                return_string.push_str(self.to_string().as_str());
                return_string.push_str(" ");
            }

            for i in 0..children.len() {

                if i > 0 {
                    return_string.push_str(" ");
                }
                return_string.push_str(children[i].to_string_tree().as_str());

            }

            if !self.is_nil() {
                return_string.push_str(")");
            }

        }
        return_string
    }
}

pub trait ExprTrait: AstTrait {
    fn new(token::Token) -> Self;
    fn get_eval_type(&self) -> EvalType;
}

pub trait BinaryTrait: ExprTrait {
    fn new(Box<Nodes>, token::Token, Box<Nodes>) -> Self;
}

pub trait UnaryTrait: ExprTrait {
    fn new(Box<Nodes>, token::Token) -> Self;
}

impl AstTrait for Nodes {
    fn new(t: Option<token::Token>) -> Self {
        if let Some(x) = t {
            match x.token_type {
                token::TokenType::ADD => {
                    let a = Nodes::AST(Some(x), vec![]);
                    let b = Nodes::ExprNode(EvalType::T_INVALID, Box::new(a));
                    Nodes::AddNode(Box::new(b))
                },
                token::TokenType::INT => {
                    let a = Nodes::AST(Some(x), vec![]);
                    let b = Nodes::ExprNode(EvalType::T_INTEGER, Box::new(a));
                    Nodes::IntNode(Box::new(b))
                },
                _ => {
                    Nodes::AST(Some(x), vec![])
                }

            }
        } else {
            unimplemented!()
        }
    }

    fn get_node_type(&self) -> token::TokenType {
        unimplemented!()
    }

    fn add_child(&mut self, t: Nodes) {
        match *self {
            Nodes::AST(ref to, ref mut vn) => {
                vn.push(Box::new(t))
            },
            Nodes::ExprNode(ref e, ref mut n) => {
                n.add_child(t)
            },
            Nodes::AddNode(ref mut n) => {
                n.add_child(t)
            },
            _ => unimplemented!()
        }
    }

    fn is_nil(&self) -> bool {
        match *self {
            Nodes::AST(ref to, ref vn) => {
                if let Some(x) = to.clone() {
                    false
                } else {
                    true
                }
            },
            Nodes::ExprNode(ref e, ref n) => n.is_nil(),
            Nodes::AddNode(ref n) => n.is_nil(),
            _ => unimplemented!()
        }
    }

    fn get_children(&self) -> &Vec<Box<Nodes>> {
        match *self {
            Nodes::AST(ref to, ref vn) => vn,
            Nodes::ExprNode(ref e, ref n) => n.get_children(),
            Nodes::AddNode(ref n) => n.get_children(),
            Nodes::IntNode(ref n) => n.get_children(),
            _ => unimplemented!()
        }
    }
}

impl fmt::Display for Nodes {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let printable = match *self {
            Nodes::AddNode(ref n) => n.to_string(),
            Nodes::SubNode(ref n) => n.to_string(),
            Nodes::MulNode(ref n) => n.to_string(),
            Nodes::DivNode(ref n) => n.to_string(),
            Nodes::IntNode(ref n) => n.to_string(),
            Nodes::ExprNode(ref e, ref n) => {
                let mut a = n.to_string();
                let t = e.clone();
                if t != EvalType::T_INVALID {
                    let b = if t == EvalType::T_INTEGER { "<type=T_INTEGER>" } else { "<type=T_VECTOR>" };
                    a.push_str(b);
                }
                a
            },
            Nodes::AST(ref t, ref vn) => {
                if let Some(x) = t.clone() {
                    x.to_string()
                } else {
                    "nil".to_string()
                }
            },
        };
        write!(f, "{}", printable)
    }
}

//impl ast_trait for Nodes::ExprNode {
//
//}


//use ast::{ast_t, new_ast};
//use expr_node::{ExprNode, expr_node_t};
//use expr_node;
//use token;
//use std::fmt;
//
//pub struct AddNode {
//    expr: ExprNode,
//}
//
//pub struct SubNode {
//    expr: ExprNode
//}
//
//pub struct MulNode {
//    expr: ExprNode
//}
//
//pub struct DivNode {
//    expr: ExprNode
//}
//
//pub struct IntNode {
//    expr: ExprNode
//}
//
//impl expr_node_t for AddNode {
//    fn getEvalType(&self) -> i32 {
//        self.expr.getEvalType()
//    }
//
//    fn new(t: token::Token) -> Self {
//        let a = ExprNode {
//            ast: new_ast(Some(t), None),
//            eval_type: expr_node::T_INTEGER
//        };
//        AddNode {
//            expr: a
//        }
//    }
//}
//
//impl expr_node_t for IntNode {
//    fn getEvalType(&self) -> i32 {
//        self.expr.getEvalType()
//    }
//
//    fn new(t: token::Token) -> Self {
//        let a = ExprNode {
//            ast: new_ast(Some(t), None),
//            eval_type: expr_node::T_INTEGER
//        };
//        IntNode {
//            expr: a
//        }
//    }
//}
//
//impl ast_t for AddNode {
//    fn get_node_type(&self) -> token::TokenType {
//        self.expr.get_node_type()
//    }
//
//    fn add_child(&mut self, t: Box<ast_t>) {
//        self.expr.add_child(t)
//    }
//
//    fn get_children(&self) -> &Vec<Box<ast_t>> {
//        self.expr.get_children()
//    }
//
//    fn is_nil(&self) -> bool {
//        self.expr.is_nil()
//    }
//}
//
//impl ast_t for IntNode {
//    fn get_node_type(&self) -> token::TokenType {
//        self.expr.get_node_type()
//    }
//
//    fn add_child(&mut self, t: Box<ast_t>) {
//        self.expr.add_child(t)
//    }
//
//    fn get_children(&self) -> &Vec<Box<ast_t>> {
//        self.expr.get_children()
//    }
//
//    fn is_nil(&self) -> bool {
//        self.expr.is_nil()
//    }
//}
//
//impl fmt::Display for AddNode {
//    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
//        write!(f, "{}", self.expr)
//    }
//}
//
//impl fmt::Display for IntNode {
//    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
//        write!(f, "{}", self.expr)
//    }
//}
//
//
//fn new_add_node<T: expr_node_t>(left: Box<T>, t: token::Token, right: Box<T>) -> AddNode {
//    let a = AddNode::new(t);
//    a.add_child(left);
//    a.add_child(right);
//    a
//}