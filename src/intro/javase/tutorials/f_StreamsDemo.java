package intro.javase.tutorials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * STREAMs
 * 
 * <pre>
Stream is a new abstract layer introduced in Java 8. Using stream, you can process data in a declarative way similar to SQL statements. For example, consider the following SQL statement.
SELECT max(salary), employee_id, employee_name FROM Employee

The above SQL expression automatically returns the maximum salaried employee's details, without doing any computation on the developer's end. Using collections 
framework in Java, a developer has to use loops and make repeated checks. Another concern is efficiency; as multi-core processors are available at ease, a 
Java developer has to write parallel code processing that can be pretty error-prone.

To resolve such issues, Java 8 introduced the concept of stream that lets the developer to process data declaratively and leverage multicore architecture 
without the need to write any specific code for it.
 * 
 * 
 * What is Stream?

        Stream represents a sequence of objects from a source, which supports aggregate operations. Following are the characteristics of a Stream −
        
        Sequence of elements − A stream provides a set of elements of specific type in a sequential manner. A stream gets/computes elements on demand. 
        It never stores the elements.
        
        
        Source − Stream takes Collections, Arrays, or I/O resources as input source.
        
        
        Aggregate operations − Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on.
        
        
        Pipelining − Most of the stream operations return stream itself so that their result can be pipelined. These operations are called intermediate 
        operations and their function is to take input, process them, and return output to the target. collect() method is a terminal operation which is 
        normally present at the end of the pipelining operation to mark the end of the stream.
        
        
        Automatic iterations − Stream operations do the iterations internally over the source elements provided, in contrast to Collections 
        where explicit iteration is required.
        
        
        Generating Streams

        With Java 8, Collection interface has two methods to generate a Stream.
        
        stream() − Returns a sequential stream considering collection as its source.
        
        
        parallelStream() − Returns a parallel Stream considering collection as its source.
 * 
 * </pre>
 * 
 */
public class f_StreamsDemo {

	public static void main(String[] args) {
		System.out.println(
				"\nStream is a new abstract layer introduced in Java 8. Using stream, you can process data in a declarative way similar to SQL statements.");
		System.out.println(
				"To resolve such issues, Java 8 introduced the concept of stream that lets the developer to process data declaratively and leverage multicore architecture without the need to write any specific code for it.");
		System.out.println("GOPASda yanymdaky oglan sorapdy, shu STREAM ler PYTHON da yok ");

		System.out.println(
				"\nAggregate operations − Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on.");
		System.out.println();

		System.out.println("Generating Streams - stream() , parallelStream()");
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println(strings);
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println(filtered);

		strings = Arrays.asList("abc", "", "bc", "aefgd", "abcd", "", "jkl");
		System.out.println(strings);
		filtered = strings.stream().filter(string -> !string.startsWith("a")).collect(Collectors.toList());
		System.out.println(filtered);

		filtered = strings.stream().filter(string -> string.startsWith("a") && string.endsWith("d"))
				.collect(Collectors.toList());
		System.out.println(filtered);

		System.out
				.println("\n forEach Stream has provided a new method ‘forEach’ to iterate each element of the stream. "
						+ "\nAlso see Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on.");
		Random random = new Random();
		IntStream ints = random.ints();
		ints.limit(4).forEach(System.out::println);
		System.out.println();

		System.out.println(
				"Gyzyk tarapy, 2018 indi shu Lambda ny dushunip otyryn, Enriandaky Pavel aydanda oncha dushunmandim");

		System.out.println("\nThe ‘map’ method is used to map each element to its corresponding result.");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		// get list of unique squares
		List<Integer> squaresList = numbers.stream().map(i -> i * i).collect(Collectors.toList());
		System.out.println(squaresList);

		squaresList = numbers.stream().map(i -> i * i).distinct().distinct().collect(Collectors.toList());
		System.out.println(squaresList);

		// get list of squares
		squaresList = numbers.stream().map((i) -> i * i).collect(Collectors.toList());
		System.out.println(squaresList);

		System.out.println("\nThe ‘filter’ method is used to eliminate elements based on a criteria. ");
		List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		// get count of empty string
		long count = strings2.stream().filter(str -> str.isEmpty()).count();
		System.out.println(count);
		count = strings2.stream().filter(str -> !str.isEmpty()).count();
		System.out.println(count);

		System.out.println("\nThe ‘limit’ method is used to reduce the size of the stream.");
		random.ints().limit(7).forEach(System.out::println);

		System.out.println("\nThe ‘sorted’ method is used to sort the stream.");
		random.ints().limit(10).sorted().forEach(System.out::println);
		strings2.stream().sorted().forEach(System.out::println);

		System.out.println("\nparallelStream is the alternative of stream for parallel processing. ");
		// get count of empty string
		long count2 = strings2.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println(count2);

		System.out.println(
				"\nCollectors are used to combine the result of processing on the elements of a stream. Collectors can be used to return a list or a string.");

		strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining("; "));
		System.out.println("Merged String: " + mergedString);
		Long collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.counting());
		System.out.println("collect: " + collect);

		System.out.println(
				"\nWith Java 8, statistics collectors are introduced to calculate all statistics when stream processing is being done. ");
		numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());

		System.out.println("-- the end -- ");
		System.exit(0);

	}

}

class Java8TesterSterams {

	public static void main(String args[]) {
		System.out.println("Using Java 7: ");

		// Count empty strings
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println("List: " + strings);
		long count = getCountEmptyStringUsingJava7(strings);

		System.out.println("Empty Strings: " + count);
		count = getCountLength3UsingJava7(strings);

		System.out.println("Strings of length 3: " + count);

		// Eliminate empty string
		List<String> filtered = deleteEmptyStringsUsingJava7(strings);
		System.out.println("Filtered List: " + filtered);

		// Eliminate empty string and join using comma.
		String mergedString = getMergedStringUsingJava7(strings, ", ");
		System.out.println("Merged String: " + mergedString);
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		// get list of square of distinct numbers
		List<Integer> squaresList = getSquares(numbers);
		System.out.println("Squares List: " + squaresList);
		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);

		System.out.println("List: " + integers);
		System.out.println("Highest number in List : " + getMax(integers));
		System.out.println("Lowest number in List : " + getMin(integers));
		System.out.println("Sum of all numbers : " + getSum(integers));
		System.out.println("Average of all numbers : " + getAverage(integers));
		System.out.println("Random Numbers: ");

		// print ten random numbers
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt());
		}

		System.out.println("Using Java 8: ");
		System.out.println("List: " + strings);

		count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("Empty Strings: " + count);

		count = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("Strings of length 3: " + count);

		filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filtered);

		mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);

		squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("Squares List: " + squaresList);
		System.out.println("List: " + integers);

		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		System.out.println("Random Numbers: ");

		random.ints().limit(10).sorted().forEach(System.out::println);

		// parallel processing
		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("Empty Strings: " + count);

		Student student1 = new Student("ads", 32);
		Student student2 = new Student("bds", -32);
		Student student3 = new Student("cds", 132);
		Student student4 = new Student("ads", 32);
		Student student5 = new Student("zds", 55);
		Student student6 = new Student("kds", 72);
		List<Student> stList = new ArrayList<>();
		stList.add(student1);
		stList.add(student2);
		stList.add(student3);
		stList.add(student4);
		stList.add(student5);
		stList.add(student6);

		Set<Student> set = new HashSet<>();
		set.add(student6);
		set.add(student4);
		boolean add = set.add(student6);
		System.out.println(add);

		stList.forEach(item -> System.out.print(item + "; "));
		System.out.println();
		set.forEach(item -> System.out.print(item + "; "));

		System.out.println();
		List<Student> collect = stList.stream().filter(c -> stList.contains("zds")).collect(Collectors.toList());
		System.out.println(collect);

		// stList.stream.filter(c->{users.stream.filter(u->u.getName().equals(c.getName()).count()>0
		// }).collect(Collectors.toList());

		Set<String> setS = new HashSet<>();
		setS.add("ss");
		setS.add("sss");
		add = setS.add("ss");
		setS.add("");
		setS.add(null);
		System.out.println(add);
		System.out.println(setS);
		System.out.println(setS.contains(""));
		System.out.println(setS.contains(null));
		if (setS.contains(null)) {
			System.out.println("INTERESTING null");
		}

	}

	private static class Student {
		String name;
		int id;

		public Student(String name, int id) {
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return name + ": " + id;
		}

	}

	private static int getCountEmptyStringUsingJava7(List<String> strings) {
		int count = 0;

		for (String string : strings) {

			if (string.isEmpty()) {
				count++;
			}
		}
		return count;
	}

	private static int getCountLength3UsingJava7(List<String> strings) {
		int count = 0;

		for (String string : strings) {

			if (string.length() == 3) {
				count++;
			}
		}
		return count;
	}

	private static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
		List<String> filteredList = new ArrayList<String>();

		for (String string : strings) {

			if (!string.isEmpty()) {
				filteredList.add(string);
			}
		}
		return filteredList;
	}

	private static String getMergedStringUsingJava7(List<String> strings, String separator) {
		StringBuilder stringBuilder = new StringBuilder();

		for (String string : strings) {

			if (!string.isEmpty()) {
				stringBuilder.append(string);
				stringBuilder.append(separator);
			}
		}
		String mergedString = stringBuilder.toString();
		return mergedString.substring(0, mergedString.length() - 2);
	}

	private static List<Integer> getSquares(List<Integer> numbers) {
		List<Integer> squaresList = new ArrayList<Integer>();

		for (Integer number : numbers) {
			Integer square = new Integer(number.intValue() * number.intValue());

			if (!squaresList.contains(square)) {
				squaresList.add(square);
			}
		}
		return squaresList;
	}

	private static int getMax(List<Integer> numbers) {
		int max = numbers.get(0);

		for (int i = 1; i < numbers.size(); i++) {

			Integer number = numbers.get(i);

			if (number.intValue() > max) {
				max = number.intValue();
			}
		}
		return max;
	}

	private static int getMin(List<Integer> numbers) {
		int min = numbers.get(0);

		for (int i = 1; i < numbers.size(); i++) {
			Integer number = numbers.get(i);

			if (number.intValue() < min) {
				min = number.intValue();
			}
		}
		return min;
	}

	private static int getSum(List numbers) {
		int sum = (int) (numbers.get(0));

		for (int i = 1; i < numbers.size(); i++) {
			sum += (int) numbers.get(i);
		}
		return sum;
	}

	private static int getAverage(List<Integer> numbers) {
		return getSum(numbers) / numbers.size();
	}
}

class Test {

	public static void main(String args[]) {

		List<String> names = new ArrayList<>();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");

		System.out.println("Here we have passed System.out::println method as a static method reference.");
		names.forEach(System.out::println);
		// names.forEach(System.out.println());

		System.out.println("\n OR ");
		for (Object object : names) {
			System.out.println(object);
		}

		int[] numbers = { 10, 20, 30, 40, 50 };
		// numbers.forEach(System.out::println);

		for (int x : numbers) {
			System.out.print(x);
			System.out.print(",");
		}

	}
}