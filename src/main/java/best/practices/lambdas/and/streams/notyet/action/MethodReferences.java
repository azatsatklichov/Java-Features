package best.practices.lambdas.and.streams.notyet.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

public class MethodReferences {
	public static void main(String[] args) {
		System.out.println(
				"Method references let you reuse existing method definitions and pass them just like lambdas. In\r\n"
						+ "some cases they appear more readable and feel more natural than using lambda expressions.");

		// Before
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"),
				new Apple(120, "red", 44), new Apple(120, "red", 77));
		System.out.println(inventory);
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(inventory);

		// inventory.sort(comparing(Apple::getWeight));
		// via method reference - RECVERSED
		inventory.sort(comparing(Apple::getWeight).reversed());
		System.out.println(inventory);

		// Chaining Comparators
		inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getPrice));
		System.out.println(inventory);

		// Chaining Comparators

		System.out.println("\n Method references can be seen as shorthand for lambdas calling only a specific method.");
		System.out.println(
				"The basic idea is that if a lambda represents �call this  method directly,� it�s best to refer to the method by name rather than by a description of how to call it.");
		System.out.println(
				"Indeed, a method reference lets you create a lambda expression from an existing method implementation.");
		System.out.println("But by referring to a method name explicitly, your code can gain better readability.");

	}
}

class HowToConstructMethodReference {
	/**
	 * 
	 * Recipe for constructing method references
	 * 
	 * <pre>
	There are three main kinds of method references:
	1. A method reference to a static method (for example, the method parseInt of Integer, written
	Integer::parseInt)
	
	2. A method reference to an instance method of an arbitrary type (for example, the method
	length of a String, written String::length)
	
	3. A method reference to an instance method of an existing object (for example, suppose you
	have a local variable expensiveTransaction that holds an object of type Transaction, which
	supports an instance method getValue; you can write expensiveTransaction::getValue)
	 * </pre>
	 */
	public static void main(String[] args) {
		System.out.println("1. A method reference to a static method: e.g. Integer::parseInt");

		System.out.println("2. A method reference to an instance method of an arbitrary type: e.g. String::length ");

		System.out.println(
				"3. A method reference to an instance method of an existing object: e.g. xpensiveTransaction::getValue");

		List<String> str = Arrays.asList("a", "b", "A", "B");
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		// method reference
		str = Arrays.asList("a", "b", "A", "B");
		str.sort(String::compareToIgnoreCase);
		System.out.println(
				"\nNote that the compiler goes through a similar type-checking process as for lambda expressions\r\n"
						+ "to figure out whether a method reference is valid with a given functional interface: the signature\r\n"
						+ "of the method reference has to match the type of the context.");

		/**
		 * can be rewritten as String::toUpperCase
		 */
		Function<String, String> capitalize = (String s) -> s.toUpperCase();
		// method reference
		Function<String, String> capitalize2 = String::toUpperCase;

		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		Function<String, Integer> stringToInteger2 = Integer::parseInt;

		BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
		BiPredicate<List<String>, String> contains2 = List::contains;

	}
}

class HowToConstructConstructorReference {
	/**
	 * Constructor references
	 * 
	 * <pre>
	* You can create a reference to an existing constructor using its name and the keyword new as
	follows: ClassName::new. It works similarly to a reference to a static method.
	 * </pre>
	 */
	public static void main(String[] args) {

		System.out.println("Using default constructor");
		Supplier<Apple> c1 = Apple::new;
		Apple apple = c1.get();
		System.out.println(apple);

		// which is equivalent to
		Supplier<Apple> c2 = () -> new Apple();
		Apple apple2 = c1.get();
		System.out.println(apple2);

		System.out.println(
				"If you have a constructor with signature Apple(Integer weight), it fits the signature of the Function interface, so you can do this,");
		BiFunction<Integer, String, Apple> f = Apple::new;
		Apple a2 = f.apply(23, "Green");
		System.out.println(a2);

		// which is equivalent to
		BiFunction<Integer, String, Apple> f2 = (w, c) -> new Apple(w, c);
		a2 = f2.apply(23, "Green");
		System.out.println(a2);

		List<Integer> weights = Arrays.asList(1, 23, 55, 78);
		List<Apple> apples = map(weights, Apple::new);
		System.out.println(apples);

		weights = Arrays.asList(1, 23, 55, 78);
		List<Apple> apples2 = map2(weights, Apple::new);
		System.out.println(apples2);

		weights = Arrays.asList(111, 33, 55, 44);
		List<Apple> apples3 = map3(weights, Apple::new);
		System.out.println(apples3);

		TriFunction<Integer, String, Integer, Apple> f3 = Apple::new;
		Apple alma = f3.apply(55, "Gyzyl", 2);
		System.out.println(alma);

	}

	public static List<Apple> map(List<Integer> list, Function<String, Apple> f) {
		List<Apple> result = new ArrayList<>();
		for (Integer i : list) {
			result.add(f.apply("Green"));
		}
		return result;
	}

	public static List<Apple> map2(List<Integer> list, BiFunction<Integer, String, Apple> f) {
		List<Apple> result = new ArrayList<>();
		for (Integer i : list) {
			if (i % 2 == 0) {
				result.add(f.apply(i, "Green"));
			} else {
				result.add(f.apply(i, "Red"));
			}
		}
		return result;
	}

	public static List<Apple> map3(List<Integer> list, TriFunction<Integer, String, Integer, Apple> f) {
		List<Apple> result = new ArrayList<>();
		for (Integer i : list) {
			if (i % 2 == 0) {
				result.add(f.apply(i, "Green", 44));
			} else {
				result.add(f.apply(i, "Red", 77));
			}
		}
		return result;
	}

	public interface TriFunction<T, U, V, R> {
		R apply(T t, U u, V v);
	}
}



