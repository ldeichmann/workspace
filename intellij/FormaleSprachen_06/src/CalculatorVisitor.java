import gen.calcBaseVisitor;
import gen.calcParser;

import java.util.HashMap;
import java.util.Map;

public class CalculatorVisitor extends calcBaseVisitor<Double> {

    Map<String, Double> vars = new HashMap<>();

    @Override
    public Double visitAdd(calcParser.AddContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        return val1 + val2;
    }

    @Override
    public Double visitSub(calcParser.SubContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        return val1 - val2;
    }

    @Override
    public Double visitMul(calcParser.MulContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        return val1 * val2;
    }

    @Override
    public Double visitDiv(calcParser.DivContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        return val1 / val2;
    }

    @Override
    public Double visitPow(calcParser.PowContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        return Math.pow(val1, val2);
    }

    @Override
    public Double visitFac(calcParser.FacContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double fact = 1.0; // this  will be the result
        for (int i = 1; i <= val1.intValue(); i++) {
            fact *= i;
        }
        return fact;
    }

    @Override
    public Double visitGt(calcParser.GtContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
        if (val1 >= val2) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    @Override
    public Double visitLt(calcParser.LtContext ctx) {
        Double val1 = visit(ctx.getParent().getChild(0));
        Double val2 = visit(ctx.getParent().getChild(2));
//        System.out.println("Lt " + val1 + " " + val2);
        if (val1 <= val2) {
            return 0.0;
        } else {
            return 1.0;
        }
    }

    @Override
    public Double visitExpr(calcParser.ExprContext ctx) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.getChild(1));
        } else if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }
        return super.visitExpr(ctx);
    }

    @Override
    public Double visitBlock(calcParser.BlockContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Double visitVariable(calcParser.VariableContext ctx) {
        String varname = ctx.getChild(0).getChild(0).getText();
        Double value = visit(ctx.getChild(2));
        vars.put(varname, value);
        return null;
    }

    @Override
    public Double visitVal(calcParser.ValContext ctx) {
        return Double.parseDouble(ctx.INT().getText());
    }

    @Override
    public Double visitVar(calcParser.VarContext ctx) {
        String var = ctx.ID().getText();
        return vars.get(var);
    }

    @Override
    public Double visitClear(calcParser.ClearContext ctx) {
        vars.clear();
        return null;
    }
}
