package features.in.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsDemo {

	public static void main(String[] args) {
		//https://howtodoinjava.com/java8/java-streams-by-examples/
		
		System.out.println(
				"\nStream is a new abstract layer introduced in Java 8. Using stream, you can process data in a declarative way similar to SQL statements.");
		System.out.println(
				"To resolve such issues, Java 8 introduced the concept of stream that lets the developer to process data declaratively and \n"
						+ "leverage multicore architecture without the need to write any specific code for it.");

		Random random = new Random();
		IntStream ints = random.ints();
		ints.limit(4).forEach(System.out::println);

		System.out.println("\nThe  - sorted -  method is used to sort the stream.");
		random.ints().limit(10).sorted().forEach(System.out::println);

		List<Integer> integers = Arrays.asList(2, 4, 1, 3, 8, 4, 7, 5, 9, 6, 8);
		integers.stream().sorted((i1, i2) -> i2.compareTo(i1)).forEach(System.out::println);
		System.out.println("squaresList = " + integers.stream().map(i -> i * i).collect(Collectors.toList()));
		System.out.println(
				"distinct squaresList = " + integers.stream().map(i -> i * i).distinct().collect(Collectors.toList()));

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		strings.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.println(
				"\nCollectors are used to combine the result of processing on the elements of a stream. Collectors can be used to return a list or a string.");

		strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println(
				"Filtered List: " + strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()));
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining("; ")); // count()
		System.out.println("Merged String: " + mergedString);
		Long collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.counting());
		System.out.println("collect: " + collect);

		System.out.println(
				"\nWith Java 8, statistics collectors are introduced to calculate all statistics when stream processing is being done. ");
		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());

		System.out.println("\n StringJoiner");
		// Join String by a delimiter
		StringJoiner sj = new StringJoiner(",");
		sj.add("aaa");
		sj.add("bbb");
		sj.add("ccc");
		System.out.println(sj); // sj.toString() = aaa,bbb,ccc

		// Join String by a delimiter and starting with a supplied prefix and ending
		// with a supplied suffix.
		sj = new StringJoiner("/", "before-", "-after");// delimiter, prefix, suffix
		sj.add("2019");
		sj.add("06");
		sj.add("26");
		System.out.println(sj); // sj.toString() = //before-2019/06/26-after

		System.out.println("\n String.join ");
		// Join String by a delimiter.
		String result = String.join("-", "2019", "10", "31", "00");
		System.out.println(result); // 2019-10-31-00

		// Join a List by a delimiter.
		List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
		result = String.join(", ", list);
		System.out.println(result); // java, python, nodejs, ruby

		System.out.println("\n Collectors.joining ");
		result = list.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(" | "));
		System.out.println(result); // JAVA | PYTHON | NODEJS | RUBY

		result = list.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", ", "{", "}"));
		System.out.println(result); // JAVA | PYTHON | NODEJS | RUBY

		System.out.println("\n Parallel array sorting  ");
		int[] intArray = { 18, 1, 14, 2, 15, 12, 5, 4 };
		System.out.println(Arrays.toString(intArray)); 
		// Parallel Sorting
		Arrays.parallelSort(intArray);
		System.out.println("---After Parallel Sort---");
		System.out.println(Arrays.toString(intArray)); 

	}

}