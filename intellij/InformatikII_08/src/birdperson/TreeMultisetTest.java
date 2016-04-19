package birdperson;

import LinkedListMultiset.Multiset;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class TreeMultisetTest {

    @org.junit.Test
    public void isEmpty() throws Exception {
        SuchBaum<String> tree = new SuchBaum<>();
        assertTrue(tree.isEmpty());
    }

    @org.junit.Test
    public void containsTwo() throws Exception {
        Multiset<String> tree = new TreeMultiset<>();
        tree.add("Bert");
        tree.add("Peter");
        tree.add("Peter");
        tree.add("Peter");
        tree.add("Peter");
        tree.add("Peter");
        assertTrue(tree.distinct() == 2);

        System.out.println(tree);
    }


    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @org.junit.Test
    public void testFaust() throws Exception {

        try {
            InputStream in;
            String content = readFile("/home/lukas/Documents/Faust.txt", StandardCharsets.UTF_8);
            in = new ByteArrayInputStream(content.getBytes());
            assertTrue(Wc.countWords(in) == 30628);

        } catch (IOException e) {
            e.printStackTrace();
            fail("IO Error");
        }
    }

    @org.junit.Test
    public void testHalstead() throws Exception {

        CharStream input = new ANTLRFileStream("/home/lukas/Code/workspace/intellij/InformatikII_06/files/main.c");
        halstead.evalHalstead(input);
        assertTrue(true);
    }
}