/** Grammars always start with a grammar header. This grammar is called
* ArrayInit and must match the filename: ArrayInit.g4
*/
grammar ExprLexer_antlr;
/** A rule called init that matches comma-separated values between {...}. */
//init : '{' value (',' value)* '}' ; // must match at least one value
prog: valid_operation+ ;

//valid_operation: (value value binary_operator) | (value unary_operator) ;
valid_operation: valid_operation valid_operation binary_operator
    | valid_operation unary_operator
    | value
    ;

/** A value can be either a nested array/struct or a simple integer (INT) */
//value : init
value: INT ;

binary_operator: plus
| minus
| mul
| div
| pow
;
unary_operator : uminus
;

plus : PLUS ;
minus : MINUS ;
mul : MUL ;
div : DIV ;
pow : POW ;
uminus : UMINUS ;
// parser rules start with lowercase letters, lexer rules with uppercase
INT :
[0-9]+ ;
NL :
[\n] ;
PLUS :
'+' ;
MINUS :
'-' ;
UMINUS :
'#' ;
MUL :
'*' ;
DIV :
'/' ;
POW :
'^' ;
// Define token INT as one or more digits
WS :
[ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out