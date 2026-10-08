package features.in.java9;
 

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalStream {

    public static void main(String[] args) {

        Stream<Optional<Integer>> optionals =
                Stream.of(Optional.of(1), Optional.empty(), Optional.of(2));

        Stream<Integer> ints = optionals.flatMap(Optional::stream);

        ints.forEach(System.out::println);

        // Find all first authors of the books
        Set<String> authors = Set.of();// TBD, Book.getBooks()
                //.map(book -> book.authors.stream().findFirst())
                //.flatMap(optAuthor -> optAuthor.stream())
                //.collect(Collectors.toSet());
        System.out.println(authors);
    }
}
