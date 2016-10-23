package lexer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

import java.util.Stack;

/**
 * Created by cru on 10/23/16.
 */
public class Postfix_Tokens {

    public static int evalPostfix(String PostfixString) throws Exception {

        Stack<Integer> tokenStack = new Stack<>();
        CharStream input = new ANTLRInputStream(PostfixString);;
        // Pick an input stream (filename from commandline or stdin)
        ExprLexer_antlrLexer lex = new ExprLexer_antlrLexer(input);
        Token t = lex.nextToken();
        int v1, v2;
        while (t.getType()!= Token.EOF) {//ExprLexer.EOF works as well
//            System.out.printf("%2d:%2d Typ-Code: %2d Lexem: %s\n",
//                    t.getLine(),
//                    t.getCharPositionInLine(),
//                    t.getType(),
//                    t.getText());
            switch (t.getType()) {
                /**
                 * binary operators
                 */
                case ExprLexer_antlrLexer.PLUS:
                    v2 = tokenStack.pop();
                    v1 = tokenStack.pop();
                    tokenStack.push(v1+v2);
                    break;

                case ExprLexer_antlrLexer.MINUS:
                    v2 = tokenStack.pop();
                    v1 = tokenStack.pop();
                    tokenStack.push(v1-v2);
                    break;

                case ExprLexer_antlrLexer.MUL:
                    v2 = tokenStack.pop();
                    v1 = tokenStack.pop();
                    tokenStack.push(v1*v2);
                    break;

                case ExprLexer_antlrLexer.DIV:
                    v2 = tokenStack.pop();
                    v1 = tokenStack.pop();
                    tokenStack.push(v1/v2);
                    break;

                case ExprLexer_antlrLexer.POW:
                    v2 = tokenStack.pop();
                    v1 = tokenStack.pop();
                    tokenStack.push((int)Math.pow(v1,v2));
                    break;


                /**
                 * unary operators
                 */
                case ExprLexer_antlrLexer.UMINUS:
                    v1 = tokenStack.pop();
                    tokenStack.push(-v1);
                    break;

                case ExprLexer_antlrLexer.INT:
                    tokenStack.push(Integer.parseInt(t.getText()));
                    break;
            }

            t = lex.nextToken();
        }
        return tokenStack.pop();
    }

    public static void main(String[] args) throws Exception {
        System.out.print("3 7 - : ");
        System.out.println(evalPostfix("3 7 -"));
        System.out.print("16 4 /: ");
        System.out.println(evalPostfix("16 4 /"));
        System.out.print("2 4 + 2 ^ 2 4 + /: ");
        System.out.println(evalPostfix("2 4 + 2 ^ 2 4 + /"));
    }
}
