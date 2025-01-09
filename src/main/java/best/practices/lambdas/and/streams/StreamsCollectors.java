package best.practices.lambdas.and.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCollectors {

	public static void main(String[] args) {

		/*
		 * What is a Stream ? A typed interface helps to process large data in fast way
		 * 
		 * public interface Stream<T> extends BaseStream<T, Stream<T>> {
		 */

		List<String> l = Arrays.asList("alma", "enar", "enar", "alma", "uzum", "enjir", "ahoj");
		List<String> result = new ArrayList<>();

		System.out.println("Chain consumers");
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = result::add;
		l.forEach(c1.andThen(c2));
		System.out.println("size = " + result.size());

		System.out.println("\nPredicates");
		Predicate<String> predicate1 = s -> s.length() > 6;
		System.out.println(predicate1.test("ahojahoj"));
		Predicate<String> predicate2 = s -> s.length() < 6;
		Predicate<String> predicate3 = s -> s.length() == 8;

		System.out.println("\nPredicates or | and");
		Predicate<String> predicateOr = predicate1.or(predicate2);
		System.out.println(predicateOr.test("ahojahoj"));

		Predicate<String> predicateOrAnd = predicate1.or(predicate2).and(predicate3);
		System.out.println(predicateOrAnd.test("ahojahoj"));

		System.out.println("\nJust note that, Operator precedence is not WORKING for predicates");

		Predicate<String> predicateAhoj = Predicate.isEqual("ahoj");
		Stream<String> stream = Stream.of("ahoj", "cau", "Ahoj", "nazdar");
		stream.filter(predicateAhoj).forEach(System.out::println);

		Stream.of("ahoj", "cau", "Ahoj", "nazdar").filter(s -> "ahoj".equalsIgnoreCase(s)).forEach(System.out::println);

		Predicate<String> predicateCau = Predicate.isEqual("cau");
		Stream.of("ahoj", "cau", "Ahoj", "nazdar").filter(predicateAhoj.or(predicateCau)).forEach(System.out::println);
		Stream.of("ahoj", "cau", "Ahoj", "nazdar").filter(s -> "ahoj".equalsIgnoreCase(s) || "cau".equalsIgnoreCase(s))
				.forEach(System.out::println);

		System.out.println(
				"\nStream intermediate operators are LAZY. See nothing happends, until some termination-operator triggers ");
		// foreach is end operator, peek is intermediate (you can do LOG)
		l.stream().peek(System.out::print).filter(Predicate.isEqual("alma")).peek(System.out::println);

		System.out.println();
		result = new ArrayList<>();
		long count = l.stream().peek(System.out::println).filter(predicateAhoj.or(Predicate.isEqual("alma")))
				.peek(result::add).count();
		System.out.println(count);
		System.out.println(result);

		List<Integer> i1 = List.of(23, 33, -5, 87, 4);
		List<Integer> i2 = List.of(123, 43, -25, 6);
		List<Integer> i3 = List.of(31, 39, 95);

		// map, and flatMap
		List<List<Integer>> listOfList = Arrays.asList(i1, i2, i3);
		System.out.println(listOfList);

		// listOfList.stream().map(x -> x.size()).forEach(System.out::println);
		listOfList.stream().map(x -> x.size()).forEach(System.out::println);
		listOfList.stream().map(List::size).forEach(System.out::println);

		System.out.println();
		System.out.println("Thanks to prof. Eshchanov, I solved his Task this way");
		List<Integer> flattenedList = listOfList.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println(flattenedList);

		System.out.println(
				"Two type of Reductions (aggregation[reduce, min, max, findFirst, allMatch,..], collectors[Collectors...])");
		// Reduction
		/**
		 * {@link StringAndNumbersEnhancements}
		 */
		int sumOfValues = flattenedList.stream().reduce(0, (a, b) -> a + b).intValue();
		System.out.println(sumOfValues);

		sumOfValues = flattenedList.stream().reduce(0, binaryOpt()).intValue();
		System.out.println(sumOfValues);

		BinaryOperator<Integer> sum = (a, b) -> a + b;
		sumOfValues = flattenedList.stream().reduce(0, sum).intValue();
		System.out.println(sumOfValues);

		Stream<Integer> empty = Stream.empty();
		sumOfValues = empty.reduce(0, sum).intValue();
		System.out.println(sumOfValues);

		// Collectors
		String joined = l.stream().filter(Predicate.not(predicateAhoj)).collect(Collectors.joining(","));
		System.out.println(joined);

		List<String> list = l.stream().filter(Predicate.not(predicateAhoj)).collect(Collectors.toList());
		System.out.println(list);

		// Collecting into MAP
		System.out.println("Collecting into MAP");
		Map<String, Long> map = l.stream().filter(Predicate.not(predicateAhoj))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		List<Item> items = Arrays.asList(new Item(1, "bir"), new Item(2, "iki"), new Item(2, "ikki"),
				new Item(3, "uc"));

		Map<Integer, List<Item>> itemMaps1 = items.stream().collect(Collectors.groupingBy(Item::getId));
		System.out.println(itemMaps1);

		Map<String, List<Item>> itemMaps2 = items.stream().collect(Collectors.groupingBy(Item::getName));
		System.out.println(itemMaps2);

		// via DownstreamCollector
		Map<Integer, Long> itemMaps3 = items.stream()
				.collect(Collectors.groupingBy(Item::getId, Collectors.counting()));
		System.out.println(itemMaps3);

		List<Integer> ints = Stream.of(1, 2, 3).map(n -> n * n).collect(Collectors.toList());
		System.out.println(ints);

		// odd and even numbers
		Map<Integer, List<Integer>> mapInts = Stream.of(1, 2, 3, 3, 45, 78)
				.collect(Collectors.groupingBy(i -> i % 2, Collectors.toList()));
		System.out.println(mapInts);

		/**
		 * {@link NewCollectors}
		 */

	}

	private static BinaryOperator<Integer> binaryOpt() {
		return (a, b) -> a + b;
	}
}

class Item {
	private int id;
	private String name;

	public Item(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Item {id=" + id + ", name=" + name + "}";
	}

}
