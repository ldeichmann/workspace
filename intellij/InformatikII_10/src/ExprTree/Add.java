package ExprTree;

import evaluator.Evaluator;
import lexer.Token;
import visitor.Visitor;

public class Add extends Binary {

    public Add(Expr left, Token t, Expr right) {
        super(left, t, right);
    }

    @Override
    public double eval() {
        return getLeft().eval() + getRight().eval();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public double accept(Evaluator e) {
        return e.eval(this);
    }
}
