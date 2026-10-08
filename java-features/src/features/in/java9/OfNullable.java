package features.in.java9;
 

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList; 

public class OfNullable {

    public static void main(String... args ) {

        long zero = Stream.ofNullable(null).count();
       // long one = Stream.ofNullable(getBook()).count();

        System.out.printf("zero: %d, one: %d", zero) ;// , one);

        // Before ofNullable
        Book2 book = getPossiblyNull(true);
        Stream<String> authors =
                book == null ? Stream.empty() : book.authors.stream();
        authors.forEach(System.out::println);

        // With ofNullable
        Stream.ofNullable(getPossiblyNull(false))
                .flatMap(b -> b.authors.stream())
                .forEach(System.out::println);
    }

    private static Book2 getPossiblyNull(boolean isNull) {
        return isNull ? null : new Book2("Watan", 5.4); // getBook();
    }


}
