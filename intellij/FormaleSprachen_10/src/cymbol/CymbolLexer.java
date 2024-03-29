// Generated from /home/cru/Code/workspace/intellij/FormaleSprachen_10/src/mccabe/Cymbol.g4 by ANTLR 4.6
package cymbol;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CymbolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, ID=28, INT=29, WS=30, SL_COMMENT=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "ID", "LETTER", "INT", "WS", "SL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "';'", "'float'", "'int'", "'void'", "'char'", "'('", "')'", 
		"','", "'{'", "'}'", "'if'", "'else'", "'return'", "'for'", "'['", "']'", 
		"'-'", "'!'", "'*'", "'+'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "ID", "INT", "WS", "SL_COMMENT"
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


	public CymbolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cymbol.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00b7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\7\35\u0098\n\35\f\35\16\35\u009b"+
		"\13\35\3\36\3\36\3\37\6\37\u00a0\n\37\r\37\16\37\u00a1\3 \6 \u00a5\n "+
		"\r \16 \u00a6\3 \3 \3!\3!\3!\3!\7!\u00af\n!\f!\16!\u00b2\13!\3!\3!\3!"+
		"\3!\3\u00b0\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\2=\37? A!\3\2\5\3\2\62;\4\2C\\c|\5\2\13\f\17\17\"\"\u00ba"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5E\3\2\2\2\7G\3\2\2\2\tM\3\2\2"+
		"\2\13Q\3\2\2\2\rV\3\2\2\2\17[\3\2\2\2\21]\3\2\2\2\23_\3\2\2\2\25a\3\2"+
		"\2\2\27c\3\2\2\2\31e\3\2\2\2\33h\3\2\2\2\35m\3\2\2\2\37t\3\2\2\2!x\3\2"+
		"\2\2#z\3\2\2\2%|\3\2\2\2\'~\3\2\2\2)\u0080\3\2\2\2+\u0082\3\2\2\2-\u0084"+
		"\3\2\2\2/\u0087\3\2\2\2\61\u008a\3\2\2\2\63\u008c\3\2\2\2\65\u008e\3\2"+
		"\2\2\67\u0091\3\2\2\29\u0094\3\2\2\2;\u009c\3\2\2\2=\u009f\3\2\2\2?\u00a4"+
		"\3\2\2\2A\u00aa\3\2\2\2CD\7?\2\2D\4\3\2\2\2EF\7=\2\2F\6\3\2\2\2GH\7h\2"+
		"\2HI\7n\2\2IJ\7q\2\2JK\7c\2\2KL\7v\2\2L\b\3\2\2\2MN\7k\2\2NO\7p\2\2OP"+
		"\7v\2\2P\n\3\2\2\2QR\7x\2\2RS\7q\2\2ST\7k\2\2TU\7f\2\2U\f\3\2\2\2VW\7"+
		"e\2\2WX\7j\2\2XY\7c\2\2YZ\7t\2\2Z\16\3\2\2\2[\\\7*\2\2\\\20\3\2\2\2]^"+
		"\7+\2\2^\22\3\2\2\2_`\7.\2\2`\24\3\2\2\2ab\7}\2\2b\26\3\2\2\2cd\7\177"+
		"\2\2d\30\3\2\2\2ef\7k\2\2fg\7h\2\2g\32\3\2\2\2hi\7g\2\2ij\7n\2\2jk\7u"+
		"\2\2kl\7g\2\2l\34\3\2\2\2mn\7t\2\2no\7g\2\2op\7v\2\2pq\7w\2\2qr\7t\2\2"+
		"rs\7p\2\2s\36\3\2\2\2tu\7h\2\2uv\7q\2\2vw\7t\2\2w \3\2\2\2xy\7]\2\2y\""+
		"\3\2\2\2z{\7_\2\2{$\3\2\2\2|}\7/\2\2}&\3\2\2\2~\177\7#\2\2\177(\3\2\2"+
		"\2\u0080\u0081\7,\2\2\u0081*\3\2\2\2\u0082\u0083\7-\2\2\u0083,\3\2\2\2"+
		"\u0084\u0085\7?\2\2\u0085\u0086\7?\2\2\u0086.\3\2\2\2\u0087\u0088\7#\2"+
		"\2\u0088\u0089\7?\2\2\u0089\60\3\2\2\2\u008a\u008b\7>\2\2\u008b\62\3\2"+
		"\2\2\u008c\u008d\7@\2\2\u008d\64\3\2\2\2\u008e\u008f\7>\2\2\u008f\u0090"+
		"\7?\2\2\u0090\66\3\2\2\2\u0091\u0092\7@\2\2\u0092\u0093\7?\2\2\u00938"+
		"\3\2\2\2\u0094\u0099\5;\36\2\u0095\u0098\5;\36\2\u0096\u0098\t\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a:\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d"+
		"\t\3\2\2\u009d<\3\2\2\2\u009e\u00a0\t\2\2\2\u009f\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2>\3\2\2\2"+
		"\u00a3\u00a5\t\4\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b \2\2\u00a9"+
		"@\3\2\2\2\u00aa\u00ab\7\61\2\2\u00ab\u00ac\7\61\2\2\u00ac\u00b0\3\2\2"+
		"\2\u00ad\u00af\13\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b3\u00b4\7\f\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\b!\2\2\u00b6"+
		"B\3\2\2\2\b\2\u0097\u0099\u00a1\u00a6\u00b0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}