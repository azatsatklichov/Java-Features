package features.in.java11;

import java.util.Optional;
import java.util.function.Predicate;

public class TransformNullOrEmptyElementIntoEmptyOptional {

	public static void main(String[] args) {

		/**
		 * Getting an empty Optional out of null is straightforward — we just use
		 * Optional.ofNullable().
		 */
		Optional<String> ofNullable = Optional.ofNullable(null);
		if (ofNullable.isEmpty()) {
			System.out.println("yes empty ");
			System.out.println(ofNullable.orElse(""));
		}

		// But, what if we want empty Strings to work this way as well?
		// Java 8
		String str = "";
		Optional<String> opt2 = Optional.ofNullable(str).filter(s -> !s.isEmpty());
		if (opt2.isEmpty()) {
			System.out.println(opt2.orElse(""));
		}

		// Java 11 - Predicate.not()
		opt2 = Optional.ofNullable(str).filter(Predicate.not(String::isEmpty));
		if (opt2.isEmpty()) {
			System.out.println(opt2.orElse(""));
		}

		// Using Google Guava: first convert an empty String to null
		// opt = Optional.ofNullable(Strings.emptyToNull(str));

		Optional opt = Optional.empty();
		System.out.println(opt.isEmpty());

		opt = Optional.of("TonyStark");
		System.out.println(opt.isEmpty());

	}

}
