package features.in.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * Method references help to point to methods by their names. A method reference
 * is described using "::" symbol. A method reference can be used to point the
 * following types of methods
 * 
 * <pre>
 *  
    Static methods
    Instance methods
    Constructors using new operator (TreeSet::new)
 * 
 * </pre>
 */
public class MethodReference {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("\n------- Java 8 Method Reference ---------");
		System.out.println("A method reference is the shorthand syntax for a lambda expression that executes "
				+ "just ONE method. Here's the general syntax of a method reference:");

		System.out.println("\nWe know that we can use lambda expressions instead of using an anonymous class. "
				+ "But sometimes, the lambda expression is really just a call to some method, for example:");
		Consumer<String> c = s -> System.out.println(s);
		c.accept("Ahoj Method Reference");

		c = (s) -> {
			System.out.print("Anything ");
			for (char x : "hayret be".toCharArray()) {
				System.out.println(x);				
			}
			System.out.println(s);
		};
		c.accept("Ahoj Method Reference");

		Consumer<Integer> i = j -> System.out.println(j);
		i.accept(63);

		// or
		System.out.println("\nTo make the code clearer, you can turn that lambda expression into a method reference:");
		Consumer<Integer> i2 = System.out::println;
		i2.accept(63);

		System.out.println(
				"First of all, a method reference can't be used for any method. They can only be used to replace a single-method lambda expression.");
		/**
		 * <pre>
		  (args) -> Class.staticMethod(args) 
		  
		 This can be turned into the following method reference:
		 Class::staticMethod
		 * </pre>
		 */
		String[] names = { "Bob", "George", "Henry", "Declan", "Peter", "Steven" };
		List<String> letters = Arrays.asList(names);

		for (Object object : letters) {
			System.out.println(object);
		}

		System.out.println("\n using :: ");
		letters.forEach(System.out::println);
		
		c = (s) -> {
			System.out.print("Anything ");
			for (char x : "hayret be".toCharArray()) {
				System.out.print(x+" ");				
			}
			//System.out.println(s);
		};
		letters.forEach(c);

		/*
		 * int[] arrs = new int[2]; arrs[0]=3; arrs[1]=5;
		 * 
		 * arrs.forEach(System.out::println);
		 */

		/*
		 * Integer[] arrs = new Integer[2]; arrs[0]=3; arrs[1]=5;
		 * 
		 * arrs.forEach(System.out::println);
		 */

	}
}

/**
 * <pre>
In general, we don't have to pass arguments to method references. However, arguments are treated depending on the type of 
method reference.

In this case, any arguments (if any) taken by the method are passed automatically behind the curtains.
Where ever we can pass a lambda expression that just calls a static method, we can use a method reference. For example, 
assuming this class:
 * 
 * </pre>
 * 
 */
class Numbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

		// Using an anonymous class
		List<Integer> foundNumbers = findNumbers(list, new BiPredicate<Integer, Integer>() {
			public boolean test(Integer i1, Integer i2) {
				return Numbers.isMoreThanFifty(i1, i2);
			}
		});
		System.out.println(foundNumbers);

		// Using a lambda expression
		foundNumbers = findNumbers(list, (i1, i2) -> i1 + i2 > 50);
		System.out.println(foundNumbers);

		// Using a lambda expression
		foundNumbers = findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));
		System.out.println(foundNumbers);

		// Using a method reference
		/**
		 * In this case, any arguments (if any) taken by the method are passed
		 * automatically behind the curtains. Where ever we can pass a lambda expression
		 * that just calls a static method, we can use a method reference. For example,
		 * assuming this class:
		 */
		foundNumbers = findNumbers(list, Numbers::isMoreThanFifty);
		System.out.println(foundNumbers);

	}

	public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
		List<Integer> newList = new ArrayList<>();
		for (Integer i : l) {
			if (p.test(i, i + 10)) {
				newList.add(i);
			}
		}
		return newList;
	}

	public static boolean isMoreThanFifty(int n1, int n2) {
		return (n1 + n2) > 50;
	}

}
