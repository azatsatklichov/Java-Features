package features.in.java9;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class NewCollectors {
	public static void main(String... args) {
		Stream<Book2> books = Book2.getBooks();

		// Collect all books costing more than 10, grouped by author(s)
		Map<Set<String>, Set<Book2>> booksByAuthors = books.collect(groupingBy(Book2::getAuthors, 
				filtering(b -> b.getPrice() > 10, toSet())));
		System.out.println(booksByAuthors);

		books = Book2.getBooks();
		// Collect all authors that sell books at a given price
		Map<Double, Set<String>> authorsSellingForPrice = books
				.collect(groupingBy(Book2::getPrice, 
						flatMapping(b -> b.getAuthors().stream(), toSet())));
		System.out.println(authorsSellingForPrice);
	}
}
