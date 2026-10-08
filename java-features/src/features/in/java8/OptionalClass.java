package features.in.java8;

import java.util.Optional;

/**
 * Desc:
 * 
 * Optional is a container object used to contain not-null objects. Optional
 * object is used to represent null with absent value. This class has various
 * utility methods to facilitate code to handle values as �available� or �not
 * available� instead of checking null values. It is introduced in Java 8 and is
 * similar to what Optional is in Guava.
 * 
 * 
 */
public class OptionalClass {

	public static void main(String[] args) {
		System.out.println("It is introduced in Java 8 and is similar to what Optional is in Guava.");
		OptionalClass java8Tester = new OptionalClass();
		Integer value1 = null;
		Integer value2 = new Integer(10);

		System.out.println();

		// Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);
		System.out.println(a); // java.util.NoSuchElementException: No value present
		// System.out.println(a.get());
		System.out.println("you see : isPresent  = " + a.isPresent());
		// Optional<Integer> a2 = Optional.of(value1);
		// //java.lang.NullPointerException
		// System.out.println(a2);

		// Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);
		System.out.println(java8Tester.sum(a, b));

		// long way
		Optional<Integer> o = Optional.of(23);
		if (o.isPresent()) {
			System.out.println("Value = " + o.get());
		} else {
			System.out.println("Empty  ");
		}

		// better way
		System.out.println("Value = " + o.orElse(0));

		o = Optional.ofNullable(null);
		System.out.println("Value = " + o.orElse(0));

		// 3 ways of throwing exception
		o.orElseThrow(() -> new AppException("No value present"));
		o.orElseThrow(AppException::new);
		// Java 10
		o.orElseThrow();
		// See Java 9 ways

		/**
		 * See {@link OptionalClassImprovements}
		 */

	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		// Optional.isPresent - checks the value is present or not

		System.out.println("a is present: " + a.isPresent());
		System.out.println("b is present: " + b.isPresent());

		// Optional.orElse - returns the value if present otherwise returns
		// the default value passed.
		Integer value1 = a.orElse(new Integer(0));

		// Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		// Integer value2 = a.get(); //java.util.NoSuchElementException: No value
		// present
		return value1 + value2;
	}

}

class AppException extends RuntimeException {

	public AppException(String message) {
		super(message);
	}

	public AppException() {
	}

}
