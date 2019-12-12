package intro.javase.tutorials;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * 
 * <pre>
Functional interfaces have a single functionality to exhibit. For example, a Comparable interface with a 
single method ‘compareTo’ is used for comparison purpose.
Java 8 has defined a lot of functional interfaces to be used extensively in lambda expressions. Following 
is the list of functional interfaces defined in java.util.Function package.


Given below is the list of interfaces in Java8.
 * </pre>
 */
public class d_FunctionalInterfaces {
    
     
    
    public static void main(String[] args) {
        
        System.out.println(""
                + ""
                + "In Java 8's java.util.function package, we have:\n"
                + "\n• Function: Takes one argument, produces one result."
                + "\n• Consumer: Takes one argument, produces nothing."
                + "\n• Supplier: Takes no argument, produces one result.");
        System.out.println();
        
        
        System.out.println(
                "Predicate <T> interface is a functional interface with a method test(Object) to return a Boolean value.");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n is passed as parameter to test method of Predicate interface
        // test method will always return true no matter what value n has.

        System.out.println("Print all numbers:");
        // pass n as parameter
        eval(list, n -> true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n%2 comes to be zero

        System.out.println("Print even numbers:");
        eval(list, (n) -> n % 2 == 0);

        // Predicate<Integer> predicate2 = n -> n > 3
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n is greater than 3.

        System.out.println("Print numbers greater than 3:");
        eval(list, n -> n > 3);

        System.out.println("/nPrint if two numbers sum is greater than 7  :");
        evalViaBiPredicate(list, (a, b) -> a + b > 7);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {

        for (Integer n : list) {

            if (predicate.test(n)) {
                System.out.println(n + " :| ");
            }
        }
    }

    public static void evalViaBiPredicate(List<Integer> list, BiPredicate<Integer, Integer> predicate) {

        for (Integer n : list) {
            if (predicate.test(n, n + 1)) {
                System.out.println(n + " :| ");
            }
        }
    }

}

class EvenOrOddTestByPredicate {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.forEach(System.out::println);

        System.out.println("Print even numbers");
        evalViaPredicate(list, n -> n % 2 == 0);

        System.out.println("\nPrint odd numbers");
        evalViaPredicate(list, n -> n % 2 != 0);
    }

    public static void evalViaPredicate(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer))
                System.out.print(integer + " ");
        }
    }
}
