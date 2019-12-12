package intro.javase.essentials;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

class TestFormat {

    public static void main(String[] args) {
        long n = 461012;
        System.out.format("%d%n", n); // --> "461012"
        System.out.format("%08d%n", n); // --> "00461012"
        System.out.format("%+8d%n", n); // --> " +461012"
        System.out.format("%,8d%n", n); // --> " 461,012"
        System.out.format("%+,8d%n%n", n); // --> "+461,012"

        double pi = Math.PI;

        System.out.format("%f%n", pi); // --> "3.141593"
        System.out.format("%.3f%n", pi); // --> "3.142"
        System.out.format("%10.3f%n", pi); // --> " 3.142"
        System.out.format("%-10.3f%n", pi); // --> "3.142"
        System.out.format(Locale.FRANCE, "%-10.4f%n%n", pi); // --> "3,1416"

        Calendar c = Calendar.getInstance();
        System.out.format("%tB %te, %tY%n", c, c, c); // --> "May 29, 2006"

        System.out.format("%tl:%tM %tp%n", c, c, c); // --> "2:34 am"

        System.out.format("%tD%n", c); // --> "05/29/06"
    }
}

class DecimalFormatDemo2 {

    static public void customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + "  " + pattern + "  " + output);
    }

    static public void main(String[] args) {

        customFormat("###,###.###", 123456.789);
        customFormat("###.##", 123456.789);
        customFormat("000000.000", 123.78);
        customFormat("$###,###.###", 12345.67);
    }
}

class StringDemo {
    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];

        // put original string in an
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] = palindrome.charAt(i);
        }

        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] = tempCharArray[len - 1 - j];
        }

        String reversePalindrome = new String(charArray);
        System.out.println(reversePalindrome);
    }
}

class ValueOfDemo {
    public static void main(String[] args) {

        // this program requires two
        // arguments on the command line
        if (args.length == 2) {
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue();
            float b = (Float.valueOf(args[1])).floatValue();

            // do some arithmetic
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));
        } else {
            System.out.println("This program " + "requires two command-line arguments.");
        }
    }
}

class RegionMatchesDemo {
    public static void main(String[] args) {
        String searchMe = "Green Eggs and Ham";
        String findMe = "Eggs";
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;
        for (int i = 0; i <= (searchMeLength - findMeLength); i++) {
            if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                foundIt = true;
                System.out.println(searchMe.substring(i, i + findMeLength));
                break;
            }
        }
        if (!foundIt)
            System.out.println("No match found.");
    }
}

class StringDemo2 {
    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];

        // put original string in an
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] = palindrome.charAt(i);
        }

        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] = tempCharArray[len - 1 - j];
        }

        String reversePalindrome = new String(charArray);
        System.out.println(reversePalindrome);
    }
}
