use nodes;
use nodes::{AstTrait};

pub trait Visitor<T> {
    fn visit(&self, Box<nodes::Nodes>) -> T;
}

pub struct EvalVisitor;

pub struct StringVisitor;

impl Visitor<f32> for EvalVisitor {
    fn visit(&self, no: Box<nodes::Nodes>) -> f32 {
        match *no {
            nodes::Nodes::AddNode(ref n) => {
                let c = n.get_children();
                let c0 = c[0].clone();
                let c1 = c[1].clone();
                self.visit(c0) + self.visit(c1)
            },
            nodes::Nodes::SubNode(ref n) => {
                let c = n.get_children();
                let c0 = c[0].clone();
                let c1 = c[1].clone();
                self.visit(c0) - self.visit(c1)
            },
            nodes::Nodes::MulNode(ref n) => {
                let c = n.get_children();
                let c0 = c[0].clone();
                let c1 = c[1].clone();
                self.visit(c0) * self.visit(c1)
            },
            nodes::Nodes::DivNode(ref n) => {
                let c = n.get_children();
                let c0 = c[0].clone();
                let c1 = c[1].clone();
                self.visit(c0) / self.visit(c1)
            },
            nodes::Nodes::UMinusNode(ref n) => {
                let c = n.get_children();
                let c0 = c[0].clone();
                -self.visit(c0)
            },
            nodes::Nodes::ExprNode(_, ref n) |
            nodes::Nodes::IntNode(ref n) => {
                self.visit(n.clone())
            },
            nodes::Nodes::AST(ref t, _) => {
                let to = t.clone();
//                println!("{}", no);
                match to {
                    Some(x) => {
//                        println!("{}", x);
                        match x.content.parse::<f32>() {
                            Ok(y) => y,
                            Err(_) => unimplemented!()
                        }
                    },
                    None => {
                        let c = no.get_children();
                        let c0 = c[0].clone();
                        self.visit(c0)
                    }
                }
            }
        }
    }
}

impl Visitor<String> for StringVisitor {
    fn visit(&self, no: Box<nodes::Nodes>) -> String {
        match *no {
            nodes::Nodes::AddNode(ref n) => {
                let c = n.get_children();
                let c0 = c[0].clone();
                let c1 = c[1].clone();
                let mut a = String::new();
                a.push_str(self.visit(c0).as_str());
                a.push_str(" + ");
                a.push_str(self.visit(c1).as_str());
                a
            },
            nodes::Nodes::SubNode(ref n) => {
                let c = n.get_children();
                let c0 = c[0].clone();
                let c1 = c[1].clone();
                let mut a = String::new();
                a.push_str(self.visit(c0).as_str());
                a.push_str(" - ");
                a.push_str(self.visit(c1).as_str());
                a
            },
            nodes::Nodes::MulNode(ref n) => {
                let c = n.get_children();
                let c0 = c[0].clone();
                let c1 = c[1].clone();
                let mut a = String::new();
                a.push_str(self.visit(c0).as_str());
                a.push_str(" * ");
                a.push_str(self.visit(c1).as_str());
                a
            },
            nodes::Nodes::DivNode(ref n) => {
                let c = n.get_children();
                let c0 = c[0].clone();
                let c1 = c[1].clone();
                let mut a = String::new();
                a.push_str(self.visit(c0).as_str());
                a.push_str(" / ");
                a.push_str(self.visit(c1).as_str());
                a
            },
            nodes::Nodes::UMinusNode(ref n) => {
                let c = n.get_children();
                let c0 = c[0].clone();
                let mut a = String::new();
                a.push_str(" -");
                a.push_str(self.visit(c0).as_str());
                a
            },
            nodes::Nodes::ExprNode(_, ref n) |
            nodes::Nodes::IntNode(ref n) => {
                self.visit(n.clone())
            },
            nodes::Nodes::AST(ref t, _) => {
                let to = t.clone();
//                println!("{}", no);
                match to {
                    Some(x) => {
                        x.content
                    },
                    None => {
                        let c = no.get_children();
                        let c0 = c[0].clone();
                        self.visit(c0)
                    }
                }
            }
        }
    }
}