package best.practices.lambdas.and.streams.not.doneyet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class StreamsProperUsage {
	public static void main(String[] args) throws FileNotFoundException {
		String path; // = args[0]
		path = "C:\\workspace-17\\java-in-deep\\src-practical\\net\\sahet\\streams\\and\\effective\\lambdas\\freq.txt";
		File file = new File(path);
		Map<String, Long> freq = new HashMap<>();

		// Uses the streams API but not the paradigm--Don't do this!
		try (Stream<String> words = new Scanner(file).tokens()) {
			words.forEach(word -> {
				/*
				 * collection must be effectively final here
				 */
				freq.merge(word.toLowerCase(), 1L, Long::sum);
			});
		}

		System.out.println(freq);
		Map<String, Long> freq2 = new HashMap<>();

		// Proper use of streams to initialize
		try (Stream<String> words = new Scanner(file).tokens()) {
			/*
			 * Performs a mutable reduction operation on the elements of this stream using a
			 * Collector.
			 */
			// freq2 =
			// words.peek(System.out::println).collect(groupingBy(String::toLowerCase,
			// counting()));
			freq2 = words.collect(groupingBy(String::toLowerCase, counting()));
		}

		System.out.println(freq2);

		// get top-ten frequent words
		List<String> topTen = freq.keySet().stream().sorted(comparing(freq::get).reversed()).limit(10)
				.collect(toList());

		System.out.println(topTen);
	}
}

class CharStream {
	public static void main(String[] args) {
		// result is now what we expected
		"Hello world!".chars().forEach(System.out::print);
		// just cast it 
		System.out.println();
		"Hello world!".chars().forEach(x -> System.out.print((char) x));
		System.out.println();

		// Fixes the problem
		"Hello world!".chars().forEach(x -> System.out.print((char) x));
		System.out.println();
	}
}
