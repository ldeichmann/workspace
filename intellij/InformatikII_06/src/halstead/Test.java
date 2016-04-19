package halstead;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;

import static halstead.Halstead.evalHalstead;

/**
 * Created by lukas on 4/19/16.
 */
public class Test {
//
//    @org.junit.Test
//    public void testBeispiel() {
//        try {
//            CharStream input = null;
//            // Pick an input stream (filename from commandline or stdin)
//            input = new ANTLRFileStream("/home/lukas/Code/workspace/intellij/InformatikII_06/files/Beispiel.c");
//            evalHalstead(input);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    @org.junit.Test
    public void testEval1() {
        try {
            CharStream input = null;
            // Pick an input stream (filename from commandline or stdin)
            input = new ANTLRFileStream("/home/lukas/Code/workspace/intellij/InformatikII_06/files/eval1.c");
            evalHalstead(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void testMain() {
        try {
            CharStream input = null;
            // Pick an input stream (filename from commandline or stdin)
            input = new ANTLRFileStream("/home/lukas/Code/workspace/intellij/InformatikII_06/files/main.c");
            evalHalstead(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}