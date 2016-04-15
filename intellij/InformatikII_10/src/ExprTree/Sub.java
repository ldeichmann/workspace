package ExprTree;

import evaluator.Evaluator;
import lexer.Token;
import visitor.Visitor;

public class Sub extends Binary{

    public Sub(Expr left, Token t, Expr right) {
        super(left, t, right);
    }

    public double eval() {
        return getLeft().eval() - getRight().eval();
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

