<<<<<<< HEAD
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

=======
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

    @Test
    public void testSnippet1() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("\`google.com");
        exp.add("google.com");
        exp.add("ucsd.edu");

        String content = Files.readString(Path.of("snippet1.md"));

        assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void testSnippet2() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("a.com");
        exp.add("a.com(())");
        exp.add("example.com");

        String content = Files.readString(Path.of("snippet2.md"));

        assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void testSnippet3() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("https://www.twitter.com");
        exp.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        exp.add("https://cse.ucsd.edu/");

        String content = Files.readString(Path.of("snippet3.md"));

        assertEquals(exp, MarkdownParse.getLinks(content));
    }
    
}

>>>>>>> ca9185a5ad6904d027fded09fb5e53d0f2635612
