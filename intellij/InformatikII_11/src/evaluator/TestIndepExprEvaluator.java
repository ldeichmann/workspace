package evaluator;

import ExprTree.Expr;
import ExprTree.Postfix;

@SuppressWarnings("Duplicates")
public class TestIndepExprEvaluator {

    public static void main(String[] args) {
        String test = "1 2 + 3 # -\n";
        Postfix tb = new Postfix(test);
        Expr exprTree;
        IndepExprEvaluator exev = new IndepExprEvaluator();
        try {
            System.out.println("eval teststring: " + test);
            exprTree = tb.evalPostfix();
            System.out.println("printInorder");
            System.out.println(exev.eval(exprTree));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
