package intro.javase.essentials;

/**
 * The Garbage Collector
 * 
 * <pre>
 * 
 * 
 * Some object-oriented languages require that you keep track of all the objects
 * you create and that you explicitly destroy them when they are no longer
 * needed. Managing memory explicitly is tedious and error-prone. The Java
 * platform allows you to create as many objects as you want (limited, of
 * course, by what your system can handle), and you don't have to worry about
 * destroying them. The Java runtime environment deletes objects when it
 * determines that they are no longer being used. This process is called garbage
 * collection.
 * 
 * An object is eligible for garbage collection when there are no more
 * references to that object. References that are held in a variable are usually
 * dropped when the variable goes out of scope. Or, you can explicitly drop an
 * object reference by setting the variable to the special value null. Remember
 * that a program can have multiple references to the same object; all
 * references to an object must be dropped before the object is eligible for
 * garbage collection.
 * 
 * The Java runtime environment has a garbage collector that periodically frees
 * the memory used by objects that are no longer referenced. The garbage
 * collector does its job automatically when it determines that the time is
 * right.
 * 
 * 
 * </pre>
 * 
 */
public class b_GC_and_This {

    /**
     * Each of these statements has three parts (discussed in detail below):
     * 
     * <pre>
    
    1.Declaration: The code set in bold are all variable declarations that associate a variable name with an object type.
    2.Instantiation: The new keyword is a Java operator that creates the object.
    3.Initialization: The new operator is followed by a call to a constructor, which initializes the new object.
     * 
     * </pre>
     * 
     */
    Integer i;

    public static void main(String[] args) {

        System.out.println(
                "The following code creates one array and one string object. How many references to those objects exist after the code executes? \n"
                        + "Is either object eligible for garbage collection?");
        // ...
        String[] students = new String[10];
        String studentName = "Peter Smith";
        students[0] = studentName;
        studentName = null;
        // ...
        System.out.println();

        System.out.println(
                "Answer: There is one reference to the students array and that array has one reference to the string Peter Smith. \n"
                        + "Neither object is eligible for garbage collection. The array students is not eligible for garbage collection \n"
                        + "because it has one reference to the object studentName even though that object has been assigned the value null. \n"
                        + "The object studentName is not eligible either because students[0] still refers to it.");
        System.out.println();
        System.out.println("\n How does a program destroy an object that it creates?");
        System.out.println(
                "A program does not explicitly destroy objects. A program can set all references to an object to null \n"
                        + "so that it becomes eligible for garbage collection. But the program does not actually destroy objects.");

    }

}

class Point {
    public int x = 0;
    public int y = 0;

    // constructor
    public Point(int x, int y) {
        x = x; // shadowing the field, that is why we use below to assign to
               // field
        y = y; // shadowing the field, that is why we use below to assign to
               // field
        this.x = x;
        this.y = y;
    }
}

class Rectangle {
    private int x, y;
    private int width, height;

    public Rectangle() {
        this(0, 0, 1, 1);
    }

    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}

class IdentifyMyParts {
    public static int x = 7;
    public int y = 3;

    public static void main(String[] args) {
        IdentifyMyParts a = new IdentifyMyParts();
        IdentifyMyParts b = new IdentifyMyParts();
        a.y = 5;
        b.y = 6;
        a.x = 1;
        b.x = 2;
        System.out.println("a.y = " + a.y);
        System.out.println("b.y = " + b.y);
        System.out.println("a.x = " + a.x);
        System.out.println("b.x = " + b.x);
        System.out.println("IdentifyMyParts.x = " + IdentifyMyParts.x);
    }
}
