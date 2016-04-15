package ExprTree;

import evaluator.Evaluator;
import lexer.Token;
import visitor.Visitor;

public class UMinus extends Unary {

    public UMinus(Expr child, Token token) {
        super(child, token);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double eval() {
        return -(getChild().eval());
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
