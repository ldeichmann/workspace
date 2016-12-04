mod token;
mod lexer;
mod parser;
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

    let mut lex = lexer::new_lexer("-5-5 + 5 - 3 / 2 \n (5-2)/2 \n 4 \n".to_string());
    lex.lex();
    lex.reset_counter();
    let mut par = parser::new_parser(&mut lex);
    par.statlist();

    let n = par.get_root();

    println!("{}", n.to_string_tree())

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