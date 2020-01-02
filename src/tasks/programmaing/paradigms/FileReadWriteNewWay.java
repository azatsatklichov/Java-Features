package tasks.programmaing.paradigms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//http://tutorials.jenkov.com/java-io/files.html
public class FileReadWriteNewWay {

	/**
	 * 
	 * Reading Files via Java 11
	 * 
	 * or
	 * 
	 * If you need to read a file from one end to the other you can use a
	 * FileInputStream or a FileReader depending on whether you want to read the
	 * file as binary or textual data.
	 * 
	 * If you need to jump around the file and read only parts of it from here and
	 * there, you can use a RandomAccessFile.
	 * 
	 * 
	 * Writing File via Java 11
	 * 
	 * or
	 * 
	 * If you need to write a file from one end to the other you can use a
	 * FileOutputStream or a FileWriter depending on whether you need to write
	 * binary data or characters. If you need to skip around a file and write to it
	 * in various places, for instance appending to the end of the file, you can use
	 * a RandomAccessFile.
	 * 
	 * @throws IOException
	 * 
	 * 
	 */
	public static void main(String[] args) throws IOException {

		var words = "forest\nwood\nsky\nrock";

		Files.writeString(Path.of("words.txt"), words);

		var data = Files.readString(Path.of("words.txt"));

		System.out.println(data);

	}
}
