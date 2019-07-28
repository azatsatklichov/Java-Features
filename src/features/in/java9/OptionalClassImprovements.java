package features.in.java9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Desc
 *
 * <pre>
*Optional Class was introduced in Java 8 to avoid null checks and NullPointerException issues. 
*
*In java 9, three new methods are added to improve its functionality.

stream() - If a value is present, it returns a sequential Stream containing only that value, otherwise returns an empty Stream.

ifPresentOrElse() - If a value is present, performs the given action with the value, otherwise performs the given empty-based action.

or() - If a value is present, returns an Optional describing the value, otherwise returns an Optional produced by the supplying function.
 * 
 * </pre>                                                                                                                                                                                                                                                                                                                                   
 */
public class OptionalClassImprovements {
    public static void main(String[] args) {

        List<Optional<String>> list = Arrays.asList(Optional.empty(), Optional.of("A"), Optional.empty(),
                Optional.of("B"));
        System.out.println(list);

        // filter the list based to print non-empty values

        // if optional is non-empty, get the value in stream, otherwise return empty
        List<String> filteredList = list.stream().flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
                .collect(Collectors.toList());

        // Optional::stream method will return a stream of either one
        // or zero element if data is present or not.
        List<String> filteredListJava9 = list.stream().flatMap(Optional::stream).collect(Collectors.toList());

        System.out.println(filteredList);
        System.out.println(filteredListJava9);

        // If a value is present, performs the given action with the value, otherwise
        // performs the given empty-based action.
        Optional<Integer> optional = Optional.of(1);
        optional.ifPresentOrElse(x -> System.out.println("Value: " + x), () -> System.out.println("Not Present."));
        optional = Optional.empty();
        optional.ifPresentOrElse(x -> System.out.println("Value: " + x), () -> System.out.println("Not Present."));

        // OR
        Optional<String> optional1 = Optional.of("Test");
        Supplier<Optional<String>> supplierString = () -> Optional.of("Not Present");
        optional1 = optional1.or(supplierString);
        optional1.ifPresent(x -> System.out.println("Value: " + x));
        optional1 = Optional.empty();
        optional1 = optional1.or(supplierString);
        optional1.ifPresent(x -> System.out.println("Value: " + x));
        
    }

}
