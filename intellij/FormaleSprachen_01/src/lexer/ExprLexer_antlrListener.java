// Generated from /home/cru/IdeaProjects/FormaleSprachen_01/src/lexer/ExprLexer_antlr.g4 by ANTLR 4.5.3
package lexer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprLexer_antlrParser}.
 */
public interface ExprLexer_antlrListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprLexer_antlrParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprLexer_antlrParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#valid_operation}.
	 * @param ctx the parse tree
	 */
	void enterValid_operation(ExprLexer_antlrParser.Valid_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#valid_operation}.
	 * @param ctx the parse tree
	 */
	void exitValid_operation(ExprLexer_antlrParser.Valid_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ExprLexer_antlrParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ExprLexer_antlrParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#binary_operator}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator(ExprLexer_antlrParser.Binary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#binary_operator}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator(ExprLexer_antlrParser.Binary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(ExprLexer_antlrParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(ExprLexer_antlrParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#plus}.
	 * @param ctx the parse tree
	 */
	void enterPlus(ExprLexer_antlrParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#plus}.
	 * @param ctx the parse tree
	 */
	void exitPlus(ExprLexer_antlrParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#minus}.
	 * @param ctx the parse tree
	 */
	void enterMinus(ExprLexer_antlrParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#minus}.
	 * @param ctx the parse tree
	 */
	void exitMinus(ExprLexer_antlrParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(ExprLexer_antlrParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(ExprLexer_antlrParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#div}.
	 * @param ctx the parse tree
	 */
	void enterDiv(ExprLexer_antlrParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#div}.
	 * @param ctx the parse tree
	 */
	void exitDiv(ExprLexer_antlrParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPow(ExprLexer_antlrParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPow(ExprLexer_antlrParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprLexer_antlrParser#uminus}.
	 * @param ctx the parse tree
	 */
	void enterUminus(ExprLexer_antlrParser.UminusContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprLexer_antlrParser#uminus}.
	 * @param ctx the parse tree
	 */
	void exitUminus(ExprLexer_antlrParser.UminusContext ctx);
}