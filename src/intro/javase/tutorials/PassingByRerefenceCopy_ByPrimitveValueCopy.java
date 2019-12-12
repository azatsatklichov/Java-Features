package intro.javase.tutorials;

/**
 * 
 * 
 * Passing Parameters by Value
 * 
 * <pre>
 * 
 * While working under calling process, arguments is to be passed. These should
 * be in the same order as their respective parameters in the method
 * specification. Parameters can be passed by value or by reference.
 * 
 * Passing Parameters by Value means calling a method with a parameter. Through
 * this, the argument value is passed to the parameter.
 * 
 * 
 * </pre>
 * 
 * *
 */
public class PassingByRerefenceCopy_ByPrimitveValueCopy {

    public static void main(String[] args) {

        System.out
                .println("In Java parameters are passed by 1. Referece copy for Objects, 2. Value copy for primitives");

        int a = 30;
        int b = 45;
        System.out.println("Before swapping, a = " + a + " and b = " + b);

        // Invoke the swap method
        swapFunction(a, b);
        System.out.println("\n**Now, Before and After swapping values will be same here**:");
        System.out.println("After swapping, a = " + a + " and b is " + b);
    }

    public static void swapFunction(int a, int b) {
        System.out.println("Before swapping(Inside), a = " + a + " b = " + b);

        // Swap n1 with n2
        int c = a;
        a = b;
        b = c;
        System.out.println("After swapping(Inside), a = " + a + " b = " + b);
    }

}

class _Ilki2 {

    public static void main(String[] args) {
        System.out.println("wELCOME TO DHL");

        Dog myDog = new Dog("Rover");
        foo(myDog);
        System.out.println(myDog); // what name is printed?

    }

    public static void foo(Dog someDog) {
        someDog.setName("Max"); // step A
        someDog = new Dog("Fifi"); // step B
        someDog.setName("Goofy"); // step C
    }
}

class Dog {

    private String name;

    public Dog(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public String toString() {
        return name;
    } 

}
