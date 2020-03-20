package features.in.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 
 * <pre>
Functional interfaces have a single functionality to exhibit. For example, a Comparable interface with a 
single method ‘compareTo’ is used for comparison purpose.
Java 8 has defined a lot of functional interfaces to be used extensively in lambda expressions. Following 
is the list of functional interfaces defined in java.util.Function package.


Functional interfaces, which are gathered in the java.util.function package, satisfy most developers’ needs in providing 
target types for lambda expressions and method references.
 * </pre>
 */
public class FunctionalInterfaces {

	public static void main(String[] args) {

		System.out.println("" + "" + "In Java 8's java.util.function package, we have:\n"
				+ "\n  Predicate: functional interface to return a Boolean value - boolean test(T t)"
				+ "\n  Function: Takes one argument, produces one result - R apply(T t)"
				+ "\n  Consumer: Takes one argument, produces nothing - void accept(T t)"
				+ "\n  Supplier: Takes no argument, produces one result - T get() ");
		System.out.println();

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		list.forEach(System.out::println);

		System.out.println("\nPrint all numbers:");
		evalViaPredicate(list, n -> true);

		System.out.println("Print even numbers:");
		evalViaPredicate(list, (n) -> n % 2 == 0);

		System.out.println("\nPrint odd numbers");
		evalViaPredicate(list, n -> n % 2 != 0);

		System.out.println("Print numbers greater than 3:");
		evalViaPredicate(list, n -> n > 3);

		System.out.println("\nPrint if two numbers sum is greater than 7  :");
		evalViaBiPredicate(list, (a, b) -> a + b > 7);

		List<String> l = Arrays.asList("alma", "enar", "uzum", "enjir");
		List<String> result = new ArrayList<>();

		// Consumers, use functions as a parameters
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = result::add;
		l.forEach(c1);
		System.out.println();
		l.forEach(c1.andThen(c2));
		System.out.println("size = "+result.size());

		// Predicates
		Predicate<String> predicate1 = s -> s.length() > 3;
		Predicate<String> predicate2 = s -> s.length() < 6; 

	}

	public static void evalViaPredicate(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer integer : list) {
			if (predicate.test(integer))
				System.out.print(integer + " ");
		}
		System.out.println();
	}

	public static void evalViaBiPredicate(List<Integer> list, BiPredicate<Integer, Integer> predicate) {

		for (Integer n : list) {
			if (predicate.test(n, n + 1)) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
	}

}

/**
 * Note that the @FunctionalInterface annotation isn’t mandatory, but it’s good
 * practice to use it when an interface is designed for that purpose. You can
 * think of it like the @Override notation to indicate that a method is
 * overridden.
 *
 * 
 */
@FunctionalInterface
interface FI {
	String method(String string);
}

class UseFI {
	public String add(String string, FI fi) {
		return fi.method(string);
	}

	public static void main(String[] args) {
		/**
		 * Look closer and you will see that FI is nothing more than a function that
		 * accepts one argument and produces a result.
		 * 
		 * Java 8 already provides such an interface in Function<T,R> from the
		 * java.util.function package.
		 */
		FI fi = parameter -> parameter + " from lambda";

		UseFI useFoo = new UseFI();
		String result = useFoo.add("Message ", fi);

		// To execute this, we can write:
		Function<String, String> fn = parameter -> parameter + " from lambda";
		result = useFoo.add("Message ", fn);
	}

	// Now we can remove interface Foo completely and change our code to:
	public String add(String string, Function<String, String> fn) {
		return fn.apply(string);
	}
}
