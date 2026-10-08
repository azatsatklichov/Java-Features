package features.in.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesReadStringWriteString {
	public static void main(String[] args) throws IOException {

		var words = "forest\nwood\nsky\nrock\nelma";

		/**
		 * writeString method is used to write the contents to a file. Characters are
		 * encoded into bytes using the specified charset, and the default value is a
		 * UTF-8 charset.
		 */
		Path path = Files.writeString(Path.of("words.txt"), words);
		Files.writeString(Path.of("words2.txt"), words);
		// Path path = Files.writeString(Files.createTempFile("test", ".txt")
		System.out.println(path);

		/**
		 * readString method will read all contents from a file into a string, decoding
		 * from bytes to characters using the UTF-8 charset.
		 */
		var data = Files.readString(Path.of("words.txt"));
		// String data = Files.readString(path);
		System.out.println(data);

		/**
		 * isSameFile method is used for tests if two paths locate the same file or not.
		 * This method returns true if two path objects are equal without even checking
		 * the file existence.
		 */

		System.out.println("Same files  = " + Files.isSameFile(Path.of("words.txt"), Path.of("words2.txt")));
		;

	}
}
