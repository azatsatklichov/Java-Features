package tasks.programmaing.paradigms;

public interface Java8Interface {

    default void defaultMethod() {
        System.out.println("I am a default method in INTERFACE");
    }

    static void defStaticMethod() {
        System.out.println("I am a static method since Java 8");
    }

    void defImAAbstractMethod();

}

class Java8InterfaceImpl implements Java8Interface {

    /**
     * may be Overrided, if you want
     */
    // @Override
    public void defaultMethod() {
        System.out.println("I am default method, but overridden in this class");
    }
    
    public void defaultMethod2() {
        System.out.println("I am default method, but overridden in this class");
    }

    /**
     * Must be Implemented
     */
    @Override
    public void defImAAbstractMethod() {
        System.out.println("I am implemented");
    }

    // This is actually redefinition, nothing related with Interface
    static void defStaticMethod() {
        System.out.println("I am a static method in normal class as always");
    }

    public static void main(String[] args) {
        System.out.println("-- reference type Interface -- ");
        Java8Interface i = new Java8InterfaceImpl();
        i.defaultMethod();
        i.defImAAbstractMethod();
        // i.defStaticMethod();
        Java8Interface.defStaticMethod();

        System.out.println();
        System.out.println("-- reference type class -- ");
        Java8InterfaceImpl j = new Java8InterfaceImpl();
        j.defaultMethod();
        j.defImAAbstractMethod();
        j.defStaticMethod();
        Java8InterfaceImpl.defStaticMethod();

    }

}