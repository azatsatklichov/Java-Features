package tasks.programmaing.paradigms;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * The Java LineNumberReader class
 * 
 * (java.io.LineNumberReader is a BufferedReader that keeps track of line
 * numbers of the read characters. Line numbering begins at 0. Whenever the
 * LineNumberReader encounters a line terminator in the characters returned by
 * the wrapped Reader, the line number is incremented.
 * 
 * You can get the current line number from the LineNumberReader by calling the
 * getLineNumber() method. You can also set the current line number, should you
 * need to, by calling the setLineNumber() method.
 *
 */
public class LineNumberReaderDemo {

	private static final String file = "words.txt";

	public static void main(String[] args) throws IOException {
		LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));

		int data = lineNumberReader.read();
		int lineNumber = lineNumberReader.getLineNumber();
		while (data != -1) {
			char dataChar = (char) data;
			System.out.println(dataChar);

			System.out.println(" line#" + lineNumber);
			data = lineNumberReader.read();
			lineNumber = lineNumberReader.getLineNumber();
		}
		lineNumberReader.close();

		System.out.println();
		try (LineNumberReader lineNumberReader2 = new LineNumberReader(new FileReader(file))) {

			String line = lineNumberReader2.readLine();
			while (line != null) {

				System.out.println(line);
				line = lineNumberReader2.readLine();
			}

		}
	}

}
