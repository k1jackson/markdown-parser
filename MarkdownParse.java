//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//https://www.geeksforgeeks.org/check-if-url-is-valid-or-not-in-java/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.net.URL;

public class MarkdownParse {

    public static boolean isValid (String link) {
        try {
            new URL(link).toURI();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static int parens (String link) {
        int count = 0;
        for (int i = 0; i < link.length(); i++) {
            if (link.charAt(i) == '(') count++;
            if (link.charAt(i) == ')') count--;
        }
        return count;
    }

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length() && markdown.substring(currentIndex).contains("(")) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            String link = markdown.substring(openParen + 1, closeParen);

            while (parens(link) != 0) {
                closeParen = markdown.indexOf(")", closeParen + 1);
                link = markdown.substring(openParen + 1, closeParen);
            }

            if (openBracket < 0) { // No brackets
                if (isValid(link)) { toReturn.add(link); }
            } else if  (openBracket > 0) {
                if (!(markdown.charAt(openBracket - 1) == '!')) { toReturn.add(link); }
            } else {
                toReturn.add(link);
            }
            
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }
    // Make change


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
