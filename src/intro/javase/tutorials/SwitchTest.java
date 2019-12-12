package intro.javase.tutorials;

/**
 * Desc: A switch statement allows a variable to be tested for equality against
 * a list of values. Each value is called a case, and the variable being
 * switched on is checked for each case.
 * 
 * <pre>
 * The following rules apply to a switch statement −

The variable used in a switch statement can only be integers, convertable integers (byte, short, char), strings and enums.

You can have any number of case statements within a switch. Each case is followed by the value to be compared to and a colon.

The value for a case must be the same data type as the variable in the switch and it must be a constant or a literal.

When the variable being switched on is equal to a case, the statements following that case will execute until a break statement is reached.

When a break statement is reached, the switch terminates, and the flow of control jumps to the next line following the switch statement.

Not every case needs to contain a break. If no break appears, the flow of control will fall through  to subsequent cases until a break is reached.

A switch statement can have an optional default case, which must appear at the end of the switch. The default case can be used for performing a task when none of the cases is true. No break is needed in the default case.
 * 
 * 
 * </pre>
 * 
 */
public class SwitchTest {
    public static void main(String args[]) {
        // char grade = args[0].charAt(0);
        char grade = 'C';

        switch (grade) {
        case 'A':
            System.out.println("Excellent!");
            break;
        case 'B':
        case 'C':
            System.out.println("Well done");
            break;
        case 'D':
            System.out.println("You passed");
        case 'F':
            System.out.println("Better try again");
            break;
        default:
            System.out.println("Invalid grade");
        }
        System.out.println("Your grade is " + grade);

        Integer x = 5;

        // Returns byte primitive data type
        System.out.println(x.byteValue());

        // Returns double primitive data type
        System.out.println(x.doubleValue());

        // Returns long primitive data type
        System.out.println(x.longValue());

        System.out.println(x.compareTo(3));
        System.out.println(x.compareTo(5));
        System.out.println(x.compareTo(8));

        x = Integer.parseInt("9");
        double c = Double.parseDouble("5");
        int b = Integer.parseInt("444", 16);

        System.out.println(x);
        System.out.println(c);
        System.out.println(b);

        double d = -100.675;
        float f = -90;

        System.out.println(Math.floor(d));
        System.out.println(Math.floor(f));

        System.out.println(Math.ceil(d));
        System.out.println(Math.ceil(f));

        System.out.println(Math.max(12.123, 12.456));
        System.out.println(Math.max(23.12, 23.0));

        double xx = 11.635;
        double yy = 2.76;

        System.out.printf("The value of e is %.4f%n", Math.E);
        System.out.printf("exp(%.3f) is %.3f%n", xx, Math.exp(xx));

        System.out.printf("The value of e is %.4f%n", Math.E);
        System.out.printf("sqrt(%.3f) is %.3f%n", xx, Math.sqrt(xx));

        System.out.println(Math.toRadians(xx));
        System.out.println(Math.toRadians(yy));

        double x2 = 45.0;
        double y2 = 30.0;

        System.out.println();
        System.out.println(Math.toDegrees(x2));
        System.out.println(Math.toDegrees(y2));

        System.out.println(Math.random());
        System.out.println(Math.random());

    }

}
