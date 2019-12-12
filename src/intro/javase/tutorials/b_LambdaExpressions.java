package intro.javase.tutorials;

/**
 * 
 * Following are the important characteristics of a lambda expression.
 * 
 * <pre>

Optional type declaration − No need to declare the type of a parameter. The compiler can inference the same from the value of the parameter.


Optional parenthesis around parameter − No need to declare a single parameter in parenthesis. For multiple parameters, parentheses are required.


Optional curly braces − No need to use curly braces in expression body if the body contains a single statement.


Optional return keyword − The compiler automatically returns the value if the body has a single expression to return the value. Curly braces are required to indicate that expression returns a value.


Lambda Expressions Example

Create the following Java program using any editor of your choice in, say, C:\> JAVA.
 * 
 * </pre>
 * 
 */
public class b_LambdaExpressions {

    public static void main(String args[]) {

        System.out.println(
                "\nLambda expressions are used primarily to define inline implementation of a functional interface, \ni.e., an interface with a single method only.\n");
        System.out.println(
                "Lambda expression eliminates the need of anonymous class and gives a very simple yet powerful functional programming capability to Java");

        MathOperation2 selfAdd = (int a) -> a + a;
        System.out.println(selfAdd.operation(3));

        // type definition is not needed
        MathOperation2 selfTimes = (a) -> a * a;
        System.out.println(selfTimes.operation(3));

        // paranthesis not needed
        selfTimes = b -> b * b;
        System.out.println(selfTimes.operation(3));

        MathOperation selfTimesw = (a, b) -> a * a - b * b;
        System.out.println(selfTimesw.operation(13, 5));

        b_LambdaExpressions tester = new b_LambdaExpressions();

        // with type declaration
        MathOperation addition = (int a, int b) -> a + b;
        System.out.println(addition.operation(3, 8));

        // with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        // with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        System.out.println("10^2-5^2 = " + tester.operate(10, 5, new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a * a - b * b;
            }
        }));
        MathOperation pythogorian = (int a, int b) -> a * a - b * b;
        System.out.println("10^2-5^2 = " + tester.operate(10, 5, pythogorian));

        // without parenthesis
        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        // with parenthesis
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
    }

    interface MathOperation {
        int operation(int a, int b);
        // int operation2(int a, int b); //then all above Labmdas gives compile
        // time error
        // The target type of this expression must be a functional interface
        // int operation2(int a, int b);
    }

    /**
     * Class instance method
     * 
     * @param a
     * @param b
     * @param mathOperation
     * @return
     */
    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    // other functional interfaces
    interface MathOperation2 {
        int operation(int a);
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}

class Java8Tester2 {

    final static String salutation = "Hello! ";

    public static void main(String args[]) {
        System.out.println(
                "\nLambda expressions are used primarily to define inline implementation of a functional interface, \ni.e., an interface with a single method only.");
        System.out.println(
                "Lambda expression eliminates the need of anonymous class and gives a very simple yet powerful functional programming capability to Java");

        System.out.println();

        GreetingService greetService1 = message -> System.out.println(salutation + message);
        greetService1.sayMessage("Mahesh");

        System.out.println(
                "starting in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. A variable or parameter whose value is never changed after it is initialized is effectively final.");
        System.out.println(
                "Diymek EFFECTIVELY FINAL diyileni, final bolmadyk uytgeyiji bashdaky alan bahasynyny uytgetman saklayar, yagniy gaytadan re-assign bolmayar");
        System.out.println();

        String heyHey = "heyHey";
        final String heyHey2 = "heyHey - final or effectively final";

        greetService1 = message -> {
            System.out.println(heyHey);
            System.out.println(
                    "Cannot be re-assigned: Local variable heyHey defined in an enclosing scope must be final or effectively final");
            // heyHey = "gulley";
            System.out.println(heyHey);
            System.out.println();

            System.out.println(heyHey2);
            System.out.println(
                    "The final local variable heyHey2 cannot be assigned. It must be blank and not using a compound assignment");
            // heyHey2 = "gulley";
            System.out.println(heyHey2);
            System.out.println();

            message += "second time ";
            System.out.println(salutation + message);
        };

        greetService1.sayMessage("Mahesh");
        
        GreetingService msg = habar -> {
          System.out.println(9+7+"  "+habar);  
        };
        
        msg.sayMessage("ahhaha");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}