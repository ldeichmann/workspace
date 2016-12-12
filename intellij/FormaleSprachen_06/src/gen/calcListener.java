// Generated from /home/cru/Code/workspace/intellij/FormaleSprachen_06/src/calc.g4 by ANTLR 4.5.3
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link calcParser}.
 */
public interface calcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link calcParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(calcParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(calcParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(calcParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(calcParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#clear}.
	 * @param ctx the parse tree
	 */
	void enterClear(calcParser.ClearContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#clear}.
	 * @param ctx the parse tree
	 */
	void exitClear(calcParser.ClearContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(calcParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(calcParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(calcParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(calcParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(calcParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(calcParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#div}.
	 * @param ctx the parse tree
	 */
	void enterDiv(calcParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#div}.
	 * @param ctx the parse tree
	 */
	void exitDiv(calcParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPow(calcParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPow(calcParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#fac}.
	 * @param ctx the parse tree
	 */
	void enterFac(calcParser.FacContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#fac}.
	 * @param ctx the parse tree
	 */
	void exitFac(calcParser.FacContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#lt}.
	 * @param ctx the parse tree
	 */
	void enterLt(calcParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#lt}.
	 * @param ctx the parse tree
	 */
	void exitLt(calcParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#gt}.
	 * @param ctx the parse tree
	 */
	void enterGt(calcParser.GtContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#gt}.
	 * @param ctx the parse tree
	 */
	void exitGt(calcParser.GtContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(calcParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(calcParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(calcParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(calcParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#val_or_var}.
	 * @param ctx the parse tree
	 */
	void enterVal_or_var(calcParser.Val_or_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#val_or_var}.
	 * @param ctx the parse tree
	 */
	void exitVal_or_var(calcParser.Val_or_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(calcParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(calcParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(calcParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(calcParser.VarContext ctx);
}