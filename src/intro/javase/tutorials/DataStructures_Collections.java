package intro.javase.tutorials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.WeakHashMap;

/**
 * Desc:
 * 
 * <pre>
 * 
 * 
 * Prior to Java 2, Java provided ad hoc classes such as Dictionary, Vector,
 * Stack, and Properties to store and manipulate groups of objects. Although
 * these classes were quite useful, they lacked a central, unifying theme. Thus,
 * the way that you used Vector was different from the way that you used
 * Properties.
 * 
 * The collections framework was designed to meet several goals, such as −
 * 
 * The framework had to be high-performance. The implementations for the
 * fundamental collections (dynamic arrays, linked lists, trees, and hashtables)
 * were to be highly efficient.
 * 
 * 
 * The framework had to allow different types of collections to work in a
 * similar manner and with a high degree of interoperability.
 * 
 * 
 * The framework had to extend and/or adapt a collection easily.
 * 
 * 
 * Towards this end, the entire collections framework is designed around a set
 * of standard interfaces. Several standard implementations such as LinkedList,
 * HashSet, and TreeSet, of these interfaces are provided that you may use as-is
 * and you may also implement your own collection, if you choose.
 * 
 * A collections framework is a unified architecture for representing and
 * manipulating collections. All collections frameworks contain the following −
 * 
 * Interfaces − These are abstract data types that represent collections.
 * Interfaces allow collections to be manipulated independently of the details
 * of their representation. In object-oriented languages, interfaces generally
 * form a hierarchy.
 * 
 * 
 * Implementations, i.e., Classes − These are the concrete implementations of
 * the collection interfaces. In essence, they are reusable data structures.
 * 
 * 
 * Algorithms − These are the methods that perform useful computations, such as
 * searching and sorting, on objects that implement collection interfaces. The
 * algorithms are said to be polymorphic: that is, the same method can be used
 * on many different implementations of the appropriate collection interface.
 * 
 * 
 * </pre>
 */
public class DataStructures_Collections {

}

class CollectionsDemo {

    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        System.out.println(" ArrayList Elements");
        System.out.print("\t" + a1);

        List l1 = new LinkedList();
        l1.add("Zara");
        l1.add("Mahnaz");
        l1.add("Ayan");
        System.out.println();
        System.out.println(" LinkedList Elements");
        System.out.print("\t" + l1);

        Map m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");

        System.out.println();
        System.out.println(" Map Elements");
        System.out.print("\t" + m1);

    }
}

class SetDemo {

    public static void main(String args[]) {
        int count[] = { 34, 22, 10, 60, 30, 22 };
        Set<Integer> set = new HashSet<Integer>();
        try {
            System.out.println("Un ordered list is:");
            for (int i = 0; i < 5; i++) {
                set.add(count[i]);
            }
            System.out.println(set);

            TreeSet sortedSet = new TreeSet<Integer>(set);
            System.out.println("The sorted list is:");
            System.out.println(sortedSet);

            System.out.println("The First element of the set is: " + (Integer) sortedSet.first());
            System.out.println("The last element of the set is: " + (Integer) sortedSet.last());
        } catch (Exception e) {
        }
    }
}

class SortedSetTest {

    public static void main(String[] args) {
        // Create the sorted set
        SortedSet set = new TreeSet();

        // Add elements to the set
        set.add("b");
        set.add("c");
        set.add("a");

        // Iterating over the elements in the set
        Iterator it = set.iterator();

        while (it.hasNext()) {
            // Get element
            Object element = it.next();
            System.out.println(element.toString());
        }
    }
}

/**
 * Desc:
 * 
 * A hash table stores information by using a mechanism called hashing. In
 * hashing, the informational content of a key is used to determine a unique
 * value, called its hash code.
 * 
 * The hash code is then used as the index at which the data associated with the
 * key is stored. The transformation of the key into its hash code is performed
 * automatically.
 * 
 * 
 */

class HashSetDemo {

    public static void main(String args[]) {
        // create a hash set
        HashSet hs = new HashSet();

        // add elements to the hash set
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        System.out.println(hs);
    }
}

class LikedHashSetDemo {

    public static void main(String args[]) {
        // create a hash set
        LinkedHashSet hs = new LinkedHashSet();

        // add elements to the hash set
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        System.out.println(hs);
    }
}

class TreeSetDemo {

    public static void main(String args[]) {
        // Create a tree set
        TreeSet ts = new TreeSet();

        // Add elements to the tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        System.out.println(ts);
    }
}

class HashMapDemo {

    public static void main(String args[]) {
        // Create a hash map
        HashMap hm = new HashMap();

        // Put elements to the map
        hm.put("Zara", new Double(3434.34));
        hm.put("Mahnaz", new Double(123.22));
        hm.put("Ayan", new Double(1378.00));
        hm.put("Daisy", new Double(99.22));
        hm.put("Qadir", new Double(-19.08));

        // Get a set of the entries
        Set set = hm.entrySet();
        System.out.println("Entry set: " + set);

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // Deposit 1000 into Zara's account
        double balance = ((Double) hm.get("Zara")).doubleValue();
        hm.put("Zara", new Double(balance + 1000));
        System.out.println("Zara's new balance: " + hm.get("Zara"));
    }
}

class LinkedHashMapDemo {

    public static void main(String args[]) {
        // Create a hash map
        LinkedHashMap lhm = new LinkedHashMap();

        // Put elements to the map
        lhm.put("Zara", new Double(3434.34));
        lhm.put("Mahnaz", new Double(123.22));
        lhm.put("Ayan", new Double(1378.00));
        lhm.put("Daisy", new Double(99.22));
        lhm.put("Qadir", new Double(-19.08));

        // Get a set of the entries
        Set set = lhm.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // Deposit 1000 into Zara's account
        double balance = ((Double) lhm.get("Zara")).doubleValue();
        lhm.put("Zara", new Double(balance + 1000));
        System.out.println("Zara's new balance: " + lhm.get("Zara"));
    }
}

class TreeMapDemo {

    public static void main(String args[]) {
        // Create a hash map
        TreeMap tm = new TreeMap();

        // Put elements to the map
        tm.put("Zara", new Double(3434.34));
        tm.put("Mahnaz", new Double(123.22));
        tm.put("Ayan", new Double(1378.00));
        tm.put("Daisy", new Double(99.22));
        tm.put("Qadir", new Double(-19.08));

        // Get a set of the entries
        Set set = tm.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // Deposit 1000 into Zara's account
        double balance = ((Double) tm.get("Zara")).doubleValue();
        tm.put("Zara", new Double(balance + 1000));
        System.out.println("Zara's new balance: " + tm.get("Zara"));
    }
}

/**
 * Desc:
 * 
 * <pre>

ArrayList

LinkedList

1) ArrayList internally uses dynamic array to store the elements. 
   LinkedList internally uses doubly linked list to store the elements. 

2) Manipulation with ArrayList is slow because it internally uses array. If any element is removed from the array, all the bits are shifted in memory.
   Manipulation with LinkedList is faster than ArrayList because it uses doubly linked list so no bit shifting is required in memory. 

3) ArrayList class can act as a list only because it implements List only. 
  LinkedList class can act as a list and queue both because it implements List and Deque interfaces. 

4) ArrayList is better for storing and accessing data. 
   LinkedList is better for manipulating data.
   
   
   
   ArrayList Vs LinkedList

1) Search: ArrayList search operation is pretty fast compared to the LinkedList search operation. get(int index) 
in ArrayList gives the performance of O(1) while LinkedList performance is O(n).

Reason: ArrayList maintains index based system for its elements as it uses array data structure implicitly 
which makes it faster for searching an element in the list. On the other side LinkedList implements doubly linked 
list which requires the traversal through all the elements for searching an element.

2) Deletion: LinkedList remove operation gives O(1) performance while ArrayList gives variable 
performance: O(n) in worst case (while removing first element) and O(1) in best case (While removing last element).
 * 
 * Conclusion: LinkedList element deletion is faster compared to ArrayList.
 * Reason: LinkedList’s each element maintains two pointers (addresses) which points to the both neighbor elements in the list. Hence removal only requires change in the pointer location in the two neighbor nodes (elements) of the node which is going to be removed. While In ArrayList all the elements need to be shifted to fill out the space created by removed element.
 * 
 * 
 *3) Inserts Performance: LinkedList add method gives O(1) performance while ArrayList gives O(n) in worst case. 
 *Reason is same as explained for remove.

4) Memory Overhead: ArrayList maintains indexes and element data while LinkedList maintains element data and 
two pointers for neighbor nodes hence the memory consumption is high in LinkedList comparatively.
 * 
 * </pre>
 * 
 * 
 * When to use LinkedList and when to use ArrayList?
 * 
 * 1) As explained above the insert and remove operations give good performance
 * (O(1)) in LinkedList compared to ArrayList(O(n)). Hence if there is a
 * requirement of frequent addition and deletion in application then LinkedList
 * is a best choice.
 * 
 * 2) Search (get method) operations are fast in Arraylist (O(1)) but not in
 * LinkedList (O(n)) so If there are less add and remove operations and more
 * search operations requirement, ArrayList would be your best bet.
 * 
 */

class LinkedListDemo {

    public static void main(String args[]) {
        // create a linked list
        LinkedList ll = new LinkedList();

        // add elements to the linked list
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, "A2");
        System.out.println("Original contents of ll: " + ll);

        // remove elements from the linked list
        ll.remove("F");
        ll.remove(2);
        System.out.println("Contents of ll after deletion: " + ll);

        // remove first and last elements
        ll.removeFirst();
        ll.removeLast();
        System.out.println("ll after deleting first and last: " + ll);

        // get and set a value
        Object val = ll.get(2);
        ll.set(2, (String) val + " Changed");
        System.out.println("ll after change: " + ll);
    }
}

class ArrayListDemo {

    public static void main(String args[]) {
        // create an array list
        ArrayList al = new ArrayList();
        System.out.println("Initial size of al: " + al.size());

        // add elements to the array list
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");
        System.out.println("Size of al after additions: " + al.size());

        // display the array list
        System.out.println("Contents of al: " + al);

        // Remove elements from the array list
        al.remove("F");
        al.remove(2);
        System.out.println("Size of al after deletions: " + al.size());
        System.out.println("Contents of al: " + al);
    }
}

/**
 * Desc:
 * 
 * <pre>
 * 
 * 
 * WeakHashMap is an implementation of the Map interface that stores only weak
 * references to its keys. Storing only weak references allows a key-value pair
 * to be garbage-collected when its key is no longer referenced outside of the
 * WeakHashMap.
 * 
 * This class provides the easiest way to harness the power of weak references.
 * It is useful for implementing "registry-like" data structures, where the
 * utility of an entry vanishes when its key is no longer reachable by any
 * thread.
 * 
 * The WeakHashMap functions identically to the HashMap with one very important
 * exception: if the Java memory manager no longer has a strong reference to the
 * object specified as a key, then the entry in the map will be removed.
 * 
 * Weak Reference − If the only references to an object are weak references, the
 * garbage collector can reclaim the object's memory at any time.it doesn't have
 * to wait until the system runs out of memory. Usually, it will be freed the
 * next time the garbage collector runs.
 * 
 * Following is the list of constructors supported by the WeakHashMap class.
 * 
 * 
 * Strong References

The strong reference is the most common type of Reference that we use in our day to day programming: 
 
Integer prime = 1;
 

The variable prime has a strong reference to an Integer object with value 1. Any object which has a strong reference pointing to it is not eligible for GC.

2.2. Soft References

Simply put, an object that has a SoftReference pointing to it won’t be garbage collected until the JVM absolutely needs memory.

Let’s see how we can create a SoftReference in Java:  

Integer prime = 1;  
SoftReference<Integer> soft = new SoftReference<Integer>(prime); 
prime = null;
 

The prime object has a strong reference pointing to it.

Next, we are wrapping prime strong reference into a soft reference. After making that strong reference null,
 a prime object is eligible for GC but will be collected only when JVM absolutely needs memory.

2.3. Weak References

The objects that are referenced only by weak references are garbage collected eagerly; the GC won’t wait until 
it needs memory in that case.

We can create a WeakReference in Java in the following way:
 * 
 * </pre>
 * 
 * *
 */
class WeakHashMap_Demo {

    private static Map map;

    public static void main(String args[]) {
        System.out.println(
                "If you do not include the call to System.gc(), the system may never run the garbage collector as "
                        + "\nnot much memory is used by the program. For a more active program, the call would be unnecessary.");

        System.out.println(
                "Simply put, the WeakHashMap is a hashtable-based implementation of the Map interface, with keys "
                        + "\nthat are of a WeakReference type.");
        map = new WeakHashMap();
        map.put(new String("Maine"), "Augusta");

        System.out.println();

        System.out.println(
                "Let’s say that we want to build a cache that keeps big image objects as values, and image names as keys. We want to pick a proper map implementation for solving that problem.");

        System.out.println("Weak Reference − If the only references to an object are weak references, the garbage "
                + "collector can reclaim the object's memory at any time. \nIt doesn't have to wait until the system runs out of memory. Usually, it will be freed the next time the garbage collector runs.");

        Runnable runner = new Runnable() {
            public void run() {
                while (map.containsKey("Maine")) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println("Thread waiting");
                    System.gc();
                }
            }
        };
        Thread t = new Thread(runner);
        t.start();
        System.out.println("Main waiting");
        try {
            t.join();
        } catch (InterruptedException ignored) {
        }
    }
}

/**
 * Desc:
 * 
 * <pre>
 * 
 * This class implements AbstractMap. It is similar to HashMap except that it
 * uses reference equality when comparing the elements.
 * 
 * This class is not a general-purpose Map implementation. While this class
 * implements the Map interface, it intentionally violates Map's general
 * contract, which mandates the use of the equals method when comparing objects.
 * 
 * This class is designed for use only in rare cases wherein reference-equality
 * semantics are required. This class provides constant-time performance for the
 * basic operations (get and put), assuming the system identity hash function
 * (System.identityHashCode(Object)) disperses elements properly among the
 * buckets.
 * 
 * This class has one tuning parameter (which affects performance but not
 * semantics): expected maximum size. This parameter is the maximum number of
 * key-value mappings that the map is expected to hold.
 * 
 * Following is the list of the constructors supported by the IdentityHashMap.
 * 
 * </pre>
 * 
 * *
 */
class IdentityHashMapDemo {

    public static void main(String args[]) {
        System.out.println();
        System.out.println(
                "This class is not a general-purpose Map implementation. While this class implements the Map interface,\n "
                        + " intentionally violates Map's general contract, which mandates the use of the equals method when comparing objects.");
        System.out.println();
        System.out.println(
                "This class is designed for use only in rare cases wherein reference-equality semantics are required. \n"
                        + "This class provides constant-time performance for the basic operations (get and put), assuming the \n"
                        + "system identity hash function (System.identityHashCode(Object)) disperses elements properly among the buckets.");

        System.out.println();
        // Create a hash map
        IdentityHashMap ihm = new IdentityHashMap();

        // Put elements to the map
        ihm.put("Zara", new Double(3434.34));
        ihm.put("Mahnaz", new Double(123.22));
        ihm.put("Ayan", new Double(1378.00));
        ihm.put("Daisy", new Double(99.22));
        ihm.put("Qadir", new Double(-19.08));

        // Get a set of the entries
        Set set = ihm.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // Deposit 1000 into Zara's account
        double balance = ((Double) ihm.get("Zara")).doubleValue();
        ihm.put("Zara", new Double(balance + 1000));
        System.out.println("Zara's new balance: " + ihm.get("Zara"));
    }
}

/**
 * Desc:
 * 
 * <pre>
 * 
 * 
 * Often, you will want to cycle through the elements in a collection. For
 * example, you might want to display each element. The easiest way to do this
 * is to employ an iterator, which is an object that implements either the
 * Iterator or the ListIterator interface.
 * 
 * Iterator enables you to cycle through a collection, obtaining or removing
 * elements. ListIterator extends Iterator to allow bidirectional traversal of a
 * list, and the modification of elements.
 * 
 * Before you can access a collection through an iterator, you must obtain one.
 * Each of the collection classes provides an iterator( ) method that returns an
 * iterator to the start of the collection. By using this iterator object, you
 * can access each element in the collection, one element at a time.
 * 
 * In general, to use an iterator to cycle through the contents of a collection,
 * follow these steps −
 * 
 * Obtain an iterator to the start of the collection by calling the collection's
 * iterator( ) method.
 * 
 * 
 * Set up a loop that makes a call to hasNext( ). Have the loop iterate as long
 * as hasNext( ) returns true.
 * 
 * 
 * Within the loop, obtain each element by calling next( ).
 * 
 * 
 * For collections that implement List, you can also obtain an iterator by
 * calling ListIterator.
 * 
 * </pre>
 * 
 * *
 */
class IteratorDemo {

    public static void main(String args[]) {
        // Create an array list
        ArrayList al = new ArrayList();

        // add elements to the array list
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        // Use iterator to display contents of al
        System.out.print("Original contents of al: ");
        Iterator itr = al.iterator();

        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println(" ListIterator is available only to those collections that implement the List interface.");
        System.out.println();
        // Modify objects being iterated
        ListIterator litr = al.listIterator();

        while (litr.hasNext()) {
            Object element = litr.next();
            litr.set(element + "+");
        }
        System.out.print("Modified contents of al: ");
        itr = al.iterator();

        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // Now, display the list backwards
        System.out.print("Modified list backwards: ");

        while (litr.hasPrevious()) {
            Object element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

/**
 * The collections framework defines several algorithms that can be applied to
 * collections and maps.
 * 
 * These algorithms are defined as static methods within the Collections class.
 * Several of the methods can throw a ClassCastException, which occurs when an
 * attempt is made to compare incompatible types, or an
 * UnsupportedOperationException, which occurs when an attempt is made to modify
 * an unmodifiable collection.
 * 
 * @author asatklic
 *
 */
class AlgorithmsDemo {

    public static void main(String args[]) {

        // Create and initialize linked list
        LinkedList ll = new LinkedList();
        ll.add(new Integer(-8));
        ll.add(new Integer(20));
        ll.add(new Integer(-20));
        ll.add(new Integer(8));

        System.out.println(ll);
        Collections.sort(ll);
        System.out.print("List sorted in ascending: ");
        System.out.println(ll);

        // Create a reverse order comparator
        Comparator r = Collections.reverseOrder();

        // Sort list by using the comparator
        Collections.sort(ll, r);

        // Get iterator
        Iterator li = ll.iterator();
        System.out.print("List sorted in reverse(descending): ");

        while (li.hasNext()) {
            System.out.print(li.next() + " ");
        }
        System.out.println();
        Collections.shuffle(ll);

        // display randomized list
        li = ll.iterator();
        System.out.print("List shuffled: ");

        while (li.hasNext()) {
            System.out.print(li.next() + " ");
        }

        System.out.println();
        System.out.println("Minimum: " + Collections.min(ll));
        System.out.println("Maximum: " + Collections.max(ll));
    }
}

/**
 * *
 * 
 * <pre>
 * 
 * Both TreeSet and TreeMap store elements in sorted order. However, it is the
 * comparator that defines precisely what sorted order means.
 * 
 * The Comparator interface defines two methods: compare( ) and equals( ). The
 * compare( ) method, shown here, compares two elements for order −
 * 
 * The compare Method int compare(Object obj1, Object obj2)
 * 
 * 
 * obj1 and obj2 are the objects to be compared. This method returns zero if the
 * objects are equal. It returns a positive value if obj1 is greater than obj2.
 * Otherwise, a negative value is returned.
 * 
 * By overriding compare( ), you can alter the way that objects are ordered. For
 * example, to sort in a reverse order, you can create a comparator that
 * reverses the outcome of a comparison.
 * 
 * The equals Method
 * 
 * The equals( ) method, shown here, tests whether an object equals the invoking
 * comparator − boolean equals(Object obj)
 * 
 * 
 * obj is the object to be tested for equality. The method returns true if obj
 * and the invoking object are both Comparator objects and use the same
 * ordering. Otherwise, it returns false.
 * 
 * Overriding equals( ) is unnecessary, and most simple comparators will not do
 * so.
 * 
 * </pre>
 * 
 */
class Dogg implements Comparator<Dogg>, Comparable<Dogg> {
    private String name;
    private int age;

    Dogg() {
    }

    Dogg(String n, int a) {
        name = n;
        age = a;
    }

    public String getDoggName() {
        return name;
    }

    public int getDoggAge() {
        return age;
    }

    // Overriding the compareTo method
    public int compareTo(Dogg d) {
        return (this.name).compareTo(d.name);
    }

    // Overriding the compare method to sort the age
    public int compare(Dogg d, Dogg d1) {
        return d.age - d1.age;
    }
}

class ComparatorDemo {

    public static void main(String args[]) {
        // Takes a list o Dogg objects
        List<Dogg> list = new ArrayList<Dogg>();

        list.add(new Dogg("Shaggy", 3));
        list.add(new Dogg("Lacy", 2));
        list.add(new Dogg("Roger", 10));
        list.add(new Dogg("Tommy", 4));
        list.add(new Dogg("Tammy", 1));
        Collections.sort(list); // Sorts the array list

        for (Dogg a : list) // printing the sorted list of names
            System.out.print(a.getDoggName() + ", ");

        // Sorts the array list using comparator
        Collections.sort(list, new Dogg());
        System.out.println(" ");

        for (Dogg a : list) // printing the sorted list of ages
            System.out.print(a.getDoggName() + "  : " + a.getDoggAge() + ", ");
    }
}