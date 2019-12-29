package cx55.and.cx65.ch6.strings.format.parse.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class InputStreamReaderISWrapper {

    private static final String file = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\dos2.txt";

    public static void main(String[] args) throws IOException {
        /**
         * The Java InputStreamReader class, java.io.InputStreamReader, wraps a Java
         * InputStream, thereby turning the byte based InputStream into a character
         * based Reader. In other words, the Java InputStreamReader interprets the bytes
         * of an InputStream as text instead of numerical data. The Java
         * InputStreamReader class is thus a subclass of the Java Reader class.
         */
        InputStream inputStream = new FileInputStream(file);
        Reader inputStreamReader = new InputStreamReader(inputStream);

        int data = inputStreamReader.read();
        while (data != -1) {
            char theChar = (char) data;
            System.out.print(theChar);
            data = inputStreamReader.read();
        }

        inputStreamReader.close();

        // or
        inputStream = new FileInputStream(file);
        /**
         * The characters in underlying InputStream will be encoded using some character
         * encoding. T
         * 
         * his character encoding is referred to as a character set, or Charset in Java.
         * Two of the commonly used character sets are ASCII (or ISO-Latin1) and UTF8
         * (or UTF-16 in some cases).
         * 
         * You need to tell the Java InputStreamReader instance what character sets the
         * characters in the InputStream are encoded with.
         */
        InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

    }

}
