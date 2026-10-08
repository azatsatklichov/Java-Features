package features.in.java7;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class RecursiveWalk {
	public static void main(String[] args) {
		Path itunes = Paths.get("/Users/amiller/Music/iTunes/iTunes Music");
		try {
			Files.walkFileTree(itunes, new Mp3Visitor(itunes));//?
		} catch (IOException e) {
			// TBD
			e.printStackTrace();
		}

	}

}

class Mp3Visitor extends SimpleFileVisitor<Path> {
	private Path root;

	public Mp3Visitor(Path root) {
		this.root = root;
	}

	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

		System.out.println(root.relativize(file));
		// TBD
		return null;
	}
}
