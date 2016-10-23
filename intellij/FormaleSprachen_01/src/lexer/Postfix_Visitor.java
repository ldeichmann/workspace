package lexer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by cru on 10/23/16.
 */
public class Postfix_Visitor {


    public static int evalPostfix(String PostfixString) throws Exception {

        CharStream input = null;
        input = new ANTLRInputStream(PostfixString);
        ExprLexer_antlrLexer lexer = new ExprLexer_antlrLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprLexer_antlrParser parser = new ExprLexer_antlrParser(tokens);
        ParseTree tree = parser.prog();

        ExprVisitor visit = new ExprVisitor();
        return visit.visit(tree);
    }

    public static void main(String[] args) throws Exception {
        System.out.print("3 7 - : ");
        System.out.println(evalPostfix("3 7 -"));
        System.out.print("16 4 /: ");
        System.out.println(evalPostfix("16 4 /"));
        System.out.print("2 4 + 2 ^ 2 4 + /: ");
        System.out.println(evalPostfix("2 4 + 2 ^ 2 4 + /"));
    }
}