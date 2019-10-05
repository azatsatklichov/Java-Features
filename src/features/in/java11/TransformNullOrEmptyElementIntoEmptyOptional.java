package features.in.java11;

import static java.util.function.Predicate.not;

import java.util.Optional;

public class TransformNullOrEmptyElementIntoEmptyOptional {

	public static void main(String[] args) {

		/**
		 * Getting an empty Optional out of null is straightforward — we just use
		 * Optional.ofNullable().
		 */
		Optional<String> ofNullable = Optional.ofNullable(null);
		if (ofNullable.isEmpty()) {
			System.out.println(ofNullable.get());
		}

		// But, what if we want empty Strings to work this way as well?
		// Java 8
		String str = "";
		Optional<String> opt = Optional.ofNullable(str).filter(s -> !s.isEmpty());
		if (opt.isEmpty()) {
			System.out.println(opt.orElse(""));
		}

		// Java 11 - Predicate.not()
		opt = Optional.ofNullable(str).filter(not(String::isEmpty));
		if (opt.isEmpty()) {
			System.out.println(opt.orElse(""));
		}
		
		
		
		//Using Google Guava:  first convert an empty String to null
		//	opt = Optional.ofNullable(Strings.emptyToNull(str));
		

	}

}
