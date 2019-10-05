package features.in.java11;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;

class MatchPredicate {

	public static void main(String[] args) {

		var str = Pattern.compile("aba").asMatchPredicate();
		System.out.println(str.test("aabb"));
		System.out.println(str.test("aba"));

		// There is a new asMatchPredicate method for working with regular expressions.
		var words = Arrays.asList("dog", "Dog", "DOG", "Doggy");
		var asMatchPredicate = Pattern.compile("dog", Pattern.CASE_INSENSITIVE).asMatchPredicate();

		words.forEach((word) -> {
			if (asMatchPredicate.test(word)) {
				System.out.printf("%s matches%n", word);
			} else {
				System.out.printf("%s does not match%n", word);
			}
		});

		// before Java 10
		Predicate<String> asMatchPredicate2 = Pattern.compile("dog", Pattern.CASE_INSENSITIVE).asMatchPredicate();
		if (asMatchPredicate2.test("dog")) {
			System.out.println("\nmatched");
		}

	}
}
