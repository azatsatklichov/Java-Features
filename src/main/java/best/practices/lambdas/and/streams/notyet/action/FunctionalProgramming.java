package best.practices.lambdas.and.streams.notyet.action;

import java.util.function.Function;

/**
 * Desc:
 * 
 * <pre>
*From a slightly revision ist viewpoint, the addition of Streams in Java 8 can be seen as a direct
cause of the two other additions to Java 8: concise techniques to pass code to methods (method
references, lambdas) and default methods in interfaces.

But thinking of passing code to methods as a mere consequence of Streams downplays its range
of uses within Java 8. It gives you a new concise way to express 

behavior parameterization.


The Java 8 feature of passing code to methods (and also being able to return it and incorporate
it into data structures) also provides access to a whole range of additional techniques that are
commonly referred to as functional-style programming.

The main benefit of Java 8 to a programmer is that it provides more programming tools and
concepts to solve new or existing programming problems more quickly or, more importantly, in
a more concise, more easily maintainable way.


1. The first programming concept is stream processing.

2. The second programming concept added to Java 8 is the ability to pass a piece of code to an API.
We also refer to this conceptually as behavior parameterization

The Streams API is built on the idea of passing code to parameterize the
behavior of its operations, just as you passed compareUsingCustomerId to parameterize the
behavior of sort.


The word function in programming languages is commonly used as a synonym for method,
particularly a static method; this is in addition to it being used for mathematical function, one
without side effects. Fortunately, as you�ll see, when Java 8 refers to functions these usages very
nearly coincide.

To help answer this, we�ll note that the whole point of a programming language is to manipulate
values, which, following historical programming-language tradition, are therefore called
first-class values (or citizens, in the terminology borrowed from the 1960s civil rights movement
in the United States). Other structures in our programming languages, which perhaps help us
express the structure of values but which can�t be passed around during program execution, are
second-class citizens. Values as listed previously are first-class Java citizens, but various other
Java concepts, such as methods and classes, exemplify second-class citizens.

So does this matter? Yes, it turns out that being able to pass methods
around at run-time, and hence making them first-class citizens, is very useful in programming,
and so the Java 8 designers added this ability to Java. Incidentally, you might wonder whether
making other second-class citizens such as classes into first-class-citizen values might also be a
good idea. Various languages such as Smalltalk and JavaScript have explored this route.


The first new Java 8 feature we introduce is that of method references.

Now, in Java 8 you can rewrite that code as follows:
File[] hiddenFiles = new File(".").listFiles(File::isHidden);



Java 8 method reference :: syntax (meaning �use this method as a
value�);
 * 
 * </pre>
 */
public class FunctionalProgramming {

	public static void main(String[] args) {
		// method references - 1st class citizenship, method as a VALUEs, ... behavior
		// parameterization
		// Streams
		// Other good ideas from functional programming: Optional<T>,

		System.out.println("Java 8 method reference :: syntax (meaning �use this method as a value�);");
		System.out.println(
				"methods are no longer second-class values. \nAnalogously to using an object reference when you pass an object around");

		System.out.println("For example, you can now\r\n"
				+ "write (int x) -> x + 1 to mean �the function that, when called with argument x, returns the value\r\n"
				+ "x + 1.�");
		System.out.println("Programs using these concepts are said to be written in\r\n"
				+ "functional-programming style�this phrase means �writing programs that pass functions around\r\n"
				+ "as first-class values.�");

		System.out.println("Passing code with behavior parameterization ");

		

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
 