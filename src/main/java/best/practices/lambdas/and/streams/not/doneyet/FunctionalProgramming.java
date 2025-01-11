package best.practices.lambdas.and.streams.not.doneyet;


import java.util.function.Predicate;

public class FunctionalProgramming {

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
