package best.practices.lambdas.and.streams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Functional composition is a technique to combine multiple functions into a
 * single function which uses the combined functions internally.
 *
 * http://tutorials.jenkov.com/java-functional-programming/functional-composition.html
 */
public class FunctionalComposition {

	public static void main(String[] args) {
		Predicate<String> startsWithA = (text) -> text.startsWith("A");
		Predicate<String> endsWithX = (text) -> text.endsWith("x");

		Predicate<String> startsWithAAndEndsWithX = (text) -> startsWithA.test(text) && endsWithX.test(text);

		String input = "A hardworking person must relax";
		boolean result = startsWithAAndEndsWithX.test(input);
		System.out.println(result);

		System.out.println("\nPredicate Composition - and()");
		// and
		Predicate<String> composed = startsWithA.and(endsWithX);
		input = "A hardworking person must relax";
		result = composed.test(input);
		System.out.println(result);

		// or
		System.out.println("\nPredicate Composition - or()");
		Predicate<String> composed2 = startsWithA.or(endsWithX);
		String input2 = "A hardworking person must relax sometimes";
		boolean result3 = composed2.test(input2);
		System.out.println(result3);

		// compose
		System.out.println("\nFunction Composition - compose()");
		Function<Integer, Integer> multiply = (value) -> value * 2;
		Function<Integer, Integer> add = (value) -> value + 4;

		//composed Function will first call the add Function and then the multiply Function
		Function<Integer, Integer> addThenMultiply = multiply.compose(add);
		Integer result1 = addThenMultiply.apply(10); // (10+4)*2 = 28
		System.out.println(result1);
		
		UnaryOperator<Integer> multiplyO = (value) -> value * 2;
		UnaryOperator<Integer> addO = (value) -> value + 3;
		//only for FUNCTION
		//UnaryOperator<Integer> addThenMultiplyO = multiplyO.compose(addO);
		 
		System.out.println("\nandThen(), opposite of compose"); 
		Function<Integer, Integer> multiply2 = (value) -> value * 2;
		Function<Integer, Integer> add2 = (value) -> value + 3;

		Function<Integer, Integer> multiplyThenAdd2 = multiply2.andThen(add2);

		//here firstly multiplies then adds - ooposite of compose
		Integer result2 = multiplyThenAdd2.apply(4); // (4*2)+3 == 11
		System.out.println(result2);
	}

	/**
	 * In mathematics, function composition is an operation that takes two functions
	 * f and g and produces a function h such that h(x) = g(f(x)). In this
	 * operation, the function g is applied to the result of applying the function f
	 * to x.
	 *
	 * Or a technique to combine multiple functions into a single function which
	 * uses the combined functions internally.
	 *
	 */

	public static void main2(String[] args) {
		Predicate<String> startsWithLetter = (input) -> input.startsWith("C");
		Predicate<String> endsWithLetter = (inputt) -> inputt.endsWith("t");

		Predicate<String> startsAndEndsWith = (input) -> startsWithLetter.test(input) && endsWithLetter.test(input);

		String input = "Cehsen zahmet yagar rahmet";
		boolean result = startsAndEndsWith.test(input);
		System.out.println(result);
	}

}


