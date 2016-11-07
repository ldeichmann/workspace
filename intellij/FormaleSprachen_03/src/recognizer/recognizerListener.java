// Generated from /home/cru/Code/workspace/intellij/FormaleSprachen_03/src/recognizer.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link recognizerParser}.
 */
public interface recognizerListener extends ParseTreeListener {
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
}