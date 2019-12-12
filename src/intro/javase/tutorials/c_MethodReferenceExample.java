package intro.javase.tutorials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * Method references help to point to methods by their names. A method reference
 * is described using "::" symbol. A method reference can be used to point the
 * following types of methods −
 * 
 * <pre>
     * 
    Static methods
    Instance methods
    Constructors using new operator (TreeSet::new)

    Method Reference Example
    
    Create the following Java program using any editor of your choice in, say, C:\> JAVA.
 * 
 * </pre>
 */
public class c_MethodReferenceExample {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n---  Ya Sabyr ---");
        System.out.println(
                "\n---  Aslynda Coook Sukur, tobalar etdim, beterinden Ozin saklasyn, mun toba, mun sukur  ---");
        System.out.println("Here we have passed System.out::println method as a static method reference.");

        List<String> names = new ArrayList<>();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        System.out.println("Here we have passed System.out::println method as a static method reference.");
        names.forEach(System.out::println);
        // names.forEach(System.out.println());

        System.out.println("\n OR ");
        for (Object object : names) {
            System.out.println(object);
        }

        /*
         * int[] arrs = new int[2]; arrs[0]=3; arrs[1]=5;
         * 
         * arrs.forEach(System.out::println);
         */

        /*
         * Integer[] arrs = new Integer[2]; arrs[0]=3; arrs[1]=5;
         * 
         * arrs.forEach(System.out::println);
         */

        System.out.println("\n------- Java 8 Method Reference ---------");
        System.out.println("A method reference is the shorthand syntax for a lambda expression that executes "
                + "just ONE method. Here's the general syntax of a method reference:");

        System.out.println("\nWe know that we can use lambda expressions instead of using an anonymous class. "
                + "But sometimes, the lambda expression is really just a call to some method, for example:");
        Consumer<String> c = s -> System.out.println(s);
        System.out.println(c);
        c = (s) -> {
            System.out.println(s);
        };

        Consumer<Integer> i = j -> System.out.print(j + j);
        // or
        Consumer<Integer> i2 = System.out::println;
        System.out.println(i);
        System.out.println();
        Thread.sleep(30000);

        System.out.println(c);
        System.out.println("To make the code clearer, you can turn that lambda expression into a method reference:");
        Consumer<String> c2 = System.out::println;
        System.out.println(c2);
        System.out.println(
                "First of all, a method reference can't be used for any method. They can only be used to replace a single-method lambda expression.");
        /**
         * <pre>
          (args) -> Class.staticMethod(args) 
          
         This can be turned into the following method reference:
         Class::staticMethod
         * </pre>
         */
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
    public static boolean isMoreThanFifty(int n1, int n2) {
        return (n1 + n2) > 50;
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

    public static void main(String[] args) {
        System.out.println("We can call the findNumbers() method:");
        List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

        // Using an anonymous class
        findNumbers(list, new BiPredicate<Integer, Integer>() {
            public boolean test(Integer i1, Integer i2) {
                return Numbers.isMoreThanFifty(i1, i2);
            }
        });

        // Using a lambda expression
        findNumbers(list, (i1, i2) -> i1 + i2 > 50);

        // Using a lambda expression
        findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));

        // Using a method reference
        findNumbers(list, Numbers::isMoreThanFifty);

    }
}
