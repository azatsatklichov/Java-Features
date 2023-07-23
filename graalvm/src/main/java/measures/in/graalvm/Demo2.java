package measures.in.graalvm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1. High-performance modern Java
 * 
 * 
 * 2. Low-footprint, fast-startup
 * 
 *  Java The Java platform is particularly strong
 * for long-running processes and peak performance, but short-running processes
 * can suffer from longer startup time and relatively high memory usage.
 *
 */
public class Demo2 {

	/**
	 * https://developers.redhat.com/articles/2021/06/23/how-jit-compiler-boosts-java-performance-openjdk#the_jit_compiler_in_openjdk
	 * https://www.eclipse.org/openj9/docs/jit/
	 *
	 */
	private static final String PATH = "C:\\workspace-JavaNew\\Java-Features\\graalvm-jmh\\src\\main\\java\\measures\\in\\graalvm\\";
	private static final String FILE_PATH1 = PATH + "bigfile128MB.txt";
	private static final String FILE_PATH2 = PATH + "small6MB.txt";

	// disabling Graal: java -XX:-UseJVMCICompiler  Demo2  
	public static void main(String[] args) {
		System.out.println("Processing ...");
		String[] fp = new String[] { FILE_PATH2 }; // big1, small2
		long start = System.currentTimeMillis();
		Arrays.stream(fp).flatMap(Demo2::fileLines).flatMap(line -> Arrays.stream(line.split("\\b")))
				.map(word -> word.replaceAll("[^a-zA-Z]", "")).filter(word -> word.length() > 0)
				.map(word -> word.toLowerCase())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.sorted((a, b) -> -a.getValue().compareTo(b.getValue())).limit(10)
				.forEach(e -> System.out.format("%s = %d%n", e.getKey(), e.getValue()));
		long end = System.currentTimeMillis();
		System.out.println("\nElapsed time = " + (end - start) + " millisec");
	}

	private static Stream<String> fileLines(String path) {
		try {
			return Files.lines(Paths.get(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
