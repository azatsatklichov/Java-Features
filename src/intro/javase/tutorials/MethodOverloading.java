package intro.javase.tutorials;

/**
 * 
 * 
 * Method Overloading
 * 
 * <pre>
 * 
 * When a class has two or more methods by the same name but different
 * parameters, it is known as method overloading. It is different from
 * overriding. In overriding, a method has the same method name, type, number of
 * parameters, etc.
 * 
 * Let’s consider the example discussed earlier for finding minimum numbers of
 * integer type. If, let’s say we want to find the minimum number of double
 * type. Then the concept of overloading will be introduced to create two or
 * more methods with the same name but different parameters.
 * 
 * The following example explains the same −
 * 
 * </pre>
 * 
 */

public class MethodOverloading {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Then the concept of overloading will be introduced to create two or more methods with \n"
                + "the same name but different parameters.");

        int a = 11;
        int b = 6;
        double c = 7.3;
        double d = 9.4;
        int result1 = minFunction(a, b);

        // same function name with different parameters
        double result2 = minFunction(c, d);
        System.out.println("Minimum Value = " + result1);
        System.out.println("Minimum Value = " + result2);
    }

    // for integer
    public static int minFunction(int n1, int n2) {
        int min;
        if (n1 > n2)
            min = n2;
        else
            min = n1;

        return min;
    }

    // for double
    public static double minFunction(double n1, double n2) {
        double min;
        if (n1 > n2)
            min = n2;
        else
            min = n1;

        return min;
    }
}