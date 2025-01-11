package best.practices.lambdas.and.streams.not.doneyet;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.fail;

class FunctionalOperationsInJavaMapTest {

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
	@Test
	void test() {
		fail("Not yet implemented");
	}

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
