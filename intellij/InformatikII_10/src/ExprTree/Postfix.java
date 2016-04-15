package ExprTree;

import Stack.Stack;
import Stack.ListStack;
import lexer.ExprLexer;
import lexer.Token;

//Klasse Postfix mit der Methode evalPostfix
public class Postfix extends ExprLexer{
    //Konstruktor
    public Postfix(String text) {
        super(text);
    }

    //Methode zum Berechnen eines Postfixausdruckes
    public Expr evalPostfix() throws Exception{
        Stack<Expr> tokenStack = new ListStack<Expr>();

        Token currentToken = nextToken();
        Expr v1, v2;

        while (currentToken.getType() != ExprLexer.NL) {
            switch (currentToken.getType()) {
                case ExprLexer.INT:
                    Expr integer = new Int(currentToken);
                    tokenStack.push(integer);
                    break;

                case ExprLexer.PLUS:
                    v1 = tokenStack.popTop();
                    v2 = tokenStack.popTop();
                    Expr plus = new Add(v1, currentToken, v2);
                    tokenStack.push(plus);
                    break;

                case ExprLexer.MINUS:
                    v1 = tokenStack.popTop();
                    v2 = tokenStack.popTop();
                    Expr minus = new Sub(v2, currentToken, v1);
                    tokenStack.push(minus);
                    break;

                case ExprLexer.UMINUS:
                    v1 = tokenStack.popTop();
                    Expr uminus = new UMinus(v1, currentToken);
                    tokenStack.push(uminus);
                    break;

                default:
                    throw new Exception("Wrong Token detected");
            }
            currentToken = nextToken();
        }
        return tokenStack.popTop();
    }


}