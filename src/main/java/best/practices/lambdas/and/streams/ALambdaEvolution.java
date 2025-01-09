package best.practices.lambdas.and.streams;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


public class ALambdaEvolution {
    public static void main(String[] args) {
        System.out.println("Hello Lambda Expression - Samples");

        //single-method interface
        interface Arithmetic {
            int compute(int a, int b);
        }

        // with type declaration, two input parameters and returns value
        Arithmetic addition = (int a, int b) -> a + b;
        System.out.println(addition.compute(3, 8)); //11

        // without type declaration, two input parameters and returns value
        Arithmetic subtraction = (a, b) -> a - b;
        System.out.println(subtraction.compute(3, 8)); //-5

        // Or another example, which implements well known Runnable Interface

        //Using a class to implement the Runnable interface
        Runnable r1 = new AppThread();
        r1.run();

        // Classic Runnable interface implementation using anonymous class
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Zero parameter & return void");
            }
        };
        r2.run();

        //Implementation with Lambda expression with no type declaration, no input parameter, and no return value
        Runnable r3 = () -> System.out.println("Zero parameter & return void");
        r3.run();

    }
}

class AppThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Zero parameter & return void");
    }
}


/**
 * Lambda Expressions
 *
 * <pre>
 * One issue with anonymous classes is that if the implementation of your
 * anonymous class is very simple, such as an interface that contains only one
 * method, then the syntax of anonymous classes may seem unwieldy and unclear.
 * In these cases, you're usually trying to pass functionality as an argument to
 * another method, such as what action should be taken when someone clicks a
 * button. Lambda expressions enable you to do this, to treat functionality as
 * method argument, or code as data.
 *
 * The previous section, Anonymous Classes, shows you how to implement a base
 * class without giving it a name. Although this is often more concise than a
 * named class, for classes with only one method, even an anonymous class seems
 * a bit excessive and cumbersome. Lambda expressions let you express instances
 * of single-method classes more compactly.
 *
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * </pre>
 * <p>
 * *
 */
class Person {

    public enum Gender {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Gender gender;
    String emailAddress;

    Person(String name, LocalDate bd, Gender gender, String email) {
        this.name = name;
        this.birthday = bd;
        this.gender = gender;
        this.emailAddress = email;
    }

    public int getAge() {
        return 0;
        // ...
    }

    public void printPerson() {
        // ...
    }

    public String getEmailAddress() {
        // TODO Auto-generated method stub
        return null;
    }

    // Approach 1: Create Methods That Search for Members That Match One Characteristic

    /**
     * This approach can potentially make your application brittle (fragile),
     * which is the likelihood of an application not working because of the introduction of updates (such as newer data types).
     */
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    // Approach 2: Create More Generalized Search Methods

    /**
     * What if you want to print members of a specified sex, or a combination of a
     * specified gender and age range? What if you decide to change the Person class
     * and add other attributes such as relationship status or geographical
     * location? Although this method is more generic than printPersonsOlderThan,
     * trying to create a separate method for each possible search query can still
     * lead to brittle code. You can instead separate the code that specifies the
     * criteria for which you want to search in a different class.
     *
     * @param roster
     * @param low
     * @param high
     */
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    // Approach 3: Specify Search Criteria Code in a Local Class

    /**
     * Although this approach is less brittle (fragile) you don't have to rewrite methods if
     * you change the structure of the Person you still have additional code: a new
     * interface and a local class for each search you plan to perform in your
     * application. Because CheckPersonEligibleForSelectiveService implements an
     * interface, you can use an anonymous class instead of a local class and bypass
     * the need to declare a new class for each search.
     *
     * @param roster
     * @param tester
     */
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    interface CheckPerson {
        boolean test(Person p);
    }

    class CheckPersonEligibleForSelectiveService implements CheckPerson {
        public boolean test(Person p) {
            return p.gender == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("Ola", LocalDate.of(1994, 11, 11), Gender.FEMALE, "ola@ola.com");
        Person p2 = new Person("Muro", LocalDate.of(1993, 9, 21), Gender.MALE, "muro@muro.com");
        Person p3 = new Person("Ela", LocalDate.of(1995, 7, 31), Gender.FEMALE, "ela@ola.com");
        List<Person> roster = List.of(p1, p2, p3);

        // Approach 3:
        //To use this class, you create a new instance of it and invoke the printPersons method:
        printPersons(roster, p1.new CheckPersonEligibleForSelectiveService()); //how to call inner class


        // Approach 4: Specify Search Criteria Code in an Anonymous Class
        /**
         * This approach reduces the amount of code required because you don't have to
         * create a new class for each search that you want to perform. However, the
         * syntax of anonymous classes is bulky considering that the CheckPerson
         * interface contains only one method. In this case, you can use a lambda
         * expression instead of an anonymous class, as described in the next section.
         */
        printPersons(roster, new CheckPerson() {
            public boolean test(Person p) {
                return p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25;
            }
        });

        // Approach 5: Specify Search Criteria Code with a Lambda Expression
        printPersons(roster, (Person p) -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25);

        // You can use a standard functional interface in place of the interface
        // CheckPerson, which reduces even further the amount of code required

        // Approach 6: Use Standard Functional Interfaces with Lambda Expressions
        /**
         * As a result, the following method invocation is the same as when you invoked
         * printPersons in Approach 3: Specify Search Criteria Code in a Local Class to
         * obtain members who are eligible for Selective Service:
         */
        printPersonsWithPredicate(roster,
                p -> p.getGender() == Person.Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25);

        /**
         * This is not the only possible place in this method to use a lambda
         * expression. The following approach suggests other ways to use lambda
         * expressions.
         */

        // Approach 7: Use Lambda Expressions Throughout Your Application
        /**
         * As a result, the following method invocation is the same as when you invoked
         * printPersons in Approach 3: Specify Search Criteria Code in a Local Class to
         * obtain members who are eligible for Selective Service. The lambda expression
         * used to print members is highlighted:
         */
        processPersons(roster, p -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25, p -> p.printPerson());

        /**
         * The following method retrieves the email address from each member contained
         * in roster who is eligible for Selective Service and then prints it:
         */

        processPersonsWithFunction(roster, p -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25, p -> p.getEmailAddress(), email -> System.out.println(email));

        // Approach 8: Use Generics More Extensively
        /**
         * To print the e-mail address of members who are eligible for Selective
         * Service, invoke the processElements method as follows:
         */
        processElements(roster, p -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25, p -> p.getEmailAddress(), email -> System.out.println(email));

        // Approach 9: Use Aggregate Operations That Accept Lambda Expressions as
        // Parameters
        /**
         * The following example uses aggregate operations to print the e-mail addresses
         * of those members contained in the collection roster who are eligible for
         * Selective Service:
         */
        //using stream API approach
        roster.stream().filter(p -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25).map(p -> p.getEmailAddress()).forEach(email -> System.out.println(email));


    }


    /**
     * This parameterized type contains a method that has the same return type and
     * parameters as CheckPerson.boolean test(Person p). Consequently, you can use
     * Predicate<T> in place of CheckPerson as the following method demonstrates:
     */
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    /*
     * Reconsider the method processPersonsWithFunction. The following is a generic
     * version of it that accepts, as a parameter, a collection that contains
     * elements of any data type:
     */
    public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    protected Gender getGender() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * The interface Predicate<T> is an example of a generic interface. (For more
     * information about generics, see the Generics (Updated) lesson.) Generic types
     * (such as generic interfaces) specify one or more type parameters within angle
     * brackets (<>). This interface contains only one type parameter, T. When you
     * declare or instantiate a generic type with actual type arguments, you have a
     * parameterized type. For example, the parameterized type Predicate<Person> is
     * the following:
     *
     * @param <Person>
     * @author ASUS
     */
    interface Predicate<Person> {
        boolean test(Person t);
    }
}