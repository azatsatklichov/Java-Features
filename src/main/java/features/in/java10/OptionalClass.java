package features.in.java10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Optional*.orElseThrow()
 *
 * <pre>
 * orElseThrow -  java.util.Optional, java.util.OptionalDouble, java.util.OptionalInt and java.util.OptionalLong each got
 * a new method orElseThrow()
 * which doesn�t take any argument and throws NoSuchElementException if no value is present:
 *
 * It�s synonymous with and is now the preferred alternative to the existing get()method.
 * </pre>
 */
public class OptionalClass {

    @Test
    public void orElseThrowValueTest() {
        List<Integer> ints = List.of(1, 12, 6, -9);
        Integer firstEven = ints.stream().filter(i -> i % 2 == 0).findFirst().orElseThrow();
        assertEquals(firstEven, Integer.valueOf(12));

        OptionalInt opInt = OptionalInt.of(12345);
        System.out.println("int Valuevia " + " orElseThrow() = " + opInt.orElseThrow());

        // OptionalDouble
        IntStream.of(1, 2, 3).average().orElseThrow(() -> new IllegalArgumentException("Array is empty"));
        //IntStream.of().average().orElseThrow(() -> new IllegalArgumentException("Array is empty"));
    }

    @Test
    public void orElseThrowExceptionTest() throws NoSuchElementException {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            List<Integer> ints = List.of(1, -19, 19);
            Integer firstEven = ints.stream().filter(i -> i % 2 == 0).findFirst().orElseThrow();
            assertEquals(firstEven, Integer.valueOf(12));
        });

    }

    @Test
    public void orElseThrowExceptionTest2() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            OptionalDouble empty = OptionalDouble.empty();
            double num = empty.orElseThrow(IllegalArgumentException::new);
            System.out.println(num);
        });
    }
}
