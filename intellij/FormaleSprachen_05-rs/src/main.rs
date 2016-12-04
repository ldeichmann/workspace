mod token;
mod lexer;
mod parser;
mod ast;
mod expr_node;
mod nodes;

use nodes::AstTrait;

//use ast::ast_t;
//use ast::AST;
//use expr_node::expr_node_t;

//fn main() {
//    let mut lex = lexer::new_lexer("-5-5 + 5 - 3 / 2 \n (5-2)/2 \n 4 \n".to_string());
//    lex.lex();
//    println!("{:?}", lex.tokens);
//    while let Some(i) = lex.next_token() {
//        println!("{}", i);
//    }
//    lex.reset_counter();
//    let mut par: parser::Parser = parser::new_parser(&mut lex);
//    par.statlist();
//}


fn main() {

    let t1 = token::Token{token_type: token::TokenType::ADD, content: "+".to_string()};
    let t2 = token::Token{token_type: token::TokenType::DIV, content: "/".to_string()};
    let t3 = token::Token{token_type: token::TokenType::SUB, content: "-".to_string()};
    let t4 = token::Token{token_type: token::TokenType::MUL, content: "*".to_string()};
    let t5 = token::Token{token_type: token::TokenType::MUL, content: "*".to_string()};
    let t6 = token::Token{token_type: token::TokenType::INT, content: "5".to_string()};

    let mut a = nodes::Nodes::new(Some(t1));
    let mut b = nodes::Nodes::new(Some(t6));

    a.add_child(b);

    println!("{}", a.to_string_tree())


//    let mut a = ast::new_ast(Some(t1), None);
//    let mut b = ast::new_ast(Some(t2), None);
//    let mut c = ast::new_ast(Some(t3), None);
//    let mut d = ast::new_ast(Some(t4), None);
//
//    let mut e = expr_node::ExprNode::new(t5);
//
//    let mut f = nodes::IntNode::new(t6);
//
//    c.add_child(d);
//    a.add_child(c);
//    a.add_child(Box::new(e));
//    a.add_child(Box::new(f));
//
//    println!("{}", a.to_string_tree());
//
//    a.fuck();
}

#[test]
fn test_lexer() {
    let mut lex = lexer::new_lexer("-5-5 \n".to_string());
    lex.lex();
    assert!(lex.tokens[0].token_type == Token::TokenType::SUB);
    assert!(lex.tokens[1].token_type == Token::TokenType::INT);
    assert!(lex.tokens[2].token_type == Token::TokenType::SUB);
    assert!(lex.tokens[3].token_type == Token::TokenType::INT);
    assert!(lex.tokens[4].token_type == Token::TokenType::NL);
    assert!(lex.tokens[5].token_type == Token::TokenType::EOF);

}

#[test]
fn test_parser() {
    let mut lex = lexer::new_lexer("-5-5 + 5 - 3 / 2 \n (5-2)/2 \n 4+1 \n".to_string());
    lex.lex();
    let mut par: parser::Parser = parser::new_parser(&mut lex);
    par.statlist();
    assert!(true);
}

#[test]
#[should_panic]
fn test_parser_error() {
    let mut lex = lexer::new_lexer("-5-5+ \n".to_string());
    lex.lex();
    let mut par: parser::Parser = parser::new_parser(&mut lex);
    par.statlist();
}