package intro.javase.essentials;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a_RegExp {

    public static void main(String[] args) {
        System.out.println(
                "Regular expressions are a way to describe a set of strings based on common characteristics shared by each string in the set. ");

    }
}

class RegexTestHarness {

    /**
     * Desc:
     * 
     * <pre>
     Enter your regex: [bcr]at
     //or  [^bcr]at, foo[1-5], foo[^1-5],  
     Enter input string to search: bat   //cat, rat, pat,...
     I found the text "bat" starting at index 0 and ending at index 3.
    
    Unions
    Enter your regex: [0-4[6-8]]  //matches the numbers 0, 1, 2, 3, 4, 6, 7, and 8.
    
    Intersections
    Enter your regex: [0-9&&[345]]   //both character classes: 3, 4, and 5.
                   [2-8&&[4-6]]   
                   
    
    Subtraction  you can use subtraction to negate one or more nested character classes, such as [0-9&&[^345]]. 
    Enter your regex: [0-9&&[^345]] //all 0-2, 5-9
     * </pre>
     * 
     */
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        while (true) {

            Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex: "));

            Matcher matcher = pattern.matcher(console.readLine("Enter input string to search: "));

            boolean found = false;
            while (matcher.find()) {
                console.format("I found the text" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
                        matcher.group(), matcher.start(), matcher.end());
                found = true;
            }
            if (!found) {
                console.format("No match found.%n");
            }
        }
    }
}

class Greedy_Reluctant_Possessive_Quantifiers {
    /**
     * There are subtle differences among greedy, reluctant, and possessive
     * quantifiers.
     * 
     * <pre>
     *  
     * Greedy quantifiers are considered "greedy" because they force the matcher
     * to read in, or eat, the entire input string prior to attempting the first
     * match. If the first match attempt (the entire input string) fails, the
     * matcher backs off the input string by one character and tries again,
     * repeating the process until a match is found or there are no more
     * characters left to back off from. Depending on the quantifier used in the
     * expression, the last thing it will try matching against is 1 or 0
     * characters.
     * 
     * The reluctant quantifiers, however, take the opposite approach: They
     * start at the beginning of the input string, then reluctantly eat one
     * character at a time looking for a match. The last thing they try is the
     * entire input string.
     * 
     * Finally, the possessive quantifiers always eat the entire input string,
     * trying once (and only once) for a match. Unlike the greedy quantifiers,
     * possessive quantifiers never back off, even if doing so would allow the
     * overall match to succeed.
     * 
     * 
     * To illustrate, consider the input string xfooxxxxxxfoo.
    
    Enter your regex: .*foo  // greedy quantifier
    Enter input string to search: xfooxxxxxxfoo
    I found the text "xfooxxxxxxfoo" starting at index 0 and ending at index 13.
    
    Enter your regex: .*?foo  // reluctant quantifier
    Enter input string to search: xfooxxxxxxfoo
    I found the text "xfoo" starting at index 0 and ending at index 4.
    I found the text "xxxxxxfoo" starting at index 4 and ending at index 13.
    
    Enter your regex: .*+foo // possessive quantifier
    Enter input string to search: xfooxxxxxxfoo
    No match found.
     * 
     * 
     * </pre>
     * 
     */

}

class SplitDemo {

    private static final String REGEX = ":";
    private static final String INPUT = "one:two:three:four:five";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        String[] items = p.split(INPUT);
        for (String s : items) {
            System.out.println(s);
        }
    }
}

class SplitDemo2 {

    private static final String REGEX = "\\d";
    private static final String INPUT = "one9two4three7four1five";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        String[] items = p.split(INPUT);
        for (String s : items) {
            System.out.println(s);
        }
    }
}

class MatcherDemo2 {

    private static final String REGEX = "\\bdog\\b";
    private static final String INPUT = "dog dog dog doggie dogg";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }
    }
}

class MatchesLooking {

    private static final String REGEX = "foo";
    private static final String INPUT = "fooooooooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String[] args) {
        System.out.println(
                "The matches and lookingAt methods both attempt to match an input sequence against a pattern. \n"
                        + "The difference, however, is that matches requires the entire input sequence to be matched, while lookingAt does not");

        // Initialize
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);

        System.out.println("Current REGEX is: " + REGEX);
        System.out.println("Current INPUT is: " + INPUT);

        System.out.println("lookingAt(): " + matcher.lookingAt());
        System.out.println("matches(): " + matcher.matches());
    }
}

class ReplaceDemo {

    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow. All dogs say meow.";
    private static String REPLACE = "cat";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }
}

class ReplaceDemo2 {

    private static String REGEX = "a*b";// 0-N
    private static String INPUT = "aabfooacabfooabfoob";
    private static String REPLACE = "-";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }
}

class RegexDemo_AppanedTail {

    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoob";
    private static String REPLACE = "-";

    /**
     * Desc:
     * 
     * <pre>
     Matcher Method Equivalents in java.lang.String
    
    For convenience, the String class mimics a couple of Matcher methods as well:
    
    • public String replaceFirst(String regex, String replacement): Replaces the first substring of this string that matches the given regular expression with the given replacement. An invocation of this method of the form str.replaceFirst(regex, repl) yields exactly the same result as the expression Pattern.compile(regex).matcher(str).replaceFirst(repl)
    • public String replaceAll(String regex, String replacement): Replaces each substring of this string that matches the given regular expression with the given replacement. An invocation of this method of the form str.replaceAll(regex, repl) yields exactly the same result as the expression Pattern.compile(regex).matcher(str).replaceAll(repl)
     * 
     * </pre>
     * 
     */
    public static void main(String[] args) {
        System.out.println(
                "The Matcher class also provides appendReplacement and appendTail methods for text replacement. ");
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // get a matcher object
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
