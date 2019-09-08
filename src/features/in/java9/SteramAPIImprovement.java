package features.in.java9;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * 
 * There are four new methods added to the Stream interface:
 * 
 * dropWhile - method takes all the values until the predicate returns false.
 * 
 * takeWhile - method throw away all the values at the start until the predicate
 * returns true.
 * 
 * iterate - overloaded method now has hasNext predicate as parameter which
 * stops the loop once hasNext predicate returns false.
 * 
 * ofNullable - lets you create a single-element stream which wraps a value if
 * not null, or is an empty stream otherwise.
 * 
 *
 */
public class SteramAPIImprovement {

	public static void main(String[] args) {
		Stream.of("a", "b", "c", "", "e", "f").takeWhile(s -> !s.isEmpty()).forEach(System.out::print);

		System.out.println();
		Stream.of("a", "b", "c", "", "e", "f").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);

		// Java 8
		System.out.println();
		IntStream.iterate(3, x -> x + 3).limit(6).forEach(x -> System.out.printf("%d ", x));

		// Java 9
		System.out.println();
		IntStream.iterate(3, x -> x < 19, x -> x + 3).forEach(x -> System.out.printf("%d ", x));

		// Technically, Stream.ofNullable() is very similar to null condition check
		System.out.println();
		Stream<String> stream = Stream.ofNullable("123");
		System.out.println(stream.count());

		stream = Stream.ofNullable(null);
		System.out.println(stream.count());

	}

}
