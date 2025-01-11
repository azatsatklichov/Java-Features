package best.practices.lambdas.and.streams.not.doneyet;

import java.util.*;
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
public class StreamApiImprovementsJava9 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * takeWhile method takes all a, b, and c values, then once string is empty, it
		 * stopped executing.
		 */
		System.out.println("takeWhile()");
		Stream.of("a", "b", "c", " ", "d", "", "z").takeWhile(s -> !s.isEmpty()).forEach(System.out::print);// see
																											// isBlank

		Stream.of("a", "b", "c", " ", "d", "", "z").takeWhile(s -> !s.isBlank()).forEach(System.out::print);
		System.out.println();

		/**
		 * dropWhile method throw away all the values at the start until the predicate
		 * returns true. It returns, in case of ordered stream, a stream consisting of
		 * the remaining elements of this stream after dropping the longest prefix of
		 * elements matching the given predicate.
		 */
		System.out.println("\ndropWhile()");
		Stream.of("a", "b", "c", " ", "d", "", "z").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);// causes
																											// break: ""
		System.out.println();
		Stream.of("a", "b", "c", " ", "d", "", "  ", "z").dropWhile(s -> !s.isBlank()).forEach(System.out::print);// causes
																													// break:

		Stream.of("a", "b", "c", "", "e", "f").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);
		System.out.println();
		Stream.of("a", "b", "c", "", "e", " ", "f").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);
		System.out.println();

		System.out.println("\nList creation ways");
		List<String> lists = new ArrayList<>(Arrays.asList("Enar", "Alma", "Erik", "Nar", "Uzum", "Setdaly"));
		System.out.println(lists);
		// or classic
		lists.add("Behi");
		System.out.println(lists);

		List<Integer> ints = List.of(1, 2, 3, 44, -4);
		ints.stream().forEach(System.out::print);
		System.out.println();

		System.out.println("\n via Stream.of");
		IntStream stm = IntStream.of(-7, 44, 54, 4545);
		for (Iterator iterator = stm.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println("==>  " + integer);
		}

		System.out.println("\n via IntStream.iterate");
		/**
		 * Iterate method now has hasNext predicate as parameter which stops the loop
		 * once hasNext predicate returns false.
		 * 
		 * Before it was just iterating it, ...
		 */
		IntStream.iterate(0, x -> x < 100, i -> i + 12).peek(x -> System.out.print(" ")).forEach(System.out::print);
		System.out.println();
		IntStream.iterate(0, x -> x < 100, i -> i + 15).peek(x -> System.out.print(" ")).forEach(System.out::print);
		System.out.println();

		System.out.println("\nOptional.ofNullable");
		List<String> ll = List.of("a", "b", "c"); // = null;
		Stream<String> stream = ll == null ? Stream.empty() : ll.stream();

		stream = Optional.ofNullable(ll).orElse(List.of()).stream();
		stream.peek(x -> System.out.print(" ")).forEach(System.out::print);

		// or via:
		// org.apache.commons.collections4.CollectionUtils.emptyIfNull(list).stream().filter(...);

		System.out.println(
				"\nStream.ofNullable - Returns a sequential Stream containing a single element or return empty");
		/**
		 * Returns a sequential Stream containing a single element, ifnon-null, //
		 * otherwise returns an empty
		 *
		 * /** ofNullable method is introduced to prevent NullPointerExceptions and to
		 * avoid null checks for streams. This method returns a sequential Stream
		 * containing single element, if non-null, otherwise returns an empty Stream.
		 */
		Stream<Integer> ofNullable = Stream.ofNullable(100);
		System.out.println(ofNullable.count());// 1
		System.out.println(Stream.ofNullable(null).count());// 0

		System.out.println(Stream.ofNullable(ll).count());// 1
		Set<String> ss = null;
		Stream<String> stream1 = ss == null ? Stream.empty() : ss.stream();
		System.out.println(Stream.ofNullable(ss).count());
		Stream<Set<String>> ss1 = Stream.ofNullable(ss);// 0
		ss1.peek(x -> System.out.print(" ")).forEach(System.out::print);
	}
}