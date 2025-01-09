package best.practices.lambdas.and.streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Java Stream API provides a more functional programming approach to
 * iterating and processing elements of e.g. a collection.
 * 
 * Streams are designed to work with Java lambda expressions.
 * 
 * <pre>
     * Stream Processing Phases
     * 
    Once you have obtained a Stream instance from a Collection instance, you use that stream 
    to process the elements in the collection.
    
    Processing the elements in the stream happens in two steps / phases:
    
    Configuration
    Processing
    
    First the stream is configured. The configuration can consist of filters and mappings. 
    These are also referred to as non-terminal operations.
 * </pre>
 */
public class Streams {

    // http://tutorials.jenkov.com/java-functional-programming/index.html
    // http://tutorials.jenkov.com/java-collections/streams.html
    public static void main(String[] args) {
        List<String> items = new ArrayList<String>();

        items.add("one");
        items.add("two");
        items.add("three");

        long count = items.stream().filter(item -> item.startsWith("t")).count();
        System.out.println(count);

        // EPAM like question
        String shortest = items.stream().min(Comparator.comparing(item -> item.length())).get();
        System.out.println(shortest);

        System.out.println();

        items.add(null);
        System.out.println("Stream.reduce()");
        String reduced2 = items.stream().reduce((acc, item) -> acc + " # " + item).get();
        System.out.println(reduced2);

        /**
         * The reduce() method taking a BinaryOperator as parameter returns an Optional
         * . In case the stream contains no elements, the Optional.get() returns null.
         * 
         * There is another reduce() method which takes two parameters. It takes an
         * initial value for the accumulated value, and then a BinaryOperator.
         */
        String reduced = items.stream().reduce("", (acc, item) -> acc + " # " + item);
        System.out.println(reduced);

        List<Integer> ints = Arrays.asList(new Integer[] { 34, 5, -5, 55, 6 });
        Integer min = ints.stream().min(Comparator.comparing(item -> item)).get();
        System.out.println(min);

        Integer max = ints.stream().max(Comparator.comparing(item -> item)).get();
        System.out.println(max);

    }

}

class StreamApi {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();

        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");

        Stream<String> stream = stringList.stream();

        long count = stream.map((value) -> {
            return value.toLowerCase();
        }).count();

        System.out.println("count = " + count);

        System.out.println(
                "The non-terminal stream operations of the Java Stream API are operations that transform or filter the elements in the stream.");
        stringList.stream().map((value) -> {
            return value.toLowerCase();
        });
        // or
        List<String> collect = stringList.stream().map((value) -> value.toLowerCase()).collect(Collectors.toList());

        Stream<String> longStringsStream = stringList.stream().filter((value) -> {
            return value.length() >= 3;
        });

        List<String> collect2 = stringList.stream().filter((value) -> value.length() > 3).collect(Collectors.toList());

        /**
         * flatMap()
         * 
         * The Java Stream flatMap() methods maps a single element into multiple
         * elements. The idea is that you "flatten" each element from a complex
         * structure consisting of multiple internal elements, to a "flat" stream
         * consisting only of these internal elements.
         */

        List<String> stringList2 = new ArrayList<String>();

        stringList2.add("One flew over the cuckoo's nest");
        stringList2.add("To kill a muckingbird");
        stringList2.add("Gone with the wind");

        Stream<String> stream2 = stringList2.stream();

        stream2.flatMap((value) -> {
            String[] split = value.split(" ");
            return (Stream<String>) Arrays.asList(split).stream();
        }).forEach((value) -> System.out.println(value));

        List<String> stringList3 = new ArrayList<String>();

        stringList3.add("abc");
        stringList3.add("def");

        Stream<String> stream3 = stringList.stream();
        System.out.println();

        /**
         * The Java Stream peek() method is a non-terminal operation that takes a
         * Consumer (java.util.function.Consumer) as parameter.
         */
        Stream<String> streamPeeked3 = stream3.peek((value) -> {
            System.out.println("value");
        });

        boolean anyMatch = stringList.stream().anyMatch((value) -> {
            return value.startsWith("One");
        });
        System.out.println(anyMatch);

        boolean allMatch = stringList.stream().allMatch((value) -> {
            return value.startsWith("One");
        });
        System.out.println(allMatch);

        boolean noneMatch = stringList.stream().noneMatch((value) -> {
            return value.startsWith("Onew");
        });
        System.out.println(noneMatch);

        // find any
        /**
         * The element found can be from anywhere in the Stream. There is no guarantee
         * about from where in the stream the element is taken.
         */
        Optional<String> anyElement = stringList.stream().findAny();
        System.out.println(anyElement.get());

        Optional<String> findFirst = stringList.stream().findFirst();
        System.out.println(findFirst.get());

        Optional<String> minElement = stringList.stream().min((val1, val2) -> {
            return val1.compareTo(val2);
        });
        System.out.println(minElement.get());

        List<Integer> ints = Arrays.asList(new Integer[] { 34, 5, -5, 55, 6 });
        Integer min = ints.stream().min(Comparator.comparing(item -> item)).get();
        System.out.println(min);

        // array
        Object[] array = stringList2.stream().filter(x -> x != null).toArray();
        System.out.println(Arrays.toString(array));

        System.out.println("\n  -- Concatenate Streams --");
        stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        stringList2 = new ArrayList<>();
        stringList2.add("Lord of the Rings");
        stringList2.add("Planet of the Rats");
        stringList2.add("Phantom Menace");

        Stream<String> concatStream = Stream.concat(stringList.stream(), stringList2.stream());
        List<String> stringsAsUppercaseList = concatStream.collect(Collectors.toList());

        System.out.println(stringsAsUppercaseList);

        System.out.println("\n Create Stream From Array");
        Stream<String> streamOf = Stream.of("one", "two", "three");
        streamOf.forEach(System.out::println);

        System.out.println("Critique");
        /**
         * Java Stream API Critique Having worked with other data streaming API's like
         * the Apache Kafka Streams API, I have a bit of critique of the Java Stream API
         * that I will share with you. They aren't big, important points of critique,
         * but they are useful to have in the back of your head as you venture into
         * stream processing.
         */

    }
}
