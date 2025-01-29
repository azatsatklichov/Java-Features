package best.practices.lambdas.and.streams;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * <pre>
 * Functional interfaces have a single functionality to exhibit. For example, a Comparable interface with a
 * single method  compareTo  is used for comparison purpose.
 * Java 8 has defined a lot of functional interfaces to be used extensively in lambda expressions. Following
 * is the list of functional interfaces defined in java.util.Function package.
 *
 * Functional interfaces, which are gathered in the java.util.function package, satisfy most developers  needs in providing
 * target types for lambda expressions and method references.
 * </pre>
 */

public class CFunctionalInterfaces {

    public static void main(String[] args) {

        System.out.println("\n  Legacy Functional Interfaces (e.g. Runnable, Clallable, or your own.)");
        System.out.println("\nFunctional Interfaces Can Be Implemented by a Lambda Expression");
        MyFunctionalInterface lambda = () -> {
            System.out.println("Welcome to Java Functional Interface");
        };
        lambda.run();
        lambda.runDefault("Welcome to Java Functional Interface");

        /**
         * Not all functional interfaces appeared in Java 8. Many interfaces from
         * previous versions of Java conform to the constraints of a FunctionalInterface
         * and can be used as lambdas.
         */
        Thread thread = new Thread(() -> System.out.println("Hello From Another Thread"));
        thread.start();


        /**
         Java Standard functional interfaces in java.util.function.*
         */
        System.out.println("\n --Built-in Functional Interfaces in Java--");
        System.out.println("" + "" + "In Java 8's java.util.function package, we have:\n"
                + "\n  Predicate: functional interface to return a Boolean value - boolean test(T t)"
                + "\n  Function: Takes one argument, produces one result - R apply(T t)"
                + "\n  Consumer: Takes one argument, produces nothing - void accept(T t)"
                + "\n  Supplier: Takes no argument, produces one result - T get()  and nore .... ");
        System.out.println();


        System.out.println("\nPredicate - public boolean test(T t);");
        /**
         * The Java Predicate interface, java.util.function.Predicate, represents a
         * simple function that takes a single value as parameter, and returns true or
         * false.
         *
         * Predicates In mathematical logic, a predicate is a function that receives a
         * value and returns a boolean value.
         *
         * The Predicate functional interface is a specialization of a Function that
         * receives a generified value and returns a boolean. A typical use case of the
         * Predicate lambda is to filter a collection of values: *
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


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.forEach(System.out::println);

        System.out.println("\nPrint all numbers:");
        evalViaPredicate(list, n -> true);

        System.out.println("Print even numbers:");
        evalViaPredicate(list, (n) -> n % 2 == 0);

        System.out.println("\nPrint odd numbers");
        evalViaPredicate(list, n -> n % 2 != 0);

        System.out.println("Print numbers greater than 3:");
        evalViaPredicate(list, n -> n > 3);

        System.out.println("\nPrint if two numbers sum is greater than 7  :");
        evalViaBiPredicate(list, (a, b) -> a + b > 7);

        // Predicates
        Predicate<String> predicate1 = s -> s.length() > 3;
        Predicate<String> predicate2 = s -> s.length() < 6;


        List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");
        List<String> namesWithA = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        System.out.println(namesWithA);


        //double predicate
        DoublePredicate isFiveDotOne = (d) -> Double.compare(d, 5.1) == 0;
        boolean test1 = isFiveDotOne.test(5.11);//false
        System.out.println(test1);


        //bi-predicate
        BiPredicate<Integer, String> validator = (num, txt) -> num > 63 && txt.length() > 63;
        validator.test(63, "Adam");//false


        System.out.println("\nSupplier [Producer] - public <T> get()");
        /**
         * The Java Supplier interface is a functional interface that represents an
         * function that supplies a value of some sorts. No input but returns result.
         *
         * The Supplier functional interface is yet another Function specialization that
         * does not take any arguments. It is typically used for lazy generation of
         * values. For instance, let's define a function that squares a double value. It
         * will receive not a value itself, but a Supplier of this value:
         */

        Supplier<String> sp = () -> "Your grade is: " + 5;
        System.out.println(sp.get());
        //with custom supplier (producer)
        Supplier<String> sup = new MySupplier();
        String string = sup.get();
        System.out.println(string);

        Supplier<Double> lazyValue = () -> {
            System.out.println("Her havzun dibi aynidir");
            return 9d;
        };

        Double valueD = lazyValue.get();
        System.out.println("valueD = " + valueD);

        int[] fibs = {0, 1};
        Stream<Integer> fibonacci = Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        }).limit(23);
        // fibonacci.forEach(System.out::println);

        fibonacci.forEach(x -> {
            System.out.print(x + ",  ");
        });


        /**
         * The Java Consumer interface is a functional interface that represents a
         * function that consumes a value without returning any value.
         */
        System.out.println("\nConsumer [Receiver] - public void accept(String t)");
        /**
         * Consumers As opposed to the Supplier, the Consumer accepts a generified
         * argument and returns nothing. It is a function that is representing side
         * effects.
         *
         * For instance, let’s greet everybody in a list of names by printing the
         * greeting in the console. The lambda passed to the List.forEach method
         * implements the Consumer functional interface:
         */

        Consumer<Integer> c = System.out::println;
        c.accept(71);

        Consumer<Integer> cs2 = (i) -> {
            System.out.println(i + 4);
        };
        cs2.accept(3232);
        //custom consumer (receiver)
        Consumer<String> cs = new MyConsumer();
        cs.accept("Okalga");


        List<String> l = Arrays.asList("alma", "enar", "uzum", "enjir");
        List<String> result = new ArrayList<>();

        // Consumers, use functions as a parameters
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = result::add;
        l.forEach(c1);
        System.out.println();
        l.forEach(c1.andThen(c2));
        System.out.println("size = " + result.size());


        names = Arrays.asList("John", "Freddy", "Samuel");
        names.forEach(name -> System.out.println("Hello, " + name));

        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);

        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));

        BiConsumer<String, Integer> bC = (name, age) -> System.out.println(name + " is " + age + " years old.");
        bC.accept("Meret", 41);


        System.out.println("Function - public <R> apply(T parameter)");
        /**
         * The Java Function interface (java.util.function.Function) interface The
         * Function interface represents a function (method) that takes a single
         * parameter and returns a single value.
         *
         * The most simple and general case of a lambda is a functional interface with a
         * method that receives one value and returns another. This function of a single
         argument is represented by the Function interface which is parameterized by
         the types of its argument and a return value:
         *
         * public <R> apply(T parameter);
         */

        System.out.println("\n Functions  (T) -> R");
        Function<String, Integer> f = s -> s.length();
        Integer r = f.apply("Java Functional Interface ");//26
        System.out.println("length = " + r);

        Function<Long, Long> duplicate = new Duplicate(); //Duplicate is Function Implementor
        Long resultt = duplicate.apply((long) 4);//8
        System.out.println("result = " + resultt);

        Function<Integer, String> myGrade = (a) -> "My Grade is: " + a;
        String s1 = myGrade.apply(84);//My Grade is: 84
        System.out.println(s1);

        //or via lambda
        Function<Integer, Integer> multiplyByTwo = (a) -> a * 2; //a + a
        Integer duplicatedVal = multiplyByTwo.apply(41); //82
        System.out.println(duplicatedVal);

        //you can do it with UnaryOperator if return type is same as input type
        UnaryOperator<Integer> multiplyByTwo2 = (a) -> a * 2; //a + a
        Integer apply1 = multiplyByTwo2.apply(41);//82
        System.out.println(apply1);


        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
        System.out.println(value);
        value = nameMap.computeIfAbsent("Johny", s -> {
            return s.length() + s.length();
        });

        // via method reference
        value = nameMap.computeIfAbsent("Jimmy", String::length);

        System.out.println(nameMap);
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        // In Lambdas
        BiFunction<Integer, Integer, Integer> summer = (Integer num1, Integer num2) -> {
            return num1 + num2;
        };

        Integer number1 = 10;
        Integer number2 = 20;

        System.out.println(number1 + " + " + number2 + " = " + summer.apply(number1, number2));

        BiFunction<Integer, Integer, Long> summer2 = (num1, num2) -> {
            return (long) (number1 + number2);
        };

        System.out.println(number1 + " + " + number2 + " = " + summer2.apply(number1, number2));

        List<Integer> intList = Arrays.asList(5, 2, 4, 2, 1);
        Collections.sort(intList, (a, b) -> a.compareTo(b));

        List<String> strList = Arrays.asList("Red", "Blue", "Green");
        Collections.sort(strList, (a, b) -> a.compareTo(b));

        BiFunction<Integer, Integer, Integer> sum1 = (a, b) -> a + b;
        System.out.println(sum1.apply(23, 71));//94

        //try same with operator
        BinaryOperator<Integer> sum2 = (a, b) -> a + b;
        System.out.println(sum2.apply(23, 71));//94


        //try same with primitive - for optimization
        IntBinaryOperator sum3 = (a, b) -> a + b;
        System.out.println(sum3.applyAsInt(23, 71));


        System.out.println("\n Primitive Function Specializations");
        /**
         * IntFunction, LongFunction, DoubleFunction: arguments are of specified type,
         * return type is parameterized ToIntFunction, ToLongFunction, ToDoubleFunction:
         * return type is of specified type, arguments are parameterized
         * DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction,
         * IntToLongFunction, LongToIntFunction, LongToDoubleFunction — having both
         * argument and return type defined as primitive types, as specified by their
         * names.
         *
         * BiFunction has both arguments and a return type generified, while
         * ToDoubleBiFunction and others allow you to return a primitive value.
         */
        System.out.println("\n Function Specializations - BiFunctional");
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        salaries.replaceAll((key, oldValue) -> key.equals("Freddy") ? oldValue : oldValue + 10000);
        System.out.println(salaries);


        System.out.println("\n   Operators");
        /**
         * Operator interfaces are special cases of a function that receive and return
         * the same value type. The UnaryOperator interface receives a single argument.
         * One of its use cases in the Collections API is to replace all values in a
         * list with some computed values of the same type:
         */
        OperationOld old = OperationOld.PLUS;
        System.out.println(old.apply(4343, 56));

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (OperationNew op : OperationNew.values())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
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

        names.replaceAll(nam -> nam.toUpperCase());
        // or
        names.replaceAll(String::toUpperCase);
        System.out.println(names);

        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);

        /**
         * BinaryOperator is a reduction operation. Use the reduce method.
         */
        int sum = values.stream().reduce(0, (i1, i2) -> i1 + i2);
        System.out.println(sum);


    }


    public static void evalViaPredicate(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer))
                System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void evalViaBiPredicate(List<Integer> list, BiPredicate<Integer, Integer> predicate) {

        for (Integer n : list) {
            if (predicate.test(n, n + 1)) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }
}

class PrimitiveSpecializatons {
    public static void main(String[] args) {
        /*
        However, what about Autoboxing? It works the same for anonymous classes and lambda expressions.
Yes, Java 5 introduced the Autoboxing concept (automated boxing & unboxing). The Java compiler makes the automatic
conversion between the primitive types and their corresponding object wrapper classes. For example,
converting an int to an Integer, a double to a Double, and so on.

         */
        viaBoxing(); //comes with a performance cost, timeElapsed=10sec or 11sec

        /**

         * Java 8 added a specialized primitive version of the functional interfaces
         * to deal with number computations operations, to avoid autoboxing operations when the inputs or outputs are primitives.
         */
        viaPrimitiveSpecialization(); //no performance cost, timeElapsed=3sec or 2sec
    }

    private static void viaBoxing() {
        long start = System.nanoTime();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (i % 7 == 0 || i % 13 == 0) { //boxing
                list.add(i);
            }
        }
        printElapsedTime(start);//comes with a performance cost, timeElapsed=10sec
    }

    private static void viaPrimitiveSpecialization() {
        long start = System.nanoTime();
        IntPredicate divisibleBy7And13 = (i) -> i % 7 == 0 && i % 13 == 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (divisibleBy7And13.test(i)) {//no boxing needed
                list.add(i);
            }
        }
        printElapsedTime(start);//no performance cost, timeElapsed=2sec
    }


    private static void printElapsedTime(long start) {
        long finish = System.nanoTime();
        long timeElapsed = (finish - start) / 1000000000;
        System.out.println("timeElapsed=" + timeElapsed + "sec");
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

/**
 * Note that the @FunctionalInterface annotation isn t mandatory, but it's good
 * practice to use it when an interface is designed for that purpose. You can
 * think of it like the @Override notation to indicate that a method is
 * overridden.
 */
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


enum OperationOld {

    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    OperationOld(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);
}

enum OperationNew {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    OperationNew(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (OperationNew op : OperationNew.values())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }
}
