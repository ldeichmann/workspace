package visitor;

import ExprTree.Expr;
import ExprTree.Postfix;

@SuppressWarnings("Duplicates")
public class TestIndepVisitors {
    public static void main(String[] args) {
        String test = "1 2 + 3 # -\n";
        Postfix tb = new Postfix(test);
        Expr exprTree;
        IndepPrintInorderVisitor piv = new IndepPrintInorderVisitor();
        IndepPrintPreorderVisitor prev = new IndepPrintPreorderVisitor();
        IndepPrintPostorderVisitor prov = new IndepPrintPostorderVisitor();
        try {
            System.out.println("eval teststring: " + test);
            exprTree = tb.evalPostfix();
            System.out.println("printInorder");
            piv.print(exprTree);
            System.out.println();
            System.out.println("printPreorder");
            prev.print(exprTree);
            System.out.println();
            System.out.println("printPostorder");
            prov.print(exprTree);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
