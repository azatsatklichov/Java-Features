package features.in.java9;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class TakeDropWhile {

	public static void main(String... args) {

		// Before takeWhile
		IntStream.range(1, 100).filter(i -> i < 4) // applied to all elements
				.forEach(System.out::println);

		// With takeWhile, only the first 4 elements are
		// evaluated against the predicate.
		IntStream.range(1, 100).takeWhile(i -> i < 4) // short-circuits on element '4'
				.forEach(System.out::println);

		// Before dropWhile
		IntStream.range(1, 10).filter(i -> i >= 4).forEach(System.out::println);

		// With dropWhile (only works if Stream is sorted!)
		IntStream.range(1, 10).dropWhile(i -> i < 4).forEach(System.out::println);
	}

}

class FindGitConflict {

	public static void main(String... args) throws Exception {

		// Files.lines -> Stream<String>
		Files.lines(Paths.get("C:\\workspace-JavaNew\\Java-Features\\src\\main\\java\\features\\in\\java9\\z-links"))
				.dropWhile(l -> !l.contains("<<<<<<<")).skip(1).takeWhile(l -> !l.contains(">>>>>>>"))
				.forEach(System.out::println);

	}

}
