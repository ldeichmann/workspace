use token;
use std::fmt;

#[derive(PartialEq, Clone)]
pub enum EvalType {
    TInvalid,
    TInteger,
    TVector
}

pub enum Nodes {
    AddNode(Box<Nodes>),
    SubNode(Box<Nodes>),
    MulNode(Box<Nodes>),
    DivNode(Box<Nodes>),
    IntNode(Box<Nodes>),
    UMinusNode(Box<Nodes>),
    ExprNode(EvalType, Box<Nodes>),
    AST(Option<token::Token>, Vec<Box<Nodes>>)
}

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
    fn new_expr(token::Token) -> Self;
    fn get_eval_type(&self) -> EvalType;
}

pub trait BinaryTrait: ExprTrait {
    fn new_bin(Nodes, token::Token, Nodes) -> Self;
}

pub trait UnaryTrait: ExprTrait {
    fn new_un(Nodes, token::Token) -> Self;
}

impl AstTrait for Nodes {
    fn new(t: Option<token::Token>) -> Self {
        if let Some(x) = t {
            match x.token_type {
                token::TokenType::ADD |
                token::TokenType::DIV |
                token::TokenType::MUL |
                token::TokenType::SUB => {
                    let tmp = x.clone();
                    let a = Nodes::AST(Some(x), vec![]);
                    let b = Nodes::ExprNode(EvalType::TInvalid, Box::new(a));
                    match tmp.token_type {
                        token::TokenType::ADD => Nodes::AddNode(Box::new(b)),
                        token::TokenType::SUB => Nodes::SubNode(Box::new(b)),
                        token::TokenType::MUL => Nodes::MulNode(Box::new(b)),
                        token::TokenType::DIV => Nodes::DivNode(Box::new(b)),
                        // This should never happen
                        _ => unimplemented!()
                    }
                },
                token::TokenType::INT => {
                    let a = Nodes::AST(Some(x), vec![]);
                    let b = Nodes::ExprNode(EvalType::TInteger, Box::new(a));
                    Nodes::IntNode(Box::new(b))
                },
                _ => {
                    Nodes::AST(Some(x), vec![])
                }

            }
        } else {
            Nodes::AST(None, vec![])
        }
    }

    fn get_node_type(&self) -> token::TokenType {
        if !self.is_nil() {
            match *self {
                Nodes::AST(ref to, _) => {
                    to.clone().unwrap().token_type
                },
                Nodes::ExprNode(_, ref n) |
                Nodes::AddNode(ref n) |
                Nodes::SubNode(ref n) |
                Nodes::MulNode(ref n) |
                Nodes::DivNode(ref n) |
                Nodes::UMinusNode(ref n) |
                Nodes::IntNode(ref n) => n.get_node_type(),
            }
        } else {
            token::TokenType::Invalid
        }
    }

    fn add_child(&mut self, t: Nodes) {
        match *self {
            Nodes::AST(_, ref mut vn) => {
                vn.push(Box::new(t))
            },
            Nodes::ExprNode(_, ref mut n) |
            Nodes::AddNode(ref mut n) |
            Nodes::SubNode(ref mut n) |
            Nodes::MulNode(ref mut n) |
            Nodes::DivNode(ref mut n) |
            Nodes::UMinusNode(ref mut n) |
            Nodes::IntNode(ref mut n) => {
                n.add_child(t)
            },
        }
    }

    fn is_nil(&self) -> bool {
        match *self {
            Nodes::AST(ref to, _) => {
                if let Some(_) = to.clone() {
                    false
                } else {
                    true
                }
            },
            Nodes::ExprNode(_, ref n) |
            Nodes::AddNode(ref n) |
            Nodes::SubNode(ref n) |
            Nodes::MulNode(ref n) |
            Nodes::DivNode(ref n) |
            Nodes::UMinusNode(ref n) |
            Nodes::IntNode(ref n) => n.is_nil(),
        }
    }

    fn get_children(&self) -> &Vec<Box<Nodes>> {
        match *self {
            Nodes::AST(_, ref vn) => vn,
            Nodes::ExprNode(_, ref n) |
            Nodes::AddNode(ref n) |
            Nodes::SubNode(ref n) |
            Nodes::MulNode(ref n) |
            Nodes::DivNode(ref n) |
            Nodes::UMinusNode(ref n) |
            Nodes::IntNode(ref n) => n.get_children(),
        }
    }
}

impl fmt::Display for Nodes {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let printable = match *self {
            Nodes::AddNode(ref n) |
            Nodes::SubNode(ref n) |
            Nodes::MulNode(ref n) |
            Nodes::DivNode(ref n) |
            Nodes::UMinusNode(ref n) |
            Nodes::IntNode(ref n) => n.to_string(),
            Nodes::ExprNode(ref e, ref n) => {
                let mut a = n.to_string();
                let t = e.clone();
                if t != EvalType::TInvalid {
                    let b = if t == EvalType::TInteger { "<type=TInteger>" } else { "<type=TVector>" };
                    a.push_str(b);
                }
                a
            },
            Nodes::AST(ref t, _) => {
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

impl ExprTrait for Nodes {
    fn new_expr(t: token::Token) -> Self {
        Nodes::new(Some(t))
    }

    fn get_eval_type(&self) -> EvalType {
        match *self {
            Nodes::AddNode(ref n) |
            Nodes::SubNode(ref n) |
            Nodes::MulNode(ref n) |
            Nodes::DivNode(ref n) => {
                let c_all = n.get_children();
                let ref left = c_all[0];
                let ref right = c_all[1];

                if left.get_eval_type() == EvalType::TInteger && right.get_eval_type() == EvalType::TInteger {
                    EvalType::TInteger
                } else if left.get_eval_type() == EvalType::TVector && right.get_eval_type() == EvalType::TVector {
                    EvalType::TVector
                } else {
                    EvalType::TInvalid
                }
            },
            Nodes::UMinusNode(ref n) => {
                n.get_children()[0].get_eval_type()
            }
            Nodes::IntNode(_) => {
                EvalType::TInteger
            },
            Nodes::ExprNode(_, _) => {
                unimplemented!()
            },
            Nodes::AST(_, _) => {
                unimplemented!()
            },
        }
    }
}

impl BinaryTrait for Nodes {
    fn new_bin(l: Nodes, t: token::Token, r: Nodes) -> Self {
        match t.token_type {
            token::TokenType::ADD |
            token::TokenType::DIV |
            token::TokenType::MUL |
            token::TokenType::SUB => {
                let tmp = t.clone();
                let a = Nodes::AST(Some(t), vec![]);
                let mut b = Nodes::ExprNode(EvalType::TInvalid, Box::new(a));
                b.add_child(l);
                b.add_child(r);
                match tmp.token_type {
                    token::TokenType::ADD => Nodes::AddNode(Box::new(b)),
                    token::TokenType::SUB => Nodes::SubNode(Box::new(b)),
                    token::TokenType::MUL => Nodes::MulNode(Box::new(b)),
                    token::TokenType::DIV => Nodes::DivNode(Box::new(b)),
                    // This should never happen
                    _ => unimplemented!()
                }
            },
            _ => unimplemented!()
        }
    }
}

impl UnaryTrait for Nodes {
    fn new_un(l: Nodes, t: token::Token) -> Self {
        match t.token_type {
            token::TokenType::UMINUS |
            token::TokenType::INT => {
                let tmp = t.clone();
                let a = Nodes::AST(Some(t), vec![]);
                let mut b = Nodes::ExprNode(EvalType::TInvalid, Box::new(a));
                b.add_child(l);
                match tmp.token_type {
                    token::TokenType::INT => Nodes::IntNode(Box::new(b)),
                    token::TokenType::UMINUS => Nodes::UMinusNode(Box::new(b)),
                    // This should never happen
                    _ => unimplemented!()
                }
            },
            _ => unimplemented!()
        }
    }
}

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
//            eval_type: expr_node::TInteger
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
//            eval_type: expr_node::TInteger
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