package features.in.java8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IOEnhancements {
	private final static String filePath = "\\workspace_ext\\Java-Features\\src\\features\\in\\java8\\test.js";

	public static void main(String[] args) {
		// Java 7
		try (BufferedReader br = new BufferedReader(new FileReader(new File("C:" + filePath)))) {
			// Java 8 br.lines()
			Stream<String> linesStream = br.lines();
			Predicate<String> hasArray = s -> s.contains("array");
			linesStream.filter(Predicate.not(hasArray)).forEach(System.out::println);
		} catch (IOException e) {
			System.err.println("Err" + e);
		}

		System.out.println("\n\n ********* \n");

		// Java 7 Path.of
		Path path = Path.of("c:", filePath);
		// Java 8 Files.lines
		try (Stream<String> linesStream = Files.lines(path)) {
			Predicate<String> hasArray = s -> s.contains("array");
			linesStream.filter(Predicate.not(hasArray)).forEach(System.out::println);
		} catch (IOException e) {
			System.err.println("Err" + e);
		}

		// Walking on Files
		path = Path.of("C:\\workspace_ext\\Java-Features\\src");
		// Java 8 Files.lines
		try (Stream<Path> stream = Files.walk(path)) {
			stream.filter(f -> f.toFile().isDirectory()).forEach(s -> {
				System.out.println("Dir: " + s);
			});
		} catch (IOException e) {
			System.err.println("Err" + e);
		}

		System.out.println();
		// tune the Depth
		try (Stream<Path> stream = Files.walk(path, 2)) {
			stream.filter(f -> f.toFile().isDirectory()).forEach(s -> {
				System.out.println("Dir: " + s);
			});
		} catch (IOException e) {
			System.err.println("Err" + e);
		}

	}

}
