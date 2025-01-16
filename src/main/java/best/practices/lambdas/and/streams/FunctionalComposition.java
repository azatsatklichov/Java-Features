package best.practices.lambdas.and.streams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class FunctionalProgramming {

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

	public static void main(String[] args) {
		Predicate<String> startsWithLetter = (input) -> input.startsWith("C");
		Predicate<String> endsWithLetter = (inputt) -> inputt.endsWith("t");

		Predicate<String> startsAndEndsWith = (input) -> startsWithLetter.test(input) && endsWithLetter.test(input);

		String input = "Cehsen zahmet yagar rahmet";
		boolean result = startsAndEndsWith.test(input);
		System.out.println(result);
	}
}

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
		/**
		 * The Java Function compose() method composes a new Function instance from the
		 * Function instance it is called on, and the Function instance passed as
		 * parameter to the compose() method.
		 */
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





/**
 * Composing Functions
 *
 * <pre>
 Finally, you can also compose lambda expressions represented by the Function interface. The
 Function interface comes with two default methods for this, andThen and compose, which both
 return an instance of Function.
 * </pre>
 */
class ComposingFunctions {
	public static void main(String[] args) {
		System.out.println("You can also compose lambda expressions represented by the Function interface");

		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		System.out.println("In math you like to write g(f(x)) or (g of f)(x)");
		Function<Integer, Integer> gf = f.andThen(g);
		Integer result = gf.apply(10); // (10+1)*2=22
		System.out.println(result);

		System.out.println(
				"\nYou can also use the method compose similarly to first apply the function given as argument to\r\n"
						+ "compose and then apply the function to the result. In math you like to write f(g(x)) or (f of g)(x)");
		Function<Integer, Integer> composed = f.compose(g);
		result = composed.apply(10); // (10*2)+1=21
		System.out.println(result);

	}

}

/**
 * You can now create various transformation pipelines by composing the utility
 * methods, for example, creating a pipeline that first adds a header, then
 * checks spelling, and finally adds a footer
 */
class TrasformationPipeline {
	public static void main(String[] args) {
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);

		String result = transformationPipeline.apply("Go Reds");
		System.out.println(result);

		// A second pipeline might be only adding a header and footer without checking
		// for spelling:

		Function<String, String> addHeader2 = Letter::addHeader;
		Function<String, String> transformationPipeline2 = addHeader2.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);
		result = transformationPipeline.apply("Hola Madrid");
		System.out.println(result);

	}

}

class Letter {

	public static String addHeader(String text) {
		return "From Raoul, Mario and Alan: " + text;
	}

	public static String addFooter(String text) {
		return text + " Kind regards";
	}

	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}
}
