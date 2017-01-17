package mccabe;

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

public class mccabe {

    public static class ComplexityCounter extends CymbolBaseListener {

        ParseTreeProperty<Integer> values = new ParseTreeProperty<>();

        @Override
        public void exitFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
            int val = 0;
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (values.get(ctx.getChild(i)) != null) {
                    val = val + getValue(ctx.getChild(i));
                }
            }
            System.out.println("Function: " + ctx.ID().toString());
            System.out.println("Complexity: " + (val+1));
        }

        @Override
        public void exitBlock(CymbolParser.BlockContext ctx) {
            int val = 0;
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (values.get(ctx.getChild(i)) != null) {
                    val = val + getValue(ctx.getChild(i));
                }
            }
            setValue(ctx, val);
        }

        @Override
        public void exitStat(CymbolParser.StatContext ctx) {
//            System.out.println(ctx.getChild(0));
            if (ctx.getChild(0).getText().equals("for")) {
//                System.out.println(ctx.getChild(0));
//                setValue(ctx, 2);
            }
            else if (ctx.getChild(0).getText().equals("if")) {
//                System.out.println(ctx.getChild(0));
                setValue(ctx, 1);
                for (int i = 0; i < ctx.getChildCount(); i++) {
                    if (ctx.getChild(i).getText().equals("else")) {
                        setValue(ctx, getValue(ctx) + 1);
//                        System.out.println(ctx.getChild(i));
                    }
                }
            }
            int val = 0;
            if (values.get(ctx) != null) {
                val = getValue(ctx);
            }
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (values.get(ctx.getChild(i)) != null) {
                    val = val + getValue(ctx.getChild(i));
                }
            }
            setValue(ctx, val);
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
