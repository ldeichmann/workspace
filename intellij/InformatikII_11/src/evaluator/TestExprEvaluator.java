package evaluator;

import ExprTree.Expr;
import ExprTree.Postfix;
import visitor.PrintInorderVisitor;
import visitor.PrintPostorderVisitor;
import visitor.PrintPreorderVisitor;

@SuppressWarnings("Duplicates")
public class TestExprEvaluator {

    public static void main(String[] args) {
        String test = "1 2 + 3 # -\n";
        Postfix tb = new Postfix(test);
        Expr exprTree;
        ExprEvaluator exev = new ExprEvaluator();
        try {
            System.out.println("eval teststring: " + test);
            exprTree = tb.evalPostfix();
            System.out.println("printInorder");
            System.out.println(exprTree.accept(exev));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
