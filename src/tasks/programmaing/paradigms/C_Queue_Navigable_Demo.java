package cx55.and.cx65.ch7.collections.generics;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Navigating (Searching) TreeSets and TreeMaps
 * 
 * <pre>
 * 
 * We've talked about searching lists and arrays. Let's turn our attention to searching 
 * TreeSets and TreeMaps. 
 * 
 * Java 6 introduced (among others) two new interfaces: 
 * java.util.NavigableSet and java.util.NavigableMap. For the purposes 
 * of the exam, you’re interested in how TreeSet and TreeMap implement these 
 * interfaces.
 * 
 * 
 * Imagine that the Santa Cruz–Monterey ferry has an irregular schedule. Let's 
 * say that we have the daily Santa Cruz departure times stored, in military time, in a 
 * TreeSet.
 * 
 *  Let's look at some code that determines two things:
 *  
 *  1. The last ferry that leaves before 4   (1600 hours)
 *  
 *  2. The first ferry that leaves after 8   (2000 hours)
 * </pre>
 * 
 */
public class C_Queue_Navigable_Demo {

}

/**
 * This should produce the following:
 * 
 * <pre>
 * 
 * J5 - last before 4pm is: 1545
 * J5 - first after 8pm is: 2010
 * J6 - last before 4pm is: 1545
 * J6 - first after 8pm is: 2010
 * </pre>
 * 
 */
class Ferry {
	public static void main(String[] args) {
		/*
		 * As you can see in the preceding code, before the addition of the
		 * 
		 * NavigableSet interface, zeroing in on an arbitrary spot in a
		 * Set—using the methods available in Java 5—was a compute-expensive and
		 * clunky proposition.
		 * 
		 * On the other hand, using the new Java 6 methods lower() and higher(),
		 * the code becomes a lot cleaner.
		 */
		TreeSet<Integer> times = new TreeSet<Integer>();
		times.add(1205); // add some departure times
		times.add(1505);
		times.add(1545);
		times.add(1830);
		times.add(2010);
		times.add(2100);
		System.out.println(times);
		// Java 5 version
		TreeSet<Integer> headSet = new TreeSet<Integer>();
		headSet = (TreeSet) times.headSet(1830); //to element  
		System.out.println(headSet);
		System.out.println("J5 - last before 4pm is: " + headSet.first());
		System.out.println("J5 - last before 4pm is: " + headSet.last());
		TreeSet<Integer> tailSet = new TreeSet<Integer>();
		tailSet = (TreeSet) times.tailSet(1830);
		System.out.println(tailSet);
		System.out.println("J5 - first after 8pm is: " + tailSet.first());
		System.out.println("J5 - first after 8pm is: " + tailSet.last());
		
		System.out.println("");
		// Java 6 version using the new lower() and higher() methods
		System.out.println("J6 - last before 4pm is: " + times.lower(1600));
		System.out.println("J6 - first after 8pm is: " + times.higher(2000));

		// Polling
		System.out.println("\n-- Polling");
		/*
		 * Although the idea of polling isn't new to Java 6 (as you'll see in a
		 * minute, PriorityQueue had a poll() method before Java 6), it is new
		 * to TreeSet and TreeMap. The idea of polling is that we want both to
		 * retrieve and remove an element from either the beginning or the end
		 * of a collection. In the case of TreeSet, pollFirst() returns and
		 * removes the first entry in the set, and pollLast() returns and
		 * removes the last. Similarly, TreeMap now provides pollFirstEntry()
		 * and pollLastEntry() to retrieve and remove key-value pairs.
		 */

		// Descending Order
		System.out.println("\n-- Descending Order");
		/*
		 * Also new to Java 6 for TreeSet and TreeMap are methods that return a
		 * collection in the reverse order of the collection on which the method
		 * was invoked. The important methods for the exam are
		 * TreeSet.descendingSet() and TreeMap .descendingMap().
		 */
	}
}

/**
 * Backed Collections
 * 
 * 
 * Some of the classes in the java.util package support the concept of
 * "backed collections". We'll use a little code to help explain the idea:
 */
class BackedCollections {
	public static void main(String[] args) {
		/**
		 * The important method in this code is the TreeMap.subMap() method.
		 * It's easy to guess (and it's correct), that the subMap() method is
		 * makportioing a copy of a n of the TreeMap named map. The first line
		 * of output verifies the conclusions we've just drawn.
		 * 
		 * 
		 * What happens next is powerful and a little bit unexpected (now we're
		 * getting to why they're called backed collections).
		 * 
		 * 
		 * When we add key-value pairs to either the original TreeMap or the
		 * partial-copy SortedMap, the new entries were automatically added to
		 * the other collection—sometimes. When submap was created, we provided
		 * a value range for the new collection. This range defines not only
		 * what should be included when the partial copy is created, but also
		 * defines the range of values that can be added to the copy.
		 */

		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("a", "ant");
		map.put("d", "dog");
		map.put("h", "horse");
		SortedMap<String, String> submap;
		submap = map.subMap("b", "g"); // #1 create a backed collection
		System.out.println(map + " <--> " + submap); // #2 show contents
		map.put("b", "bat"); // #3 add to original
		map.put("a", "anttt"); //update
		submap.put("f", "fish"); // #4 add to copy
		map.put("r", "raccoon"); // #5 add to original - out of range
		// submap.put("p", "pig"); // #6 add to copy - out of range
		System.out.println(map + " <==> " + submap); // #7 show final contents
	}

}

/**
 * Using the PriorityQueue Class
 * 
 * 
 * The last collection class you'll need to understand for the exam is the
 * PriorityQueue. Unlike basic queue structures that are first-in, first-out by
 * default, a PriorityQueue orders its elements using a user-defined priority.
 * 
 * The priority can be as simple as natural ordering (in which, for instance, an
 * entry of 1 would be a higher priority than an entry of 2).
 * 
 * In addition, a PriorityQueue can be ordered using a Comparator, which lets
 * you define any ordering you want. Queues have a few methods not found in
 * other collection interfaces: peek(), poll(), and offer().
 */

class PriorityQueueTest {
	static class PQsort implements Comparator<Integer> { // inverse sort
		public int compare(Integer one, Integer two) {
			return two - one; // unboxing
		}
	}

	public static void main(String[] args) {
		int[] ia = { 1, 5, 3, 7, 6, 9, 8 }; // unordered data
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(); // use
																	// natural
																	// order
		for (int x : ia)
			// load queue
			pq1.offer(x);
		for (int x : ia)
			// review queue
			System.out.print(pq1.poll() + " ");
		System.out.println("  all polled");
		PQsort pqs = new PQsort(); // get a Comparator
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs); // use
																			// Comparator
		for (int x : ia)
			// load queue
			pq2.offer(x);
		System.out.println("size " + pq2.size());
		System.out.println("peek " + pq2.peek());
		System.out.println("size " + pq2.size());
		System.out.println("poll " + pq2.poll());
		System.out.println("size " + pq2.size());
		for (int x : ia)
			// review queue
			System.out.print(pq2.poll() + " ");

		/**
		 * It’s important to know some of the details of natural ordering. The
		 * following code will help you understand the relative positions of
		 * uppercase characters, lowercase characters, and spaces in a natural
		 * ordering:
		 */
		String[] sa = { ">ff<", "> f<", ">f <", ">FF<" }; // ordered?
		PriorityQueue<String> pq3 = new PriorityQueue<String>();
		for (String s : sa)
			pq3.offer(s);
		for (String s : sa)
			System.out.print(pq3.poll() + " ");
		/**
		 * This produces
		 * 
		 * > f< >FF< >f < >ff<
		 * 
		 * If you remember that spaces sort before characters and that uppercase
		 * letters sort before lowercase characters, you should be good to go
		 * for the exam.
		 */
	}
}
