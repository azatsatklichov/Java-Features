package features.in.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class E_Files_readString_and_writeString {
	public static void main(String[] args) throws IOException {

		var words = "forest\nwo  od\nsky\nrock";

		Files.writeString(Path.of("words.txt"), words);

		var data = Files.readString(Path.of("words.txt"));
		//String data = Files.readString(Path.of("words.txt"));
		String[] split = data.split("\n");
		System.out.println(Arrays.toString(split));

		System.out.println(data);
	}
}
