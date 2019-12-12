package intro.javase.tutorials;

/**
 * Java 8 introduces a new concept of default method implementation in
 * interfaces. This capability is added for backward compatibility so that old
 * interfaces can be used to leverage the lambda expression capability of Java
 * 8.
 * 
 * For example, ‘List’ or ‘Collection’ interfaces do not have ‘forEach’ method
 * declaration. Thus, adding such method will simply break the collection
 * framework implementations. Java 8 introduces default method so that
 * List/Collection interface can have a default implementation of forEach
 * method, and the class implementing these interfaces need not implement the
 * same.
 * 
 */
public class e_DefaultMethodsInInterface {

    public static void main(String[] args) {
        System.out.println("default method implementation in interfaces  -  is added for backward compatibility \n"
                + "so that old interfaces can be used to leverage the lambda expression capability of Java 8.");

    }
}

interface vehicle {

    default void print() {
        System.out.println("I am a vehicle!");
    }

    void print2();
}

interface fourWheeler {

    default void print() {
        System.out.println("I am a four wheeler!");
    }
}

/**
 * Multiple Defaults
 * 
 * With default functions in interfaces, there is a possibility that a class is
 * implementing two interfaces with same default methods. The following code
 * explains how this ambiguity can be resolved.
 * 
 */
class Car implements fourWheeler, vehicle { // overrides who comes first:
                                            // vehicle, fourWheeler

    // overrides
    public void print() {
        System.out.println("I am a four wheeler car vehicle!");
    }

    // implements
    public void print2() {
        System.out.println(" print2 impl");
    }
}

/**
 * Second solution is to call the default method of the specified interface
 * using super.
 */
class Car2 implements vehicle, fourWheeler {

    // default of vehicle, overrides
    public void print() {
        vehicle.super.print();
    }

    // implements
    public void print2() {
        System.out.println(" print2 impl");
    }
}
