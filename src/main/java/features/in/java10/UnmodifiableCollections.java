package features.in.java10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 * here are a couple of changes related to unmodifiable collections in Java 10.
 * </pre>
 */
public class UnmodifiableCollections {

    /**
     * Desc: 3.1. copyOf()
     *
     * <pre>
     *
     * java.util.List, java.util.Map and java.util.Set each got a new static method copyOf(Collection).
     *
     * It returns the unmodifiable copy of the given Collection:
     *
     * Any attempt to modify such a collection would result in java.lang.UnsupportedOperationExceptionruntime exception.
     *
     * </pre>
     */
    @Test
    public void whenModifyCopyOf_thenThrowsException() throws UnsupportedOperationException {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            System.out.println();
            Map<String, Long> agesMap = Map.of("Bruce", 59L, "Steve", 61L, "Dave", 60L, "Adrian", 60L, "Janick", 60L, "Nicko",
                    65L);
            System.out.println(agesMap);
            Map<String, Long> agesMap2 = Map.copyOf(agesMap);
            System.out.println(agesMap2);

            Set<String> set = Set.of("Q", "V", "E", "R", "T", "Y");
            System.out.println(set);
            Set<String> set2 = Set.copyOf(set);
            System.out.println(set2);

            List<String> list = List.of("A", "B", "A", "B", "C");
            System.out.println(list);
            list.add("gg");
            List<String> copyList = List.copyOf(list);//
            System.out.println(copyList);
            copyList.add("Z");
        });
    }

    /**
     * 3.2. toUnmodifiable*()
     *
     * <pre>
     *
     * java.util.stream.Collectors get additional methods to collect a Stream into unmodifiable List, Map or Set:
     *
     * Any attempt to modify such a collection would result in java.lang.UnsupportedOperationExceptionruntime exception.
     * </pre>
     */
    @Test
    public void whenModifyToUnmodifiableList_thenThrowsException() throws UnsupportedOperationException {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> ints = List.of(1, 12, 6, -9);
            List<Integer> evenList = ints.stream().filter(i -> i % 2 == 0).collect(Collectors.toUnmodifiableList());
            System.out.println(evenList);
            evenList.add(4);//
        });
    }

}
