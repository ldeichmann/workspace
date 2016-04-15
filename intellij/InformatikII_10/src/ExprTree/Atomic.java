package ExprTree;

import lexer.Token;

public abstract class Atomic extends Expr{

    public Atomic(Token token) {
        super(token);
    }


    public void printInorder() {
        System.out.print(getToken());
    }
}
