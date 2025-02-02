package best.practices.lambdas.and.streams;
//read medium blog related to this topic 'Java Lambda Expressions - Behavior Parameterization Pattern' here - https://medium.com/@azat-satklichov

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EBehaviorParameterization {
    public static void main(String[] args) {
        System.out.println("\n Guitar Solution DEMO Applying - Classic Java Solution, Lambdas, Method References, Functional Interfaces and Stream API");
        Guitar.main(null);
    }
}


class Guitar {

    private String serialNumber;
    private double price;
    private GuitarType type;
    private Wood backWood, topWood;

    public Guitar(String serialNumber, double price, GuitarType type, Wood backWood, Wood topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public static void main(String[] args) {
        Guitar g1 = new Guitar("E44TNS3", 342.50, GuitarType.ELECTRIC, Wood.ALDER, Wood.MAHOGANY);
        Guitar g2 = new Guitar("iNT4T7o3", 896.6, GuitarType.ACOUSTIC, Wood.CEDAR, Wood.MAPLE);
        Guitar g3 = new Guitar("P239oi5Y", 797.23, GuitarType.ACOUSTIC, Wood.MAPLE, Wood.ALDER);
        List<Guitar> guitars = List.of(g1, g2, g3);


        // Approach 1: Display method based on one specific field
        /**
         * This approach (search method with one specific field) make your application fragile.
         * Think about big project use, then it may break in multiple places if some update is done accross the project.
         */
        displayGuitarsExpensiveThanGivenPrice(guitars, 800.45);

        // Approach 2: display method based on more generalized search
        /**
         * Above approach is tight to one filed, moreover it makes project fragile.
         * Also, if you want to do a search based on different fields, or add new fields
         * then you need to end up either new methods, or change the method itself.
         * So, let's try display based on search within a range. And see it is still
         * lead to a brittle code.
         */
        displayGuitarsBetweenPrices(guitars, 880.45, 100.8);


        // Approach 3: display method based on specific Object Checker
        /**
         * This approach improves the above one, based on specific object checker.
         * So, you do not need to introduce new method each time. But still you have to provide
         * you need to add additional code: a new
         * interface and an inner class implementation for each search you plan to perform in your
         * application.
         */
        displayGuitars(guitars, g1.new GuitarValidator()); //to call inner class


        // Approach 4: display method based on Anonymous Class which defines search method
        /**
         *
         *  In above method GuitarValidator implements an Interface and instance used only here.
         *  But, instead you can use an anonymous class.
         *
         * Using anonymous class reduces the amount of code required because you don't have to
         * create a new class for each search that you want to perform.
         */
        displayGuitars(guitars, new Validator() {
            public boolean test(Guitar guitar) {
                return guitar.type == GuitarType.ACOUSTIC && guitar.getPrice() >= 712.6 && guitar.getPrice() <= 980.3;
            }
        });

        // Approach 5: use Lambda Expression for the Search Criteria
        /**
         * However syntax of anonymous classes is excessive excessive -
         * writing definitions for short methods (here for only one method) and unclear.
         * In this case, you can use a lambda expression instead of an anonymous class.
         * Even you can see the IntelliJ warning.
         */
        displayGuitars(guitars, (Guitar guitar) -> guitar.type == GuitarType.ACOUSTIC && guitar.getPrice() >= 712.6 && guitar.getPrice() <= 980.3);


        // Approach 6: Use Standard Functional Interfaces with Lambda Expressions
        /**
         * Above Lambda appraoch is fantastic, but you can standardize it
         * using a standard functional interface specially desgned for that purpose.
         * As a result, the following method invocation is the same as when you invoked
         * displayGuitars in Approach 3
         */
        displayGuitarsWithPredicate(guitars,
                guitar -> guitar.type == GuitarType.ACOUSTIC && guitar.getPrice() >= 712.6 && guitar.getPrice() <= 980.3);


        // Approach 7: Use Method Reference instead of Lambda
        /**
         * Just in case your lambda expressions exceed a few lines in length (so that its behavior isn’t instantly
         * clear), you should instead use a method reference to a method with a descriptive
         * name instead of using an anonymous lambda.
         * Also follow you to clean code
         */
        displayGuitarsWithPredicate(guitars, Guitar::isValidGuitar);

        /**
         * It is fantastic, as you see it shortened code, and behaviour (method) is passed as a value to further use
         */

        // Approach 8: Use Lambda Expressions (Predicate, Consumer, Function, etc.) in Project
        /**
         Let's enhance Approach 3-5, applying the Java Standard Functional Interface powered with lambda expression.
         Also lambda expressions (logic implementation) are extracted to named methods to be re-used as method reference accross the application.
         */
        //Applying Java Funtional Interfaces - Predicate, Consumer
        processGuitars(guitars, Guitar::isValidGuitar, Guitar::display);
        //Applying Java Funtional Interfaces - Predicate, Function, Consumer
        processGuitarsWithFunction(guitars, Guitar::isValidGuitar, Guitar::getGuitarType, Guitar::displayGuitarType);


        // Approach 9: Use Generics - make the method type agnostic
        processGuitars(guitars, Guitar::isValidGuitar, Guitar::getGuitarType, Guitar::displayGuitarType);

        // Approach 10: Stream API to do declarative programming
        /**
         *  Use Aggregate Operations That Accept Lambda Expressions as Parameters.
         *  Here we are passing a behaiour using method reference (named lambdas)
         */
        guitars.stream().filter(Guitar::isValidGuitar).map(Guitar::getGuitarType).forEach(Guitar::displayGuitarType);


    }


    // Approach 1: Display method based on one specific field
    public static void displayGuitarsExpensiveThanGivenPrice(List<Guitar> guitars, double price) {
        for (Guitar guitar : guitars) {
            if (guitar.getPrice() >= price) {
                display(guitar);
            }
        }
    }

    private static void display(Guitar guitar) {
        System.out.println(guitar);
    }

    public double getPrice() {
        return price;
    }


    public static void displayGuitarsBetweenPrices(List<Guitar> guitars, double lowerPrice, double higherPrice) {
        for (Guitar guitar : guitars) {
            if (lowerPrice <= guitar.getPrice() && guitar.getPrice() < higherPrice) {
                display(guitar);
            }
        }
    }

    // Approach 3: display method based on specific Object Checker
    public static void displayGuitars(List<Guitar> guitars, Validator validator) {
        for (Guitar guitar : guitars) {
            if (validator.test(guitar)) {
                display(guitar);
            }
        }
    }

    interface Validator {
        boolean test(Guitar guitar);
    }


    class GuitarValidator implements Validator {
        public boolean test(Guitar guitar) {
            return guitar.type == GuitarType.ACOUSTIC && guitar.getPrice() >= 712.6 && guitar.getPrice() <= 980.3;
        }
    }


    /**
     * Java Functional Interface has one abstract method and optionally annotated with @FunctionalInterface.
     * You can use Java Standard Functional Interface and make it standardized.
     * So, use Predicate<T> in place of GuitarValidator
     * <p>
     * This parameterized type contains a method that has the same return type and
     * parameters as GuitarValidator boolean test(Guitar guitar).
     * <p>
     */
    public static void displayGuitarsWithPredicate(List<Guitar> guitars, Predicate<Guitar> predicate) {
        for (Guitar guitar : guitars) {
            if (predicate.test(guitar)) {
                display(guitar);
            }
        }
    }


    public static boolean isValidGuitar(Guitar guitar) {
        return guitar.type == GuitarType.ACOUSTIC && guitar.getPrice() >= 712.6 && guitar.getPrice() <= 980.3;
    }


    /**
     * Applying STANDARD Java Funtional Interfaces - java.util.function.Predicate, java.util.function.Consumer
     */
    public static void processGuitars(List<Guitar> guitars, Predicate<Guitar> tester, Consumer<Guitar> consumer) {
        for (Guitar guitar : guitars) {
            if (tester.test(guitar)) {
                consumer.accept(guitar);
            }
        }
    }

    /**
     * Applying more Standard Java Funtional Interfaces (Predicate, Function, Consumer)
     */
    public static void processGuitarsWithFunction(List<Guitar> guitars, Predicate<Guitar> predicate, Function<Guitar, GuitarType> function, Consumer<GuitarType> consumer) {
        for (Guitar guitar : guitars) {
            if (predicate.test(guitar)) {
                GuitarType guitarType = function.apply(guitar);
                consumer.accept(guitarType);
            }
        }
    }

    /**
     * Generic version of method processGuitarsWithFunction.
     * Overloaded version of processGuitars(List<Guitar> guitars, Predicate<Guitar> tester, Consumer<Guitar> consumer)
     */
    public static <T, R> void processGuitars(Iterable<T> source, Predicate<T> predicate, Function<T, R> function, Consumer<R> consumer) {
        for (T type : source) {
            if (predicate.test(type)) {
                R resultData = function.apply(type);
                consumer.accept(resultData);
            }
        }
    }

    public static GuitarType getGuitarType(Guitar guitar) {
        return guitar.type;
    }

    public static void displayGuitarType(GuitarType guitarType) {
        System.out.println(guitarType);
    }


    @Override
    public String toString() {
        return STR."Guitar [serialNumber = \{this.serialNumber}, price = \{this.price}, type = \{this.type}, backWood = \{this.backWood}, topWood = \{this.topWood}";
    }
}

enum GuitarType {

    ACOUSTIC, ELECTRIC;

    public String toString() {
        switch (this) {
            case ACOUSTIC:
                return "acoustic";
            case ELECTRIC:
                return "electric";
            default:
                return "unspecified";
        }
    }
}

enum Wood {

    MAHOGANY, MAPLE, CEDAR, ALDER;

    public String toString() {
        switch (this) {
            case MAHOGANY:
                return "Mahogany";
            case MAPLE:
                return "Maple";
            case ALDER:
                return "Alder";
            default:
                return "unspecified";
        }
    }
}

