package intro.javase.essentials;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

/**
 * 
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
 * </pre>
 * 
 * *
 */
public class b_lambdas {
    // https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

}

class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return 0;
        // ...
    }

    public void printPerson() {
        // ...
    }

    // Approach 1: Create Methods That Search for Members That Match One
    // Characteristic
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }
    
    

    // Approach 2: Create More Generalized Search Methods
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    // Approach 3: Specify Search Criteria Code in a Local Class
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
            return p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
        }
    }

    //
}

class Calculator {

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String... args) {

        Calculator myApp = new Calculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
    }
}

class LambdaScopeTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {

            // The following statement causes the compiler to generate
            // the error "local variables referenced from a lambda expression
            // must be final or effectively final" in statement A:
            //
            // x = 99;

            Consumer<Integer> myConsumer = (y) -> {
                System.out.println("x = " + x); // Statement A
                System.out.println("y = " + y);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
            };

            myConsumer.accept(x);

        }
    }

    public static void main(String... args) {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
