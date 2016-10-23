package lexer;

import java.util.Stack;

/**
 * Created by cru on 10/23/16.
 */
public class ExprVisitor extends ExprLexer_antlrBaseVisitor<Integer> {

    Stack<Integer> memory = new Stack<>();

    @Override
    public Integer visitDiv(ExprLexer_antlrParser.DivContext ctx) {
        int val1 = visit(ctx.getParent().getParent().getChild(0));
        int val2 = visit(ctx.getParent().getParent().getChild(1));
        return (val1/val2);
    }

    @Override
    public Integer visitMinus(ExprLexer_antlrParser.MinusContext ctx) {
        int val1 = visit(ctx.getParent().getParent().getChild(0));
        int val2 = visit(ctx.getParent().getParent().getChild(1));
        return val1 - val2;
    }

    @Override
    public Integer visitMul(ExprLexer_antlrParser.MulContext ctx) {
        int val1 = visit(ctx.getParent().getParent().getChild(0));
        int val2 = visit(ctx.getParent().getParent().getChild(1));
        return val1 * val2;
    }

    @Override
    public Integer visitPlus(ExprLexer_antlrParser.PlusContext ctx) {
        int val1 = visit(ctx.getParent().getParent().getChild(0));
        int val2 = visit(ctx.getParent().getParent().getChild(1));
        return val1 + val2;
    }

    @Override
    public Integer visitPow(ExprLexer_antlrParser.PowContext ctx) {
        int val1 = visit(ctx.getParent().getParent().getChild(0));
        int val2 = visit(ctx.getParent().getParent().getChild(1));
        return (int) Math.pow(val1, val2);
    }

    @Override
    public Integer visitUminus(ExprLexer_antlrParser.UminusContext ctx) {
        int val1 = visit(ctx.getParent().getParent().getChild(0));
        return -val1;
    }

    @Override
    public Integer visitValue(ExprLexer_antlrParser.ValueContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }

//    @Override
//    public Integer visitValid_operation(ExprLexer_antlrParser.Valid_operationContext ctx) {
//        if (ctx.getChildCount() == 1) {
//            return visit(ctx.getChild(0));
//        } else if (ctx.getChildCount() == 2) {
//            return 
//        }
////        return super.visitValid_operation(ctx);
//    }

    //    @Override
//    public void visitDiv(ExprLexer_antlrParser.DivContext ctx) {
//        memory.push(memory.pop() * (1/memory.pop()));
//    }
//
//    @Override
//    public void enterMinus(ExprLexer_antlrParser.MinusContext ctx) {
//        super.enterMinus(ctx);
//        memory.push(-memory.pop() + memory.pop());
//    }
//
//    @Override
//    public void enterMul(ExprLexer_antlrParser.MulContext ctx) {
//        super.enterMul(ctx);
//        memory.push(memory.pop() * memory.pop());
//    }
//
//    @Override
//    public void enterPlus(ExprLexer_antlrParser.PlusContext ctx) {
//        super.enterPlus(ctx);
//        memory.push(memory.pop() + memory.pop());
//    }
//
//    @Override
//    public void enterPow(ExprLexer_antlrParser.PowContext ctx) {
//        super.enterPow(ctx);
//        int temp = memory.pop();
//        memory.push((int) Math.pow(memory.pop(), temp));
//    }
//
//    @Override
//    public void enterValue(ExprLexer_antlrParser.ValueContext ctx) {
//        super.enterValue(ctx);
//        memory.push(Integer.parseInt(ctx.INT().getText()));
//    }
}
