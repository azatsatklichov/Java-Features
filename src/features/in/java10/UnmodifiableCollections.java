package features.in.java10;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
 
 


/**
 * 
 * <pre>
*here are a couple of changes related to unmodifiable collections in Java 10.
 * </pre>
 */
public class UnmodifiableCollections {

	/**
	 * Desc: 3.1. copyOf()
	 * 
	 * <pre>
	* 
	java.util.List, java.util.Map and java.util.Set each got a new static method copyOf(Collection).
	
	It returns the unmodifiable copy of the given Collection:
	
	Any attempt to modify such a collection would result in java.lang.UnsupportedOperationExceptionruntime exception.
	 *
	 * </pre>
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void whenModifyCopyOfList_thenThrowsException() {
		List<String> list = List.of("A", "B", "A", "B", "C");
		List<String> copyList = List.copyOf(list);
		System.out.println(copyList);
		copyList.add("Z");
	}

	/**
	 * 3.2. toUnmodifiable*()
	 * 
	 * <pre>
	*
	java.util.stream.Collectors get additional methods to collect a Stream into unmodifiable List, Map or Set:
	
	Any attempt to modify such a collection would result in java.lang.UnsupportedOperationExceptionruntime exception.
	 * </pre>
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void whenModifyToUnmodifiableList_thenThrowsException() {
		List<Integer> ints = List.of(1, 12, 6, -9);
		List<Integer> evenList = ints.stream().filter(i -> i % 2 == 0).collect(Collectors.toUnmodifiableList());
		System.out.println(evenList);
		evenList.add(4);
	}

}
