package ExprTree;

import evaluator.Evaluator;
import lexer.Token;
import visitor.Visitor;

public class Int extends Atomic {

    public Int(Token token) {
        super(token);
    }

    public double eval() {
        return Double.parseDouble(getToken().getText());
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
