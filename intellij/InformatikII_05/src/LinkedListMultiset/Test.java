package LinkedListMultiset;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class Test {

    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @org.junit.Test
    public void testFaust() {

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
}