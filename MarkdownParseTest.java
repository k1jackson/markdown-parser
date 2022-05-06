import static org.junit.Assert.*; // Imports JUnit's Assert class to access static methods
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*; // Imports JUnit

public class MarkdownParseTest { // Creates class MarkdownParseTest
    @Test
    public void testFile() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("https://something.com");
        exp.add("some-thing.html");

        String content = Files.readString(Path.of("test-file.md"));

        assertEquals(exp, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFileImg() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("https://something.com");

        String content = Files.readString(Path.of("test-file-img.md"));

        assertEquals(exp, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFileParen() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();

        String content = Files.readString(Path.of("test-file-paren.md"));

        assertEquals(exp, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFileParenLink() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("https://www.example.com/(parenthesis)");
        exp.add("https://www.example.com/(parenthesis)");
        exp.add("https://www.example.com/(par(en)thesis)");

        String content = Files.readString(Path.of("test-file-paren-link.md"));

        assertEquals(exp, MarkdownParse.getLinks(content));
    }
    // Make change
}

