package features.in.java9;

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
        Stream.of("a", "b", "c", " ", "d", "", "z").takeWhile(s -> !s.isEmpty()).forEach(System.out::print);
        System.out.println();

        /**
         * dropWhile method throw away all the values at the start until the predicate
         * returns true. It returns, in case of ordered stream, a stream consisting of
         * the remaining elements of this stream after dropping the longest prefix of
         * elements matching the given predicate.
         */
        Stream.of("a", "b", "c", " ", "d", "", "z").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);
        System.out.println();
        Stream.of("a", "b", "c", "", "e", "f").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);
        System.out.println();
        Stream.of("a", "b", "c", "", "e", " ", "f").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);
        System.out.println();

        /**
         * iterate method now has hasNext predicate as parameter which stops the loop
         * once hasNext predicate returns false.
         */
        IntStream.iterate(0, x -> x < 100, i -> i + 4).forEach(System.out::print);

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

    }
}
