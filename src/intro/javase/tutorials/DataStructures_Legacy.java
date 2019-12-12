package intro.javase.tutorials;

import java.util.BitSet;
import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 * Java - Data Structures
 * 
 * <pre>
 *  
The data structures provided by the Java utility package are very 
powerful and perform a wide range of functions. These data structures consist of 
the following interface and classes −

Enumeration
BitSet
Vector
Stack
Dictionary
Hashtable
Properties
 * </pre>
 * 
 */

class EnumerationTester {

    public static void main(String args[]) {
        Enumeration days;
        Vector dayNames = new Vector();

        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();

        while (days.hasMoreElements()) {
            System.out.println(days.nextElement());
        }
    }
}

class BitSetDemo {

    public static void main(String args[]) {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);

        // set some bits
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0)
                bits1.set(i);
            if ((i % 5) != 0)
                bits2.set(i);
        }

        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println("\nInitial pattern in bits2: ");
        System.out.println(bits2);

        // AND bits
        bits2.and(bits1);
        System.out.println("\nbits2 AND bits1: ");
        System.out.println(bits2);

        // AND bits
        bits1.and(bits2);
        System.out.println("\nbits1 AND bits2: ");
        System.out.println(bits1);

        // OR bits
        bits2.or(bits1);
        System.out.println("\nbits2 OR bits1: ");
        System.out.println(bits2);
        // OR bits
        bits1.or(bits2);
        System.out.println("\nbits1 OR bits2: ");
        System.out.println(bits1);

        // XOR bits
        bits2.xor(bits1);
        System.out.println("\nbits2 XOR bits1: ");
        System.out.println(bits2);
    }
}

/**
 * Desc:
 * 
 * <pre>
 * 
 * 
 * Vector implements a dynamic array. It is similar to ArrayList, but with two
 * differences −
 * 
 * Vector is synchronized.
 * 
 * 
 * Vector contains many legacy methods that are not part of the collections
 * framework.
 * 
 * 
 * Vector proves to be very useful if you don't know the size of the array in
 * advance or you just need one that can change sizes over the lifetime of a
 * program.
 * 
 * Following is the list of constructors provided by the vector class.
 * 
 * 
 * </pre>
 */
class VectorDemo {

    public static void main(String args[]) {
        // initial size is 3, increment is 2
        Vector v = new Vector(3, 2);
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " + v.capacity());

        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        System.out.println("Capacity after four additions: " + v.capacity());

        v.addElement(new Double(5.45));
        System.out.println("Current capacity: " + v.capacity());

        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        System.out.println("Current capacity: " + v.capacity());

        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        System.out.println("Current capacity: " + v.capacity());

        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        System.out.println("First element: " + (Integer) v.firstElement());
        System.out.println("Last element: " + (Integer) v.lastElement());

        if (v.contains(new Integer(3)))
            System.out.println("Vector contains 3.");

        // enumerate the elements in the vector.
        Enumeration vEnum = v.elements();
        System.out.println("\nElements in vector:");

        while (vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();
    }
}

/**
 * Desc:
 * 
 * <pre>
 * Stack is a subclass of Vector that implements a standard last-in,
 * first-out stack.
 * 
 * Stack only defines the default constructor, which creates an empty stack.
 * Stack includes all the methods defined by Vector, and adds several of its
 * own.
 * 
 * 
 * </pre>
 * 
 */
class StackDemo {

    static void showpush(Stack st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showpop(Stack st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String args[]) {
        Stack st = new Stack();
        System.out.println("stack: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        showpop(st);
        showpop(st);
        showpop(st);
        try {
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
}

/**
 * Desc:
 * 
 * <pre>
 * Dictionary is an abstract class that represents a key/value storage
 * repository and operates much like Map.
 * 
 * Given a key and value, you can store the value in a Dictionary object. Once
 * the value is stored, you can retrieve it by using its key. Thus, like a map,
 * a dictionary can be thought of as a list of key/value pairs.
 * 
 * The abstract methods defined by Dictionary are listed below −
 * 
 * </pre>
 * 
 */
class DictDemo {
    // Hashtable was part of the original java.util and is a concrete
    // implementation of a Dictionary

}

/**
 * Desc: *
 * 
 * <pre>
 * Hashtable was part of the original java.util and is a concrete
 * implementation of a Dictionary.
 * 
 * However, Java 2 re-engineered Hashtable so that it also implements the Map
 * interface. Thus, Hashtable is now integrated into the collections framework.
 * It is similar to HashMap, but is synchronized.
 * 
 * Like HashMap, Hashtable stores key/value pairs in a hash table. When using a
 * Hashtable, you specify an object that is used as a key, and the value that
 * you want linked to that key. The key is then hashed, and the resulting hash
 * code is used as the index at which the value is stored within the table.
 * 
 * Following is the list of constructors provided by the HashTable class.
 * 
 * </pre>
 * 
 */
class HashtableDemo {

    public static void main(String args[]) {
        // Create a hash map
        Hashtable balance = new Hashtable();
        Enumeration names;
        String key;
        double bal;

        balance.put("Zara", new Double(3434.34));
        balance.put("Mahnaz", new Double(123.22));
        balance.put("Ayan", new Double(1378.00));
        balance.put("Daisy", new Double(99.22));
        balance.put("Qadir", new Double(-19.08));

        // Show all balances in hash table.
        names = balance.keys();
        // System.out.println(names);

        while (names.hasMoreElements()) {
            key = (String) names.nextElement();
            System.out.println(key + ": " + balance.get(key));
        }
        System.out.println();

        // Deposit 1,000 into Zara's account
        bal = ((Double) balance.get("Zara")).doubleValue();
        balance.put("Zara", new Double(bal + 1000));
        System.out.println("Zara's new balance: " + balance.get("Zara"));
    }

}

/**
 * Desc:
 * 
 * <pre>
 * 
 * 
 * Properties is a subclass of Hashtable. It is used to maintain lists of values
 * in which the key is a String and the value is also a String.
 * 
 * The Properties class is used by many other Java classes. For example, it is
 * the type of object returned by System.getProperties( ) when obtaining
 * environmental values.
 * 
 * Properties define the following instance variable. This variable holds a
 * default property list associated with a Properties object.
 * 
 * </pre>
 * 
 * *
 */
class PropDemo {

    public static void main(String args[]) {
       Properties capitals = new Properties();
       Set states;
       String str;
       
       capitals.put("Illinois", "Springfield");
       capitals.put("Missouri", "Jefferson City");
       capitals.put("Washington", "Olympia");
       capitals.put("California", "Sacramento");
       capitals.put("Indiana", "Indianapolis");

       // Show all states and capitals in hashtable.
       states = capitals.keySet();   // get set-view of keys
       Iterator itr = states.iterator();
       
       while(itr.hasNext()) {
          str = (String) itr.next();
          System.out.println("The capital of " + str + " is " + 
             capitals.getProperty(str) + ".");
       }     
       System.out.println();

       // look for state not in list -- specify default
       str = capitals.getProperty("Florida", "Not Found");
       System.out.println("The capital of Florida is " + str + ".");
    }
 }