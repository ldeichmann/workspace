package birdperson;

import LinkedListMultiset.Multiset;
import halstead.Halstead;
import halstead.lexer.HalsteadLexer;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;

public class halstead extends Halstead {

    public static void evalHalstead(CharStream HalsteadStream) {

        HalsteadLexer lex = new HalsteadLexer(HalsteadStream);

        Multiset<String> operator = new TreeMultiset<String>();
        Multiset<String> operand = new TreeMultiset<String>();


        Token t = lex.nextToken();
        while( t.getType()!= Token.EOF) {
            //HalsteadLexer.EOF works as well
            int line  = t.getLine();
            int pos = t.getCharPositionInLine();
            String lexem = t.getText();
            switch(t.getType()) {
                case HalsteadLexer.OPERATOR:
                    operator.add(t.getText());
                    break;
                case HalsteadLexer.OPERAND:
                    operand.add(t.getText());
                    break;
            }
            t = lex.nextToken();
        }
        list(operand, operator);
        System.out.println("Programmlänge : "
                + ProgramLength(operand, operator));
        System.out.println("Anzahl der Operatoren: " + operator.size());
        System.out.println("Anzahl der Operanden: " + operand.size());
        System.out.println("Vokabulargröße: "
                + VocabularySize(operand, operator));
        System.out.println("Anzahl verschiedener Operatoren: " + operator.distinct());
        System.out.println("Anzahl verschiedener Operanden: " + operand.distinct());
        System.out.println("Volumen:  " + Volume(operand, operator));
        System.out.println("Difficulty: " + Difficulty(operand, operator));
        System.out.println("Aufwand: " + Effort(operand, operator));

    }

    public static void main(String args[]) {

        try {
            CharStream input = null;
            // Pick an input stream (filename from commandline or stdin)
            if (args.length > 0)
                input = new ANTLRFileStream(args[0]);
            else
                input = new ANTLRInputStream(System.in);

            evalHalstead(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
