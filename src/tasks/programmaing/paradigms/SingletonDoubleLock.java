package tasks.programmaing.paradigms;

//https://www.baeldung.com/java-singleton-double-checked-locking

public class SingletonDoubleLock {

    private volatile static SingletonDoubleLock instance;

    private SingletonDoubleLock() {
    }

    public static SingletonDoubleLock getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new SingletonDoubleLock();
                }
            }
        }
        return instance;
    }
}

class DraconianSingleton {
    private static DraconianSingleton instance;

    public static synchronized DraconianSingleton getInstance() {
        if (instance == null) {
            instance = new DraconianSingleton();
        }
        return instance;
    }

    // private constructor and other methods ...
}

/**
 * Alternatives
 * 
 * Even though the double-checked locking can potentially speed things up, it
 * has at least two issues:
 * 
 * •since it requires the volatile keyword to work properly, it’s not compatible
 * with Java 1.4 and lower versions
 * 
 * •it’s quite verbose and it makes the code difficult to read
 * 
 * For these reasons, let’s look into some other options without these flaws.
 * All of the following methods delegate the synchronization task to the JVM.
 * 
 * @author asatklic
 *
 */
class DclSingleton {
    private static volatile DclSingleton instance;

    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }

    // private constructor and other methods...
}

/**
 * Enum Singleton
 * 
 * The last solution comes from the Effective Java book (Item 3) by Joshua Block
 * and uses an enum instead of a class. At the time of writing, this is
 * considered to be the most concise and safe way to write a singleton:
 */
enum EnumSingleton {
    INSTANCE;

    // other methods...
}
