package interior;

import java.io.FileInputStream;
import java.io.InputStream;

import cymbol.CymbolBaseListener;
import cymbol.CymbolLexer;
import cymbol.CymbolParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class interior {

    public static class ComplexityCounter extends CymbolBaseListener {

        ParseTreeProperty<Integer> values = new ParseTreeProperty<>();

        @Override
        public void exitFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
            int val = 1;
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (values.get(ctx.getChild(i)) != null) {
                        val = val * getValue(ctx.getChild(i));
                }
            }
            System.out.println("Function: " + ctx.ID().toString());
            System.out.println("Complexity: " + val);
        }

        @Override
        public void exitBlock(CymbolParser.BlockContext ctx) {
            int val = 0;
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (values.get(ctx.getChild(i)) != null) {
                    if (ctx.getChild(i).getChild(0).getText().equals("if")) {
                        if (val == 0) {
                            val = getValue(ctx.getChild(i));
                        } else {
                            val = val * getValue(ctx.getChild(i));
                        }
                    } else {
//                        System.out.println("Update block " + ctx.getText() + " adding " + ctx.getChild(i).getChild(0));
                        val += getValue(ctx.getChild(i));
                    }
//                    System.out.println("Update block " + ctx.getText() + " to " + val + " because " + ctx.getChild(i).getText());
                }
            }
//            System.out.println("Setting block " + ctx.getText() + " to " + val);
            if (val != 0) {
                setValue(ctx, val);
            }
        }

        @Override
        public void exitStat(CymbolParser.StatContext ctx) {
//            System.out.println(ctx.getChild(0));
            if (ctx.getChild(0).getText().equals("for")) {
                int val = 2;
                for (int i = 0; i < ctx.getChildCount(); i++) {
                    if (values.get(ctx.getChild(i)) != null) {
                        if (val == 0) {
                            val = getValue(ctx.getChild(i));
                        } else {
                            val = val * getValue(ctx.getChild(i));
                        }
                    }
                }
//                System.out.println("Setting for to " + val);
                if (val != 2) {
                    setValue(ctx, val);
                }
            }
            else if (ctx.getChild(0).getText().equals("if")) {
                int pow = 1;
                int forks = 1;
                for (int i = 1; i < ctx.getChildCount(); i++) {
                    if (values.get(ctx.getChild(i)) != null) {
                        pow = pow * getValue(ctx.getChild(i));
                    } else
                    if (ctx.getChild(i).getText().equals("else")) {
                        forks++;
                    }
                }
                if (forks == 2) forks = 1;
//                System.out.println("Setting if " + ctx.getText() + " to " + (pow+forks));
                setValue(ctx, pow+forks);
            } else {
                int val;
                if (values.get(ctx) != null) {
                    val = getValue(ctx);
                } else {
                    val = 0;
                }
                for (int i = 0; i < ctx.getChildCount(); i++) {
                    if (values.get(ctx.getChild(i)) != null) {
                        if (val == 0) {
                            val = getValue(ctx.getChild(i));
                        } else {
                            val = val * getValue(ctx.getChild(i));
                        }
                    }
                }
                if (val != 0) {
                    setValue(ctx, Math.abs(val));
                }
            }
        }

        public void setValue(ParseTree node, int value) {
            values.put(node, value);
        }

        public int getValue(ParseTree node) {
            return values.get(node);
        }
    }

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream(is);
        CymbolLexer lexer = new CymbolLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CymbolParser parser = new CymbolParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.file();

//        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        ComplexityCounter ccount = new ComplexityCounter();
        walker.walk(ccount, tree);
//        System.out.println("complexity = " + ccount.getValue(tree));
    }

}
