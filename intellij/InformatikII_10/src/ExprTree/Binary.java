package ExprTree;

import lexer.Token;

public abstract class Binary extends Expr {

    private Expr left;
    private Expr right;

    public Binary(Expr left, Token t, Expr right) {
        super(t);
        this.setLeft(left);
        this.setRight(right);
    }

    public Expr getLeft() {
        return left;
    }

    private void setLeft(Expr left) {
        this.left = left;
    }

    public Expr getRight() {
        return right;
    }

    private void setRight(Expr right) {
        this.right = right;
    }

    public void printInorder() {
        getLeft().printInorder();
        System.out.print(getToken());
        getRight().printInorder();
    }

}

