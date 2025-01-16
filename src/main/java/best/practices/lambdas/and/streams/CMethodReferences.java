package best.practices.lambdas.and.streams;

import java.util.function.Function;

public class CMethodReferences {

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

