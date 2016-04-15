package evaluator;

import ExprTree.*;

public class IndepExprEvaluator {

    public double eval(Expr e) {
        String eClass = e.getClass().getName();
        if (eClass.equals("ExprTree.Add")) {
            return eval((Add) e);
        } else if (eClass.equals("ExprTree.Sub")) {
            return eval((Sub) e);
        } else if (eClass.equals("ExprTree.Int")) {
            return eval((Int) e);
        } else if (eClass.equals("ExprTree.UMinus")) {
            return eval((UMinus) e);
        }
        return 0.0;
    }

    public double eval(Add a) {
        return (eval(a.getLeft()) + eval(a.getRight()));
    }

    public double eval(Sub s) {
        return (eval(s.getLeft()) - eval(s.getRight()));
    }

    public double eval(UMinus u) {
        return -(eval(u.getChild()));
    }

    public double eval(Int i) {
        return i.eval();
    }
}
