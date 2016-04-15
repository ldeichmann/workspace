package visitor;

import ExprTree.Atomic;
import ExprTree.Binary;
import ExprTree.Unary;

public class PrintPostorderVisitor implements Visitor {

    @Override
    public void visit(Binary b) {
        b.getLeft().accept(this);
        b.getRight().accept(this);
        System.out.println(b);
    }

    @Override
    public void visit(Atomic c) {
        System.out.println(c);
    }

    @Override
    public void visit(Unary u) {
        u.getChild().accept(this);
        System.out.println(u);
    }
}
