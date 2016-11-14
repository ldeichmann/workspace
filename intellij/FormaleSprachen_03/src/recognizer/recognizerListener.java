// Generated from /home/cru/Code/workspace/intellij/FormaleSprachen_03/src/recognizer.g4 by ANTLR 4.5.3
package recognizer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link recognizerParser}.
 */
public interface recognizerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link recognizerParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(recognizerParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(recognizerParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(recognizerParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(recognizerParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(recognizerParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(recognizerParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(recognizerParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(recognizerParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(recognizerParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(recognizerParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(recognizerParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(recognizerParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(recognizerParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(recognizerParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#div}.
	 * @param ctx the parse tree
	 */
	void enterDiv(recognizerParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#div}.
	 * @param ctx the parse tree
	 */
	void exitDiv(recognizerParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPow(recognizerParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPow(recognizerParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#fac}.
	 * @param ctx the parse tree
	 */
	void enterFac(recognizerParser.FacContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#fac}.
	 * @param ctx the parse tree
	 */
	void exitFac(recognizerParser.FacContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#lt}.
	 * @param ctx the parse tree
	 */
	void enterLt(recognizerParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#lt}.
	 * @param ctx the parse tree
	 */
	void exitLt(recognizerParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#gt}.
	 * @param ctx the parse tree
	 */
	void enterGt(recognizerParser.GtContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#gt}.
	 * @param ctx the parse tree
	 */
	void exitGt(recognizerParser.GtContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(recognizerParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(recognizerParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#val_or_var}.
	 * @param ctx the parse tree
	 */
	void enterVal_or_var(recognizerParser.Val_or_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#val_or_var}.
	 * @param ctx the parse tree
	 */
	void exitVal_or_var(recognizerParser.Val_or_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(recognizerParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(recognizerParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link recognizerParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(recognizerParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link recognizerParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(recognizerParser.VarContext ctx);
}