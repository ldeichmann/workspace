mod token;
mod lexer;
mod parser;
mod ast;

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

    let mut d = ast::new_ast(Some(t4), None);
    let mut b = ast::new_ast(Some(t2), None);
    let mut c = ast::new_ast(Some(t3), None);
    let mut a = ast::new_ast(Some(t1), None);

    c.add_child(&mut d);
    a.add_child(&mut c);
//    a.add_child(&mut b);

    println!("{}", a.to_string_tree());

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