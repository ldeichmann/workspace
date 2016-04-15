package evaluator;

import ExprTree.Add;
import ExprTree.Int;
import ExprTree.Sub;
import ExprTree.UMinus;

public class ExprEvaluator implements Evaluator {


    @Override
    public double eval(Add a) {
        return (a.getLeft().accept(this) + a.getRight().accept(this));
    }

    @Override
    public double eval(Sub s) {
        return (s.getLeft().accept(this) - s.getRight().accept(this));
    }

    @Override
    public double eval(UMinus u) {
        return (-u.getChild().accept(this));
    }

    @Override
    public double eval(Int i) {
        return i.eval();
    }
}
