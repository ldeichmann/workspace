package halstead;

import LinkedListMultiset.LinkedMultiset;
import LinkedListMultiset.Multiset;
import halstead.lexer.HalsteadLexer;
import org.antlr.runtime.*;

public class Halstead {

    //Methode zum Auflisten der Operatoren / Operanden
    public static void list(Multiset<String> operand,
                            Multiset<String> operator) {
        System.out.println("Operand ------- Haeufigkeit\n" + operand);
        System.out.println("Operator ------- Haeufigkeit\n" + operator);
    }

    /*
     * Methode zum bestimmen der ProgrammLänge
     * return Programmlänge(Operanden + Operatoren)
     */
    public static double ProgramLength(Multiset<String> operand,
                                        Multiset<String> operator) {
        return operand.size() + operator.size();
    }

    /*
     * Methode zur Ausgabe der Vokabulargröße
     * return Vokabulargröße (unterschiedliche Operatoren + Operanden)
     */
    public static double VocabularySize(Multiset<String> operand,
                                         Multiset<String> operator) {
        return operand.distinct() + operator.distinct();
    }

    /*
     * Methode zur Ausgabe des Volumes
     * return Volumen (Programmlänge * log2(Volumen))
     */
    public static double Volume(Multiset<String> operand,
                                 Multiset<String> operator) {
        return ((operand.size() + operator.size())
                * Math.log((operand.distinct() + operator.distinct())) / Math
                .log(2));
    }

    /*
     * Methode zur Berechnung der Difficulty
     */
    public static double Difficulty(Multiset<String> operand,
                                    Multiset<String> operator) {
        if (operand.distinct() != 0 && operator.distinct() != 0)
            return (operator.distinct() / (double)2)
                    * ((double)operand.size() / operand.distinct());
        else
            return 0;
    }

    /*
     * Methode zur Berechnung des Efforts
     * return Effort(Volume * Difficulty)
     */
    public static double Effort(Multiset<String> operand,
                                 Multiset<String> operator) {
        return Volume(operand, operator) * Difficulty(operand, operator);
    }

    public static void evalHalstead(CharStream HalsteadStream) {

        HalsteadLexer lex = new HalsteadLexer(HalsteadStream);

        Multiset<String> operator = new LinkedMultiset<String>();
        Multiset<String> operand = new LinkedMultiset<String>();


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
//        list(operand, operator);
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
