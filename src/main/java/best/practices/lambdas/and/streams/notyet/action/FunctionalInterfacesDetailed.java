package best.practices.lambdas.and.streams.notyet.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

public class FunctionalInterfacesDetailed {

	// java8-functional-interfaces.JPG

}

/**
 * Predicate
 * 
 * <pre>
 * The java.util.function.Predicate<T> interface defines an abstract
 * method named test that accepts an object of generic type T and returns a
 * boolean.
 *
 * </pre>
 */
class PredicateDemo {

	public static void main(String[] args) {
		System.out.println("\nWhat�s a Predicate?");
		System.out
				.println("predicate is often used in mathematics to mean something function-like that takes a value\r\n"
						+ "for an argument and returns true or false");

		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		List<String> nonEmpty = filter(Arrays.asList("one", "four", "fives", " ", "bounce"), nonEmptyStringPredicate);
		System.out.println(nonEmpty);

	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				result.add(s);
			}
		}
		return result;
	}

}

/**
 * Consumer
 * 
 * <pre>
*
The java.util.function.Consumer<T> interface defines an abstract method named accept that
takes an object of generic type T and returns no result (void). 

You might use this interface when
you need to access an object of type T and perform some operations on it. For example, you can
use it to create a method forEach, which takes a list of Integers and applies an operation on each
element of that list. In the following listing you use this forEach method combined with a
lambda to print all the elements of the list.
 * </pre>
 */
class ConsumerDemo {

	public static void main(String[] args) {

		forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.print(i + " "));

	}

	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T i : list) {
			c.accept(i);
		}
	}

}

/**
 * 
 * Function
 * 
 * <pre>
The java.util.function.Function<T, R> interface defines an abstract method named apply that
takes an object of generic type T as input and returns an object of generic type R. You might use 
this interface when you need to define a lambda that maps information from an input object to
an output (for example, extracting the weight of an apple or mapping a string to its length). In
the listing that follows we show how you can use it to create a method map to transform a list of
Strings into a list of Integers containing the length of each String.
 * </pre>
 */
class FunctionDemo {

	public static void main(String[] args) {

		// implicit return
		List<Integer> ints = map(Arrays.asList("one", "four", "fives", "bounce"), (String s) -> s.length());
		System.out.println(ints);

		// write return explicitly
		ints = map(Arrays.asList("one", "four", "fives", "bounce"), (String s) -> {
			return s.length();
		});
		System.out.println(ints);

		// Via method reference
		ints = map(Arrays.asList("one", "four", "fives", "bounce"), FunctionDemo::len);
		System.out.println(ints);

	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T s : list) {
			result.add(f.apply(s));
		}
		return result;
	}

	public static int len(String s) {
		if (null == s) // || s.isBlank())
			return 0;
		return s.length();
	}

}

/**
 * <pre>
 * Generic parameters (for example, the T in Consumer<T>) can be bound only to reference types.
 * 
 * As a result, in Java there�s a mechanism to convert a 
 * primitive type into a corresponding reference type. This mechanism is called boxing.
 * 
 * The opposite approach (that is, converting a reference type into a corresponding primitive type) is
called unboxing. Java also has an autoboxing mechanism to facilitate the task for programmers:
boxing and unboxing operations are done automatically. For example, this is why the following
code is valid (an int gets boxed to an Integer):
 * </pre>
 */

class IntPredicateDemo {
	public static void main(String[] args) {
		System.out.println("Boxing comes with a performance cost. Boxed values use more memory and\r\n"
				+ "require additional memory lookups to fetch the wrapped primitive value.");
		List<Integer> list = new ArrayList<>();
		for (int i = 300; i < 400; i++) {
			list.add(i);
		}

		System.out
				.println("Java 8 brings a specialized version of the functional interfaces avoid autoboxing operations "
						+ "when the inputs or outputs are primitives.");

		System.out.println("-- true (no boxing) --");
		IntPredicate evenNumbers = (int i) -> i % 2 == 0;
		System.out.println(evenNumbers.test(44));

		System.out.println("-- false (no boxing) --");
		IntPredicate oddNumbers = (int i) -> i % 2 == 0;
		System.out.println(oddNumbers.test(23));

	}

}

class ExceptionsInLamdas {
	public static void main(String[] args) {
		System.out.println("You have "
				+ "two options if you need a lambda expression to throw an exception: \r\ndefine your own functional"
				+ "interface that declares the checked exception, \r\nor wrap the lambda with a try/catch block.");

		BufferedReaderProcessor p = (BufferedReader br) -> br.readLine();
		String oneLine = null;
		try {
			oneLine = processFile(p);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(oneLine);

		System.out.println(
				"But you may be using an API that expects a functional interface such as Function<T, R> and\r\n"
						+ "there�s no option to create your own");
		Function<BufferedReader, String> f = (BufferedReader b) -> {
			try {
				return b.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		};
	}

	@FunctionalInterface
	interface BufferedReaderProcessor {
		String process(BufferedReader b) throws IOException;
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(
				"C:\\workspace_ext\\Java-Features\\src\\features\\in\\java8\\lambdasinaction\\data.txt"))) {
			return p.process(br);
		}
	}
}

/**
 * 
 * Because of the idea of target typing, the same lambda expression can be
 * associated with different functional interfaces if they have a compatible
 * abstract method signature.
 * 
 * In this case the first assignment has target type Callable<Integer> and the
 * second assignment has target type PrivilegedAction<Integer>.
 */
class SameLambdaDifferentFI {
	public static void main(String[] args) {
		Callable<Integer> c = () -> 42;
		PrivilegedAction<Integer> p = () -> 42;

		Comparator<Apple> c1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		ToIntBiFunction<Apple, Apple> c2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		BiFunction<Apple, Apple, Integer> c3 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

	}
}