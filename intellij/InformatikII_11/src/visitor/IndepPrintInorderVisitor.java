package visitor;

import ExprTree.Atomic;
import ExprTree.Binary;
import ExprTree.Expr;
import ExprTree.Unary;

/**
 * Created by lukas on 4/15/16.
 */
public class IndepPrintInorderVisitor {

    @SuppressWarnings("Duplicates")
    public void print(Expr e) {
        String eClass = e.getClass().getName();
        if (eClass.equals("ExprTree.Add") || eClass.equals("ExprTree.Sub")) {
            print((Binary) e);
        } else if (eClass.equals("ExprTree.Int")) {
            print((Atomic) e);
        } else if (eClass.equals("ExprTree.UMinus")) {
            print((Unary) e);
        }
    }

    public void print(Binary b) {
        print(b.getLeft());
        System.out.println(b);
        print(b.getRight());
    }


    public void print(Atomic c) {
        System.out.println(c);
    }


    public void print(Unary u) {
        System.out.println(u);
        print(u.getChild());
    }
}
