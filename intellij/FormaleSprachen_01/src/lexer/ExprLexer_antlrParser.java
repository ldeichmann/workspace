// Generated from /home/cru/IdeaProjects/FormaleSprachen_01/src/lexer/ExprLexer_antlr.g4 by ANTLR 4.5.3
package lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer_antlrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, NL=2, PLUS=3, MINUS=4, UMINUS=5, MUL=6, DIV=7, POW=8, WS=9;
	public static final int
		RULE_prog = 0, RULE_valid_operation = 1, RULE_value = 2, RULE_binary_operator = 3, 
		RULE_unary_operator = 4, RULE_plus = 5, RULE_minus = 6, RULE_mul = 7, 
		RULE_div = 8, RULE_pow = 9, RULE_uminus = 10;
	public static final String[] ruleNames = {
		"prog", "valid_operation", "value", "binary_operator", "unary_operator", 
		"plus", "minus", "mul", "div", "pow", "uminus"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'+'", "'-'", "'#'", "'*'", "'/'", "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INT", "NL", "PLUS", "MINUS", "UMINUS", "MUL", "DIV", "POW", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ExprLexer_antlr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprLexer_antlrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<Valid_operationContext> valid_operation() {
			return getRuleContexts(Valid_operationContext.class);
		}
		public Valid_operationContext valid_operation(int i) {
			return getRuleContext(Valid_operationContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				valid_operation(0);
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Valid_operationContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<Valid_operationContext> valid_operation() {
			return getRuleContexts(Valid_operationContext.class);
		}
		public Valid_operationContext valid_operation(int i) {
			return getRuleContext(Valid_operationContext.class,i);
		}
		public Binary_operatorContext binary_operator() {
			return getRuleContext(Binary_operatorContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public Valid_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valid_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterValid_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitValid_operation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitValid_operation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valid_operationContext valid_operation() throws RecognitionException {
		return valid_operation(0);
	}

	private Valid_operationContext valid_operation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Valid_operationContext _localctx = new Valid_operationContext(_ctx, _parentState);
		Valid_operationContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_valid_operation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(28);
			value();
			}
			_ctx.stop = _input.LT(-1);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(36);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new Valid_operationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valid_operation);
						setState(30);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(31);
						valid_operation(0);
						setState(32);
						binary_operator();
						}
						break;
					case 2:
						{
						_localctx = new Valid_operationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valid_operation);
						setState(34);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(35);
						unary_operator();
						}
						break;
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ExprLexer_antlrParser.INT, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_operatorContext extends ParserRuleContext {
		public PlusContext plus() {
			return getRuleContext(PlusContext.class,0);
		}
		public MinusContext minus() {
			return getRuleContext(MinusContext.class,0);
		}
		public MulContext mul() {
			return getRuleContext(MulContext.class,0);
		}
		public DivContext div() {
			return getRuleContext(DivContext.class,0);
		}
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public Binary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterBinary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitBinary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitBinary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_operatorContext binary_operator() throws RecognitionException {
		Binary_operatorContext _localctx = new Binary_operatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_binary_operator);
		try {
			setState(48);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				plus();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				minus();
				}
				break;
			case MUL:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				mul();
				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				div();
				}
				break;
			case POW:
				enterOuterAlt(_localctx, 5);
				{
				setState(47);
				pow();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public UminusContext uminus() {
			return getRuleContext(UminusContext.class,0);
		}
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitUnary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unary_operator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			uminus();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ExprLexer_antlrParser.PLUS, 0); }
		public PlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusContext plus() throws RecognitionException {
		PlusContext _localctx = new PlusContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_plus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(PLUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MinusContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(ExprLexer_antlrParser.MINUS, 0); }
		public MinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MinusContext minus() throws RecognitionException {
		MinusContext _localctx = new MinusContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_minus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(MINUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(ExprLexer_antlrParser.MUL, 0); }
		public MulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitMul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulContext mul() throws RecognitionException {
		MulContext _localctx = new MulContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_mul);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(MUL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DivContext extends ParserRuleContext {
		public TerminalNode DIV() { return getToken(ExprLexer_antlrParser.DIV, 0); }
		public DivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_div; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivContext div() throws RecognitionException {
		DivContext _localctx = new DivContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_div);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(DIV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PowContext extends ParserRuleContext {
		public TerminalNode POW() { return getToken(ExprLexer_antlrParser.POW, 0); }
		public PowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitPow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitPow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowContext pow() throws RecognitionException {
		PowContext _localctx = new PowContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(POW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UminusContext extends ParserRuleContext {
		public TerminalNode UMINUS() { return getToken(ExprLexer_antlrParser.UMINUS, 0); }
		public UminusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uminus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).enterUminus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprLexer_antlrListener ) ((ExprLexer_antlrListener)listener).exitUminus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprLexer_antlrVisitor ) return ((ExprLexer_antlrVisitor<? extends T>)visitor).visitUminus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UminusContext uminus() throws RecognitionException {
		UminusContext _localctx = new UminusContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_uminus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(UMINUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return valid_operation_sempred((Valid_operationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean valid_operation_sempred(Valid_operationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13C\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3\'\n\3\f\3\16\3*\13\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5\63\n\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\2\3\4\r\2\4\6"+
		"\b\n\f\16\20\22\24\26\2\2>\2\31\3\2\2\2\4\35\3\2\2\2\6+\3\2\2\2\b\62\3"+
		"\2\2\2\n\64\3\2\2\2\f\66\3\2\2\2\168\3\2\2\2\20:\3\2\2\2\22<\3\2\2\2\24"+
		">\3\2\2\2\26@\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31"+
		"\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2\35\36\b\3\1\2\36\37\5\6\4\2\37(\3"+
		"\2\2\2 !\f\5\2\2!\"\5\4\3\2\"#\5\b\5\2#\'\3\2\2\2$%\f\4\2\2%\'\5\n\6\2"+
		"& \3\2\2\2&$\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*(\3\2\2"+
		"\2+,\7\3\2\2,\7\3\2\2\2-\63\5\f\7\2.\63\5\16\b\2/\63\5\20\t\2\60\63\5"+
		"\22\n\2\61\63\5\24\13\2\62-\3\2\2\2\62.\3\2\2\2\62/\3\2\2\2\62\60\3\2"+
		"\2\2\62\61\3\2\2\2\63\t\3\2\2\2\64\65\5\26\f\2\65\13\3\2\2\2\66\67\7\5"+
		"\2\2\67\r\3\2\2\289\7\6\2\29\17\3\2\2\2:;\7\b\2\2;\21\3\2\2\2<=\7\t\2"+
		"\2=\23\3\2\2\2>?\7\n\2\2?\25\3\2\2\2@A\7\7\2\2A\27\3\2\2\2\6\33&(\62";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}