// Generated from /home/cru/IdeaProjects/FormaleSprachen_01/src/lexer/ExprLexer_antlr.g4 by ANTLR 4.5.3
package lexer;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer_antlrLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, NL=2, PLUS=3, MINUS=4, UMINUS=5, MUL=6, DIV=7, POW=8, WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INT", "NL", "PLUS", "MINUS", "UMINUS", "MUL", "DIV", "POW", "WS"
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


	public ExprLexer_antlrLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExprLexer_antlr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13/\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\6\2"+
		"\27\n\2\r\2\16\2\30\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\6\n*\n\n\r\n\16\n+\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\3\2\5\3\2\62;\3\2\f\f\5\2\13\f\17\17\"\"\60\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\26\3\2\2\2\5\32\3\2\2\2\7\34\3\2\2"+
		"\2\t\36\3\2\2\2\13 \3\2\2\2\r\"\3\2\2\2\17$\3\2\2\2\21&\3\2\2\2\23)\3"+
		"\2\2\2\25\27\t\2\2\2\26\25\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3"+
		"\2\2\2\31\4\3\2\2\2\32\33\t\3\2\2\33\6\3\2\2\2\34\35\7-\2\2\35\b\3\2\2"+
		"\2\36\37\7/\2\2\37\n\3\2\2\2 !\7%\2\2!\f\3\2\2\2\"#\7,\2\2#\16\3\2\2\2"+
		"$%\7\61\2\2%\20\3\2\2\2&\'\7`\2\2\'\22\3\2\2\2(*\t\4\2\2)(\3\2\2\2*+\3"+
		"\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\b\n\2\2.\24\3\2\2\2\5\2\30+\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}