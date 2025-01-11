package best.practices.lambdas.and.streams;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.*;

/**
 * Functional Interfaces Can Be Implemented by a Lambda Expression
 */
public class FunctionalInterfaces {

    public static void main(String[] args) {

        System.out.println("\nFunctional Interfaces Can Be Implemented by a Lambda Expression");
        MyFunctionalInterface lambda = () -> {
            System.out.println("Welcome to Java Functional Interface");
        };
        lambda.run();
        lambda.runDefault("Welcome to Java Functional Interface");


        /**
         Java Standard functional interfaces in java.util.function.*
         */
        System.out.println("\n --Built-in Functional Interfaces in Java--");

        System.out.println("\nPredicate - public boolean test(T t);");
        /**
         * The Java Predicate interface, java.util.function.Predicate, represents a
         * simple function that takes a single value as parameter, and returns true or
         * false.
         */
        Predicate nonNullPredicate = (value) -> value != null;
        boolean test = nonNullPredicate.test(new String()); //true
        System.out.println(test);
        // or via custom Predicate
        nonNullPredicate = new NonNullPredicate();
        test = nonNullPredicate.test(null); //false
        System.out.println(test);

        Predicate<String> predicate3 = (var c) -> c.length() > 3;
        test = predicate3.test("Yhhymbil"); //true
        System.out.println(test);


        System.out.println("\nSupplier [Producer] - public <T> get()");
        /**
         * The Java Supplier interface is a functional interface that represents an
         * function that supplies a value of some sorts. No input but returns result.
         */
        Supplier<String> sp = () -> "Your grade is: " + 5;
        System.out.println(sp.get());
        //with custom supplier (producer)
        Supplier<String> sup = new MySupplier();
        String string = sup.get();
        System.out.println(string);


        /**
         * The Java Consumer interface is a functional interface that represents a
         * function that consumes a value without returning any value.
         */
        System.out.println("\nConsumer [Receiver] - public void accept(String t)");
        Consumer<Integer> cs2 = (i) -> {
            System.out.println(i + 4);
        };
        cs2.accept(3232);
        //custom consumer (receiver)
        Consumer<String> cs = new MyConsumer();
        cs.accept("Okalga");


        System.out.println("Function - public <R> apply(T parameter)");
        /**
         * The Java Function interface (java.util.function.Function) interface The
         * Function interface represents a function (method) that takes a single
         * parameter and returns a single value.
         *
         * public <R> apply(T parameter);
         */
        Function<String, Integer> f = s -> s.length();
        Integer r = f.apply("Java Functional Interface ");//26
        System.out.println("length = " + r);

        Function<Long, Long> duplicate = new Duplicate(); //Duplicate is Function Implementor
        Long result = duplicate.apply((long) 4);//8
        System.out.println("result = " + result);

        //or via lambda
        Function<Integer, Integer> multiplyByTwo = (a) -> a * 2; //a + a
        Integer duplicatedVal = multiplyByTwo.apply(41); //82
        System.out.println(duplicatedVal);


        System.out.println("\nUnaryOperator - public <T> apply(T parameter), not same with Function<T,R>");
        /**
         * The Java UnaryOperator interface is a functional interface that represents an
         * operation which takes a single parameter and returns a parameter of the same
         * type.
         */
        System.out.println(
                "Differentce from function is - which takes a single parameter and returns a parameter of the same TYPE." +
                        "Whereas Function<T, R> takes input with type T, and returns value with type R ");
        UnaryOperator<String> uS = (s) -> "Halo " + s;
        //UnaryOperator<String> uSS = (s) -> s.length(); //error, not returning same type
        String apply2 = uS.apply("Merdan");
        System.out.println(apply2);
        //custom
        UnaryOperator<Integer> uo = new UnaryOperatorMultiplier();
        Integer apply = uo.apply(49);
        System.out.println(apply);

        UnaryOperator<Name> unaryOperator = (name) -> {
            name.name = "New Name";
            return name;
        };
        Name name = new Name();
        name.name = "Alzahra";
        System.out.println(unaryOperator.apply(name));


        System.out.println("\nBinaryOperator - public <T> apply(T parameter1, T parameter2)");
        /**
         *
         * The Java BinaryOperator interface is a functional interface that represents
         * an operation which takes two parameters and returns a single value.
         * Both parameters and the return type must be of the same type.
         */
        BinaryOperator<Integer> mb = (a, b) -> a + b;
        System.out.println(mb.apply(23, -78));
        //custom
        mb = new BinaryOperatorAdder();
        apply = mb.apply(15, 40);
        System.out.println(apply);


    }
}

/**
 * Lambda expression implements single-method Interface (no other possibility).
 * And this interface is called Functional Interface.
 * <p>
 * <p>
 * Here is an example of a functional interface: Only has one abstract method.
 * <p>
 * Here is another example of a functional interface with a default method and a
 * static method too:
 * <p>
 * Notice the two methods with implementations. This is still a functional
 * interface, because only run() is not implemented (abstract).
 * <p>
 * However, if there were more methods without implementation, the interface
 * would no longer be a functional interface, and could thus not be implemented
 * by a Java lambda expression.
 */
@FunctionalInterface //help you to validate it has really single abstract method
interface MyFunctionalInterface {
    /**
     * A Java lambda expression implements a single method from a Java interface. In
     * order to know what method the lambda expression implements, the interface can
     * only contain a single unimplemented method.
     */
    public void run();

    //public void run2(); Multiple non-overriding abstract methods found in interface best. practices. lambdas. and. streams. MyFunctionalInterface

    //all below thre methds are now pssible in interface
    public default void runDefault(String text) {
        System.out.println(text);
    }

    public static void runStatic(String text, PrintWriter writer) throws IOException {
        writer.write(text);
    }

    private void runPrivate(String text, PrintWriter writer) throws IOException {
        writer.write(text);
    }
}

//another functional interface but no safe check against single-method
interface MyFunctionalInterface2 {

    public boolean test(Object o);

}

/**
 * Built-in Functional Interfaces
 * <p>
 * in Java Built-in Functional Interfaces in Java
 * <p>
 * Java contains a set of functional interfaces designed for commonly occuring
 * use cases, so you don't have to create your own functional interfaces for
 * every little use case. In the following sections I will be describing some of
 * these built-in functional interfaces in Java.
 */
class Duplicate implements Function<Long, Long> {

    @Override
    public Long apply(Long aLong) {
        return aLong + aLong;
    }
}

/**
 * Predicate
 * <p>
 * The Java Predicate interface, java.util.function.Predicate, represents a
 * simple function that takes a single value as parameter, and returns true or
 * false.
 */
class NonNullPredicate implements Predicate {

    @Override
    public boolean test(Object o) {
        return o != null;
    }
}


class UnaryOperatorMultiplier implements UnaryOperator<Integer> {

    @Override
    public Integer apply(Integer t) {
        return t * t;
    }

}

class BinaryOperatorAdder implements BinaryOperator<Integer> {

    @Override
    public Integer apply(Integer t, Integer u) {
        return t + u;
    }

}

class MySupplier implements Supplier<String> {

    @Override
    public String get() {
        return "Take this";
    }

}

class MyConsumer implements Consumer<String> {

    @Override
    public void accept(String t) {
        System.out.println("Value " + t + "is consumed");
    }

}


class Name {
    public String name;
}