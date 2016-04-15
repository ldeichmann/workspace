package ExprTree;

public class Test {
    public static void main(String[] args) {
        String test = "1 2 + 3 # - 3 +\n";
        Postfix tb = new Postfix(test);
        Expr exprTree;
        try {
            System.out.println("eval teststring: " + test);
            exprTree = tb.evalPostfix();
            System.out.println("printInorder");
            exprTree.printInorder();
            System.out.println();
            System.out.println("Embedded Walker: eval");
            System.out.println(exprTree.eval());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
