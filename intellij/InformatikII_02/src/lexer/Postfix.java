package lexer;

import Stack.ListStack;
import Stack.Stack;

public class Postfix {
    /**
     * evaluates a postfix string containing the Operators listed in ExprLexer
     * @see lexer.ExprLexer
     * @param PostfixString
     * @return
     */
    public static int evalPostfix(String PostfixString) {

        Stack<Token> tokenStack = new ListStack<Token>();
        ExprLexer luthlexor = new ExprLexer(PostfixString);

        Token currentToken = luthlexor.nextToken();
        int v1, v2;

        while (currentToken.getType() != ExprLexer.EOF_TYPE) {

            switch ( currentToken.getType() ) {
                /**
                 * binary operators
                  */
                case ExprLexer.PLUS:
                    v2 = Integer.parseInt(tokenStack.popTop().getText());
                    v1 = Integer.parseInt(tokenStack.popTop().getText());
                    tokenStack.push(new Token(ExprLexer.INT, String.valueOf(v1 + v2)));
                    break;

                case ExprLexer.MINUS:
                    v2 = Integer.parseInt(tokenStack.popTop().getText());
                    v1 = Integer.parseInt(tokenStack.popTop().getText());
                    tokenStack.push(new Token(ExprLexer.INT, String.valueOf(v1 - v2)));
                    break;

                case ExprLexer.MUL:
                    v2 = Integer.parseInt(tokenStack.popTop().getText());
                    v1 = Integer.parseInt(tokenStack.popTop().getText());
                    tokenStack.push(new Token(ExprLexer.INT, String.valueOf(v1 * v2)));
                    break;

                case ExprLexer.DIV:
                    v2 = Integer.parseInt(tokenStack.popTop().getText());
                    v1 = Integer.parseInt(tokenStack.popTop().getText());
                    tokenStack.push(new Token(ExprLexer.INT, String.valueOf(v1 / v2)));
                    break;

                case ExprLexer.POW:
                    v2 = Integer.parseInt(tokenStack.popTop().getText());
                    v1 = Integer.parseInt(tokenStack.popTop().getText());
                    tokenStack.push(new Token(ExprLexer.INT, String.valueOf((int) Math.pow(v1, v2))));
                    break;


                /**
                 * unary operators
                 */
                case ExprLexer.UMINUS:
                    v1 = Integer.parseInt(tokenStack.popTop().getText());
                    tokenStack.push(new Token(ExprLexer.INT, String.valueOf(-v1)));
                    break;

                case ExprLexer.INT:
                    tokenStack.push(currentToken);
                    break;

                case ExprLexer.NL:
                    System.out.print("Result: ");
                    System.out.println(tokenStack.top().getText());
                    return Integer.parseInt(tokenStack.popTop().getText());

            }

            currentToken = luthlexor.nextToken();

        }

        return -1;
    }


}
