// Generated from /home/cru/Code/workspace/intellij/FormaleSprachen_06/src/calc.g4 by ANTLR 4.5.3
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link calcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface calcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link calcParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(calcParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(calcParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#clear}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClear(calcParser.ClearContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(calcParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(calcParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(calcParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(calcParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(calcParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#fac}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFac(calcParser.FacContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#lt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLt(calcParser.LtContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#gt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGt(calcParser.GtContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(calcParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(calcParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#val_or_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal_or_var(calcParser.Val_or_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(calcParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(calcParser.VarContext ctx);
}