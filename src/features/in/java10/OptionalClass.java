package features.in.java10;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
 

/**
 * Optional*.orElseThrow()
 * 
 * <pre>
 *java.util.Optional, java.util.OptionalDouble, java.util.OptionalIntand java.util.OptionalLongeach got a new method orElseThrow()
 *which doesn’t take any argument and throws NoSuchElementExceptionif no value is present:
 *
 *It’s synonymous with and is now the preferred alternative to the existing get()method.
 * </pre>
 */
public class OptionalClass {
	@Test
	public void whenListContainsInteger_OrElseThrowReturnsInteger() {
		List<Integer> ints = List.of(1, 12, 6, -9);
		Integer firstEven = ints.stream().filter(i -> i % 2 == 0).findFirst().orElseThrow();
		assertEquals(firstEven, Integer.valueOf(12)); 
	}
}
