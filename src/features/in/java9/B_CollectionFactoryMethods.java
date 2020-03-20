package features.in.java9;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Desc New Methods
 *
 * <pre>
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
public class B_CollectionFactoryMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Internally All these factory methods use ImmutableCollections$List, $set...
		 * 
		 * ImmutableCollections.ListN<>(e1, e2, e3, e4, e5);
		 * ImmutableCollections.SetN<>(e1, e2, e3, e4, e5); ImmutableCollections.MapN
		 */

		// Set<String> set = Set.of("A", "B", "A", "B", "C"); Exception in thread "main"
		// java.lang.IllegalArgumentException: duplicate element: A
		Set<String> set = Set.of("A", "B", "A2", "B2", "C");
		System.out.println(set);

		List<String> list = List.of("A", "B", "A", "B", "C");
		System.out.println(list);

		Map<Integer, String> map = Map.of(1, "Ole", 3, "Gule", 5, "Sule");
		// # of parameters Must be EVEN number
		// Map<Integer, String> mapOdd = Map.of(1, "Ole", 3);

		// Map<Integer, String> map = Map.of("Bir", "Ole", "Uc", "Gule", "Bas", "Sule");
		// compile issue
		System.out.println(map);
		Map<String, String> map1 = Map.ofEntries(new AbstractMap.SimpleEntry<>("A", "Apple"),
				new AbstractMap.SimpleEntry<>("B", "Boy"), new AbstractMap.SimpleEntry<>("C", "Cat"));
		System.out.println(map1);
	}

}

class OldWayOfCreation {
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
	}
}