package intro.javase.tutorials;

import java.beans.ExceptionListener;
import java.io.Serializable;
import java.util.Iterator;

/**
 * Desc:
 * 
 * <pre>
 * 
 * 
 * Checked exceptions should not be declared on implementation methods other
 * than the ones declared by the interface method or subclasses of those
 * declared by the interface method.
 * 
 * 
 * The signature of the interface method and the same return type or subtype
 * should be maintained when overriding the methods.
 * 
 * 
 * An implementation class itself can be abstract and if so, interface methods
 * need not be implemented.
 *
 *
 *When implementation interfaces, there are several rules −

A class can implement more than one interface at a time.


A class can extend only one class, but implement many interfaces.


An interface can extend another interface, in a similar way as a class can extend another class.


Extending Interfaces

An interface can extend another interface in the same way that a class can extend another class. 
The extends keyword is used to extend an interface, and the child interface inherits the methods of 
the parent interface.

The following Sports interface is extended by Hockey and Football interfaces.
 * 
 * </pre>
 * 
 */

// Yes, you can do it. An interface can extend multiple interfaces, as shown
public interface Interfaces extends Serializable, ExceptionListener, Cloneable {

}

class Classes extends Thread {

}

class Classes2 implements Cloneable, Iterable<String> {

    @Override
    public Iterator<String> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

}

/* File name : Animal.java */
interface Animal {
    public void eat();

    public void travel();
}

class MammalInt implements Animal {

    public void eat() {
        System.out.println("Mammal eats");
    }

    public void travel() {
        System.out.println("Mammal travels");
    }

    public int noOfLegs() {
        return 0;
    }

    public static void main(String args[]) {
        MammalInt m = new MammalInt();
        m.eat();
        m.travel();
    }
}

// Yes, you can do it. An interface can extend multiple interfaces, as shown
// here:
interface Maininterface extends inter1, inter2, inter3 {
    void hi();
    // methods
}

interface inter1 {
    void hi();
}

interface inter2 {
    void hi();
}

interface inter3 {
    void hi();
}