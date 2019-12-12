package intro.javase.essentials;

class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }

    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}

class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }

    @Override
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}

/**
 * Interface Methods
 * 
 * <pre>
 * 
 * 
 * Default methods and abstract methods in interfaces are inherited like
 * instance methods. However, when the supertypes of a class or interface
 * provide multiple default methods with the same signature, the Java compiler
 * follows inheritance rules to resolve the name conflict. These rules are
 * driven by the following two principles:
 * 
 * •
 * 
 * 
 * </pre>
 * 
 */
class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}

interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}

interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}

class Pegasus extends Horse implements Flyer, Mythical {
    public static void main(String... args) {

        System.out.println("Default methods and abstract methods in interfaces are inherited like instance methods. \n"
                + "However, when the supertypes of a class or interface provide multiple default methods with the same signature, the Java compiler follows inheritance rules to resolve the name conflict. These rules are driven by the following two principles:");
        
        System.out.println();
        System.out.println(" 1• Instance methods are preferred over interface default methods.");
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());

        System.out.println();
        System.out.println(
                "See below  FlyingCar2: If two or more independently defined default methods conflict, or a default method conflicts with an abstract method, then the Java compiler produces a compiler error. You must explicitly override the supertype methods.");

    }
}


interface Animal2 {
    default public String identifyMyself() {
        return "I am an animal.";
    }
}

interface EggLayer extends Animal2 {
    @Override
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}

class Dragon implements EggLayer, FireBreather {
    public static void main(String... args) {
        System.out.println("Default methods and abstract methods in interfaces are inherited like instance methods. \n"
                + "However, when the supertypes of a class or interface provide multiple default methods with the same signature, the Java compiler follows inheritance rules to resolve the name conflict. These rules are driven by the following two principles:");
        
        System.out.println(
                " 2• Methods that are already overridden by other candidates are ignored. This circumstance can arise when supertypes share a common ancestor.");

        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
        
        System.out.println();
        System.out.println(
                "See below  FlyingCar2: If two or more independently defined default methods conflict, or a default method conflicts with an abstract method, then the Java compiler produces a compiler error. You must explicitly override the supertype methods.");

    }
}


interface Animal3a {
    default public String identifyMyself() {
        return "I am an Animal3a.";
    }
}

interface Animal3b { 
    default public String identifyMyself() {
        return "I am an Animal3b";
    }
}

/*class Dragon2 implements Animal3a, Animal3b {
    public static void main(String... args) {
        System.out.println(
                "Or See below  FlyingCar2: If two or more independently defined default methods conflict, or a default method conflicts with an abstract method, then the Java compiler produces a compiler error. You must explicitly override the supertype methods.");

    }
}*/

interface FireBreather extends Animal2 {
}

/**
 * x*
 * 
 * <pre>
 * If two or more independently defined default methods conflict, or a default method conflicts with an abstract 
 * method, then the Java compiler produces a compiler error. You must explicitly override the supertype methods.

Consider the example about computer-controlled cars that can now fly. You have two interfaces (OperateCar and FlyCar)
 that provide default implementations for the same method, (startEngine):
 * 
 * </pre>
 * 
 */
interface OperateCar {
    // ...
    default public int startEngine(Object key) {
        return 0;// EncryptedKey
        // Implementation
    }
}

interface FlyCar {
    // ...
    default public int startEngine(Object key) {
        return 0;// EncryptedKey
        // Implementation
    }
}

/**
 * A class that implements both OperateCar and FlyCar must override the method
 * startEngine. You could invoke any of the of the default implementations with
 * the super keyword.
 * 
 * @author asatklic
 *
 */
/*class FlyingCar2 implements OperateCar, FlyCar {
    // ...
    public int startEngine(Object key) {// EncryptedKey
        FlyCar.super.startEngine(key);
        OperateCar.super.startEngine(key);
    }
}*/
