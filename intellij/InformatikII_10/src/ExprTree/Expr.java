package ExprTree;

import evaluator.Evaluator;
import lexer.Token;
import visitor.Visitor;

public abstract class Expr extends Node {

    public Expr(Token token) {
        super(token);
    }

    public abstract void printInorder();

    public abstract double eval();

    public abstract void accept(Visitor v);

    public abstract double accept(Evaluator e);
}

