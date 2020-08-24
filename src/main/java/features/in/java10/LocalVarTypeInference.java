package features.in.java10;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * * https://www.journaldev.com/19871/java-10-local-variable-type-inference
 * 
 * <pre>
 *
 * This feature was proposed as part of JEP (JDK Enhancement Proposal): 286. The
 * proposal was for enhancing the language to support the type inference to
 * local variable declaration and initialization.
 * 
 * 
 * https://www.baeldung.com/java-10-local-variable-type-inference
 * https://www.oracle.com/technetwork/articles/java/architect-lambdas-part1-2080972.html
 * https://www.oracle.com/technetwork/articles/java/architect-lambdas-part2-2081439.html
 * https://www.journaldev.com/19871/java-10-local-variable-type-inference
 * </pre>
 */
class BeforeJava10 {
	@Test
	public void whenVarInitWithString_thenGetStringTypeVar() {

		// Until Java 9, we had to mention the type of the local variable explicitly and
		// ensure it was compatible with the initializer used to initialize it:
		String message = "Good bye, Java 9";

		/**
		 * We don�t provide the data type of message. Instead, we mark the message as a
		 * var, and the compiler infers the type of message from the type of the
		 * initializer present on the right-hand side.
		 * 
		 * Another thing to note is that var is not a keyword � this ensures backward
		 * compatibility for programs using var say, as a function or variable name. var
		 * is a reserved type name, just like int.
		 */
		System.out.println("Note that this feature is available only for local variables with the initializer. "
				+ "No runtime overhead in using var nor does it make Java a dynamically typed language. ");
		var message2 = "Hello, Java 10";
		assertTrue(message2 instanceof String);
	}
}

public class LocalVarTypeInference {

	public static void main(String[] args) {

		// runThread(runnable);

		System.out.println(" - Local Variable Type Inference Usage Scenarios");
		/**
		 * Local type inference can be used only in the following scenarios:
		 * 
		 * Limited only to Local Variable with initializer
		 * 
		 * Indexes of enhanced for loop or indexes
		 * 
		 * Local declared in for loop
		 */
		var numbers = List.of(1, 2, 3, 4, 5); // inferred value List<Integer>
		// Index of Enhanced For Loop
		for (var number : numbers) {
			System.out.println(number);
		}
		// Local variable declared in a loop
		for (var i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}

		System.out.println("Illegal Use of var"); // https://www.journaldev.com/19871/java-10-local-variable-type-inference
		// var n; // error: cannot use 'var' on variable without initializer
		// var x = 5, y = 10; Cannot be used for multiple variable definition
		// var emptyList = null; // error: variable initializer is 'null'
		// var actorArr[] = new Actor[10]; Cannot have extra array dimension brackets -
		// 'var' is not allowed as an element type of an array
		// public var = "hello"; // error: 'var' is not allowed here
		// var p = (String s) -> s.length() > 10; // error: lambda expression needs an
		// explicit target-type
		// var arr = { 1, 2, 3 }; // error: array initializer needs an explicit
		// target-type

		// In Java 10, this is how we could declare a local variable:

		System.out
				.println("Guidelines for Using var, read also: http://openjdk.java.net/projects/amber/LVTIstyle.html");
		// For example, in situations where the code could become less readable:
		// var result = obj.prcoess();

		// Another situation where it�s best to avoid var is in streams with long
		// pipeline:
		/*
		 * var x = emp.getProjects.stream() .findFirst() .map(String::length)
		 * .orElse(0);
		 */

		System.out.println("-- Generics with Local Variable Type Inference");
		/**
		 * Type Erasure: To implement generics, the Java compiler applies type erasure
		 * to, replace all type parameters in generic types with their bounds or Object
		 * if the type parameters are unbounded.
		 */
		// Usage of var may also give unexpected result.

		var m1 = new HashMap(); // Inferred as HashMap - Compiler infers the map as HashMap without any generic
								// type.
		var m2 = new HashMap<>(); // Inferred as HashMap<Object, Object>
		/*
		 * The diamond operator relies on the LHS for the type inference, here the
		 * compiler cannot infer the LHS and hence it infers map2 to have upper bound or
		 * super type to which the HashMap can be denoted to. This leads to map2 being
		 * inferred as HashMap.
		 */

		var empList = new ArrayList<>();
		// ArrayList<Object>

		// The type of empListwill be ArrayList<Object>and not List<Object>.
		// If we want it to be ArrayList<Employee>, we will have to be explicit:
		// var empList = new ArrayList<Employee>();

		// Using var with non-denotable types could cause unexpected error.
		// var obj = new Object() {};
		// assertFalse(obj.getClass().equals(Object.class));

		// Now, if we try to assign another Objectto obj, we would get a compilation
		// error:
		// obj = new Object(); // error: Object cannot be converted to <anonymous
		// Object>

		// This enhancement helps in reducing the boilerplate code; for example:
		// Pre Java 10
		Map<Integer, String> map = new HashMap<>();
		List<Actor> actors = List.of(new Actor());

		// This can now be rewritten as:
		var idToNameMap = new HashMap<Integer, String>();
		var list = new ArrayList<String>(); // infers ArrayList<String>
		var stream = list.stream(); // infers Stream<String>

		var actors10 = List.of(new Actor()); // Java 10 onwards

		var map1 = new HashMap(); // Inferred as HashMap
		var map2 = new HashMap<>(); // Inferred as HashMap<Object, Object>

		var runnable = new Runnable() {
			@Override
			public void run() {
				var numbers = List.of(5, 4, 3, 2, 1);
				for (var number : numbers) {
					System.out.println(number);
				}
			}
		};

	}

	/**
	 *
	 * <pre>
	 *How does Local Variable Type Inference work?
	Parsing a var statement, the compiler looks at the right hand side of the declaration, aka initializer, 
	and it infers the type from the right hand side (RHS) expression.
	
	Ok fine enough, does this mean that now Java is a dynamically typed language? Not really, it�s 
	still a statically typed language. Let�s take a code snippet for reading a file.
	 * 
	 * 
	 * </pre>
	 */
	private static void readFileJ10() throws IOException {
		var fileName = "Sample.txt";
		var line = "";
		var fileReader = new FileReader(fileName);
		var bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		bufferedReader.close();
	}

	// Now, let�s look at the decompiled code taken from IntelliJ IDEA decompiler.
	private static void readFile() throws IOException {
		String fileName = "Sample.txt";
		String line = "";
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		bufferedReader.close();
	}

}

class LegalLocalVarInferenceDemo {

	// in a static/instance initialization block
	static {
		var anotherName = "Sanaulla";
		System.out.println("Hello, " + anotherName);
	}

	public static void main(String[] args) {

		// as a local variable
		var name = "Mo Sanualla";
		System.out.println("Hello " + name);

		var data = new ArrayList<Map>();
		data.add(Map.of("key1", "value1", "key2", "value2"));
		data.add(Map.of("key11", "value11", "key22", "value22"));
		System.out.println(data);

		System.out.println("--  As iteration variable in enhanced for-loop -- ");
		for (var object : data) {
			System.out.println(String.format("%s of type %s", object, object.getClass().getName()));
		}

		System.out.println("--  As looping index in for-loop -- ");
		for (var i = 0; i < data.size(); i++) {
			var object = data.get(i);
			System.out.println(String.format("%s of type %s", object, object.getClass().getName()));
		}

		System.out.println("--  As a return value from another method -- ");
		var anInteger = someAnotherMethod();
		System.out.println("someAnotherMethod returned " + anInteger);

	}

	// As a return value in a method
	public static Integer someAnotherMethod() {
		System.out.println("someAnotherMethod called");
		var returnObj = 12;
		return returnObj;
	}

}

class IllegalLocalVarInferenceDemo2 {
	// Not permitted in class fields
	// var someProperty;

	// Not allowed as parameter for constructor
	// public LocalVarInferenceDemo(var param1){

	// }

	public static void main(String[] args) {

		// Not allowed in catch parameter
		// try{
		// //some operations
		// }catch(var ex){

		// }
	}

	// Not permitted below
	// public static void someMethod(var param1, var param2){
	// System.out.println("Some method called");
	// }

	// Not permitted in method return type
	// public static var someAnotherMethod2(){
	// System.out.println("someAnotherMethod called");
	// var returnObj = 12;
	// return returnObj;
	// }
}

