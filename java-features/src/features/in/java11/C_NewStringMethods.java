package features.in.java11;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class C_NewStringMethods {
    public static void main(String[] args) {

        String str = " JD ";
        System.out.print("Start");
        System.out.print(str.strip());
        System.out.println("End");

        System.out.print("Start");
        System.out.print(str.stripLeading());
        System.out.println("End");

        System.out.print("Start");
        System.out.print(str.stripTrailing());
        System.out.println("End");

        var word = "falcon ";

        System.out.println(word.repeat(5));

        var word2 = "\tnice blue\t";
        System.out.println(word2 + "sky");
        System.out.println();
        System.out.println(word2.stripTrailing() + "sky");
        System.out.println(word2.stripLeading() + "sky");
        System.out.println(word2.strip() + "sky");
        System.out.println();

        var word3 = "  ";
        System.out.println(word3.isEmpty());
        System.out.println(word3.isBlank());
        
        var words = "falcon\neagle\nsky\nwood\nforest";
        words.lines().forEach(System.out::println);

        // repeat(int) - The repeat method simply repeats the string that many numbers
        // of times as mentioned in the method in the form of an int.
        // Your code here!

        String rstr = "=".repeat(12);
        System.out.println(rstr); // prints ==

        // lines - This method returns a string array which is a collection of all
        // substrings split by lines.
        str = "JD\nJD\nJD";
        System.out.println(str);
        System.out.println(str.lines().collect(Collectors.toList()));

        // Local-Variable Syntax for Lambda Parameters
        System.out.println("J11 - Local-Variable Syntax for Lambda Parameters");
        /**
         * Local-Variable Syntax for Lambda Parameters is the only language feature
         * release in Java 11. In Java 10, Local Variable Type Inference was introduced.
         * Thus we could infer the type of the variable from the RHS – var list = new
         * ArrayList<String>();
         * 
         */
        var list = new ArrayList<String>();
        //We can now define :
        /** <pre>
        *(var s1, s2) -> s1 + s2 //no skipping allowed
        (var s1, String y) -> s1 + y //no mixing allowed

        var s1 -> s1 //not allowed. Need parentheses if you use var in lambda.
        *</pre>
        */
        
        
        

    }
}
