// Generated from /home/cru/Code/workspace/intellij/FormaleSprachen_02/src/halstead/HalsteadLexer.g4 by ANTLR 4.5.3
package halstead;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HalsteadLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPERAND=1, OPERATOR=2, IGNORE=3;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"OPERAND", "OPERATOR", "IGNORE"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OPERAND", "OPERATOR", "IGNORE"
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


	public HalsteadLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HalsteadLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\5\u01c7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2;\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u01b4\n\3\3\4\6\4\u01b7"+
		"\n\4\r\4\16\4\u01b8\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01c6"+
		"\n\4\2\2\5\3\3\5\4\7\5\3\2\7\4\2**,,\5\2AA]]``\5\2==??\u0080\u0080\4\2"+
		"C\\c|\6\2++<<__\177\177\u0226\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\3:\3"+
		"\2\2\2\5\u01b3\3\2\2\2\7\u01c5\3\2\2\2\t\n\7d\2\2\n\13\7q\2\2\13\f\7q"+
		"\2\2\f;\7n\2\2\r\16\7e\2\2\16\17\7j\2\2\17\20\7c\2\2\20;\7t\2\2\21\22"+
		"\7f\2\2\22\23\7q\2\2\23\24\7w\2\2\24\25\7d\2\2\25\26\7n\2\2\26;\7g\2\2"+
		"\27\30\7h\2\2\30\31\7n\2\2\31\32\7q\2\2\32\33\7c\2\2\33;\7v\2\2\34\35"+
		"\7k\2\2\35\36\7p\2\2\36;\7v\2\2\37 \7n\2\2 !\7q\2\2!\"\7p\2\2\";\7i\2"+
		"\2#$\7u\2\2$%\7j\2\2%&\7q\2\2&\'\7t\2\2\';\7v\2\2()\7u\2\2)*\7k\2\2*+"+
		"\7i\2\2+,\7p\2\2,-\7g\2\2-;\7f\2\2./\7w\2\2/\60\7p\2\2\60\61\7u\2\2\61"+
		"\62\7k\2\2\62\63\7i\2\2\63\64\7p\2\2\64\65\7g\2\2\65;\7f\2\2\66\67\7x"+
		"\2\2\678\7q\2\289\7k\2\29;\7f\2\2:\t\3\2\2\2:\r\3\2\2\2:\21\3\2\2\2:\27"+
		"\3\2\2\2:\34\3\2\2\2:\37\3\2\2\2:#\3\2\2\2:(\3\2\2\2:.\3\2\2\2:\66\3\2"+
		"\2\2;\4\3\2\2\2<=\7c\2\2=>\7w\2\2>?\7v\2\2?\u01b4\7q\2\2@A\7g\2\2AB\7"+
		"z\2\2BC\7v\2\2CD\7g\2\2DE\7t\2\2E\u01b4\7p\2\2FG\7k\2\2GH\7p\2\2HI\7n"+
		"\2\2IJ\7k\2\2JK\7p\2\2K\u01b4\7g\2\2LM\7t\2\2MN\7g\2\2NO\7i\2\2OP\7k\2"+
		"\2PQ\7u\2\2QR\7v\2\2RS\7g\2\2S\u01b4\7t\2\2TU\7u\2\2UV\7v\2\2VW\7c\2\2"+
		"WX\7v\2\2XY\7k\2\2Y\u01b4\7e\2\2Z[\7v\2\2[\\\7{\2\2\\]\7r\2\2]^\7g\2\2"+
		"^_\7f\2\2_`\7g\2\2`\u01b4\7h\2\2ab\7x\2\2bc\7k\2\2cd\7t\2\2de\7v\2\2e"+
		"f\7w\2\2fg\7c\2\2g\u01b4\7n\2\2hi\7o\2\2ij\7v\2\2jk\7w\2\2kl\7c\2\2lm"+
		"\7d\2\2mn\7n\2\2n\u01b4\7g\2\2op\7e\2\2pq\7q\2\2qr\7p\2\2rs\7u\2\2s\u01b4"+
		"\7v\2\2tu\7h\2\2uv\7t\2\2vw\7k\2\2wx\7g\2\2xy\7p\2\2y\u01b4\7f\2\2z{\7"+
		"x\2\2{|\7q\2\2|}\7n\2\2}~\7c\2\2~\177\7v\2\2\177\u0080\7k\2\2\u0080\u0081"+
		"\7n\2\2\u0081\u01b4\7g\2\2\u0082\u0083\7c\2\2\u0083\u0084\7u\2\2\u0084"+
		"\u01b4\7o\2\2\u0085\u0086\7d\2\2\u0086\u0087\7t\2\2\u0087\u0088\7g\2\2"+
		"\u0088\u0089\7c\2\2\u0089\u01b4\7m\2\2\u008a\u008b\7e\2\2\u008b\u008c"+
		"\7c\2\2\u008c\u008d\7u\2\2\u008d\u01b4\7g\2\2\u008e\u008f\7e\2\2\u008f"+
		"\u0090\7n\2\2\u0090\u0091\7c\2\2\u0091\u0092\7u\2\2\u0092\u01b4\7u\2\2"+
		"\u0093\u0094\7e\2\2\u0094\u0095\7q\2\2\u0095\u0096\7p\2\2\u0096\u0097"+
		"\7v\2\2\u0097\u0098\7k\2\2\u0098\u0099\7p\2\2\u0099\u009a\7w\2\2\u009a"+
		"\u01b4\7g\2\2\u009b\u009c\7f\2\2\u009c\u009d\7g\2\2\u009d\u009e\7h\2\2"+
		"\u009e\u009f\7c\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7n\2\2\u00a1\u01b4"+
		"\7v\2\2\u00a2\u00a3\7f\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7n\2\2\u00a5"+
		"\u00a6\7g\2\2\u00a6\u00a7\7v\2\2\u00a7\u01b4\7g\2\2\u00a8\u00a9\7y\2\2"+
		"\u00a9\u00aa\7j\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad"+
		"\7g\2\2\u00ad\u01b4\7*\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7n\2\2\u00b0"+
		"\u00b1\7u\2\2\u00b1\u01b4\7g\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7p\2\2"+
		"\u00b4\u00b5\7w\2\2\u00b5\u01b4\7o\2\2\u00b6\u00b7\7h\2\2\u00b7\u00b8"+
		"\7q\2\2\u00b8\u00b9\7t\2\2\u00b9\u01b4\7*\2\2\u00ba\u00bb\7i\2\2\u00bb"+
		"\u00bc\7q\2\2\u00bc\u00bd\7v\2\2\u00bd\u01b4\7q\2\2\u00be\u00bf\7k\2\2"+
		"\u00bf\u00c0\7h\2\2\u00c0\u01b4\7*\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3"+
		"\7g\2\2\u00c3\u01b4\7y\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7r\2\2\u00c6"+
		"\u00c7\7g\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7c\2\2\u00c9\u00ca\7v\2\2"+
		"\u00ca\u00cb\7q\2\2\u00cb\u01b4\7t\2\2\u00cc\u00cd\7r\2\2\u00cd\u00ce"+
		"\7t\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7x\2\2\u00d0\u00d1\7c\2\2\u00d1"+
		"\u00d2\7v\2\2\u00d2\u01b4\7g\2\2\u00d3\u00d4\7r\2\2\u00d4\u00d5\7t\2\2"+
		"\u00d5\u00d6\7q\2\2\u00d6\u00d7\7v\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9"+
		"\7e\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7g\2\2\u00db\u01b4\7f\2\2\u00dc"+
		"\u00dd\7r\2\2\u00dd\u00de\7w\2\2\u00de\u00df\7d\2\2\u00df\u00e0\7n\2\2"+
		"\u00e0\u00e1\7k\2\2\u00e1\u01b4\7e\2\2\u00e2\u00e3\7t\2\2\u00e3\u00e4"+
		"\7g\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7w\2\2\u00e6\u00e7\7t\2\2\u00e7"+
		"\u01b4\7p\2\2\u00e8\u00e9\7u\2\2\u00e9\u00ea\7k\2\2\u00ea\u00eb\7|\2\2"+
		"\u00eb\u00ec\7g\2\2\u00ec\u00ed\7q\2\2\u00ed\u01b4\7h\2\2\u00ee\u00ef"+
		"\7u\2\2\u00ef\u00f0\7v\2\2\u00f0\u00f1\7t\2\2\u00f1\u00f2\7w\2\2\u00f2"+
		"\u00f3\7e\2\2\u00f3\u01b4\7v\2\2\u00f4\u00f5\7u\2\2\u00f5\u00f6\7y\2\2"+
		"\u00f6\u00f7\7k\2\2\u00f7\u00f8\7v\2\2\u00f8\u00f9\7e\2\2\u00f9\u00fa"+
		"\7j\2\2\u00fa\u01b4\7*\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7j\2\2\u00fd"+
		"\u00fe\7k\2\2\u00fe\u01b4\7u\2\2\u00ff\u0100\7w\2\2\u0100\u0101\7p\2\2"+
		"\u0101\u0102\7k\2\2\u0102\u0103\7q\2\2\u0103\u01b4\7p\2\2\u0104\u0105"+
		"\7p\2\2\u0105\u0106\7c\2\2\u0106\u0107\7o\2\2\u0107\u0108\7g\2\2\u0108"+
		"\u0109\7u\2\2\u0109\u010a\7r\2\2\u010a\u010b\7c\2\2\u010b\u010c\7e\2\2"+
		"\u010c\u01b4\7g\2\2\u010d\u010e\7w\2\2\u010e\u010f\7u\2\2\u010f\u0110"+
		"\7k\2\2\u0110\u0111\7p\2\2\u0111\u01b4\7i\2\2\u0112\u0113\7v\2\2\u0113"+
		"\u0114\7t\2\2\u0114\u01b4\7{\2\2\u0115\u0116\7e\2\2\u0116\u0117\7c\2\2"+
		"\u0117\u0118\7v\2\2\u0118\u0119\7e\2\2\u0119\u01b4\7j\2\2\u011a\u011b"+
		"\7v\2\2\u011b\u011c\7j\2\2\u011c\u011d\7t\2\2\u011d\u011e\7q\2\2\u011e"+
		"\u01b4\7y\2\2\u011f\u0120\7e\2\2\u0120\u0121\7q\2\2\u0121\u0122\7p\2\2"+
		"\u0122\u0123\7u\2\2\u0123\u0124\7v\2\2\u0124\u0125\7a\2\2\u0125\u0126"+
		"\7e\2\2\u0126\u0127\7c\2\2\u0127\u0128\7u\2\2\u0128\u01b4\7v\2\2\u0129"+
		"\u012a\7u\2\2\u012a\u012b\7v\2\2\u012b\u012c\7c\2\2\u012c\u012d\7v\2\2"+
		"\u012d\u012e\7k\2\2\u012e\u012f\7e\2\2\u012f\u0130\7a\2\2\u0130\u0131"+
		"\7e\2\2\u0131\u0132\7c\2\2\u0132\u0133\7u\2\2\u0133\u01b4\7v\2\2\u0134"+
		"\u0135\7f\2\2\u0135\u0136\7{\2\2\u0136\u0137\7p\2\2\u0137\u0138\7c\2\2"+
		"\u0138\u0139\7o\2\2\u0139\u013a\7k\2\2\u013a\u013b\7e\2\2\u013b\u013c"+
		"\7a\2\2\u013c\u013d\7e\2\2\u013d\u013e\7c\2\2\u013e\u013f\7u\2\2\u013f"+
		"\u01b4\7v\2\2\u0140\u0141\7t\2\2\u0141\u0142\7g\2\2\u0142\u0143\7k\2\2"+
		"\u0143\u0144\7|\2\2\u0144\u0145\7p\2\2\u0145\u0146\7v\2\2\u0146\u0147"+
		"\7g\2\2\u0147\u0148\7t\2\2\u0148\u0149\7r\2\2\u0149\u014a\7t\2\2\u014a"+
		"\u014b\7g\2\2\u014b\u014c\7v\2\2\u014c\u014d\7a\2\2\u014d\u014e\7e\2\2"+
		"\u014e\u014f\7c\2\2\u014f\u0150\7u\2\2\u0150\u01b4\7v\2\2\u0151\u0152"+
		"\7v\2\2\u0152\u0153\7{\2\2\u0153\u0154\7r\2\2\u0154\u0155\7g\2\2\u0155"+
		"\u0156\7k\2\2\u0156\u01b4\7f\2\2\u0157\u0158\7v\2\2\u0158\u0159\7g\2\2"+
		"\u0159\u015a\7o\2\2\u015a\u015b\7r\2\2\u015b\u015c\7n\2\2\u015c\u015d"+
		"\7c\2\2\u015d\u015e\7v\2\2\u015e\u01b4\7g\2\2\u015f\u0160\7g\2\2\u0160"+
		"\u0161\7z\2\2\u0161\u0162\7r\2\2\u0162\u0163\7n\2\2\u0163\u0164\7k\2\2"+
		"\u0164\u0165\7e\2\2\u0165\u0166\7k\2\2\u0166\u01b4\7v\2\2\u0167\u0168"+
		"\7v\2\2\u0168\u0169\7t\2\2\u0169\u016a\7w\2\2\u016a\u01b4\7g\2\2\u016b"+
		"\u016c\7h\2\2\u016c\u016d\7c\2\2\u016d\u016e\7n\2\2\u016e\u016f\7u\2\2"+
		"\u016f\u01b4\7g\2\2\u0170\u0171\7v\2\2\u0171\u0172\7{\2\2\u0172\u0173"+
		"\7r\2\2\u0173\u0174\7g\2\2\u0174\u0175\7p\2\2\u0175\u0176\7c\2\2\u0176"+
		"\u0177\7o\2\2\u0177\u01b4\7g\2\2\u0178\u01b4\7#\2\2\u0179\u017a\7#\2\2"+
		"\u017a\u01b4\7?\2\2\u017b\u01b4\7\'\2\2\u017c\u017d\7\'\2\2\u017d\u01b4"+
		"\7?\2\2\u017e\u01b4\7(\2\2\u017f\u0180\7(\2\2\u0180\u01b4\7(\2\2\u0181"+
		"\u0182\7(\2\2\u0182\u01b4\7?\2\2\u0183\u01b4\t\2\2\2\u0184\u0185\7,\2"+
		"\2\u0185\u01b4\7?\2\2\u0186\u01b4\7-\2\2\u0187\u0188\7-\2\2\u0188\u01b4"+
		"\7-\2\2\u0189\u018a\7-\2\2\u018a\u01b4\7?\2\2\u018b\u01b4\4./\2\u018c"+
		"\u018d\7/\2\2\u018d\u01b4\7/\2\2\u018e\u018f\7/\2\2\u018f\u01b4\7?\2\2"+
		"\u0190\u0191\7/\2\2\u0191\u01b4\7@\2\2\u0192\u0193\7\60\2\2\u0193\u0194"+
		"\7\60\2\2\u0194\u01b4\7\60\2\2\u0195\u01b4\7\61\2\2\u0196\u0197\7\61\2"+
		"\2\u0197\u01b4\7?\2\2\u0198\u0199\7<\2\2\u0199\u01b4\7<\2\2\u019a\u01b4"+
		"\7>\2\2\u019b\u019c\7>\2\2\u019c\u01b4\7>\2\2\u019d\u019e\7>\2\2\u019e"+
		"\u019f\7>\2\2\u019f\u01b4\7?\2\2\u01a0\u01a1\7>\2\2\u01a1\u01b4\7?\2\2"+
		"\u01a2\u01a3\7?\2\2\u01a3\u01b4\7?\2\2\u01a4\u01b4\7@\2\2\u01a5\u01a6"+
		"\7@\2\2\u01a6\u01b4\7?\2\2\u01a7\u01a8\7@\2\2\u01a8\u01b4\7@\2\2\u01a9"+
		"\u01aa\7@\2\2\u01aa\u01ab\7@\2\2\u01ab\u01b4\7?\2\2\u01ac\u01b4\t\3\2"+
		"\2\u01ad\u01ae\7`\2\2\u01ae\u01b4\7?\2\2\u01af\u01b4\7}\2\2\u01b0\u01b1"+
		"\7~\2\2\u01b1\u01b4\7~\2\2\u01b2\u01b4\t\4\2\2\u01b3<\3\2\2\2\u01b3@\3"+
		"\2\2\2\u01b3F\3\2\2\2\u01b3L\3\2\2\2\u01b3T\3\2\2\2\u01b3Z\3\2\2\2\u01b3"+
		"a\3\2\2\2\u01b3h\3\2\2\2\u01b3o\3\2\2\2\u01b3t\3\2\2\2\u01b3z\3\2\2\2"+
		"\u01b3\u0082\3\2\2\2\u01b3\u0085\3\2\2\2\u01b3\u008a\3\2\2\2\u01b3\u008e"+
		"\3\2\2\2\u01b3\u0093\3\2\2\2\u01b3\u009b\3\2\2\2\u01b3\u00a2\3\2\2\2\u01b3"+
		"\u00a8\3\2\2\2\u01b3\u00ae\3\2\2\2\u01b3\u00b2\3\2\2\2\u01b3\u00b6\3\2"+
		"\2\2\u01b3\u00ba\3\2\2\2\u01b3\u00be\3\2\2\2\u01b3\u00c1\3\2\2\2\u01b3"+
		"\u00c4\3\2\2\2\u01b3\u00cc\3\2\2\2\u01b3\u00d3\3\2\2\2\u01b3\u00dc\3\2"+
		"\2\2\u01b3\u00e2\3\2\2\2\u01b3\u00e8\3\2\2\2\u01b3\u00ee\3\2\2\2\u01b3"+
		"\u00f4\3\2\2\2\u01b3\u00fb\3\2\2\2\u01b3\u00ff\3\2\2\2\u01b3\u0104\3\2"+
		"\2\2\u01b3\u010d\3\2\2\2\u01b3\u0112\3\2\2\2\u01b3\u0115\3\2\2\2\u01b3"+
		"\u011a\3\2\2\2\u01b3\u011f\3\2\2\2\u01b3\u0129\3\2\2\2\u01b3\u0134\3\2"+
		"\2\2\u01b3\u0140\3\2\2\2\u01b3\u0151\3\2\2\2\u01b3\u0157\3\2\2\2\u01b3"+
		"\u015f\3\2\2\2\u01b3\u0167\3\2\2\2\u01b3\u016b\3\2\2\2\u01b3\u0170\3\2"+
		"\2\2\u01b3\u0178\3\2\2\2\u01b3\u0179\3\2\2\2\u01b3\u017b\3\2\2\2\u01b3"+
		"\u017c\3\2\2\2\u01b3\u017e\3\2\2\2\u01b3\u017f\3\2\2\2\u01b3\u0181\3\2"+
		"\2\2\u01b3\u0183\3\2\2\2\u01b3\u0184\3\2\2\2\u01b3\u0186\3\2\2\2\u01b3"+
		"\u0187\3\2\2\2\u01b3\u0189\3\2\2\2\u01b3\u018b\3\2\2\2\u01b3\u018c\3\2"+
		"\2\2\u01b3\u018e\3\2\2\2\u01b3\u0190\3\2\2\2\u01b3\u0192\3\2\2\2\u01b3"+
		"\u0195\3\2\2\2\u01b3\u0196\3\2\2\2\u01b3\u0198\3\2\2\2\u01b3\u019a\3\2"+
		"\2\2\u01b3\u019b\3\2\2\2\u01b3\u019d\3\2\2\2\u01b3\u01a0\3\2\2\2\u01b3"+
		"\u01a2\3\2\2\2\u01b3\u01a4\3\2\2\2\u01b3\u01a5\3\2\2\2\u01b3\u01a7\3\2"+
		"\2\2\u01b3\u01a9\3\2\2\2\u01b3\u01ac\3\2\2\2\u01b3\u01ad\3\2\2\2\u01b3"+
		"\u01af\3\2\2\2\u01b3\u01b0\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b4\6\3\2\2\2"+
		"\u01b5\u01b7\t\5\2\2\u01b6\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b6"+
		"\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01c6\3\2\2\2\u01ba\u01c6\t\6\2\2\u01bb"+
		"\u01bc\7f\2\2\u01bc\u01c6\7q\2\2\u01bd\u01be\7%\2\2\u01be\u01bf\7k\2\2"+
		"\u01bf\u01c0\7p\2\2\u01c0\u01c1\7e\2\2\u01c1\u01c2\7n\2\2\u01c2\u01c3"+
		"\7w\2\2\u01c3\u01c4\7f\2\2\u01c4\u01c6\7g\2\2\u01c5\u01b6\3\2\2\2\u01c5"+
		"\u01ba\3\2\2\2\u01c5\u01bb\3\2\2\2\u01c5\u01bd\3\2\2\2\u01c6\b\3\2\2\2"+
		"\7\2:\u01b3\u01b8\u01c5\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}