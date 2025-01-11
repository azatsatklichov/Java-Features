package best.practices.lambdas.and.streams;

import java.util.*;

public class StreamParallelism {

    public static void main(String[] args) {

            System.out.println("Pipelines and Streams");
            System.out.println("A pipeline is a sequence of aggregate operations. ");

            System.out.println("\nDifferences Between Aggregate Operations and Iterators");
            System.out.println(
                    "Aggregate operations, like forEach, appear to be like iterators. However, they have several fundamental differences:");
            /**
             * <pre>
             * 		 *

             They use internal iteration: Aggregate operations do not contain a method like next to instruct them to process the next element
             of the collection. With internal delegation, your application determines what collection it iterates, but the JDK determines how to
             iterate the collection. With external iteration, your application determines both what collection it iterates and how it iterates it.
             However, external iteration can only iterate over the elements of a collection sequentially. Internal iteration does not have this limitation.
             It can more easily take advantage of parallel computing, which involves dividing a problem into subproblems, solving those problems simultaneously,
             and then combining the results of the solutions to the subproblems. See the section Parallelism for more information.


             They process elements from a stream: Aggregate operations process elements from a stream, not directly from a collection. Consequently, they are
             also called stream operations.


             They support behavior as parameters: You can specify lambda expressions as parameters for most aggregate operations. This enables you to customize
             the behavior of a particular aggregate operation.
             * </pre>
             */

            System.out.println("\n Reduction");
            // https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html

            System.out.println("\nParallelism");
            // https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html
            /**
             * Parallelism Parallel computing involves dividing a problem into subproblems,
             * solving those problems simultaneously (in parallel, with each subproblem
             * running in a separate thread), and then combining the results of the
             * solutions to the subproblems. Java SE provides the fork/join framework, which
             * enables you to more easily implement parallel computing in your applications.
             * However, with this framework, you must specify how the problems are
             * subdivided (partitioned). With aggregate operations, the Java runtime
             * performs this partitioning and combining of solutions for you.
             *
             * <pre>
             * This example does the following:

             The first pipeline prints the elements of the list listOfIntegers in the order that they were added to the list.

             The second pipeline prints the elements of listOfIntegers after it was sorted by the method Collections.sort.

             The third and fourth pipelines print the elements of the list in an apparently random order. Remember that stream operations use internal iteration when
             processing elements of a stream. Consequently, when you execute a stream in parallel, the Java compiler and runtime determine the order in which to process
             the stream's elements to maximize the benefits of parallel computing unless otherwise specified by the stream operation.

             The fifth pipeline uses the method forEachOrdered, which processes the elements of the stream in the order specified by its source, regardless of
             whether you executed the stream in serial or parallel. Note that you may lose the benefits of parallelism if you use operations like forEachOrdered with parallel streams.
             * </pre>
             */
            System.out.println("Ordering");
            Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
            List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

            System.out.println("listOfIntegers:");
            listOfIntegers.stream().forEach(e -> System.out.print(e + " "));
            System.out.println("");

            System.out.println("listOfIntegers sorted in reverse order:");
            Comparator<Integer> normal = Integer::compare;
            Comparator<Integer> reversed = normal.reversed();
            Collections.sort(listOfIntegers, reversed);
            listOfIntegers.stream().forEach(e -> System.out.print(e + " "));
            System.out.println("");

            System.out.println("Parallel stream");
            listOfIntegers.parallelStream().forEach(e -> System.out.print(e + " "));
            System.out.println("");

            System.out.println("Another parallel stream:");
            listOfIntegers.parallelStream().forEach(e -> System.out.print(e + " "));
            System.out.println("");

            System.out.println("With forEachOrdered:");
            listOfIntegers.parallelStream().forEachOrdered(e -> System.out.print(e + " "));
            System.out.println("");

            System.out.println("\n All intermediate operations are lazy.");

    }
}
