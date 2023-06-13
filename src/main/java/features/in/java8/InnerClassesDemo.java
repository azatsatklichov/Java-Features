package features.in.java8;

class Outer_Demo {
    int num;

    // inner class
    private class Inner_Demo {
        private void print() {
            System.out.println("This is a private inner class");
        }
    }

    public class Inner_Demo2 {
        public void print() {
            System.out.println("This is an public inner class");
        }
    }

    // Accessing he inner class from the method within
    void display_Inner() {
        Inner_Demo inner = new Inner_Demo();
        inner.print();
    }
}

public class InnerClassesDemo {
    public static void main(String args[]) {
        // Instantiating the outer class
        Outer_Demo outer = new Outer_Demo();

        // Accessing the display_Inner() method.
        outer.display_Inner();
        
        //Outer_Demo.Inner_Demo  inn = outer.new Inner_Demo();
        //inn.print();

        Outer_Demo.Inner_Demo2 inn = outer.new Inner_Demo2();
        inn.print();
    }

}

class Outer_Demo2 {
    // private variable of the outer class
    private int num = 175;

    // inner class
    public class Inner_Demo {
        public int getNum() {
            System.out.println("This is the getnum method of the inner class");
            return num;
        }
    }
}

class My_class2 {

    public static void main(String args[]) {
        // Instantiating the outer class
        Outer_Demo2 outer = new Outer_Demo2();

        // Instantiating the inner class
        Outer_Demo2.Inner_Demo inner = outer.new Inner_Demo();
        System.out.println(inner.getNum());
    }
}

class Outerclass3 {
    // instance method of the outer class
    void my_Method() {
        int num = 23;

        // method-local inner class
        class MethodInner_Demo {
            public void print() {
                System.out.println("This is method inner class " + num);
            }
        } // end of inner class

        // Accessing the inner class
        MethodInner_Demo inner = new MethodInner_Demo();
        inner.print();
    }

    public static void main(String args[]) {
        Outerclass3 outer = new Outerclass3();
        outer.my_Method();
    }
}

/**
 * Anonymous Inner Class
 * 
 * <pre>
 * 
 * 
 * An inner class declared without a class name is known as an anonymous inner
 * class. In case of anonymous inner classes, we declare and instantiate them at
 * the same time. Generally, they are used whenever you need to override the
 * method of a class or an interface. The syntax of an anonymous inner class is
 * as follows −
 * </pre>
 * 
 */
abstract class AnonymousInner {
    public abstract void mymethod();
}

interface FuncInterface {
    public abstract void mymethod();
}

class Outer_class4 {

    public static void main(String args[]) {
        System.out.println("-- Anonymous Inner Class as direct Implementor --");

        AnonymousInner inner = new AnonymousInner() {
            public void mymethod() {
                System.out.println("This is an example of anonymous inner class");
            }
        };
        inner.mymethod();

        // via Java 8, only FUNCTIONAL interface must be implemented via LAMBDA
        /*
         * AnonymousInner inner2 = () -> { System.out.println("Do nothing!"); };
         * inner2.mymethod();
         */

        FuncInterface inner2 = () -> {
            System.out
                    .println("This is an example of anonymous inner class - but only via Functional Interface LAMBDA!");
        };
        inner2.mymethod();
    }
}

// interface
interface Message {
    String greet();
}

/**
 * Anonymous Inner Class as Argument
 * 
 * Generally, if a method accepts an object of an interface, an abstract class,
 * or a concrete class, then we can implement the interface, extend the abstract
 * class, and pass the object to the method. If it is a class, then we can
 * directly pass it to the method.
 * 
 * But in all the three cases, you can pass an anonymous inner class to the
 * method. Here is the syntax of passing an anonymous inner class as a method
 * argument −
 *
 * 
 */
class Outer_class5 {
    // method which accepts the object of interface Message
    public void displayMessage(Message m) {
        System.out.println(m.greet() + ", This is an example of anonymous inner class as an argument");
    }

    public static void main(String args[]) {

        System.out.println("-- Anonymous Inner Class as Argument --");
        // Instantiating the class
        Outer_class5 obj = new Outer_class5();

        // Passing an anonymous inner class as an argument
        obj.displayMessage(new Message() {
            public String greet() {
                return "Hello";
            }
        });

        System.out.println("--via lambda --");
        Message lambd = () -> "Hello I am Lambda";
        obj.displayMessage(lambd);
    }
}

class Outer_Class_Static {

    /**
     * Static Nested Class
     * 
     * A static inner class is a nested class which is a static member of the
     * outer class. It can be accessed without instantiating the outer class,
     * using other static members. Just like static members, a static nested
     * class does not have access to the instance variables and methods of the
     * outer class. The syntax of static nested class is as follows −
     * 
     * @param args
     */
    public static void main(String[] args) {

        Outer_Class_Static.Nested_Demo nested = new Outer_Class_Static.Nested_Demo();
        nested.my_method();
    }

    static class Nested_Demo {
        public void my_method() {
            System.out.println("This is my nested class");
        }
    }

}