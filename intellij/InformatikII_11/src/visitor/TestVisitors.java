package visitor;

import ExprTree.Expr;
import ExprTree.Postfix;

@SuppressWarnings("Duplicates")
public class TestVisitors {

    public static void main(String[] args) {
        String test = "1 2 + 3 # -\n";
        Postfix tb = new Postfix(test);
        Expr exprTree;
        PrintInorderVisitor piv = new PrintInorderVisitor();
        PrintPreorderVisitor prev = new PrintPreorderVisitor();
        PrintPostorderVisitor prov = new PrintPostorderVisitor();
        try {
            System.out.println("eval teststring: " + test);
            exprTree = tb.evalPostfix();
            System.out.println("printInorder");
            exprTree.accept(piv);
            System.out.println();
            System.out.println("printPreorder");
            exprTree.accept(prev);
            System.out.println();
            System.out.println("printPostorder");
            exprTree.accept(prov);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
