package visitor;

import ExprTree.Atomic;
import ExprTree.Binary;
import ExprTree.Unary;

public interface Visitor {
    void visit(Binary b);
    void visit(Unary u);
    void visit(Atomic c);
}
