package intro.javase.essentials;

/**
 * 
 * Multiple Inheritance of State, Implementation, and Type
 * 
 * <pre>
 * One significant difference between classes and interfaces is that classes can
 * have fields whereas interfaces cannot. In addition, you can instantiate a
 * class to create an object, which you cannot do with interfaces. As explained
 * in the section What Is an Object?, an object stores its state in fields,
 * which are defined in classes. One reason why the Java programming language
 * does not permit you to extend more than one class is to avoid the issues of
 * multiple inheritance of state, which is the ability to inherit fields from
 * multiple classes. For example, suppose that you are able to define a new
 * class that extends multiple classes. When you create an object by
 * instantiating that class, that object will inherit fields from all of the
 * class's superclasses. What if methods or constructors from different
 * superclasses instantiate the same field? Which method or constructor will
 * take precedence? Because interfaces do not contain fields, you do not have to
 * worry about problems that result from multiple inheritance of state.
 * 
 * Multiple inheritance of implementation is the ability to inherit method
 * definitions from multiple classes. Problems arise with this type of multiple
 * inheritance, such as name conflicts and ambiguity. When compilers of
 * programming languages that support this type of multiple inheritance
 * encounter superclasses that contain methods with the same name, they
 * sometimes cannot determine which member or method to access or invoke. In
 * addition, a programmer can unwittingly introduce a name conflict by adding a
 * new method to a superclass. Default methods introduce one form of multiple
 * inheritance of implementation. A class can implement more than one interface,
 * which can contain default methods that have the same name. The Java compiler
 * provides some rules to determine which default method a particular class
 * uses.
 * 
 * The Java programming language supports multiple inheritance of type, which is
 * the ability of a class to implement more than one interface. An object can
 * have multiple types: the type of its own class and the types of all the
 * interfaces that the class implements. This means that if a variable is
 * declared to be the type of an interface, then its value can reference any
 * object that is instantiated from any class that implements the interface.
 * This is discussed in the section Using an Interface as a Type.
 * 
 * As with multiple inheritance of implementation, a class can inherit different
 * implementations of a method defined (as default or static) in the interfaces
 * that it extends. In this case, the compiler or the user must decide which one
 * to use.
 * 
 * 
 * 
 * </pre>
 */
public class a_Interface_diff_Class {
    public static void main(String[] args) {
        System.out.println(
                "One significant difference between classes and interfaces is that classes can have fields(STATE) whereas interfaces cannot.");

        System.out.println(
                "In addition, you can instantiate a class to create an object, which you cannot do with interfaces.");

        System.out.println(
                "One reason why the Java programming language does not permit you to extend more than one class is to avoid the issues of multiple inheritance of state, "
                + "which is the ability to inherit fields from multiple classes. F");
        System.out.println("to avoid the issues of multiple inheritance of state".toUpperCase());

        System.out.println("\n");
        System.out.println(
                "Multiple inheritance of implementation is the ability to inherit method definitions from multiple classes. \n"
                        + "Problems arise with this type of multiple inheritance, such as name conflicts and ambiguity");

        System.out.println(
                " In addition, a programmer can unwittingly introduce a name conflict by adding a new method to a superclass. \n"
                        + "Default methods introduce one form of multiple inheritance of implementation. A class can implement more than one interface, which can contain default methods that have the same name."
                        + " \nThe Java compiler provides some rules to determine which default method a particular class uses.");

        System.out.println();
        System.out.println(
                "The Java programming language supports multiple inheritance of type, which is the ability of a class \n"
                        + "to implement more than one interface.");

    }

}
