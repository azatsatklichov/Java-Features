package tasks.programmaing.paradigms;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

public class IOSequenceInputStreamDemo {

	private static final String file = "s.txt";
	private static final String file1 = "s1.txt";

	public static void main(String[] args) throws IOException {
		InputStream input1 = new FileInputStream(file);
		InputStream input2 = new FileInputStream(file1);

		SequenceInputStream sequenceInputStream = new SequenceInputStream(input1, input2);
		int data = sequenceInputStream.read();
		while (data != -1) {
			System.out.print((char) data);
			data = sequenceInputStream.read();
		}
	}

}
