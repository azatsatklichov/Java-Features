package features.in.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc:
 * 
 * <pre>
 * 
 * </pre>
 * 
 */
class GenericMethodTest {
	// generic method printArray
	public static <E> void printArray(E[] inputArray) {
		// Display array elements
		for (E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void main(String args[]) {
		// Create arrays of Integer, Double and Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array integerArray contains:");
		printArray(intArray); // pass an Integer array

		System.out.println("\nArray doubleArray contains:");
		printArray(doubleArray); // pass a Double array

		System.out.println("\nArray characterArray contains:");
		printArray(charArray); // pass a Character array
	}
}

class BoundedTypeTest {
	// determines the largest of three Comparable objects

	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x; // assume x is initially the largest

		if (y.compareTo(max) > 0) {
			max = y; // y is the largest so far
		}

		if (z.compareTo(max) > 0) {
			max = z; // z is the largest now
		}
		return max; // returns the largest object
	}

	public static void main(String args[]) {
		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));

		System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

		System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
				maximum("pear", "apple", "orange"));
	}
}

class Box<T> {
	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();

		integerBox.add(new Integer(10));
		stringBox.add(new String("Hello World"));

		System.out.printf("Integer Value :%d\n\n", integerBox.get());
		System.out.printf("String Value :%s\n", stringBox.get());
	}
}

/**
 * Why Use Generics?
 * 
 * <pre>
 * In a nutshell, generics enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods. Much like the more familiar 
 * formal parameters used in method declarations, type parameters provide a way for you to re-use the same code with different inputs. 
 * 
 * The difference is that the inputs to formal parameters are values, while the inputs to type parameters are types.

Code that uses generics has many benefits over non-generic code:
•Stronger type checks at compile time.
 A Java compiler applies strong type checking to generic code and issues errors if the code violates type safety. Fixing compile-time errors is easier 
 
 than fixing runtime errors, which can be difficult to find.


•Elimination of casts.
 The following code snippet without generics requires casting: 
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);

When re-written to use generics, the code does not require casting: 
List<String> list = new ArrayList<String>();
list.add("hello");
String s = list.get(0);   // no cast


• Enabling programmers to implement generic algorithms.
 By using generics, programmers can implement generic algorithms that work on collections of different types, can be customized, and are type safe and easier to read.
 * 
 * 
 * The most commonly used type parameter names are:
    •   E - Element (used extensively by the Java Collections Framework)
    •   K - Key
    •   N - Number
    •   T - Type
    •   V - Value
    •   S,U,V etc. - 2nd, 3rd, 4th types
 * 
 * </pre>
 * 
 */
class Genericss {

}
 
/**
 * 
 * The Diamond
 * 
 * <pre>


In Java SE 7 and later, you can replace the type arguments required to invoke the constructor of a generic class with an empty set of type arguments (<>) 
as long as the compiler can determine, or infer, the type arguments from the context. This pair of angle brackets, <>, is informally called the diamond. 
For example, you can create an instance of Box<Integer> with the following statement:

Box<Integer> integerBox = new Box<>();


For more information on diamond notation and type inference, see Type Inference.

Multiple Type Parameters

As mentioned previously, a generic class can have multiple type parameters. For example, the generic OrderedPair class, which implements the generic Pair interface:
 * 
 * </pre>
 * 
 */
interface Pair<K, V> {
	public K getKey();

	public V getValue();

	public static void main(String[] args) {
		System.out.println("Wow running in Interface. This is because of JAVA 8 static methods ");
	}
}

class OrderedPair<K, V> implements Pair<K, V> {

	private K key;
	private V value;

	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public static void main(String[] args) {

		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);

		Pair<String, String> p2 = new OrderedPair<String, String>("hello", "world");

		System.out.println(
				"As mentioned in The Diamond, because a Java compiler can infer the K and V types from the declaration OrderedPair<String, Integer>, "
						+ "these statements can be shortened using diamond notation:");

		OrderedPair<String, Integer> p3 = new OrderedPair<>("Even", 8);
		OrderedPair<String, String> p4 = new OrderedPair<>("hello", "world");

		System.out.println(p3);
		System.out.println("Parameterized Types");
		System.out.println(
				"You can also substitute a type parameter (i.e., K or V) with a parameterized type (i.e., List<String>). For example, "
						+ " using the OrderedPair<K, V> example:");

		OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>());

	}
}

// Generic Methods
class Util {

	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}

}

/**
 * Bounded Type Parameters
 * 
 * <pre>
 *  
 * There may be times when you want to restrict the types that can be used as
 * type arguments in a parameterized type. For example, a method that operates
 * on numbers might only want to accept instances of Number or its subclasses.
 * This is what bounded type parameters are for.
 * 
 * To declare a bounded type parameter, list the type parameter's name, followed
 * by the extends keyword, followed by its upper bound, which in this example is
 * Number. Note that, in this context, extends is used in a general sense to
 * mean either "extends" (as in classes) or "implements" (as in interfaces).
 * </pre>
 * 
 */
class Box2<T> {

	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public <U extends Number> void inspect(U u) {
		System.out.println("T: " + t.getClass().getName());
		System.out.println("U: " + u.getClass().getName());
	}

	public static void main(String[] args) {
		Box2<Integer> integerBox = new Box2<Integer>();
		integerBox.set(new Integer(10));
		// integerBox.inspect("some text"); // error: this is still String!
		integerBox.inspect(2); // error: this is still String!
	}
}

class NaturalNumber<T extends Integer> {

	private T n;

	public NaturalNumber(T n) {
		this.n = n;
	}

	public boolean isEven() {
		return n.intValue() % 2 == 0;
	}

	// ...
}

/**
 * 
 * Multiple Bounds
 * 
 * The preceding example illustrates the use of a type parameter with a single
 * bound, but a type parameter can have multiple bounds:
 * 
 * <T extends B1 & B2 & B3>
 * 
 * 
 */
class A {
	/* ... */ }

interface B {
	/* ... */ }

interface C {
	/* ... */ }

class D<T extends A & B & C> {
	/* ... */
}

// If bound A is not specified first, you get a compile-time error:
// class D2<T extends B & A & C> {
// /* ... */ } // compile-time error

// Generic Methods and Bounded Type Parameters
class BoundedMethods {

	/*
	 * static <T> int countGreaterThan(T[] anArray, T elem) { int count = 0; for (T
	 * e : anArray) if (e > elem) // compiler error ++count; return count; }
	 */

	interface Comparable<T> {
		public int compareTo(T o);
	}

	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
		int count = 0;
		for (T e : anArray)
			if (e.compareTo(elem) > 0)
				++count;
		return count;
	}

}

class BoxDemoTypeInference {

	public static <U> void addBox(U u, java.util.List<Box<U>> boxes) {
		Box<U> box = new Box<>();
		//box.set(u);
		boxes.add(box);
	}

	public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
		int counter = 0;

		for (Box<U> box : boxes) {
			U boxContents = box.get();
			System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
			counter++;
		}
	}

	public static void main(String[] args) {

		// https://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html

		java.util.ArrayList<Box<Integer>> listOfIntegerBoxes = new java.util.ArrayList<>();
		BoxDemoTypeInference.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
		BoxDemoTypeInference.addBox(Integer.valueOf(20), listOfIntegerBoxes);
		BoxDemoTypeInference.addBox(Integer.valueOf(30), listOfIntegerBoxes);

		BoxDemoTypeInference.<Integer>outputBoxes(listOfIntegerBoxes);
		BoxDemoTypeInference.outputBoxes(listOfIntegerBoxes);

		Map<String, List<String>> myMap = new HashMap(); // unchecked conversion
															// warning
		Map<String, List<String>> myMap2 = new HashMap<>();

		MyClass<Integer> myObject = new MyClass<>("");
		MyClass<Integer> myObject2 = new MyClass<>(32);

		/*
		 * static <T> List<T> emptyList(); List<String> listOne =
		 * Collections.emptyList();
		 *
		 *
		 */

	}
}

class MyClass<X> {
	<T> MyClass(T t) {
		// ...
	}
}

class Wildcards_UpperBound_extends {

	public static void main(String[] args) {

		List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		System.out.println("sum = " + sumOfList(ld));

		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String> ls = Arrays.asList("one", "two", "three");

		// printList2(li);
		printList3(ls);

		printList3(li);
		printList3(ls);

	}

	public static double sumOfList(List<? extends Number> list) {
		double s = 0.0;
		for (Number n : list)
			s += n.doubleValue();
		return s;
	}

	public static void printList2(List<Object> list) {
		for (Object elem : list)
			System.out.println(elem + " ");
		System.out.println();
	}

	public static void printList3(List<?> list) {
		for (Object elem : list)
			System.out.print(elem + " ");
		System.out.println();
	}

}

/**
 * The Upper Bounded Wildcards section shows that an upper bounded wildcard
 * restricts the unknown type to be a specific type or a subtype of that type
 * and is represented using the extends keyword.
 * 
 * In a similar way, a lower bounded wildcard restricts the unknown type to be a
 * specific type or a super type of that type.
 * 
 * @author asatklic
 *
 */
class Wildcards_LowerBounded_super {

	public static void main(String[] args) {
		System.out.println(
				"You can specify an upper bound for a wildcard, or you can specify a lower bound, but you cannot specify both. ");

	}

	public static void addNumbers(List<? super Integer> list) {
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
	}
}

/**
 * Desc:
 * 
 * <pre>

Wildcards and Subtyping


As described in Generics, Inheritance, and Subtypes, generic classes or interfaces are not related merely because there is a relationship between their types. However, you can use wildcards to create a relationship between generic classes or interfaces.

Given the following two regular (non-generic) classes:
 * 
 * </pre>
 * 
 */
class Wildcards_Subtyping {

	public static void main(String[] args) {

		// It would be reasonable to write the following code:

		Bb b = new Bb();
		Aa a = b;

		// This example shows that inheritance of regular classes follows this
		// rule of subtyping: class B is a subtype of class A if B extends A.
		// This rule does not apply to generic types:

		List<Bb> lb = new ArrayList<>();
		// List<Aa> la = lb; // compile-time error
		List<Aa> la2 = new ArrayList<>();
		List<Bb> lb2 = lb;

		List<? extends Integer> intList = new ArrayList<>();
		List<? extends Number> numList = intList; // OK. List<? extends Integer>
													// is a subtype of List<?
													// extends Number>

	}

}

class Aa {
	/* ... */ }

class Bb extends Aa {
	/* ... */
}

class WildcardError {

	void foo(List<?> i) {
		// i.set(0, i.get(0));
	}
}

class WildcardFixed {

	void foo(List<?> i) {
		fooHelper(i);
	}

	// Helper method created so that the wildcard can be captured
	// through type inference.
	private <T> void fooHelper(List<T> l) {
		l.set(0, l.get(0));
	}

}

/**
 * <pre>
 * Wildcard Guidelines: •An "in" variable is defined with an upper bounded wildcard, using the extends keyword.
 * 
    • An "out" variable is defined with a lower bounded wildcard, using the super keyword.
    • In the case where the "in" variable can be accessed using methods defined in the Object class, use an unbounded wildcard.
    • In the case where the code needs to access the variable as both an "in" and an "out" variable, do not use a wildcard.
 * 
 * </pre>
 * 
 * @author asatklic
 *
 */
class WildcardErrorBad {

	void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
		Number temp = l1.get(0);
		// l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
		// got a CAP#2 extends Number;
		// same bound, but different types
		// l2.set(0, temp); // expected a CAP#1 extends Number,
		// got a Number
	}
}

class TypeErasure {
	/**
	 * Generics were introduced to the Java language to provide tighter type checks
	 * at compile time and to support generic programming. To implement generics,
	 * the Java compiler applies type erasure to: •Replace all type parameters in
	 * generic types with their bounds or Object if the type parameters are
	 * unbounded. The produced bytecode, therefore, contains only ordinary classes,
	 * interfaces, and methods. •Insert type casts if necessary to preserve type
	 * safety. •Generate bridge methods to preserve polymorphism in extended generic
	 * types.
	 * 
	 * Type erasure ensures that no new classes are created for parameterized types;
	 * consequently, generics incur no runtime overhead.
	 * 
	 */
}

class Node<T> {

	private T data;
	private Node<T> next;

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}
	// ...
}

// Because the type parameter T is unbounded, the Java compiler replaces it with
// Object:

class Node2 {

	private Object data;
	private Node2 next;

	public Node2(Object data, Node2 next) {
		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}
	// ...
}

class NonReifiable_Types {
	public static void main(String[] args) {
		System.out.println("A reifiable type is a type whose type information is fully available at runtime. \n"
				+ "This includes primitives, non-generic types, raw types, and invocations of unbound wildcards.");
		System.out.println();

		System.out.println(
				"Non-Reifiable Types:   are types where information has been removed at compile-time by type \n"
						+ "erasure — invocations of generic types that are not defined as unbounded wildcards. ");
		System.out.println("A non-reifiable type does not have all of its information available at runtime. \n"
				+ "Examples of non-reifiable types are List<String> and List<Number>; the JVM cannot tell the difference between these types at runtime. ");
		System.out.println();

		System.out.println(
				"Heap pollution occurs when a variable of a parameterized type refers to an object that is not of that \n"
						+ "parameterized type. This situation occurs if the program performed some operation that gives rise to an unchecked warning at compile-time. ");
		System.out.println(
				"An unchecked warning is generated if, either at compile-time (within the limits of the compile-time type checking\n"
						+ "rules) or at runtime, the correctness of an operation involving a parameterized type (for example, a cast or method call) cannot be verified.");

	}
}

class ArrayBuilder_HeapPollution {

	public static <T> void addToList(List<T> listArg, T... elements) {
		for (T x : elements) {
			listArg.add(x);
		}
	}

	public static void faultyMethod(List<String>... l) {
		Object[] objectArray = l; // Valid
		objectArray[0] = Arrays.asList(42);
		String s = l[0].get(0); // ClassCastException thrown here
	}

}

class HeapPollutionExample {

	public static void main(String[] args) {

		List<String> stringListA = new ArrayList<String>();
		List<String> stringListB = new ArrayList<String>();

		ArrayBuilder_HeapPollution.addToList(stringListA, "Seven", "Eight", "Nine");
		ArrayBuilder_HeapPollution.addToList(stringListB, "Ten", "Eleven", "Twelve");
		List<List<String>> listOfStringLists = new ArrayList<List<String>>();
		ArrayBuilder_HeapPollution.addToList(listOfStringLists, stringListA, stringListB);

		ArrayBuilder_HeapPollution.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
	}
}
