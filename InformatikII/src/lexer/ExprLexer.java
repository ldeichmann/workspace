package lexer;

/***
 * Excerpted from "Language Implementation Patterns",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book information.
***/
public class ExprLexer extends Lexer {
    public static final int INT 	 	= 2;
    public static final int PLUS 	 	= 3;
    public static final int MINUS  		= 4;
    public static final int UMINUS		= 5;
    public static final int MUL 	 	= 6;
    public static final int DIV 		= 7;
    public static final int POW 		= 8;
    public static final int NL   		= 9;
    public static String[] tokenNames =
        { "n/a","<EOF>","INT","PLUS","MINUS","UMINUS", "MUL","DIV","POW","NL"};
    public String getTokenName(int x) { return tokenNames[x]; }

    public ExprLexer(String input) { super(input); }
    boolean isDIGIT()  { return c>='0'&&c<='9'; }

    public Token nextToken() {
        while ( c!=EOF ) {
            switch ( c ) {
                case ' ': case '\t':  WS(); continue;
                case '\r': consume();
                case '\n': consume(); return new Token(NL,"<NL>");
                case '+' : consume(); return new Token(PLUS, "+");
                case '-' : consume(); return new Token(MINUS, "-");
                case '#' : consume(); return new Token(UMINUS, "#");
                case '*' : consume(); return new Token(MUL, "*");
                case '/' : consume(); return new Token(DIV, "/");
                case '^' : consume(); return new Token(POW, "^");

                default:
                    if ( isDIGIT()  ) return INT();
                    throw new Error("invalid character: "+c);
            }
        }
        return new Token(EOF_TYPE,"<EOF>");
    }

    /** INT : ('0'..'9')+; // NAME is sequence of >=1 letter */
    Token INT() {
        StringBuilder buf = new StringBuilder();
        do { buf.append(c); consume(); } while ( isDIGIT() );
        return new Token(INT, buf.toString());
    }
    /** WS : (' '|'\t')* ; // ignore any whitespace */
    void WS() {
        while ( c==' ' || c=='\t' ) consume();
    }
}
