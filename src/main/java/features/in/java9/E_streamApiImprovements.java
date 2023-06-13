package features.in.java9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * <pre>
 *
 * Streams were introduced in Java to help developers perform aggregate
 * operations from a sequence of objects. With Java 9, few more methods are
 * added to make streams better.
 * </pre>
 */
public class E_streamApiImprovements {
	public static void main(String[] args) {
		/**
		 * takeWhile method takes all a, b, and c values, then once string is empty, it
		 * stopped executing.
		 */
		System.out.println("takeWhile");
		Stream.of("a", "b", "c", " ", "d", "", "z").takeWhile(s -> !s.isEmpty()).forEach(System.out::print);// see
																											// isBlank
																											// below
		System.out.println();
		System.out.println();

		Stream.of("a", "b", "c", " ", "d", "", "z").takeWhile(s -> !s.isBlank()).forEach(System.out::print);
		System.out.println();

		/**
		 * dropWhile method throw away all the values at the start until the predicate
		 * returns true. It returns, in case of ordered stream, a stream consisting of
		 * the remaining elements of this stream after dropping the longest prefix of
		 * elements matching the given predicate.
		 */
		System.out.println("dropWhile");
		Stream.of("a", "b", "c", " ", "d", "", "z").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);// causes
																											// break: ""
		System.out.println();
		Stream.of("a", "b", "c", " ", "d", "", "  ", "z").dropWhile(s -> !s.isBlank()).forEach(System.out::print);// causes
																													// break:
																													// "
																													// "
		System.out.println();
		System.out.println();

		Stream.of("a", "b", "c", "", "e", "f").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);
		System.out.println();
		Stream.of("a", "b", "c", "", "e", " ", "f").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);
		System.out.println();

		// old way
		List<Integer> ints = List.of(1, 2, 3, 44, -4);
		ints.stream().forEach(System.out::print);
		System.out.println();

		IntStream stm = IntStream.of(-7, 44, 54, 4545);
		for (Iterator iterator = stm.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println("==>  " + integer);
		}
		

		/**
		 * Iterate method now has hasNext predicate as parameter which stops the loop
		 * once hasNext predicate returns false.
		 * 
		 * Before it was just iterating it, ...
		 */
		IntStream.iterate(0, x -> x < 100, i -> i + 4).forEach(System.out::print);

		IntStream.iterate(0, x -> x < 100, i -> i + 4).forEach(System.out::print);

		List<String> ll = List.of("a", "b", "c"); // getList();
		Stream<String> stream = ll == null ? Stream.empty() : ll.stream();

		// or via:
		// org.apache.commons.collections4.CollectionUtils.emptyIfNull(list).stream().filter(...);

		// or
		stream = Optional.ofNullable(ll).orElse(List.of()).stream();

		/**
		 *
		 * /** ofNullable method is introduced to prevent NullPointerExceptions and to
		 * avoid null checks for streams. This method returns a sequential Stream
		 * containing single element, if non-null, otherwise returns an empty Stream.
		 */
		System.out.println();
		long count = Stream.ofNullable(100).count();
		System.out.println(count);

		count = Stream.ofNullable(null).count();
		System.out.println(count);

		count = Stream.ofNullable(ll).count();
		System.out.println(count);

		Set<String> ss = null; // TBD
		Stream<String> stream1 = ss == null ? Stream.empty() : ss.stream();

		// Stream<Set<String>> ss1 = Stream.ofNullable(ss);
		count = Stream.ofNullable(ss).count();
		System.out.println(count);

	}
}

class Example {

	private final static String filePath = "\\workspace-17\\Java-Features";

	public static void main(String[] args) {
		// Java 7 Path.of
		//explicitly 
		//Path path = Path.of("c:", filePath, "\\src\\main\\java\\features\\in\\java9\\jshell");
		Path path = Path.of(filePath, "\\src\\main\\java\\features\\in\\java9\\jshell");
		
		// Java 8 Files.lines
		try (Stream<String> linesStream = Files.lines(path)) {
			Predicate<String> hasArrow = s -> s.contains("==>");
			Predicate<String> hasJShell = s -> !s.contains("jshell");
			linesStream.dropWhile(Predicate.not(hasArrow)) // .skip(1)
					.takeWhile(hasJShell).forEach(System.out::println);
		} catch (IOException e) {
			System.err.println("Err" + e);
		}
	}
}
