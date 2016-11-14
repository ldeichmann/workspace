import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;
import recognizer.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cru on 11/14/16.
 */
public class recVisitor extends recognizerBaseVisitor<Double> {

    Map<String, Double> vars = new HashMap<>();

//    @Override
//    public Double visitBlock(recognizerParser.BlockContext ctx) {
//        return null;
//    }


    @Override
    public Double visitAdd(recognizerParser.AddContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        return val1 + val2;
    }

    @Override
    public Double visitSub(recognizerParser.SubContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        return val1 - val2;
    }

    @Override
    public Double visitMul(recognizerParser.MulContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        return val1 * val2;
    }

    @Override
    public Double visitDiv(recognizerParser.DivContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        return val1 / val2;
    }

    @Override
    public Double visitPow(recognizerParser.PowContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        return Math.pow(val1, val2);
    }

    @Override
    public Double visitFac(recognizerParser.FacContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double fact = 1.0; // this  will be the result
        for (int i = 1; i <= val1.intValue(); i++) {
            fact *= i;
        }
        return fact;
    }

    @Override
    public Double visitGt(recognizerParser.GtContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        if (val1 >= val2) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    @Override
    public Double visitLt(recognizerParser.LtContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        if (val1 <= val2) {
            return 0.0;
        } else {
            return 1.0;
        }
    }

    @Override
    public Double visitExpr(recognizerParser.ExprContext ctx) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.getChild(1));
        } else if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }
        System.out.println("Dasd " + super.visitExpr(ctx) + "\n" + ctx.getChildCount());
        return super.visitExpr(ctx);
    }

    @Override
    public Double visitBlock(recognizerParser.BlockContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Double visitVariable(recognizerParser.VariableContext ctx) {
        String varname = ctx.getChild(0).getChild(0).getText();
        Double value = visit(ctx.getChild(2));
        vars.put(varname, value);
//        System.out.println("Hallo" + value);
        return null;
    }

    @Override
    public Double visitVal(recognizerParser.ValContext ctx) {
        return Double.parseDouble(ctx.INT().getText());
    }

    @Override
    public Double visitVar(recognizerParser.VarContext ctx) {
        String var = ctx.ID().getText();
//        System.out.println("var " + var + " " + vars.get(var));
        return vars.get(var);
    }
}
