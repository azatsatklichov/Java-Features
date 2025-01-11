package best.practices.lambdas.and.streams.notyet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

/**
 * 
 * http://tutorials.jenkov.com/java-functional-programming/index.html
 * 
 * http://tutorials.jenkov.com/java/lambda-expressions.html
 * 
 * The term Java functional interface was introduced in Java 8. A functional
 * interface in Java is an interface that contains only a single abstract
 * (unimplemented) method. A functional interface can contain default and static
 * methods which do have an implementation, in addition to the single
 * unimplemented method.
 *
 * 
 * <pre>
*
Here is a Java functional interface example:

public interface MyFunctionalInterface {
    public void execute();
}
 * </pre>
 * 
 * Functional Interfaces Can Be Implemented by a Lambda Expression
 */
public class FunctionalInterfaces {

	public static void main(String[] args) {
		MyFunctionalInterface mfi = new MyFunctionalInterface() {

			@Override
			public void execute() {
				System.out.println("Implemented via Anonymous class...");

			}
		};

		mfi.execute();

		System.out.println("\nFunctional Interfaces Can Be Implemented by a Lambda Expression");
		/**
		 * Functional Interfaces Can Be Implemented by a Lambda Expression
		 */
		MyFunctionalInterface lambda = () -> {
			System.out.println("Executing...");
		};
		lambda.execute();
		lambda.print("ola");

		/**
		 * Java contains a set of functional interfaces designed for commonly occuring
		 * use cases, so you don't have to create your own functional interfaces for
		 * every little use case. In the following sections I will be describing some of
		 * these built-in functional interfaces in Java.
		 * 
		 * 
		 */
		System.out.println("\n Built-in Functional Interfaces in Java");

		System.out.println("Function - public <R> apply(T parameter)");
		/**
		 * The Java Function interface (java.util.function.Function) interface The
		 * Function interface represents a function (method) that takes a single
		 * parameter and returns a single value.
		 *
		 * public <R> apply(T parameter);
		 */
		Function<Long, Long> adder = new AddThree();
		Long result = adder.apply((long) 4);
		System.out.println("result = " + result);

		Function<Integer, Integer> duplicate = (a) -> a * 2;
		Integer duplicatedVal = duplicate.apply(41);
		System.out.println(duplicatedVal);

		System.out.println("\nPredicate - public boolean test(T t);");
		/**
		 * The Java Predicate interface, java.util.function.Predicate, represents a
		 * simple function that takes a single value as parameter, and returns true or
		 * false. Here is how the Predicate functional interface definition looks:
		 */
		Predicate predicate = (value) -> value != null;
		boolean test = predicate.test(new String());
		System.out.println(test);
		// or
		Predicate predicate2 = new CheckForNullPredicate();
		test = predicate2.test(null);
		System.out.println(test);

		Predicate<String> predicate3 = (var c) -> c.length() > 8;
		test = predicate3.test("ewewe");
		System.out.println(test);

		Predicate<AtomicInteger> predicate4 = new CheckForAtomicPredicate();
		AtomicInteger at = new AtomicInteger();
		at.set(343);
		test = predicate4.test(at);
		System.out.println(test);

		/**
		 * The Java UnaryOperator interface is a functional interface that represents an
		 * operation which takes a single parameter and returns a parameter of the same
		 * type. Here is an example of a Java UnaryOperator implementation:
		 * 
		 * The Java UnaryOperator interface is a functional interface that represents an
		 * operation which takes a single parameter and returns a parameter of the same
		 * type.
		 */
		System.out.println("\nUnaryOperator - public <T> apply(T parameter)");
		System.out.println(
				"Differentce from function is - which takes a single parameter and returns a parameter of the same TYPE ");
		UnaryOperator<Integer> uo = new MySelfMultiplyUnary();
		Integer apply = uo.apply(49);
		System.out.println(apply);

		UnaryOperator<String> uS = (s) -> "Halo " + s;
		String apply2 = uS.apply("Merdan");
		System.out.println(apply2);

		/**
		 * which takes two parameters and returns a single value Both parameters and the
		 * return type must be of the same type.
		 */
		System.out.println("\nBinaryOperator - public <T> apply(T parameter1, T parameter2)");
		BinaryOperator<Integer> mb = new MyAddBinary();
		apply = mb.apply(15, 40);
		System.out.println(apply);

		/**
		 * The Java Supplier interface is a functional interface that represents an
		 * function that supplies a value of some sorts.
		 */
		System.out.println("\nSupplier [Producer] - public <T> get()");
		Supplier<String> sup = new MySupplier();
		String string = sup.get();
		System.out.println(string);

		Supplier<String> sp = () -> 2 + "Halo get this sowgat";
		System.out.println(sp.get());

		/**
		 * The Java Consumer interface is a functional interface that represents an
		 * function that consumes a value without returning any value. A Java Consumer
		 * implementation could be printing out a value, or writing it to a file, or
		 * over the network etc. Here is an example implementation of the Java Consumer
		 * interface:
		 */
		System.out.println("\nConsumer [Receiver] - public void accept(String t)");
		Consumer<String> cs = new MyConsumer();
		cs.accept("Allayar");

		Consumer<Integer> cs2 = (i) -> {
			System.out.println(i+4);
		};
		cs2.accept(3232);
	}
}

/**
 * Here is an example of a functional interface: Only has one abstract method
 *
 */
interface MyInterface {
	public void run();
}

/**
 * Here is another example of a functional interface with a default method and a
 * static method too:
 * 
 * Notice the two methods with implementations. This is still a functional
 * interface, because only run() is not implemented (abstract).
 * 
 * However, if there were more methods without implementation, the interface
 * would no longer be a functional interface, and could thus not be implemented
 * by a Java lambda expression.
 *
 */
interface MyInterface2 {
	public void run();

	public default void doIt() {
		System.out.println("doing it");
	}

	public static void doItStatically() {
		System.out.println("doing it statically");
	}
}

/**
 * A Java lambda expression implements a single method from a Java interface. In
 * order to know what method the lambda expression implements, the interface can
 * only contain a single unimplemented method.
 * 
 */
@FunctionalInterface
interface MyFunctionalInterface {
	/**
	 * A Java lambda expression implements a single method from a Java interface. In
	 * order to know what method the lambda expression implements, the interface can
	 * only contain a single unimplemented method.
	 * 
	 */
	public void execute();

	public default void print(String text) {
		System.out.println(text);
	}

	public static void print(String text, PrintWriter writer) throws IOException {
		writer.write(text);
	}
}

/**
 * Built-in Functional Interfaces
 * 
 * in Java Built-in Functional Interfaces in Java
 * 
 * Java contains a set of functional interfaces designed for commonly occuring
 * use cases, so you don't have to create your own functional interfaces for
 * every little use case. In the following sections I will be describing some of
 * these built-in functional interfaces in Java.
 *
 */
class AddThree implements Function<Long, Long> {

	@Override
	public Long apply(Long aLong) {
		return aLong + 3;
	}
}

/**
 * Predicate
 * 
 * The Java Predicate interface, java.util.function.Predicate, represents a
 * simple function that takes a single value as parameter, and returns true or
 * false.
 *
 */
class CheckForNullPredicate implements Predicate {

	@Override
	public boolean test(Object o) {
		return o != null;
	}
}

class CheckForAtomicPredicate implements Predicate<AtomicInteger> {

	@Override
	public boolean test(AtomicInteger t) {
		return t.compareAndSet(43, 23);
	}

}

class MySelfMultiplyUnary implements UnaryOperator<Integer> {

	@Override
	public Integer apply(Integer t) {
		return t * t;
	}

}

class MyAddBinary implements BinaryOperator<Integer> {

	@Override
	public Integer apply(Integer t, Integer u) {
		return t + u;
	}

}

class MySupplier implements Supplier<String> {

	@Override
	public String get() {
		return "Here some flower buckets for you";
	}

}

class MyConsumer implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println("Thanks for message " + t + ", it is consumed");
	}

}

class OtherFunctionalInterfacses {

	public static void main(String[] args) {
		/**
		 * UnaryOperator The Java UnaryOperator interface is a functional interface that
		 * represents an operation which takes a single parameter and returns a
		 * parameter of the same type
		 */
		UnaryOperator<Person> unaryOperator = (person) -> {
			person.name = "New Name";
			return person;
		};

		/**
		 * BinaryOperator
		 * 
		 * The Java BinaryOperator interface is a functional interface that represents
		 * an operation which takes two parameters and returns a single value.
		 */
		// BinaryOperator<Person> binaryOperator = (value1, value2) -> {
		// value1.add(value2);
		// return value1;
		// };

		/**
		 * The Java Supplier interface is a functional interface that represents an
		 * function that supplies a value of some sorts.
		 */
		Supplier<Integer> supplier = () -> new Integer((int) (Math.random() * 1000D));
		Supplier<Integer> supplier2 = () -> {
			return new Integer((int) (Math.random() * 1000D));
		};

		/**
		 * Consumer The Java Consumer interface is a functional interface that
		 * represents an function that consumes a value without returning any value.
		 */
		Consumer<Integer> consumer = (value) -> System.out.println(value);
	}
}

class Person {
	public String name;
}