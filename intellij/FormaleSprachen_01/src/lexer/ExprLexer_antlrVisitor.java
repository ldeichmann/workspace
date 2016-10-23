// Generated from /home/cru/IdeaProjects/FormaleSprachen_01/src/lexer/ExprLexer_antlr.g4 by ANTLR 4.5.3
package lexer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprLexer_antlrParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprLexer_antlrVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExprLexer_antlrParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#valid_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValid_operation(ExprLexer_antlrParser.Valid_operationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ExprLexer_antlrParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#binary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_operator(ExprLexer_antlrParser.Binary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator(ExprLexer_antlrParser.Unary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#plus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(ExprLexer_antlrParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#minus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(ExprLexer_antlrParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(ExprLexer_antlrParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(ExprLexer_antlrParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(ExprLexer_antlrParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprLexer_antlrParser#uminus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUminus(ExprLexer_antlrParser.UminusContext ctx);
}