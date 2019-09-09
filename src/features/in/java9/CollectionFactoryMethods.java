package features.in.java9;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class OldWayOfCreationOrConversion {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		set = Collections.unmodifiableSet(set);
		System.out.println(set);
		List<String> list = new ArrayList<>();

		list.add("A");
		list.add("B");
		list.add("C");
		list = Collections.unmodifiableList(list);
		System.out.println(list);
		Map<String, String> map = new HashMap<>();

		map.put("A", "Apple");
		map.put("B", "Boy");
		map.put("C", "Cat");
		map = Collections.unmodifiableMap(map);
		System.out.println(map);

		List<Integer> integers = Arrays.asList(2, 4, 1, 3, 8, 4, 7, 5, 9, 6, 8);
		System.out.println(integers);

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println(strings);

		strings = Collections.singletonList(new String("ds"));
		System.out.println(strings);

		// Java 8:
		Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");
        List<String> result = language.collect(Collectors.toList());
        System.out.println(result);
        
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		stream.forEach(p -> System.out.println(p));

		stream = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		stream.forEach(p -> System.out.println(p));

		Integer[] arr = new Integer[] { 1, 2, 3 };
		List<Integer> intList = Arrays.asList(arr);
		// or inverse
		Integer[] targetArray = intList.toArray(new Integer[intList.size()]);

		// above in Java 8, creation of unnecessary objects and this method can't be
		// used for creating a Map.
		stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> numbersList = stream.collect(Collectors.toList());
		System.out.println(numbersList);
		

		stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> evenNumbersList = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(numbersList);

		// Java 8, convert array to List, primitive int[] to List<Integer>
		int iArray[] = new int[] { 1, 2, 3 };
		List<Integer> list3 = Arrays.stream(iArray).boxed().collect(Collectors.toList());

		stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Integer[] evenNumbersArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);

	}
}

/**
 * Desc New Methods
 *
 * <pre>
*
*With Java 9, new factory methods are added to List, Set and Map interfaces to create immutable instances. 
*These factory methods are convenience factory methods to create a collection in less verbose and in concise way.
*
*
With java 9, following methods are added to List, Set and Map interfaces along with their overloaded counterparts.

static <E> List<E> of(E e1, E e2, E e3);
static <E> Set<E>  of(E e1, E e2, E e3);
static <K,V> Map<K,V> of(K k1, V v1, K k2, V v2, K k3, V v3);
static <K,V> Map<K,V> ofEntries(Map.Entry<? extends K,? extends V>... entries)


Points to Note
For List and Set interfaces, of(...) method is overloaded to have 0 to 10 parameters and one with var args parameter.

For Map interface, of(...) method is overloaded to have 0 to 10 parameters.

In case of more than 10 paramters for Map interface, ofEntries(...) method can be used accepting var args parameter.
 * </pre>
 */
public class CollectionFactoryMethods {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Plain JAVA, Apache Collection, Guava, Java 8, Java 9 ... ");

		// Set<String> set = Set.of("A", "B", "A", "B", "C"); Exception in thread "main"
		// java.lang.IllegalArgumentException: duplicate element: A
		Set<String> set = Set.of("A", "B", "A2", "B2", "C", "c", "C", null);
		System.out.println(set);

		set = Set.of("A", "B", "A2", "B2", "C", "D", "E", "F", "G", "H", "I", "zz", "PP");
		System.out.println(set);

		List<String> list = List.of("A", "B", "A", "B", "C");
		System.out.println(list);
		
		List<String> emptyList = List.of();
		System.out.println(emptyList);

		list.add("OO"); //It is unmodifiable, UnsupportedOperationException
		System.out.println(list);
		
		Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");


		Map emptyImmutableMap = Map.of();
		// emptyImmutableMap ==> {}

		Map<Integer, String> map = Map.of(1, "Ole", 3, "Gule", 5, "Sule");
		// Map<Integer, String> map = Map.of("Bir", "Ole", "Uc", "Gule", "Bas", "Sule");

		// compile issue
		System.out.println(map);
		Map<String, String> map1 = Map.ofEntries(new AbstractMap.SimpleEntry<>("A", "Apple"),
				new AbstractMap.SimpleEntry<>("B", "Boy"), new AbstractMap.SimpleEntry<>("C", "Cat"));
		System.out.println(map1);

		Map<String, Long> age = Map.of("Bruce", 59L, "Steve", 61L, "Dave", 60L, "Adrian", 60L, "Janick", 60L, "Nicko",
				65L);
		System.out.println(age);

		Map<String, String> addr = Map.of("Bruce", "US", "Steve", "RU", "Dave", "PL", "Adrian", "TR", "Janick", "CZ");
		System.out.println(addr);

		age = Map.ofEntries(Map.entry("Bruce", 59L), Map.entry("Steve", 61L), Map.entry("Dave", 60L),
				Map.entry("Adrian", 60L), Map.entry("Janick", 60L), Map.entry("Nicko", 65L));
		System.out.println(age);

		System.out.println(" From Java 9, we have yet another entry's package private implementation "
				+ "—  java.util.KeyValueHolder — an immutable container that prevents instantiating an "
				+ "entry with a key or value equal to null ");

		// throws NullPointerExcepton because of null key
		age = Map.of(null, 59L, "Steve", 61L);
		// throws NullPointerExcepton because of null value
		age = Map.of("Bruce", null, "Steve", 61L);
		// throws NullPointerExcepton because of null entry
		age = Map.ofEntries(Map.entry("Bruce", 59L), null);
		// we cannot create a map with duplicate values
		age = Map.ofEntries(Map.entry("Bruce", 59L), Map.entry("Bruce", 59L));

		// NPE
		Map<Integer, String> map2 = Map.of(1, "value1", 2, "value2", 3, "value3", 4, null);

		/**
		 * Allowing null in collections is by now seen as a design error.
		 * 
		 * Reasons. - A good one is usability, where the most prominent trouble maker is
		 * Map::get. If it returns null, it is unclear whether the key is missing or the
		 * value was null.
		 * 
		 * - Implementation-wise, they also require less special casing, making the code
		 * easier to maintain and more performant.
		 * 
		 * - Null elements, keys, and values will be disallowed. (No recently introduced
		 * collections have supported nulls.) In addition, prohibiting nulls offers
		 * opportunities for a more compact internal representation, faster access, and
		 * fewer special cases.
		 */
		System.out.println("creting mutable collection using read-only approach");
		Map<Integer, String> mapp = new HashMap<Integer, String>(Map.of(1, "value1", 2, "value2", 3, "value3"));
		mapp.put(4, null);
		System.out.println(mapp);

	}
}
