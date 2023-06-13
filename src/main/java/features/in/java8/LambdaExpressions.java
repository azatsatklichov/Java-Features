package features.in.java8;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 
 * Following are the important characteristics of a lambda expression.
 * 
 * <pre>

Optional type declaration:  No need to declare the type of a parameter. The compiler can inference the same from the value of the parameter.

Optional parenthesis around parameter: No need to declare a single parameter in parenthesis. For multiple parameters, parentheses are required.

Optional curly braces: No need to use curly braces in expression body if the body contains a single statement.

Optional return keyword: The compiler automatically returns the value if the body has a single expression to return the value. 

Curly braces are required to indicate that expression returns a value.
 * 
 * 
 * </pre>
 * 
 */
public class LambdaExpressions {

	final static String salutation = "Hello! ";

	public static void main(String args[]) {

		/**
		 * Lambdas technically don�t let you do anything that you couldn�t do prior to
		 * Java 8.
		 * 
		 * But you no longer have to write clumsy code using anonymous classes to
		 * benefit from behavior parameterization! Lambda expressions will encourage you
		 * to adopt the style of behavior parameterization
		 */

		// Before:
		Comparator<Apple> byWeight = new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		};

		// With Java 8
		Comparator<Apple> byWeight2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

		System.out
				.println("So where exactly can you use lambdas? You can use a lambda expression in the context of a\r\n"
						+ "functional interface.");
		// OR
		MathOperation addition = new MathOperation() {

			@Override
			public int opt(int a, int b) {
				return a + b;
			}
		};

		System.out.println(addition.opt(3, 8));

		// Lambda with type declaration, assignment is a must
		addition = (int a, int b) -> a + b;
		System.out.println(addition.opt(3, 8));

		// without type declaration, paranthesis is only needed for multiple arguments
		addition = (a, b) -> a + b;
		System.out.println(addition.opt(3, 8));

		LambdaExpressions test = new LambdaExpressions();

		MathOperation subtraction = (a, b) -> a - b;

		// with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + test.operate(10, 5, addition));
		System.out.println("10 - 5 = " + test.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + test.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + test.operate(10, 5, division));
		System.out.println("10^2-5^2 = " + test.operate(10, 5, new MathOperation() {

			@Override
			public int opt(int a, int b) {
				return a * a - b * b;
			}
		}));

		MathOperation pythogorian = (int a, int b) -> a * a - b * b;
		System.out.println("10^2-5^2 = " + test.operate(10, 5, pythogorian));

		System.out.println(
				"\nstarting in Java 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. "
						+ "\nA variable or parameter whose value is never changed after it is initialized is effectively final.\n");

		String hey = "Hey - effectively final unless re-assigned";
		final String eHey = "eHey - final";

		GreetingService greetService = message -> {
			System.out.println(hey);
			// hey = "heyHey"; //Local variable hey defined in an enclosing scope must be
			// final or effectively final
			System.out.println(
					"Cannot be re-assigned: Local variable 'hey' defined in an enclosing scope must be final or effectively final");
			System.out.println(hey);
			System.out.println(eHey);
			System.out.println();

			message += " second time ";
			System.out.println(salutation + message);
		};

		greetService.hi("Hello");

		greetService = (String message) -> System.out.println(salutation + message);
		greetService.hi("Inter");
		// without parenthesis
		greetService = message -> System.out.println(salutation + message);
		greetService.hi("Milan");
		greetService = message -> {
			System.out.println(4 * 4 + "  " + message);
		};

		greetService.hi("Roma");

		System.out.println("\n Avoid Blocks of Code in Lambda�s Body");
		// use
		GreetingService2 gs = parameter -> buildString(parameter);
		// instead of:
		GreetingService2 gs2 = parameter -> {
			String result = "Something " + parameter;
			// many lines of code
			return result;
		};

		// more examples - pass Lanbda function as Parameter
		FileFilter ff = (File f) -> f.getName().endsWith(".java");
		File dir = new File("C:\\workspace_ext\\Java-Features\\src\\features\\in\\java8");
		File[] fArr = dir.listFiles(ff);
		Arrays.asList(fArr).forEach(System.out::println);

		// Type of Lambda ? It is a type of Functional interface, which it implements
		// Assign Lambda to a Variable
		Consumer<String> c1 = s -> System.out.println(s);
		Consumer<String> c2 = System.out::println;

		Comparator<String> cmp1 = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
		Comparator<String> cmp2 = (s1, s2) -> Integer.compare(s1.length(), s2.length());

		Comparator<Integer> cmp3 = (i1, i2) -> Integer.compare(i1, i2);
		Comparator<Integer> cmp4 = Integer::compare;

		List<String> l = List.of("A", "L", "C", "Z");
		l.forEach(s -> System.out.print(s));
		System.out.println();
		l.forEach(System.out::print);
		System.out.println();
		l.stream().sorted().forEach(System.out::print);
		

	}

	@FunctionalInterface
	interface MathOperation {
		int opt(int a, int b);
		// int opt2(int a, int b); //then all above Lambdas gives compile time error
		// The target type of this expression must be a functional interface
		// int operation2(int a, int b);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.opt(a, b);
	}

	interface GreetingService {
		void hi(String message);
	}

	interface GreetingService2 {
		String msg(String message);
	}

	private static String buildString(String parameter) {
		String result = "Something " + parameter;
		// many lines of code
		return result;
	}

	// sort using java 7
	private void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	private void sortIt(List<String> list) {
		Collections.sort(list, (l1, l2) -> l1.compareTo(l2));
	}

	// sort using java 8
	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}
}

class Apple {
	private int weight = 0;
	private String color = "";
	private int price = 0;

	public Apple(int weight, String color, Integer price) {
		this.weight = weight;
		this.color = color;
		this.price = price;
	}

	public Apple(int weight, String color) {
		this(weight, color, 0);
	}

	public Apple(String color) {
		this(23, color);
	}

	public Apple() {
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public String toString() {
		return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + ", Price=" + price + '}';
	}
}
