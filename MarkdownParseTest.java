import static org.junit.Assert.*; // Imports JUnit's Assert class to access static methods
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*; // Imports JUnit

public class MarkdownParseTest { // Creates class MarkdownParseTest
    @Test // Indicates to JUnit that addition is a tester method
    public void addition() { // Creates method addition
        assertEquals(2, 1 + 1); // Tests the value 2 against 1 + 1
    }

    @Test
    public void testFile() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("https://something.com");
        exp.add("some-thing.html");

        String content = Files.readString(Path.of("test-file.md"));

        assertEquals(exp, MarkdownParse.getLinks(content));
    }
}

