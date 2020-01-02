package tasks.programmaing.paradigms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * Desc
 *
 * <pre>
*Collection Subtypes
*
The following interfaces (collection types) extends the Java Collection interface:

List
Set
SortedSet
NavigableSet
Queue
Deque

Java does not come with a usable implementation of the Collection interface, 
so you will have to use one of the listed subtypes. The Collection interface 
just defines a set of methods (behaviour) that each of these Collection subtypes share. 
This makes it possible ignore what specific type of Collection you are using, 
and just treat it as a Collection. This is standard inheritance, so there is 
nothing magical about, but it can still be a nice feature from time to time. 

Later sections in this text will describe the most used of these common operations.
 * </pre>
 */
public class AllCollectionsDemo {

	public static void main(String[] args) {
		Collection colA = new ArrayList();
		Collection colB = new ArrayList();

		colA.add("A");
		colA.add("B");
		colA.add("C");

		colB.add("1");
		colB.add("2");
		colB.add("3");

		System.out.println(colA);
		System.out.println(colB);
		Collection target = new HashSet();

		target.addAll(colA); // target now contains [A,B,C]
		target.addAll(colB); // target now contains [A,B,C,1,2,3]

		System.out.println(target);

		/**
		 * The Java Collection retainAll() does the opposite of removeAll(). Instead of
		 * removing all the elements found in the parameter Collection, it keeps all
		 * these elements, and removes all other elements.
		 */
		target.retainAll(colB); // target now contains [1,2,3]
		System.out.println(target);

		target.removeAll(colB); // target now contains [1,2,3]
		System.out.println(target);
	}

}

class CollectionsDemo {
	public static void main(String[] args) {
		/**
		 * The Java Collections class, java.util.Collections, contains a long list of
		 * utility methods for working with collections in Java. In this Collections
		 * tutorial I will go through some of the most useful of these methods.
		 */
		List<String> list = new ArrayList<>();

		Collections.addAll(list, "element 1", "element 2", "element 3");
		System.out.println(list);

		System.out.println("\nbinarySearch()");
		list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		System.out.println(list);

		Collections.sort(list);
		int index = Collections.binarySearch(list, "four");
		System.out.println(index);

		Collections.sort(list, Comparator.reverseOrder());
		System.out.println(list);

		System.out.println("\ncopy()");
		copyEg();

		System.out.println("\nshuffle()");
		Collections.shuffle(list);
		System.out.println(list);

		System.out.println("\nsort():");
		Collections.sort(list);
		System.out.println(list);

		System.out.println("\nmin(), max():");
		String min = (String) Collections.min(list);
		String max = (String) Collections.max(list);
		System.out.println(min + " - " + max);

		String maxRev = (String) Collections.max(list, Comparator.reverseOrder());
		System.out.println("max with Comparator - " + maxRev);

		List<Integer> ints = Arrays.asList(new Integer[] { 4, 5, 6, 66, 7 });
		int min1 = Collections.min(ints);
		int max1 = Collections.max(ints);
		System.out.println(min1 + " - " + max1);

		System.out.println("\nreplaceAll():");
		boolean replacedAny = Collections.replaceAll(list, "four", "dort");
		System.out.println(list);

		System.out.println("\nunmodifiableSet():");
		Set normalSet = new HashSet();
		Set immutableSet = Collections.unmodifiableSet(normalSet);

		List<String> unmodifiableList = Collections.unmodifiableList(list);
		// java.lang.UnsupportedOperationException
		// System.out.println(unmodifiableList.add("try"));
		System.out.println(unmodifiableList);

	}

	static void copyEg() {
		List<String> srclst = new ArrayList<String>(3);
		List<String> destlst = new ArrayList<String>(3);

		// Adding element to srclst
		srclst.add("Ram");
		srclst.add("Gopal");
		srclst.add("Verma");

		// Adding element to destlst
		destlst.add("1");
		destlst.add("2");
		destlst.add("3");

		// printing the srclst
		System.out.println("Value of source list: " + srclst);
		// printing the destlst
		System.out.println("Value of destination list: " + destlst);

		System.out.println("\nAfter copying:\n");
		// copy element into destlst
		Collections.copy(destlst, srclst);

		// printing the srclst
		System.out.println("Value of source list: " + srclst);

		// printing the destlst
		System.out.println("Value of destination list: " + destlst);

		List<String> source = new ArrayList<>(3);
		Collections.addAll(source, "e1", "e2", "e3");

		List<String> destination = new ArrayList<>(3);
		// if we do not provide VALUE to destination, then below ERROR happens
		// destination.add("1");
		// destination.add("2");
		// destination.add("3");

		// Collections.copy(destination, source); //java.lang.IndexOutOfBoundsException:
		System.out.println(source + " -> " + destination);
	}
}

class Car {
	public String brand;
	public String numberPlate;
	public int noOfDoors;

	public Car(String brand, String numberPlate, int noOfDoors) {
		this.brand = brand;
		this.numberPlate = numberPlate;
		this.noOfDoors = noOfDoors;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", numberPlate=" + numberPlate + ", noOfDoors=" + noOfDoors + "]";
	}
}

class SortingLists {
	public static void main(String[] args) {

		List<String> l = new ArrayList<String>();

		l.add("c");
		l.add("b");
		l.add("d");
		l.add("a");

		System.out.println(l);
		/**
		 * When sorting a list like this the elements are ordered according to their
		 * "natural order". For objects to have a natural order they must implement the
		 * interface java.lang.Comparable.
		 */
		Collections.sort(l);
		System.out.println(l);

		/**
		 * Notice how the Collections.sort() method now takes a java.util.Comparator as
		 * parameter in addition to the List.
		 * 
		 * public interface Comparator<T> { int compare(T object1, T object2); }
		 */
		Collections.sort(l, Comparator.reverseOrder());
		System.out.println(l);

		List<Car> carList = new ArrayList<>();

		carList.add(new Car("Volvo V40", "XYZ 201845", 5));
		carList.add(new Car("Citroen C1", "ABC 164521", 4));
		carList.add(new Car("Dodge Ram", "KLM 845990", 2));

		/**
		 * Notice how the Collections.sort() method now takes a java.util.Comparator as
		 * parameter in addition to the List.
		 * 
		 * public interface Comparator<T> { int compare(T object1, T object2); }
		 */
		Comparator<Car> carBrandComparator = new Comparator<Car>() {
			@Override
			public int compare(Car car1, Car car2) {
				return car1.brand.compareTo(car2.brand);
			}
		};

		System.out.println(carList);
		Collections.sort(carList, carBrandComparator);
		System.out.println(carList);

		List<Car> list = new ArrayList<>();

		list.add(new Car("Volvo V40", "XYZ 201845", 5));
		list.add(new Car("Citroen C1", "ABC 164521", 4));
		list.add(new Car("Dodge Ram", "KLM 845990", 2));

		Comparator<Car> carBrandComparatorLambda = (car1, car2) -> car1.brand.compareTo(car2.brand);
		Comparator<Car> carNumberPlatComparatorLambda = (car1, car2) -> car1.numberPlate.compareTo(car2.numberPlate);
		Comparator<Car> carNoOfDoorsComparatorLambda = (car1, car2) -> car1.noOfDoors - car2.noOfDoors;

		System.out.println();
		Collections.sort(list, carBrandComparatorLambda);
		System.out.println(list);
		Collections.sort(list, carNumberPlatComparatorLambda);
		System.out.println(list);
		Collections.sort(list, carNoOfDoorsComparatorLambda);
		System.out.println(list);

	}
}

class MyComparatorImpl implements Comparator<Car> {
	@Override
	public int compare(Car car1, Car car2) {
		return car1.brand.compareTo(car2.brand);
	}
}

class SortedAndNavigableSets {
	public static void main(String[] args) {
		Comparator<Car> comparator = new MyComparatorImpl();
		SortedSet<Car> sortedSet = new TreeSet<>(comparator);
		sortedSet.add(new Car("Volvo V40", "XYZ 201845", 5));
		sortedSet.add(new Car("Citroen C1", "ABC 164521", 4));
		sortedSet.add(new Car("Dodge Ram", "KLM 845990", 2));
		System.out.println(sortedSet);

		Comparator<? super Car> comparator2 = sortedSet.comparator();
		System.out.println("Get comparator: " + comparator2);

		System.out.println("\n Head Set, Tail Set, Sub Set");

		SortedSet<String> sortedSet2 = new TreeSet<>(); // no need Comparator , implements Comparable

		sortedSet2.add("a");
		sortedSet2.add("b");
		sortedSet2.add("c");
		sortedSet2.add("d");
		sortedSet2.add("e");
		System.out.println(sortedSet2);

		SortedSet headSet = sortedSet2.headSet("c");
		System.out.println(headSet);

		SortedSet tailSet = sortedSet2.tailSet("c");
		System.out.println(tailSet);

		SortedSet subSet = sortedSet2.subSet("c", "e");
		System.out.println(subSet);

		NavigableSet original = new TreeSet();
		original.add("1");
		original.add("2");
		original.add("3");
		original.add("4");
		System.out.println(original);
		NavigableSet reverse = original.descendingSet();
		System.out.println(reverse);

		System.out.println("\n ceiling(), floor(), higher(), lower(), pollFirst(), pollLast()");
		System.out.println(original);
		// ceiling will be "2".
		/**
		 * The ceiling() method returns the least (smallest) element in this set that is
		 * greater than or equal to the element passed as parameter to the ceiling()
		 * method.
		 */
		Object ceiling = original.ceiling("2");
		System.out.println(ceiling);

		// floor will be "2".
		/**
		 * The floor() method does the opposite of the ceiling() method, meaning it
		 * returns the greatest element that is less than or equal to the given
		 * parameter value.
		 */
		Object floor = original.floor("2");
		System.out.println(floor);

		// higher will be "3".
		/**
		 * The higher() method returns the least (smallest) element in this set that is
		 * greater than (not equal too) the element passed as parameter to the higher()
		 * method.
		 */
		Object higher = original.higher("2");
		System.out.println(higher);

		// lower will be "1"
		/**
		 * The lower() method does the opposite of the higher() method, meaning it
		 * returns the highest element that is less than (not equal to) the given
		 * parameter.
		 */
		Object lower = original.lower("2");
		System.out.println(lower);

		// first is "1"
		/**
		 * The pollFirst() method returns and removes the "first" element in the
		 * NavigableSet or null if the set is empty.
		 */
		Object first = original.pollFirst();
		System.out.println(first);

		// last is "3"
		/**
		 * The pollLast() method returns and removes the "last" element in the
		 * NavigableSet. "Last" means largest according to the element sorting order of
		 * the set.
		 */
		Object last = original.pollLast();
		System.out.println(last);

		System.out.println(original);

	}

}

/**
 * Desc
 *
 * <pre>
*The Java Map interface had a few functional operations added from Java 8. These functional operations make it possible to interact with a Map in a more functional style. For instance, you pass a Java Lambda Expression as parameter to these functional style methods. You can read more about functional programming in my tutorial about Java Functional Programming .

The functional operation methods are:

compute()
computeIfAbsent()
computeIfPresent()
merge()
Each of these functional methods will be described in more detail in the following sections.
 * </pre>
 */
class FunctionalOperationsInJavaMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		map.put("one", "first");
		map.put("two", "second");
		map.put("three", "third");

		Iterator iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			Object value = map.get(key);
		}

		for (Object key : map.keySet()) {
			Object value = map.get(key);
		}

		Stream<String> stream = map.keySet().stream();
		stream.forEach((value) -> {
			System.out.println(value);
		});

		/// on values access
		iterator = map.values().iterator();
		while (iterator.hasNext()) {
			Object nextValue = iterator.next();
		}

		for (Object value : map.values()) {
			System.out.println(value);
		}

		stream = map.values().stream();
		stream.forEach((value) -> {
			System.out.println(value);
		});

		/// on entrySet
		Set entries = map.entrySet();
		iterator = entries.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
		}

		for (Object entryObj : map.entrySet()) {
			Map.Entry entry = (Map.Entry) entryObj;
			Object key = entry.getKey();
			Object value = entry.getValue();
		}

		/**
		 * The functional operation methods are:
		 * 
		 * compute()
		 * 
		 * computeIfAbsent()
		 * 
		 * computeIfPresent()
		 * 
		 * merge()
		 */
		System.out.println("\n Functional Operations in Java Map");
		map.compute("one", (key, value) -> value == null ? null : value.toString().toUpperCase());
		map.compute("three", (key, value) -> value == null ? null : value.toString().substring(2));
		System.out.println(map);

		map.computeIfAbsent("ones", (key) -> "abc");
		System.out.println(map);

		map.computeIfPresent("one", (key, value) -> value == null ? null : value.toString().toLowerCase());
		System.out.println(map);

		map.merge("one", "XYZ", (oldValue, newValue) -> newValue + "-abc" + oldValue);
		System.out.println(map);

	}
}

// http://tutorials.jenkov.com/java-collections/navigablemap.html
class SortedAndNavigableMaps {
	public static void main(String[] args) {

		SortedMap sortedMap = new TreeMap();

		sortedMap.put("a", "one");
		sortedMap.put("b", "two");
		sortedMap.put("c", "three");

		Iterator iterator = ((TreeMap) sortedMap).descendingKeySet().iterator();

		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			String value = (String) sortedMap.get(key);
			System.out.println("(" + key + "," + value + ")");
		}

		SortedMap headMap = sortedMap.headMap("c");
		System.out.println(headMap);
		SortedMap tailMap = sortedMap.tailMap("c");

		System.out.println(tailMap);
		SortedMap subMap = sortedMap.subMap("b", "e");
		System.out.println(subMap);

		NavigableMap original = new TreeMap();
		original.put("a", "1");
		original.put("c", "3");
		original.put("e", "5");
		original.put("d", "4");
		original.put("b", "2");

		// ceilingKey will be "2".
		Object ceilingKey = original.ceilingKey("2");
		System.out.println(ceilingKey);

		// floorKey will be "2".
		Object floorKey = original.floorKey("2");
		System.out.println(floorKey);

		// higherKey will be "3".
		Object higherKey = original.higherKey("2");
		System.out.println(higherKey);

		// lowerKey will be "1"
		Object lowerKey = original.lowerKey("2");
		System.out.println(lowerKey);

		System.out.println("\n celingEntry(), floorEntry(), higherEntry(), lowerEntry()");
		// ceilingEntry will be ("c", "3").
		Map.Entry ceilingEntry = original.ceilingEntry("c");
		System.out.println(ceilingEntry);

		// floorEntry will be ("c, "3").
		Map.Entry floorEntry = original.floorEntry("c");
		System.out.println(floorEntry);

		// higherEntry will be ("d", "4").
		Map.Entry higherEntry = original.higherEntry("c");
		System.out.println(higherEntry);

		// lowerEntry will be ("a", "1")
		Map.Entry lowerEntry = original.lowerEntry("b");
		System.out.println(lowerEntry);

		// first is ("a", "1")
		Map.Entry first = original.pollFirstEntry();
		System.out.println(first);

		// first is ("e", "5")
		Map.Entry last = original.pollLastEntry();
		System.out.println(last);

	}
}

class StackDemo {
	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.push("1");
		stack.push("3");
		stack.push("2");
		System.out.println(stack);

		int index = stack.search("3"); // index = 1

		stack = new Stack();

		stack.push("123");
		stack.push("456");
		stack.push("789");

		Iterator iterator = stack.iterator();
		while (iterator.hasNext()) {
			Object value = iterator.next();
			System.out.println(value);
		}

		Stream stream = stack.stream();

		stream.forEach((element) -> {
			System.out.println(element); // print element
		});

		List list = new ArrayList();
		list.add("A");
		list.add("B");
		list.add("C");
		System.out.println(list);

		stack = new Stack();
		while (list.size() > 0) {
			stack.push(list.remove(0));
		}

		while (stack.size() > 0) {
			list.add(stack.pop());
		}

		System.out.println(list);
	}

}
