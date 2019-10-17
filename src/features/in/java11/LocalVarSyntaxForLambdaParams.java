package features.in.java11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import features.in.java10.LocalVarTypeInference;

public class LocalVarSyntaxForLambdaParams {

	/**
	 * In Java 10, Local Variable Type Inference was introduced. Thus we could infer
	 * the type of the variable from the
	 * 
	 * RHS(right hand side) like: var list = new ArrayList<String>();
	 * 
	 * {link {@link LocalVarTypeInference#main(String[])}
	 */
	public static void main(String[] args) {

		System.out.println(
				"JEP 323 allows var to be used to declare the formal parameters of an implicitly typed lambda expression.");

		// (var s1, var s2) -> s1 + s2
		// This was possible in Java 8 too but got removed in Java 10. Now it’s back in
		// Java 11 to keep things uniform.
		// This makes the usage of var uniform in both local variables and lambda
		// parameters.
		IntStream.of(1, 2, 3, 5, 6, 7).filter((var i) -> i % 3 == 0).forEach(System.out::println);

		// benefits
		System.out.println("But why is this needed when we can just skip the type in the lambda? "
				+ "If you need to apply an annotation just as @Nullable, you cannot do that without defining the type.");
		// (@Nonnull var x, @Nullable var y) -> x.process(y)

		System.out.println("Limitation of this feature");
		/*
		 * (var s1, var s2) -> s1 + s2 //no skipping allowed
		 * 
		 * (var s1, String y) -> s1 + y //no mixing allowed
		 * 
		 * var s1 -> s1 //not allowed. Need parentheses if you use var in lambda.
		 * 
		 * s1 -> s1.toUpperCase() we can skip the parentheses in single parameter
		 * lambda: var s1 -> s1.toUpperCase() we cannot skip them while using var
		 */

		// Local-Variable Syntax for Lambda Parameters
		//System.out.println("J11 - Local-Variable Syntax for Lambda Parameters");
		/**
		 * local-Variable Syntax for Lambda Parameters is the only language feature
		 * release in Java 11. In Java 10, Local Variable Type Inference was introduced.
		 * Thus we could infer the type of the variable from the
		 * 
		 * RHS – var list = new ArrayList<String>();
		 * 
		 * 
		 */
		var list = new ArrayList<String>();
		System.out.println(list);
		var list2 = List.of();
		System.out.println(list2);
		var list3 = List.of("hello", "hi");
		System.out.println(list3);
	}
}
