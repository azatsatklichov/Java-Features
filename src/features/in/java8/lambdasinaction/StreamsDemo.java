package features.in.java8.lambdasinaction;

import static features.in.java8.lambdasinaction.Dish.menu;
import static java.util.stream.Collectors.toList;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {

	public static void main(String... args) throws Exception {

		List<Integer> nums = Arrays.asList(1, 2, 3, 44, -44, 44, 5, 424, 555);
		nums.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
		System.out.println();

		nums = Arrays.asList(1, 2, 3, 44, -44, 44, 5, 424, 555);
		nums.stream().filter(i -> i % 2 == 0).skip(1).forEach(System.out::println);
		System.out.println();

		// Stream.of
		Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		// Stream.empty
		Stream<String> emptyStream = Stream.empty();
		emptyStream.map(String::toUpperCase).forEach(System.out::println);

		// Arrays.stream
		int[] numbers = { 2, 3, 5, 7, 11, 13 };
		System.out.println(Arrays.stream(numbers).sum());
		System.out.println(Arrays.stream(numbers).min().getAsInt());
		System.out.println(Arrays.stream(numbers).max().getAsInt());

		System.out.println();

		// Stream.iterate
		Stream.iterate(0, n -> n + 2).limit(5).forEach(System.out::println);

		// fibonnaci with iterate
		System.out.println("-- FIBO by Java 8 --");
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10)
				.forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

		// wonderfull FIBO by Java 8
		Stream<int[]> limit = Stream.iterate(new int[] { 0, 1 }, x -> new int[] { x[1], x[0] + x[1] }).limit(10);
		limit.skip(10).forEach(x -> System.out.println(x[0]));

		System.out.println("----");
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).map(t -> t[0])
				.forEach(System.out::println);

		// random stream of doubles with Stream.generate
		Stream.generate(Math::random).limit(7).forEach(System.out::println);

		// stream of 1s with Stream.generate
		IntStream.generate(() -> 1).limit(5).forEach(System.out::println);

		IntStream.generate(new IntSupplier() {
			public int getAsInt() {
				return 2;
			}
		}).limit(5).forEach(System.out::println);

		System.out.println("-- fib --");
		IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;

			public int getAsInt() {
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return this.previous;
			}
		};

		IntStream.generate(fib).limit(10).forEach(System.out::println);

		long uniqueWords = Files
				.lines(Paths.get("D:\\U_Mastering\\JavaMasteringIn8911\\src\\lambdasinaction\\chap5\\data.txt"),
						Charset.defaultCharset())
				.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();

		System.out.println("There are " + uniqueWords + " unique words in data.txt");
	}
}

class Finding {

	public static void main(String... args) {
		if (isVegetarianFriendlyMenu()) {
			System.out.println("Vegetarian friendly");
		}

		System.out.println(isHealthyMenu());
		System.out.println(isHealthyMenu2());

		Optional<Dish> dish = findVegetarianDish();
		dish.ifPresent(d -> System.out.println(d.getName()));
	}

	private static boolean isVegetarianFriendlyMenu() {
		return menu.stream().anyMatch(Dish::isVegetarian);
	}

	private static boolean isHealthyMenu() {
		return menu.stream().allMatch(d -> d.getCalories() < 1000);
	}

	private static boolean isHealthyMenu2() {
		return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
	}

	private static Optional<Dish> findVegetarianDish() {
		return menu.stream().filter(Dish::isVegetarian).findAny();
	}

}

class Laziness {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> twoEvenSquares = numbers.stream().filter(n -> {
			System.out.println("filtering " + n);
			return n % 2 == 0;
		}).map(n -> {
			System.out.println("mapping " + n);
			return n * n;
		}).limit(3).collect(toList());

		System.out.println();
		System.out.println(twoEvenSquares);
	}
}

class Mapping {

	public static void main(String... args) {

		// map
		List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
		System.out.println(dishNames);

		// map
		List<String> words = Arrays.asList("Helloo", "World");
		List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
		System.out.println(wordLengths);

		// other way
		List<String[]> collect = words.stream().map(word -> word.split("")).distinct().collect(toList());
		for (String[] strings : collect) {
			System.out.println(Arrays.toString(strings));
		}
		System.out.println();

		List<char[]> collect2 = words.stream().map(word -> word.toCharArray()).distinct().collect(toList());
		for (char[] chars : collect2) {
			System.out.println(Arrays.toString(chars));
		}
		System.out.println();

		// or
		List<Stream<String>> collect3 = words.stream().map(x -> x.split("")).map(Arrays::stream).distinct()
				.collect(toList());
		System.out.println(collect3);

		String[] arrayOfWords = { "Goodbye", "World" };
		Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
		streamOfwords.forEach(System.out::print);
		System.out.println();

		// flatMap
		words.stream().flatMap((String line) -> Arrays.stream(line.split(""))).distinct().forEach(System.out::println);

		streamOfwords = words.stream().map(x -> x.split("")).flatMap(Arrays::stream).distinct();
		words = streamOfwords.collect(Collectors.toList());
		System.out.println("flatMap: " + words);

		// flatMap
		/**
		 * Given two lists of numbers, how would you return all pairs of numbers? For
		 * example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3),
		 * (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For simplicity, you can represent a
		 * pair as an array with two elements.
		 */
		final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		final List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
				.collect(toList());
		pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
		System.out.println();

		// other example
		List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> numbers4 = Arrays.asList(6, 7, 8);
		pairs = numbers3.stream().flatMap((Integer i) -> numbers4.stream().map((Integer j) -> new int[] { i, j }))
				.filter(pair -> (pair[0] + pair[1]) % 3 == 0).collect(toList());
		pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
	}
}

class NumericStreams {

	public static void main(String... args) {

		List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

		Arrays.stream(numbers.toArray()).forEach(System.out::println);
		int calories = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println("Number of calories:" + calories);

		// max and OptionalInt
		OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();

		int max;
		if (maxCalories.isPresent()) {
			max = maxCalories.getAsInt();
		} else {
			// we can choose a default value
			max = 1;
		}
		System.out.println(max);
		System.out.println();

		// numeric ranges
		IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);

		System.out.println(evenNumbers.count());
		System.out.println();

		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
						.map(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));

		pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

	}

	public static boolean isPerfectSquare(int n) {
		return Math.sqrt(n) % 1 == 0;
	}

}

class Reducing {

	public static void main(String... args) {

		List<Integer> numbers = Arrays.asList(3, 4, 5, 31, 2);
		int sum = numbers.stream().reduce(1, (a, b) -> a + b);
		System.out.println(sum);
		System.out.println();
		

		/**
		 * There’s also an overloaded variant of reduce that doesn’t take an initial
		 * value, but it returns an Optional object:
		 */
		Optional<Integer> opt = numbers.stream().reduce((a, b) -> a+b); 
		System.out.println(opt.get());
		System.out.println();

		int sum2 = numbers.stream().reduce(0, Integer::sum);
		System.out.println(sum2);
		

		List<BigInteger> bigN = Arrays.asList(null, BigInteger.TEN, BigInteger.ZERO, BigInteger.TWO);
		//bigN.stream().filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);

		int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
		System.out.println(max);

		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		min.ifPresent(System.out::println);

		int calories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
		System.out.println("Number of calories:" + calories);
		
		calories = menu.stream().map(Dish::getCalories).reduce(-2, Integer::min);
		System.out.println("Number of calories:" + calories);
		calories = menu.stream().map(Dish::getCalories).reduce(-2, Integer::max);
		System.out.println("Number of calories:" + calories); 
	}
}
