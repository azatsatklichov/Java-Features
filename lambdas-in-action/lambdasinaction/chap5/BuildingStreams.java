package lambdasinaction.chap5;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class BuildingStreams {

    public static void main(String... args) throws Exception {

        List<Integer> nums = Arrays.asList(1, 2, 3, 44, -44, 44, 5, 424, 555);
        nums.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
        System.out.println();

        nums = Arrays.asList(1, 2, 3, 44, -44, 44, 5, 424, 555);
        nums.stream().filter(i -> i % 2 == 0).skip(1).forEach(System.out::println);
        System.out.println();


        // Stream.of
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();
        emptyStream.map(String::toUpperCase).forEach(System.out::println);

        // Arrays.stream
        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());
        System.out.println(Arrays.stream(numbers).min().getAsInt());
        System.out.println(Arrays.stream(numbers).max().getAsInt());

        System.out.println();

        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);

        // fibonnaci with iterate
        System.out.println("-- FIBO by Java 8 --");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        //wonderfull FIBO by Java 8
        Stream<int[]> limit = Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]}).limit(10);
        limit.skip(10).forEach(x -> System.out.println(x[0]));

        System.out.println("----");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        // random stream of doubles with Stream.generate
        Stream.generate(Math::random)
                .limit(7)
                .forEach(System.out::println);

        // stream of 1s with Stream.generate
        IntStream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);

        IntStream.generate(new IntSupplier() {
            public int getAsInt() {
                return 2;
            }
        }).limit(5)
                .forEach(System.out::println);


        System.out.println("-- fib --");
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };


        IntStream.generate(fib).limit(10).forEach(System.out::println);

        long uniqueWords = Files.lines(Paths.get("D:\\U_Mastering\\JavaMasteringIn8911\\src\\lambdasinaction\\chap5\\data.txt"), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();

        System.out.println("There are " + uniqueWords + " unique words in data.txt");
    }
}
