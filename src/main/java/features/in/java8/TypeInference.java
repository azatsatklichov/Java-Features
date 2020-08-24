package features.in.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Type Inference means that the data type of any expression (e.g. method return
 * type or parameter type) can be deduced automatically by the compiler.
 * 
 * Type inference is a feature of Java which provides ability to compiler to
 * look at each method invocation and corresponding declaration to determine the
 * type of arguments.
 * 
 * 
 * Java provides improved version of type inference in Java 8
 * 
 */
public class TypeInference {
	public static void main(String[] args) {

		System.out.println("before Java 5");
		List intlist = new ArrayList();
		intlist.add(6);
		showList(intlist);

		System.out.println("\nin Java 5 ");
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		showList(list);

		// In Java 5, we could do Type-Inference in specific contexts as shown above.
		List<String> strListInferred = Collections.emptyList();
		System.out.println(strListInferred);
		
		List<String> strListInferred2 = Collections.EMPTY_LIST;//Type safety: The
		// expression of type List needs unchecked conversion to conform to List<String>
		System.out.println(strListInferred2);
		

		System.out.println("\nin Java 7 - diamond operator <>");
		// Java 7 expanded the contexts in which it could be performed. It introduced
		// the diamond operator <>
		Map<String, Map<String, String>> mapOfMapsInferred = new HashMap<>();
		System.out.println(mapOfMapsInferred);

		// or
		List<Integer> list2 = new ArrayList<>();
		list2.add(7);
		showList(list2);

		List<String> strListGeneralized = add(new ArrayList<>(), "abc", "def");
		List<Integer> intListGeneralized = add(new ArrayList<>(), 1, 2);
		List<Number> numListGeneralized = add(new ArrayList<>(), 1, 2.0);
		System.out.println(strListGeneralized +", "+ intListGeneralized +", "+ numListGeneralized); 

		System.out.println("\nGeneralized Target-Type Inference – Java 8");
		// Tech. Spec: https://docs.oracle.com/javase/specs/jls/se8/html/jls-18.html
		/**
		 * Java 8 supports inference using Target-Type in a method context. When we
		 * invoke a generic method without explicit type arguments, the compiler can
		 * look at the method invocation and corresponding method declarations to
		 * determine the type argument (or arguments) that make the invocation
		 * applicable.
		 */

		// In Java 8, you can call specialized method without explicitly mentioning of
		// type of arguments.
		showList(new ArrayList<>());

		// In Lambdas
		BiFunction<Integer, Integer, Integer> summer = (Integer num1, Integer num2) -> {
			return num1 + num2;
		};

		Integer number1 = 10;
		Integer number2 = 20;

		System.out.println(number1 + " + " + number2 + " = " + summer.apply(number1, number2));

		BiFunction<Integer, Integer, Long> summer2 = (num1, num2) -> {
			return (long) (number1 + number2);
		};

		System.out.println(number1 + " + " + number2 + " = " + summer2.apply(number1, number2));

		List<Integer> intList = Arrays.asList(5, 2, 4, 2, 1);
		Collections.sort(intList, (a, b) -> a.compareTo(b));

		List<String> strList = Arrays.asList("Red", "Blue", "Green");
		Collections.sort(strList, (a, b) -> a.compareTo(b));

	}

	public static void showList(List<Integer> list) {
		if (!list.isEmpty()) {
			list.forEach(System.out::println);
		} else
			System.out.println("empty list");
	}

	static <T> List<T> add(List<T> list, T a, T b) {
		list.add(a);
		list.add(b);
		return list;
	}

	interface BiFunction<K, V, R> {
		R apply(K k, V v);
	}

}
