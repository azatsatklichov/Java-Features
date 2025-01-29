package best.practices.lambdas.and.streams;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;


/**
 * Lambda Expressions
 *
 * <pre>
 * Lambda Expressions
 *
 * Problem with classic anonymous class (un-named class) is, once it implements a
 * very simple interface that contains only single method, then the syntax of anonymous classes
 * may seem excessive (writing definitions for short methods which are not used much) and unclear.
 * In these cases, you are usually trying to pass functionality as an argument to another method,
 * such as what action should be taken when someone clicks a button. Lambda expressions enable you
 * to do this, to treat functionality as method argument, or code as a data
 * </pre>
 * <p>
 * *
 * * Following are the important characteristics of a lambda expression.
 * *
 * * <pre>
 *
 *  Optional type declaration:  No need to declare the type of a parameter. The compiler can inference the same from the value of the parameter.
 *
 *  Optional parenthesis around parameter: No need to declare a single parameter in parenthesis. For multiple parameters, parentheses are required.
 *
 *  Optional curly braces: No need to use curly braces in expression body if the body contains a single statement.
 *
 *  Optional return keyword: The compiler automatically returns the value if the body has a single expression to return the value.
 *
 *  Curly braces are required to indicate that expression returns a value.
 * </pre>
 * *
 */
public class ALambdaExpression {
    public static void main(String[] args) {
        System.out.println("Hello Lambda Expression - Samples");
        /**
         Lambda expression (un-named function) represents instances of single-method classes
         (implementation of Functional Interface) more compactly. Lambda function is a short block of code that
         takes in (0-N) parameter(s) and execute an expression to return a value or nothing.

         Lambda expression can be serialized if its target type and arguments are serializable,
         but strongly discouraged as like in inner classes.
         */

        //single-method interface – functional interface
        interface Operation {
            int compute(int a, int b);
        }

        //or implement Arithmetic in 4 ways
        //before Java 8
        //1-way Using a class to implement MyPrinter
        class ArithmeticOperation implements Operation {
            @Override
            public int compute(int a, int b) {
                return a + b;
            }
        }
        Operation o1 = new ArithmeticOperation();
        System.out.println(o1.compute(3, 8));

        //2-way Using anonymous class
        Operation o2 = new Operation() {
            public int compute(int a, int b) {
                return a + b;
            }
        };
        System.out.println(o2.compute(3, 8));


        /**
         * Lambdas technically don't let you do anything that you couldn't
         * do prior to  Java 8.
         *
         * But you no longer have to write clumsy code using anonymous classes to
         * benefit from behavior parameterization! Lambda expressions will encourage you
         * to adopt the style of behavior parameterization


         Another example, which implements well-known MyPrinter Interface, to witness the
         * implementation with lambda expression is more readable, but with method reference it is the shortest of all four.
         */

        //with Java 8
        //3-way Implementation with Lambda expression with no type declaration, but with input parameter, and return value
        // with type declaration, two input parameters and returns value
        Operation o3 = (int a, int b) -> a + b;
        System.out.println(o3.compute(3, 8)); //11

        // without type declaration, two input parameters and returns value
        Operation subtraction = (a, b) -> a - b;
        System.out.println(subtraction.compute(3, 8)); //-5


        //4-way Using Method Reference
        Operation o4 = ALambdaExpression::add;
        System.out.println(o4.compute(3, 8));

        //or other example
        //1-way Using a class to implement the Runnable interface
        class AppThread implements Runnable {
            @Override
            public void run() {
                System.out.println("Zero parameter & return void");
            }
        }
        Runnable r1 = new AppThread();
        r1.run();

        //2-way Classic Runnable interface implementation using anonymous class
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Zero parameter & return void");
            }
        };
        r2.run();

        //3-way Implementation with Lambda expression with no type declaration, no input parameter, and no return value
        Runnable r3 = () -> System.out.println("Zero parameter & return void");
        r3.run();




    }

    private static int add(int a, int b) {
        return a + b;
    }
}


class LambdaExpressionsDetailed {

    final static String hey = "Hey! ";

    public static void main(String args[]) {

        MathOperation addition = new MathOperation() {
            @Override
            public int opt(int a, int b) {
                return a + b;
            }
        };

        System.out.println(addition.opt(3, 8));

        // Lambda with type declaration, assignment is a must
        addition = (int a, int b) -> a + b;
        System.out.println(addition.opt(3, 8));

        // without type declaration, paranthesis is only needed for multiple arguments
        addition = (a, b) -> a + b;
        System.out.println(addition.opt(3, 8));

        LambdaExpressionsDetailed test = new LambdaExpressionsDetailed();

        MathOperation subtraction = (a, b) -> a - b;

        // with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + test.operate(10, 5, addition));
        System.out.println("10 - 5 = " + test.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + test.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + test.operate(10, 5, division));

        System.out.println("10^2-5^2 = " + test.operate(10, 5, new MathOperation() {
            @Override
            public int opt(int a, int b) {
                return a * a - b * b;
            }
        }));

        MathOperation pythogorian = (int a, int b) -> a * a - b * b;
        System.out.println("10^2-5^2 = " + test.operate(10, 5, pythogorian));

        System.out.println(
                "\nstarting in Java 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. "
                        + "\nA variable or parameter whose value is never changed after it is initialized is effectively final.\n");

        String hey = "Hey - I am effectively final unless re-assigned";
        final String eHey = "eHey - final";

        GreetingService greetService = message -> {
            System.out.println(hey);
            // hey = "heyHey"; //Local variable hey defined in an enclosing scope must be
            // final or effectively final
            System.out.println(
                    "Cannot be re-assigned: Local variable 'hey' defined in an enclosing scope must be final or effectively final");
            System.out.println(hey);
            System.out.println(eHey);
            System.out.println();

            message += " second time ";
            System.out.println(LambdaExpressionsDetailed.hey + message);
        };

        greetService.hi("Hello");

        greetService = (String message) -> System.out.println(LambdaExpressionsDetailed.hey + message);
        greetService.hi("Inter");
        // without parenthesis
        greetService = message -> System.out.println(LambdaExpressionsDetailed.hey + message);
        greetService.hi("Milan");
        greetService = message -> {
            System.out.println(4 * 4 + "  " + message);
        };

        greetService.hi("Roma");

        System.out.println("\n Avoid Blocks of Code in Lambda�s Body");
        // use
        GreetingService2 gs = parameter -> buildString(parameter);
        // instead of:
        GreetingService2 gs2 = parameter -> {
            String result = "Something " + parameter;
            // many lines of code
            return result;
        };

        System.out.println("\nmore examples - pass Lambda function as Parameter");
        FileFilter ff = (File f) -> f.getName().endsWith(".java");
        File dir = new File("C:\\workspace-17\\Java-Features\\src\\main\\java\\best\\practices\\lambdas\\and\\streams");
        File[] fArr = dir.listFiles(ff);
        Arrays.asList(fArr).forEach(System.out::println);

    }

    @FunctionalInterface
    interface MathOperation {
        int opt(int a, int b);
        // int opt2(int a, int b); //then all above Lambdas gives compile time error
        // The target type of this expression must be a functional interface
        // int operation2(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.opt(a, b);
    }

    interface GreetingService {
        void hi(String message);
    }

    interface GreetingService2 {
        String msg(String message);
    }

    private static String buildString(String parameter) {
        String result = "Something " + parameter;
        // many lines of code
        return result;
    }

    // sort using java 7
    private void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    private void sortIt(List<String> list) {
        Collections.sort(list, (l1, l2) -> l1.compareTo(l2));
    }

    // sort using java 8
    private void sortUsingJava8(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }


    /**
     * Don't Treat Lambda Expressions as Inner Classes
     * <p>
     *
     * <pre>
     * Despite our previous example,
     * where we essentially substituted inner class by a lambda expression, the two
     * concepts are different in an important way: scope.
     *
     * When you use an inner class, it creates a new scope. You can hide local
     * variables from the enclosing scope by instantiating new local variables with
     * the same names. You can also use the keyword this inside your inner class as
     * a reference to its instance.
     *
     * However, lambda expressions work with enclosing scope. You can�t hide
     * variables from the enclosing scope inside the lambda�s body. In this case,
     * the keyword this is a reference to an enclosing instance.
     *
     * For example, in the class UseFoo you have an instance variable value:
     *
     *
     *
     * As you can see, by calling this.value in IC, you can access a local variable from its instance.
     * But in the case of the lambda, this.value call gives you access to the variable value which
     * is defined in the UseFoo class, but not to the variable value defined inside the lambda�s body.
     * </pre>
     */
    private String value = "Enclosing scope value";

    public String scopeExperiment() {
        Foo fooIC = new Foo() {
            String value = "Inner class value";

            @Override
            public String method() {
                return this.value;
            }
        };
        String resultIC = fooIC.method();

        Foo fooLambda = () -> {
            String value = "Lambda value";
            return this.value; // enclosing value
        };
        String resultLambda = fooLambda.method();

        return "Results: resultIC = " + resultIC + ", resultLambda = " + resultLambda;
    }
}


@FunctionalInterface
interface Foo {
    String method();

    default void defaultMethod() {
    }
}


interface Hey {
    String msg(String message);
}


/**
 * Desc:
 * <pre>
 * Use �Effectively Final� Variables
 * Accessing a non-final variable inside lambda expressions will cause the compile-time error. But it doesn�t mean that
 * you should mark every target variable as final.
 *
 * According to the �effectively final� concept, a compiler treats every variable as final, as long as it is assigned only once.
 *
 * It is safe to use such variables inside lambdas because the compiler will control their state and trigger a compile-time error
 * immediately after any attempt to change them.
 *
 * For example, the following code will not compile:
 *
 *
 * </pre>
 */
class EffectifelyFinal {

    public void method() {
        String localVariable = "Local";
        Hey foo = parameter -> {
            //String localVariable = parameter; //here must not be assigned
            return localVariable;
        };
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

class MeaningOfThis {

    public final String value = "23s";

    public static void main(String... args) {
        MeaningOfThis m = new MeaningOfThis();

        m.doIt();
        m.scopeExperiment();

    }

    public void doIt() {
        String value = "Ysn105";
        Runnable r = new Runnable() {
            public final String value = "Inner Wow";

            @Override
            public void run() {
                String value = "10i";
                System.out.println("Inner class 'this' means its own field =  " + this.value);
            }
        };
        r.run();
    }

    public String scopeExperiment() {
        Fooo fooIC = new Fooo() {
            String value = "Inner class value";

            @Override
            public String method(String string) {
                System.out.println("Inner class 'this' means its own field =  " + this.value);
                return this.value;
            }
        };
        String resultIC = fooIC.method("");

        Fooo fooLambda = parameter -> {
            String value = "saa";
            System.out.println("Lambda 'this' means outer instance of class, field =  " + this.value);
            return this.value;
        };
        String resultLambda = fooLambda.method("");

        return "Results: resultIC = " + resultIC + ", resultLambda = " + resultLambda;
    }

}

@FunctionalInterface
interface Fooo {
    String method(String string);

    default void defaultMethod() {
    }
}