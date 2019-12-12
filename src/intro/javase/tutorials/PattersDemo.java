package intro.javase.tutorials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PattersDemo {

    public static void main(String[] args) {

        /**
         * Capturing Groups
         * 
         * <pre>
         * 
         * 
         * Capturing groups are a way to treat multiple characters as a single
         * unit. They are created by placing the characters to be grouped inside
         * a set of parentheses. For example, the regular expression (dog)
         * creates a single group containing the letters "d", "o", and "g".
         * 
         * Capturing groups are numbered by counting their opening parentheses
         * from the left to the right. In the expression ((A)(B(C))), for
         * example, there are four such groups − ((A)(B(C))) (A) (B(C)) (C)
         * 
         * To find out how many groups are present in the expression, call the
         * groupCount method on a matcher object. The groupCount method returns
         * an int showing the number of capturing groups present in the
         * matcher's pattern.
         * 
         * There is also a special group, group 0, which always represents the
         * entire expression. This group is not included in the total reported
         * by groupCount.
         * </pre>
         * 
         */
        // String to be scanned to find the pattern.
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
        } else {
            System.out.println("NO MATCH");
        }
    }

}

class RegexMatches2 {

    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT = "cat cat cat cattie cat";

    public static void main(String args[]) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // get a matcher object
        int count = 0;

        while (m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }
    }
}

class RegexMatches3 {

    private static final String REGEX = "foo";
    private static final String INPUT = "fooooooooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String args[]) {
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);

        System.out.println("Current REGEX is: " + REGEX);
        System.out.println("Current INPUT is: " + INPUT);

        System.out.println("lookingAt(): " + matcher.lookingAt());
        System.out.println("matches(): " + matcher.matches());
    }
}

class RegexMatches4 {

    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow. " + "All dogs say meow.";
    private static String REPLACE = "cat";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);

        // get a matcher object
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }
}