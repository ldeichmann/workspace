import gen.calcLexer;
import gen.calcParser;
import gen.calcVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calculator {
    public static Double evalScript(CharStream input) {
        calcLexer lexer = new calcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        calcParser parser = new calcParser(tokens);
        ParseTree tree = parser.script();

        CalculatorVisitor visit = new CalculatorVisitor();
        return visit.visit(tree);
    }

    public static void main(String[] args) throws Exception {
        try {
            CharStream input = null;
            if (args.length > 0) {
                input = new ANTLRFileStream(args[0]);
            } else {
                input = new ANTLRInputStream(System.in);
            }
            System.out.println(evalScript(input));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
