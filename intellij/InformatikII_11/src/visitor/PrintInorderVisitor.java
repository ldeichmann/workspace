package visitor;

import ExprTree.Atomic;
import ExprTree.Binary;
import ExprTree.Unary;

public class PrintInorderVisitor implements Visitor {

    @Override
    public void visit(Binary b) {
        b.getLeft().accept(this);
        System.out.println(b);
        b.getRight().accept(this);
    }

    @Override
    public void visit(Atomic c) {
        System.out.println(c);
    }

    @Override
    public void visit(Unary u) {
        System.out.println(u);
        u.getChild().accept(this);
    }


}

