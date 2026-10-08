package features.in.java11;

import java.util.Arrays;
import java.util.regex.Pattern;

public class D_asMatchPredicate {

    public static void main(String[] args) {
        //There is a new asMatchPredicate method for working with regular expressions.
        var words = Arrays.asList("dog", "Dog", "DOG", "Doggy");

        var pred = Pattern.compile("dog", Pattern.CASE_INSENSITIVE).asMatchPredicate();
        //before Java 10
        // Predicate<String> asMatchPredicate = Pattern.compile("dog", Pattern.CASE_INSENSITIVE).asMatchPredicate();

        words.forEach((word) -> {
            
            if (pred.test(word)) {
                System.out.printf("%s matches%n", word);
            } else {
                System.out.printf("%s does not match%n", word);
            }
        });
    }
}
