package best.practices.lambdas.and.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * STREAMs
 *
 * <pre>
 Stream is a new abstract layer introduced in Java 8. Using stream, you can process data in a declarative way similar to SQL statements. For example, consider the following SQL statement.
 SELECT max(salary), employee_id, employee_name FROM Employee

 The above SQL expression automatically returns the maximum salaried employee's details, without doing any computation on the developer's end. Using collections
 framework in Java, a developer has to use loops and make repeated checks. Another concern is efficiency; as multi-core processors are available at ease, a
 Java developer has to write parallel code processing that can be pretty error-prone.

 To resolve such issues, Java 8 introduced the concept of stream that lets the developer to process data declaratively and leverage multicore architecture
 without the need to write any specific code for it.
 *
 *
 * What is Stream?

 Stream represents a sequence of objects from a source, which supports aggregate operations. Following are the characteristics of a Stream −

 Sequence of elements − A stream provides a set of elements of specific type in a sequential manner. A stream gets/computes elements on demand.
 It never stores the elements.


 Source − Stream takes Collections, Arrays, or I/O resources as input source.


 Aggregate operations − Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on.


 Pipelining − Most of the stream operations return stream itself so that their result can be pipelined. These operations are called intermediate
 operations and their function is to take input, process them, and return output to the target. collect() method is a terminal operation which is
 normally present at the end of the pipelining operation to mark the end of the stream.


 Automatic iterations − Stream operations do the iterations internally over the source elements provided, in contrast to Collections
 where explicit iteration is required.


 Generating Streams

 With Java 8, Collection interface has two methods to generate a Stream.

 stream() − Returns a sequential stream considering collection as its source.


 parallelStream() − Returns a parallel Stream considering collection as its source.
 *
 * </pre>
 *
 */
class StreamsDemo {

	public static void main(String[] args) {
		System.out.println(
				"\nStream is a new abstract layer introduced in Java 8. Using stream, you can process data in a declarative way similar to SQL statements.");
		System.out.println(
				"To resolve such issues, Java 8 introduced the concept of stream that lets the developer to process data declaratively and leverage multicore architecture without the need to write any specific code for it.");
		System.out.println("GOPASda yanymdaky oglan sorapdy, shu STREAM ler PYTHON da yok ");

		System.out.println(
				"\nAggregate operations − Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on.");
		System.out.println();

		System.out.println("Generating Streams - stream() , parallelStream()");
		// backed by the specified array
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println(strings);
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println(filtered);

		strings = Arrays.asList("abc", "", "bc", "aefgd", "abcd", "", "jkl");
		System.out.println(strings);
		filtered = strings.stream().filter(string -> !string.startsWith("a")).collect(Collectors.toList());
		System.out.println(filtered);

		filtered = strings.stream().filter(string -> string.startsWith("a") && string.endsWith("d"))
				.collect(Collectors.toList());
		System.out.println(filtered);

		System.out
				.println("\n forEach Stream has provided a new method ‘forEach’ to iterate each element of the stream. "
						+ "\nAlso see Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on.");
		Random random = new Random();
		IntStream ints = random.ints();
		ints.limit(4).forEach(System.out::println);
		System.out.println();

		System.out.println(
				"Gyzyk tarapy, 2018 indi shu Lambda ny dushunip otyryn, Enriandaky Pavel aydanda oncha dushunmandim");

		System.out.println("\nThe ‘map’ method is used to map each element to its corresponding result.");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		// get list of unique squares
		List<Integer> squaresList = numbers.stream().map(i -> i * i).collect(Collectors.toList());
		System.out.println(squaresList);

		squaresList = numbers.stream().map(i -> i * i).distinct().distinct().collect(Collectors.toList());
		System.out.println(squaresList);

		// get list of squares
		squaresList = numbers.stream().map((i) -> i * i).collect(Collectors.toList());
		System.out.println(squaresList);

		System.out.println("\nThe ‘filter’ method is used to eliminate elements based on a criteria. ");
		List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		// get count of empty string
		long count = strings2.stream().filter(str -> str.isEmpty()).count();
		System.out.println(count);
		count = strings2.stream().filter(str -> !str.isEmpty()).count();
		System.out.println(count);

		System.out.println("\nThe ‘limit’ method is used to reduce the size of the stream.");
		random.ints().limit(7).forEach(System.out::println);

		System.out.println("\nThe ‘sorted’ method is used to sort the stream.");
		random.ints().limit(10).sorted().forEach(System.out::println);
		strings2.stream().sorted().forEach(System.out::println);

		System.out.println("\nparallelStream is the alternative of stream for parallel processing. ");
		// get count of empty string
		long count2 = strings2.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println(count2);

		System.out.println(
				"\nCollectors are used to combine the result of processing on the elements of a stream. Collectors can be used to return a list or a string.");

		strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining("; "));
		System.out.println("Merged String: " + mergedString);
		Long collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.counting());
		System.out.println("collect: " + collect);

		System.out.println(
				"\nWith Java 8, statistics collectors are introduced to calculate all statistics when stream processing is being done. ");
		numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());

		System.out.println("-- the end -- ");
		System.exit(0);

	}

}

class Java8TesterSterams {

	public static void main(String args[]) {
		System.out.println("Using Java 7: ");

		// Count empty strings
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println("List: " + strings);
		long count = getCountEmptyStringUsingJava7(strings);

		System.out.println("Empty Strings: " + count);
		count = getCountLength3UsingJava7(strings);

		System.out.println("Strings of length 3: " + count);

		// Eliminate empty string
		List<String> filtered = deleteEmptyStringsUsingJava7(strings);
		System.out.println("Filtered List: " + filtered);

		// Eliminate empty string and join using comma.
		String mergedString = getMergedStringUsingJava7(strings, ", ");
		System.out.println("Merged String: " + mergedString);
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		// get list of square of distinct numbers
		List<Integer> squaresList = getSquares(numbers);
		System.out.println("Squares List: " + squaresList);
		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);

		System.out.println("List: " + integers);
		System.out.println("Highest number in List : " + getMax(integers));
		System.out.println("Lowest number in List : " + getMin(integers));
		System.out.println("Sum of all numbers : " + getSum(integers));
		System.out.println("Average of all numbers : " + getAverage(integers));
		System.out.println("Random Numbers: ");

		// print ten random numbers
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt());
		}

		System.out.println("Using Java 8: ");
		System.out.println("List: " + strings);

		count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("Empty Strings: " + count);

		count = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("Strings of length 3: " + count);

		filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filtered);

		mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);

		squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("Squares List: " + squaresList);
		System.out.println("List: " + integers);

		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		System.out.println("Random Numbers: ");

		random.ints().limit(10).sorted().forEach(System.out::println);

		// parallel processing
		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("Empty Strings: " + count);

		Student student1 = new Student("ads", 32);
		Student student2 = new Student("bds", -32);
		Student student3 = new Student("cds", 132);
		Student student4 = new Student("ads", 32);
		Student student5 = new Student("zds", 55);
		Student student6 = new Student("kds", 72);
		List<Student> stList = new ArrayList<>();
		stList.add(student1);
		stList.add(student2);
		stList.add(student3);
		stList.add(student4);
		stList.add(student5);
		stList.add(student6);

		Set<Student> set = new HashSet<>();
		set.add(student6);
		set.add(student4);
		boolean add = set.add(student6);
		System.out.println(add);

		stList.forEach(item -> System.out.print(item + "; "));
		System.out.println();
		set.forEach(item -> System.out.print(item + "; "));

		System.out.println();
		List<Student> collect = stList.stream().filter(c -> stList.contains("zds")).collect(Collectors.toList());
		System.out.println(collect);

		// stList.stream.filter(c->{users.stream.filter(u->u.getName().equals(c.getName()).count()>0
		// }).collect(Collectors.toList());

		Set<String> setS = new HashSet<>();
		setS.add("ss");
		setS.add("sss");
		add = setS.add("ss");
		setS.add("");
		setS.add(null);
		System.out.println(add);
		System.out.println(setS);
		System.out.println(setS.contains(""));
		System.out.println(setS.contains(null));
		if (setS.contains(null)) {
			System.out.println("INTERESTING null");
		}

	}

	private static class Student {
		String name;
		int id;

		public Student(String name, int id) {
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return name + ": " + id;
		}

	}

	private static int getCountEmptyStringUsingJava7(List<String> strings) {
		int count = 0;

		for (String string : strings) {

			if (string.isEmpty()) {
				count++;
			}
		}
		return count;
	}

	private static int getCountLength3UsingJava7(List<String> strings) {
		int count = 0;

		for (String string : strings) {

			if (string.length() == 3) {
				count++;
			}
		}
		return count;
	}

	private static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
		List<String> filteredList = new ArrayList<String>();

		for (String string : strings) {

			if (!string.isEmpty()) {
				filteredList.add(string);
			}
		}
		return filteredList;
	}

	private static String getMergedStringUsingJava7(List<String> strings, String separator) {
		StringBuilder stringBuilder = new StringBuilder();

		for (String string : strings) {

			if (!string.isEmpty()) {
				stringBuilder.append(string);
				stringBuilder.append(separator);
			}
		}
		String mergedString = stringBuilder.toString();
		return mergedString.substring(0, mergedString.length() - 2);
	}

	private static List<Integer> getSquares(List<Integer> numbers) {
		List<Integer> squaresList = new ArrayList<Integer>();

		for (Integer number : numbers) {
			Integer square = Integer.valueOf(number.intValue() * number.intValue());

			if (!squaresList.contains(square)) {
				squaresList.add(square);
			}
		}
		return squaresList;
	}

	private static int getMax(List<Integer> numbers) {
		int max = numbers.get(0);

		for (int i = 1; i < numbers.size(); i++) {

			Integer number = numbers.get(i);

			if (number.intValue() > max) {
				max = number.intValue();
			}
		}
		return max;
	}

	private static int getMin(List<Integer> numbers) {
		int min = numbers.get(0);

		for (int i = 1; i < numbers.size(); i++) {
			Integer number = numbers.get(i);

			if (number.intValue() < min) {
				min = number.intValue();
			}
		}
		return min;
	}

	private static int getSum(List numbers) {
		int sum = (int) (numbers.get(0));

		for (int i = 1; i < numbers.size(); i++) {
			sum += (int) numbers.get(i);
		}
		return sum;
	}

	private static int getAverage(List<Integer> numbers) {
		return getSum(numbers) / numbers.size();
	}
}

class Test {

	public static void main(String args[]) {

		List<String> names = new ArrayList<>();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");

		System.out.println("Here we have passed System.out::println method as a static method reference.");
		names.forEach(System.out::println);
		// names.forEach(System.out.println());

		System.out.println("\n OR ");
		for (Object object : names) {
			System.out.println(object);
		}

		int[] numbers = { 10, 20, 30, 40, 50 };
		// numbers.forEach(System.out::println);

		for (int x : numbers) {
			System.out.print(x);
			System.out.print(",");
		}

	}
}

class StreamApi {
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();

		stringList.add("ONE");
		stringList.add("TWO");
		stringList.add("THREE");

		Stream<String> stream = stringList.stream();

		long count = stream.map((value) -> {
			return value.toLowerCase();
		}).count();

		System.out.println("count = " + count);

		System.out.println(
				"The non-terminal stream operations of the Java Stream API are operations that transform or filter the elements in the stream.");
		stringList.stream().map((value) -> {
			return value.toLowerCase();
		});
		// or
		List<String> collect = stringList.stream().map((value) -> value.toLowerCase()).collect(Collectors.toList());

		Stream<String> longStringsStream = stringList.stream().filter((value) -> {
			return value.length() >= 3;
		});

		List<String> collect2 = stringList.stream().filter((value) -> value.length() > 3).collect(Collectors.toList());

		/**
		 * flatMap()
		 *
		 * The Java Stream flatMap() methods maps a single element into multiple
		 * elements. The idea is that you "flatten" each element from a complex
		 * structure consisting of multiple internal elements, to a "flat" stream
		 * consisting only of these internal elements.
		 */

		List<String> stringList2 = new ArrayList<String>();

		stringList2.add("One flew over the cuckoo's nest");
		stringList2.add("To kill a muckingbird");
		stringList2.add("Gone with the wind");

		Stream<String> stream2 = stringList2.stream();

		stream2.flatMap((value) -> {
			String[] split = value.split(" ");
			return (Stream<String>) Arrays.asList(split).stream();
		}).forEach((value) -> System.out.println(value));

		List<String> stringList3 = new ArrayList<String>();

		stringList3.add("abc");
		stringList3.add("def");

		Stream<String> stream3 = stringList.stream();
		System.out.println();

		/**
		 * The Java Stream peek() method is a non-terminal operation that takes a
		 * Consumer (java.util.function.Consumer) as parameter.
		 */
		Stream<String> streamPeeked3 = stream3.peek((value) -> {
			System.out.println("value");
		});

		boolean anyMatch = stringList.stream().anyMatch((value) -> {
			return value.startsWith("One");
		});
		System.out.println(anyMatch);

		boolean allMatch = stringList.stream().allMatch((value) -> {
			return value.startsWith("One");
		});
		System.out.println(allMatch);

		boolean noneMatch = stringList.stream().noneMatch((value) -> {
			return value.startsWith("Onew");
		});
		System.out.println(noneMatch);

		// find any
		/**
		 * The element found can be from anywhere in the Stream. There is no guarantee
		 * about from where in the stream the element is taken.
		 */
		Optional<String> anyElement = stringList.stream().findAny();
		System.out.println(anyElement.get());

		Optional<String> findFirst = stringList.stream().findFirst();
		System.out.println(findFirst.get());

		Optional<String> minElement = stringList.stream().min((val1, val2) -> {
			return val1.compareTo(val2);
		});
		System.out.println(minElement.get());

		List<Integer> ints = Arrays.asList(new Integer[] { 34, 5, -5, 55, 6 });
		Integer min = ints.stream().min(Comparator.comparing(item -> item)).get();
		System.out.println(min);

		// array
		Object[] array = stringList2.stream().filter(x -> x != null).toArray();
		System.out.println(Arrays.toString(array));

		System.out.println("\n  -- Concatenate Streams --");
		stringList = new ArrayList<String>();

		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");

		stringList2 = new ArrayList<>();
		stringList2.add("Lord of the Rings");
		stringList2.add("Planet of the Rats");
		stringList2.add("Phantom Menace");

		Stream<String> concatStream = Stream.concat(stringList.stream(), stringList2.stream());
		List<String> stringsAsUppercaseList = concatStream.collect(Collectors.toList());

		System.out.println(stringsAsUppercaseList);

		System.out.println("\n Create Stream From Array");
		Stream<String> streamOf = Stream.of("one", "two", "three");
		streamOf.forEach(System.out::println);

		System.out.println("Critique");
		/**
		 * Java Stream API Critique Having worked with other data streaming API's like
		 * the Apache Kafka Streams API, I have a bit of critique of the Java Stream API
		 * that I will share with you. They aren't big, important points of critique,
		 * but they are useful to have in the back of your head as you venture into
		 * stream processing.
		 */

	}
}

class StreamsApiDemo {

	public static void main(String[] args) {

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
		strings.stream().sorted().forEach(System.out::println);
		System.out.println();
		strings.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.println("\nCollectors are used to combine the result of processing on the elements of a stream. \n"
				+ "Collectors can be used to return a list or a string.");

		strings = Arrays.asList("abc", "", "bc", "efg", "abcd", " ", "jkl");
		System.out.println(
				"Filtered List: " + strings.stream().filter(string -> !string.isBlank()).collect(Collectors.toList())); //
		String mergedString = strings.stream().filter(string -> !string.isBlank()).collect(Collectors.joining("; ")); // count()
		System.out.println("Joined String: " + mergedString);
		Long collect = strings.stream().filter(string -> !string.isBlank()).collect(Collectors.counting());
		System.out.println("Count: " + collect);
		collect = strings.stream().filter(string -> !string.isBlank()).count();
		System.out.println("Count: " + collect);

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

		System.out.println("\n join using prefix and postfixes");
		/*
		 * Join String by a delimiter and starting with a supplied delimiter, prefix,
		 * suffix
		 */
		sj = new StringJoiner("/", "before-", "-after");
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


/**
 * The Java Stream API provides a more functional programming approach to
 * iterating and processing elements of e.g. a collection.
 *
 * Streams are designed to work with Java lambda expressions.
 *
 * <pre>
 * Stream Processing Phases
 *
 Once you have obtained a Stream instance from a Collection instance, you use that stream
 to process the elements in the collection.

 Processing the elements in the stream happens in two steps / phases:

 Configuration
 Processing

 First the stream is configured. The configuration can consist of filters and mappings.
 These are also referred to as non-terminal operations.
 * </pre>
 */
class Streams2 {

	// http://tutorials.jenkov.com/java-functional-programming/index.html
	// http://tutorials.jenkov.com/java-collections/streams.html
	public static void main(String[] args) {
		List<String> items = new ArrayList<String>();

		items.add("one");
		items.add("two");
		items.add("three");

		long count = items.stream().filter(item -> item.startsWith("t")).count();
		System.out.println(count);

		// EPAM like question
		String shortest = items.stream().min(Comparator.comparing(item -> item.length())).get();
		System.out.println(shortest);

		System.out.println();

		items.add(null);
		System.out.println("Stream.reduce()");
		String reduced2 = items.stream().reduce((acc, item) -> acc + " # " + item).get();
		System.out.println(reduced2);

		/**
		 * The reduce() method taking a BinaryOperator as parameter returns an Optional
		 * . In case the stream contains no elements, the Optional.get() returns null.
		 *
		 * There is another reduce() method which takes two parameters. It takes an
		 * initial value for the accumulated value, and then a BinaryOperator.
		 */
		String reduced = items.stream().reduce("", (acc, item) -> acc + " # " + item);
		System.out.println(reduced);

		List<Integer> ints = Arrays.asList(new Integer[] { 34, 5, -5, 55, 6 });
		Integer min = ints.stream().min(Comparator.comparing(item -> item)).get();
		System.out.println(min);

		Integer max = ints.stream().max(Comparator.comparing(item -> item)).get();
		System.out.println(max);

	}

}

/// //
/**
 * https://jenkov.com/tutorials/java-functional-programming/streams.html
 * 
 * The Java Stream API provides a more functional programming approach to
 * iterating and processing elements of e.g. a collection.
 * 
 * Streams are designed to work with Java lambda expressions.
 * 
 * <pre>
     * Stream Processing Phases
     * 
    Once you have obtained a Stream instance from a Collection instance, you use that stream 
    to process the elements in the collection.
    
    Processing the elements in the stream happens in two steps / phases:
    
    Configuration
    Processing
    
    First the stream is configured. The configuration can consist of filters and mappings. 
    These are also referred to as non-terminal operations.
 * </pre>
 */
public class Streams {

	public static void main(String[] args) {

		System.out.println(
				"A Java Stream is a component that is capable of internal iteration of its elements, meaning it can iterate its elements itself.");
		/**
		 * A Java Stream is a component that is capable of internal iteration of its
		 * elements, meaning it can iterate its elements itself. In contrast, when you
		 * are using the Java Collections iteration features (e.g a Java Iterator or the
		 * Java for-each loop used with a Java Iterable) you have to implement the
		 * iteration of the elements yourself.
		 */
		System.out.println("\n");

		List<String> items = new ArrayList<String>();

		items.add("one");
		items.add("two");
		items.add("three");

		System.out.println("Stream Processing");
		System.out.println("\nTerminal and Non-Terminal Operations");
		System.out.println(
				"A non-terminal stream operation (e.g. filter, map) is an operation that adds a listener to the stream without doing anything else.");
		System.out.println("You can attach listeners to a Stream using non-terminal operations");
		System.out.println(
				"A terminal stream operation (toCollection, .. count(),..) is an operation that starts the internal iteration of the elements, calls all the listeners, and returns a result.");
		System.out.println("Obtain a Stream - stream()");
		long count = items.stream().filter(item -> item.startsWith("t")).count();
		System.out.println(count);

		System.out.println("\n\n Non-Terminal Operations - map(), filter(), flatMap(), distinct(), limit(), peek()");
		/**
		 * The non-terminal stream operations of the Java Stream API are operations that
		 * transform or filter the elements in the stream. When you add a non-terminal
		 * operation to a stream, you get a new stream back as result. The new stream
		 * represents the stream of elements resulting from the original stream with the
		 * non-terminal operation applied.
		 */
		Stream<String> stream = items.stream();
		Stream<String> stringStream = stream.map((value) -> {
			return value.toUpperCase();
		});
		stringStream.forEach(System.out::print);

		System.out.println();
		System.out.println("flatMap() ");
		/**
		 * The Java Stream flatMap() methods maps a single element into multiple
		 * elements.
		 * 
		 * The idea is that you "flatten" each element from a complex structure
		 * consisting of multiple internal elements, to a "flat" stream consisting only
		 * of these internal elements.
		 */
		List<String> stringList = new ArrayList<String>();

		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");
		stringList.add("Gone with the wind");

		Stream<String> streamw = stringList.stream();
		stringList.stream().flatMap((value) -> {
			String[] split = value.split(" ");
			return (Stream<String>) Arrays.asList(split).stream();
		}).forEach((value) -> System.out.println(value));

		System.out.println("\ndistinct()");

		List<String> distinctStrings = stringList.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctStrings);

		System.out.println("\nlimit()");
		stringList.stream().limit(2).forEach(element -> {
			System.out.println(element);
		});

		System.out.println("\npeek()");
		/**
		 * The Java Stream peek() method is a non-terminal operation that takes a
		 * Consumer (java.util.function.Consumer) as parameter. The Consumer will get
		 * called for each element in the stream. The peek() method returns a new Stream
		 * which contains all the elements in the original stream.
		 * 
		 * The purpose of the peek() method is, as the method says, to peek at the
		 * elements in the stream, not to transform them. Keep in mind that the peek
		 * method does not start the internal iteration of the elements in the stream.
		 */
		List<String> stringListz = new ArrayList<String>();

		stringList.add("abc");
		stringList.add("def");
		stringList.add("ghei");

		/**
		 * It can be useful for debugging or logging, or for performing some kind of
		 * side effect on the stream elements.
		 */
		// https://medium.com/javarevisited/non-terminal-operation-peek-in-java8-e412407e6956

		stringListz.stream().filter(e -> e.contains("e")).peek(e -> System.out.println("Contains e: " + e))
				.map(String::toUpperCase).peek(e -> System.out.println("Mapped value: " + e))
				.collect(Collectors.toList());

		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());

		IntStream.range(1, 6).peek(i -> System.out.println("Before map: " + i)).map(i -> i * i)
				.peek(i -> System.out.println("After map: " + i)).sum();

		Stream.of("apple", "banana", "cherry", "date", "elderberry")
				.peek(s -> System.out.println("Before filter: " + s)).filter(s -> s.length() > 5)
				.peek(s -> System.out.println("After filter: " + s)).forEach(System.out::println);

		// Example of using peek to count the number of times a certain value appears in
		// a stream:
		System.out.println("-Example of using peek to count t-");
		int[] countz = { 0 };
		Stream.of("apple", "banana", "cherry", "date", "elderberry").peek(s -> {
			if (s.startsWith("b")) {
				countz[0]++;
			}
		}).forEach(System.out::println);
		System.out.println("Count: " + countz[0]);

		System.out.println(
				"\n\n Terminal Operations - anyMatch(), allMatch(), noneMatch()(), collect(), count(), findAny(), findFirst(), forEach(), min, max, reduce(), toArray(),  ");

		System.out.println("anyMatch()");
		stringList = new ArrayList<String>();

		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");
		boolean anyMatch = stringList.stream().anyMatch((value) -> {
			System.out.println("-->" + value);
			return value.startsWith("One");
		});
		System.out.println(anyMatch);

		System.out.println("allMatch()");
		boolean allMatch = stringList.stream().allMatch((value) -> {
			System.out.println("-->" + value);
			return value.startsWith("One");
		});
		System.out.println(allMatch);

		System.out.println("noneMatch()");
		boolean noneMatch = stringList.stream().noneMatch((value) -> {
			System.out.println("-->" + value);
			return value.startsWith("Siz");
		});
		System.out.println(noneMatch);

		System.out.println("collect()");
		List<String> stringsAsUppercaseList = items.stream().map(value -> value.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(stringsAsUppercaseList);

		System.out.println("count()");
		long count2 = items.stream().map(value -> value.toUpperCase()).count();
		System.out.println(count2);
		/**
		 * The Java Stream findAny() method can find a single element from the Stream.
		 * The element found can be from anywhere in the Stream. There is no guarantee
		 * about from where in the stream the element is taken. Here is a Java Stream
		 * findAny() example:
		 */
		System.out.println("findAny()");
		items.add("onee");
		Optional<String> findAny = items.stream().findAny();
		System.out.println(findAny.get());

		System.out.println("findFirst()");
		items.add("onee");
		Optional<String> findFirst = items.stream().findFirst();
		System.out.println(findFirst.get());

		System.out.println("forEach()");
		items.stream().forEach(System.out::println);

		System.out.println("min()");
		stringList = new ArrayList<String>();
		stringList.add("abc");
		stringList.add("def");
		Optional<String> min = stringList.stream().min((val1, val2) -> {
			return val1.compareTo(val2);
		});
		System.out.println(min.get());

		// EPAM like question
		String shortest = items.stream().min(Comparator.comparing(item -> item.length())).get();
		System.out.println(shortest);

		System.out.println("max()");
		Optional<String> maxx = stringList.stream().max((val1, val2) -> {
			return val1.compareTo(val2);
		});
		String maxString = maxx.get();
		System.out.println(maxString);

		String longest = items.stream().max(Comparator.comparing(item -> item.length())).get();
		System.out.println(longest);

		System.out.println();

		List<Integer> ints = Arrays.asList(new Integer[] { 34, 5, -5, 55, 6 });
		Integer minn = ints.stream().min(Comparator.comparing(item -> item)).get();
		System.out.println(minn);

		Integer maxz = ints.stream().max(Comparator.comparing(item -> item)).get();
		System.out.println(maxz);

		items.add(null);
		/*
		 * The Java Stream reduce() method is a terminal operation that can reduce all
		 * elements in the stream to a single element.
		 */
		System.out.println("Stream.reduce()");
		String reduced2 = items.stream().reduce((acc, item) -> acc + " # " + item).get();
		System.out.println(reduced2);

		/**
		 * The reduce() method taking a BinaryOperator as parameter returns an Optional
		 * . In case the stream contains no elements, the Optional.get() returns null.
		 * 
		 * There is another reduce() method which takes two parameters. It takes an
		 * initial value for the accumulated value, and then a BinaryOperator.
		 */
		String reduced = items.stream().reduce("", (acc, item) -> acc + " # " + item);
		System.out.println(reduced);

		System.out.println("toArray()");
		Object[] objects = stringList.stream().toArray();
		System.out.println(Arrays.toString(objects));

		System.out.println("\nConcatenate Streams");
		/**
		 * The Java Stream interface contains a static method called concat() which can
		 * concatenate two streams into one.
		 */
		Stream<String> stream1 = stringList.stream();
		List<String> stringList2 = new ArrayList<>();
		stringList2.add("Lord of the Rings");
		stringList2.add("Planet of the Rats");
		stringList2.add("Phantom Menace");
		Stream<String> stream2 = stringList2.stream();

		// concat
		Stream<String> concatStream = Stream.concat(stream1, stream2);
		stringsAsUppercaseList = concatStream.sorted().collect(Collectors.toList());
		System.out.println(stringsAsUppercaseList);

		System.out.println("\nCreate Stream From Array");
		Stream<String> streamOf = Stream.of("one", "two", "three");
		streamOf.forEach(System.out::println);
	}
}

class StreamAPICritique {
	public static void main(String[] args) {
		System.out.println("Java Stream API Critique");
		/**
		 * https://jenkov.com/tutorials/java-functional-programming/streams.html
		 * 
		 * Having worked with other data streaming API's like the Apache Kafka Streams
		 * API, I have a bit of critique of the Java Stream API that I will share with
		 * you. They aren't big, important points of critique, but they are useful to
		 * have in the back of your head as you venture into stream processing.
		 */
		System.out.println("1. Batch, Not Streaming");
		System.out.println("2. Chain, Not Graph");
		System.out.println("3. Internal, Not External Iteration");

	}
}




//// aggregate methods
///

class FunctionalOperationsInJavaMapTest {

	/**
	 * Desc
	 *
	 * <pre>
	 *The Java Map interface had a few functional operations added from Java 8. These functional operations make it possible to interact with a Map in a more functional style. For instance, you pass a Java Lambda Expression as parameter to these functional style methods. You can read more about functional programming in my tutorial about Java Functional Programming .

	 The functional operation methods are:

	 compute()
	 computeIfAbsent()
	 computeIfPresent()
	 merge()
	 Each of these functional methods will be described in more detail in the following sections.
	 * </pre>
	 */
	void test() {
		fail("Not yet implemented");
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		map.put("one", "first");
		map.put("two", "second");
		map.put("three", "third");

		Iterator iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			Object value = map.get(key);
		}

		for (Object key : map.keySet()) {
			Object value = map.get(key);
		}

		Stream<String> stream = map.keySet().stream();
		stream.forEach((value) -> {
			System.out.println(value);
		});

		/// on values access
		iterator = map.values().iterator();
		while (iterator.hasNext()) {
			Object nextValue = iterator.next();
		}

		for (Object value : map.values()) {
			System.out.println(value);
		}

		stream = map.values().stream();
		stream.forEach((value) -> {
			System.out.println(value);
		});

		/// on entrySet
		Set entries = map.entrySet();
		iterator = entries.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
		}

		for (Object entryObj : map.entrySet()) {
			Map.Entry entry = (Map.Entry) entryObj;
			Object key = entry.getKey();
			Object value = entry.getValue();
		}

		/**
		 * The functional operation methods are:
		 *
		 * compute()
		 *
		 * computeIfAbsent()
		 *
		 * computeIfPresent()
		 *
		 * merge()
		 */
		System.out.println("\n Functional Operations in Java Map");
		map.compute("one", (key, value) -> value == null ? null : value.toString().toUpperCase());
		map.compute("three", (key, value) -> value == null ? null : value.toString().substring(2));
		System.out.println(map);

		map.computeIfAbsent("ones", (key) -> "abc");
		System.out.println(map);

		map.computeIfPresent("one", (key, value) -> value == null ? null : value.toString().toLowerCase());
		System.out.println(map);

		map.merge("one", "XYZ", (oldValue, newValue) -> newValue + "-abc" + oldValue);
		System.out.println(map);

	}
}



class Java8AggregateMethods {

	public static void main(String[] args) {
		int min1 = Arrays.stream(new int[] { 1, 2, 3, 4, 5 }).min().orElse(0);
		System.out.println(1 == min1);

		int min2 = Arrays.stream(new int[] {}).min().orElse(0);
		System.out.println(0 == min2);

		int sum = Arrays.stream(new int[] { 1, 2, 3 }).filter(i -> i >= 2).map(i -> i * 3).sum();
		System.out.println(sum);

		System.out.println("Stream without terminal operation");

		Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
			System.out.println("doubling " + i);
			return i * 2;
		});

		System.out.println("Stream with terminal operation");
		Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
			System.out.println("doubling " + i);
			return i * 2;
		}).sum();

		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello World!");
			}
		});

		Thread thread2 = new Thread(() -> System.out.println(" ooo Epam sys"));

	}
}



@FunctionalInterface
interface Function2<T, U, V> {
	public V apply(T t, U u);

	default void count() {
		// increment counter
	}
}




class Java8AggregateMoreMethods {

	/**
	 * Map and flatMap
	 *
	 * <pre>
	 * What Is the Difference Between Map and flatMap Stream Operation?
	 There is a difference in signature between map and flatMap. Generally speaking,
	 a map operation wraps its return value inside its ordinal type while flatMap does not.

	 For example, in Optional, a map operation would return Optional<String> type while
	 flatMap would return String type.

	 So after mapping, one needs to unwrap (read �flatten�) the object to retrieve the value
	 whereas, after flat mapping, there is no such need as the object is already flattened.
	 The same concept is applied to mapping and flat mapping in Stream.


	 Both map and flatMap are intermediate stream operations that receive a function and apply
	 this function to all elements of a stream.

	 The difference is that for the map, this function returns a value, but for flatMap, this
	 function returns a stream. The flatMap operation �flattens� the streams into one.

	 Here's an example where we take a map of users' names and lists of phones and �flatten�
	 it down to a list of phones of all the users using flatMap:
	 * </pre>
	 */
	public static void main(String[] args) {
		Map<String, List<String>> people = new HashMap<>();
		people.put("John", Arrays.asList("555-1123", "555-3389"));
		people.put("Mary", Arrays.asList("555-2243", "555-5264"));
		people.put("Steve", Arrays.asList("555-6654", "555-3242"));

		List<String> phones2 = people.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(phones2);

		Stream<String> flatMap = people.values().stream().flatMap(x -> x.stream());
		flatMap.forEach(System.out::println);
	}
}

/**
 * What Is Stream Pipelining in Java 8? Stream pipelining is the concept of
 * chaining operations together. This is done by splitting the operations that
 * can happen on a stream into two categories: intermediate operations and
 * terminal operations.
 *
 * Each intermediate operation returns an instance of Stream itself when it
 * runs, an arbitrary number of intermediate operations can, therefore, be set
 * up to process data forming a processing pipeline.
 *
 * There must then be a terminal operation which returns a final value and
 * terminates the pipeline.
 *
 * @author ASUS
 *
 */
class StreamPipelining {

}

/**
 * Tell Us About the New Date and Time API in Java 8 A long-standing problem for
 * Java developers has been the inadequate support for the date and time
 * manipulations required by ordinary developers.
 *
 * The existing classes such as java.util.Date and SimpleDateFormatter aren�t
 * thread-safe, leading to potential concurrency issues for users.
 *
 * Poor API design is also a reality in the old Java Data API. Here's just a
 * quick example � years in java.util.Date start at 1900, months start at 1, and
 * days start at 0 which is not very intuitive.
 *
 * These issues and several others have led to the popularity of third-party
 * date and time libraries, such as Joda-Time.
 *
 * In order to address these problems and provide better support in JDK, a new
 * date and time API, which is free of these problems, has been designed for
 * Java SE 8 under the package java.time.
 *
 */
class DateTime {

}

@FunctionalInterface
interface ShortToByteFunction {

	byte applyAsByte(short s);

}

class FunInterfaces {

	static byte[] transformArray(short[] array, ShortToByteFunction function) {
		byte[] transformedArray = new byte[array.length];
		for (int i = 0; i < array.length; i++) {
			transformedArray[i] = function.applyAsByte(array[i]);
		}
		return transformedArray;
	}

	public static void main(String[] args) {
		short[] array = { (short) 1, (short) 2, (short) 3 };
		byte[] transformedArray = transformArray(array, s -> (byte) (s * 2));

		byte[] expectedArray = { (byte) 2, (byte) 4, (byte) 6 };
		System.out.println(expectedArray == transformedArray);

	}
}




class StreamsProperUsage {
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