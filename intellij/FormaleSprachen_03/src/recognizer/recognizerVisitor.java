// Generated from /home/cru/Code/workspace/intellij/FormaleSprachen_03/src/recognizer.g4 by ANTLR 4.5.3
package recognizer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link recognizerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface recognizerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link recognizerParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(recognizerParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(recognizerParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(recognizerParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(recognizerParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(recognizerParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(recognizerParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(recognizerParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(recognizerParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(recognizerParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#fac}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFac(recognizerParser.FacContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#lt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLt(recognizerParser.LtContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#gt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGt(recognizerParser.GtContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(recognizerParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#val_or_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal_or_var(recognizerParser.Val_or_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(recognizerParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link recognizerParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(recognizerParser.VarContext ctx);
}