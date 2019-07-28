package lambdasinaction.chap3;

 

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRef_Shorthand4Lambdas {

    public static void main(String[] args) {
        //Lambda Method reference equivalent
        /*(Apple a) -> a.getWeight();
        Apple::getWeight;


        () -> Thread.currentThread().dumpStack();
        Thread.currentThread()::dumpStack;

        (str, i) -> str.substring(i) String::substring
        (String s) -> System.out.println(s) System.out::println ;*/

       /* List<String> str = Arrays.asList("a", "b", "A", "B");
        str.forEach(System.out::println);
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.forEach(System.out::println);


        str = Arrays.asList("a", "b", "A", "B");
        str.forEach(System.out::println);
        str.sort(String::compareToIgnoreCase);
        str.forEach(System.out::println);


        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInteger2 =  Integer::parseInt;

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains2 = List::contains;

        Supplier<String> sp = () -> new String();
        String s = sp.get();

        Supplier<String> sp2 = String::new;
        String s2 = sp.get();

        //in case parameters in constructor
        Function<Integer, String> f = (w) -> new String(w);
        String s3 = sp.a*/







    }
}
