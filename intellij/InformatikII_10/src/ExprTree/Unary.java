package ExprTree;

import lexer.Token;

public abstract class Unary extends Expr{

    private Expr child;
    public Unary(Expr child,Token token) {
        super(token);
        this.setChild(child);
        // TODO Auto-generated constructor stub
    }
    public Expr getChild() {
        return child;
    }
    private void setChild(Expr child) {
        this.child = child;
    }

    public void printInorder() {
        System.out.print(getToken());
        System.out.print(getChild().getToken());
    }
}
