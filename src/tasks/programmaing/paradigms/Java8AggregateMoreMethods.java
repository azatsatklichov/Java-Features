package tasks.programmaing.paradigms;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8AggregateMoreMethods {

    /**
     * Map and flatMap
     * 
     * <pre>
     * What Is the Difference Between Map and flatMap Stream Operation?
    There is a difference in signature between map and flatMap. Generally speaking, 
    a map operation wraps its return value inside its ordinal type while flatMap does not.
    
    For example, in Optional, a map operation would return Optional<String> type while 
    flatMap would return String type.
    
    So after mapping, one needs to unwrap (read “flatten”) the object to retrieve the value 
    whereas, after flat mapping, there is no such need as the object is already flattened. 
    The same concept is applied to mapping and flat mapping in Stream.
    
    
    Both map and flatMap are intermediate stream operations that receive a function and apply 
    this function to all elements of a stream.
    
    The difference is that for the map, this function returns a value, but for flatMap, this 
    function returns a stream. The flatMap operation “flattens” the streams into one.
    
    Here's an example where we take a map of users' names and lists of phones and “flatten” 
    it down to a list of phones of all the users using flatMap:
     * </pre>
     */
    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones2 = people.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(phones2);

        Stream<String> flatMap = people.values().stream().flatMap(x -> x.stream());
        flatMap.forEach(System.out::println);
    }
}

/**
 * What Is Stream Pipelining in Java 8? Stream pipelining is the concept of
 * chaining operations together. This is done by splitting the operations that
 * can happen on a stream into two categories: intermediate operations and
 * terminal operations.
 * 
 * Each intermediate operation returns an instance of Stream itself when it
 * runs, an arbitrary number of intermediate operations can, therefore, be set
 * up to process data forming a processing pipeline.
 * 
 * There must then be a terminal operation which returns a final value and
 * terminates the pipeline.
 * 
 * @author ASUS
 *
 */
class StreamPipelining {

}

/**
 * Tell Us About the New Date and Time API in Java 8 A long-standing problem for
 * Java developers has been the inadequate support for the date and time
 * manipulations required by ordinary developers.
 * 
 * The existing classes such as java.util.Date and SimpleDateFormatter aren’t
 * thread-safe, leading to potential concurrency issues for users.
 * 
 * Poor API design is also a reality in the old Java Data API. Here's just a
 * quick example – years in java.util.Date start at 1900, months start at 1, and
 * days start at 0 which is not very intuitive.
 * 
 * These issues and several others have led to the popularity of third-party
 * date and time libraries, such as Joda-Time.
 * 
 * In order to address these problems and provide better support in JDK, a new
 * date and time API, which is free of these problems, has been designed for
 * Java SE 8 under the package java.time.
 *
 */
class DateTime {

}

@FunctionalInterface
interface ShortToByteFunction {

    byte applyAsByte(short s);

}

class FunInterfaces {

    static byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsByte(array[i]);
        }
        return transformedArray;
    }

    public static void main(String[] args) {
        short[] array = { (short) 1, (short) 2, (short) 3 };
        byte[] transformedArray = transformArray(array, s -> (byte) (s * 2));

        byte[] expectedArray = { (byte) 2, (byte) 4, (byte) 6 };
        System.out.println(expectedArray == transformedArray);
        
    }
}