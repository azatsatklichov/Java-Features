package best.practices.lambdas.and.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class BMethodReferences {

    private String name = "MyInstanceValue";
    private static String staticName = "MyStaticValue";

    public static void main(String[] args) {
        // Method References as Lambdas
        System.out.println("\\nMethod References as Lambdas");
        /**
         * <pre>
         * You can reference the following types of methods:

         Static method
         Instance method on parameter objects
         Instance method
         Constructor
         * </pre>
         */
        MyPrinter myPrinter = (s) -> {
            System.out.println(s);
        };
        myPrinter.print("rrrr");

        // or
        myPrinter = s -> System.out.println(s);
        myPrinter.print("eeeee");

        // or
        myPrinter = System.out::println;
        myPrinter.print("xxxx");

        System.out.println("\nStatic Method References");
        Finder finder = MyClassz::doFind;//Multiple Parameters
        int find = finder.find("dsddssd", "dsddssd");
        System.out.println(find);
        System.out.println(finder.find("ola", "ola"));


        System.out.println("\nParameter Method References");
        /**
         * You can also reference a method of one of the parameters to the lambda
         */
        Finder finder3 = String::indexOf;
        find = finder3.find("iola", "iola");
        System.out.println(find);
        // This is equivalent of this lambda definition:
        finder = (s1, s2) -> s1.indexOf(s2);
        System.out.println(finder.find("iola", "iola"));


        Finder ff = (p1, p2) -> p1.compareToIgnoreCase(p2);
        ff = (String p1, String p2) -> p1.compareToIgnoreCase(p2); //Parameter Types
        ff = (var p1, var p2) -> p1.compareToIgnoreCase(p2); //var Parameter Types from Java 11
        Function<String, String> toLowerCase = (var input) -> input.toLowerCase();


        System.out.println("\nInstance Method References");
        /**
         reference an instance method from a lambda definition
         */
        StringConverter stringConverter = new StringConverter();
        Deserializer des = stringConverter::convertToInt;


        System.out.println("\nConstructor References");
        /**
         * The create() method of this interface matches the signature of one of the
         * constructors in the String class. Therefore this constructor can be used as a
         * lambda. Here is an example of how that looks:
         */
        Factory factory = String::new;
        // This is equivalent to this Java lambda expression:
        factory = chars -> new String(chars);
    }
}

interface MyPrinter{
    void print(String s);
}

interface Tester {
    public int test(String s1, String s2);
}

//not implements Tester
class MyTester {
    public static int doTest(String s1, String s2) {
        return s1.compareTo(s2);
    }
}


interface Finder {
    public int find(String s1, String s2);
}

class MyClassz {
    public static int doFind(String s1, String s2) {
        return s1.lastIndexOf(s2);
    }
}

interface Deserializer {
    public int deserialize(String v1);
}


interface Factory {
    public String create(char[] val);
}

class StringConverter {
    public int convertToInt(String v1) {
        return Integer.valueOf(v1);
    }
}





/**
 * Method references help to point to methods by their names. A method reference
 * is described using "::" symbol. A method reference can be used to point the
 * following types of methods
 *
 * <pre>
 *
 Static methods
 Instance methods
 Constructors using new operator (TreeSet::new)


 Functional interfaces can provide a target type in multiple contexts, such as assignment context, method invocation, or cast context:

 // Assignment context
 Predicate<String> p = String::isEmpty;

 // Method invocation context
 stream.filter(e -> e.getSize() > 10)...

 // Cast context
 stream.map((ToIntFunction) e -> e.getSize())...

 *
 * </pre>
 */
class MethodReference {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n------- Java 8 Method Reference ---------");
        System.out.println("A method reference is the shorthand syntax for a lambda expression that executes "
                + "just ONE method. Here's the general syntax of a method reference:");

        System.out.println("\nWe know that we can use lambda expressions instead of using an anonymous class. "
                + "But sometimes, the lambda expression is really just a call to some method, for example:");
        Consumer<String> c = s -> System.out.println(s);
        c.accept("Ahoj Method Reference");

        c = (s) -> {
            System.out.print("Anything ");
            for (char x : "hayret be".toCharArray()) {
                System.out.println(x);
            }
            System.out.println(s);
        };
        c.accept("Ahoj Method Reference");

        Consumer<Integer> i = j -> System.out.println(j);
        i.accept(63);

        // or
        System.out.println("\nTo make the code clearer, you can turn that lambda expression into a method reference:");
        Consumer<Integer> i2 = System.out::println;
        i2.accept(63);

        System.out.println(
                "First of all, a method reference can't be used for any method. They can only be used to replace a single-method lambda expression.");
        /**
         * <pre>
         (args) -> Class.staticMethod(args)

         This can be turned into the following method reference:
         Class::staticMethod
         * </pre>
         */
        String[] names = { "Bob", "George", "Henry", "Declan", "Peter", "Steven" };
        List<String> letters = Arrays.asList(names);

        for (Object object : letters) {
            System.out.println(object);
        }

        System.out.println("\n using :: ");
        letters.forEach(System.out::println);

        c = (s) -> {
            System.out.print("Anything ");
            for (char x : "hayret be".toCharArray()) {
                System.out.print(x + " ");
            }
            // System.out.println(s);
        };
        letters.forEach(c);



    }
}

/**
 * <pre>
 In general, we don't have to pass arguments to method references. However, arguments are treated depending on the type of
 method reference.

 In this case, any arguments (if any) taken by the method are passed automatically behind the curtains.
 Where ever we can pass a lambda expression that just calls a static method, we can use a method reference. For example,
 assuming this class:
 *
 * </pre>
 *
 */
class Numbers {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

        // Using an anonymous class
        List<Integer> foundNumbers = findNumbers(list, new BiPredicate<Integer, Integer>() {
            public boolean test(Integer i1, Integer i2) {
                return Numbers.isMoreThanFifty(i1, i2);
            }
        });
        System.out.println(foundNumbers);

        // Using a lambda expression
        foundNumbers = findNumbers(list, (i1, i2) -> i1 + i2 > 50);
        System.out.println(foundNumbers);

        // Using a lambda expression
        foundNumbers = findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));
        System.out.println(foundNumbers);

        // Using a method reference
        /**
         * In this case, any arguments (if any) taken by the method are passed
         * automatically behind the curtains. Where ever we can pass a lambda expression
         * that just calls a static method, we can use a method reference. For example,
         * assuming this class:
         */
        foundNumbers = findNumbers(list, Numbers::isMoreThanFifty);
        System.out.println(foundNumbers);

    }

    public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
        List<Integer> newList = new ArrayList<>();
        for (Integer i : l) {
            if (p.test(i, i + 10)) {
                newList.add(i);
            }
        }
        return newList;
    }

    public static boolean isMoreThanFifty(int n1, int n2) {
        return (n1 + n2) > 50;
    }

}
