package best.practices.lambdas.and.streams.notyet.action;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class CharsetConverter {
	public static void main(String[] args) throws IOException {
		/*
		 * https://jenkov.com/tutorials/java-internationalization/unicode.html
		 */

		// Converting to and from Unicode UTF-8 Using the String Class
		byte[] bytes = new byte[10];
		bytes[5] = 01;
		bytes[1] = 05;
		// bytes = "olaf".getBytes();
		String str = new String(bytes, Charset.forName("UTF-8"));
		System.out.println(str);

		// You can convert the text of a String to another format using the getBytes()
		// method. Here is an example:
		bytes = "olaf".getBytes();
		bytes = str.getBytes(Charset.forName("UTF-8"));

		// The danish letters � � �
		String myString = "\u00C6\u00D8\u00C5";
		byte[] bytes2 = myString.getBytes(Charset.forName("UTF-8"));
		System.out.println(Arrays.toString(bytes2));

		InputStream inputStream = new FileInputStream("C:\\workspace-17\\ilki\\ahoj2");
		Reader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

		System.out.println();
		int data = reader.read();
		while (data != -1) {
			char theChar = (char) data;
			System.out.println(theChar);
			data = reader.read();
			System.out.println(data);
		}

		reader.close();

	}

}
