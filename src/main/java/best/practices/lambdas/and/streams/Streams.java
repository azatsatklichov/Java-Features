package best.practices.lambdas.and.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
