package features.in.java9;

import java.awt.print.Book;
import java.util.Optional;
import java.util.Set;

public class OptionalOr {
	public static void main(String... args) {
	//	Optional<Book> localFallback = Optional.of(new Book2("Oka", 4.4)); // Book2.getBook()

		// Before Optional.or
	//	Book bestBookBefore = getBestOffer().orElse(getExternalOffer().orElse(localFallback.get())); // .get() is BAD!

	//	Optional<Book> bestBook = getBestOffer().or(() -> getExternalOffer()).or(() -> localFallback);
		//System.out.println(bestBook);
	}

	static Optional<Book2> getBestOffer() {
		return Optional.empty();
	}

	static Optional<Book2> getExternalOffer() {
		return Optional.of(new Book2("External Book", Set.of(), 11.99));
	}
}