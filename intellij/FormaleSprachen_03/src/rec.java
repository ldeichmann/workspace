/**
 * Created by cru on 11/7/16.
 */

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import recognizer.recognizerLexer;
import recognizer.recognizerParser;
import recognizer.recognizerVisitor;

import java.util.HashMap;
import java.util.Map;

public class rec {

    Map<String, Double> variables = new HashMap<>();

    public static Double evalScript(CharStream input) {
//        CharStream input = null;
//        input = new ANTLRInputStream(evalString);
        recognizerLexer lexer = new recognizerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        recognizerParser parser = new recognizerParser(tokens);
        ParseTree tree = parser.script();

        recVisitor visit = new recVisitor();
        return visit.visit(tree);


    }



    public static void main(String[] args) throws Exception {
//        System.out.println(evalScript("5 + 5;"));
//        System.out.println(evalScript("hans = 5 + 5; 5-hans;"));
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
//    Stack<>

}
