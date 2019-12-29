package cx55.and.cx65.ch6.strings.format.parse.io;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;

public class ArrayReaderDemo {

    public static void main(String[] args) throws IOException {
        char[] chars = "123".toCharArray();

        CharArrayReader charArrayReader = new CharArrayReader(chars);

        int data = charArrayReader.read();
        while (data != -1) {
            // do something with data
            data = charArrayReader.read();
            System.out.println((char) data);
        }

        charArrayReader.close();

        // byte array
        System.out.println();
        byte[] bytes = "ahoj".getBytes();

        int offset = 2;
        int length = 5;

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes, offset, length);
        data = byteArrayInputStream.read();
        while (data != -1) {
            data = byteArrayInputStream.read();
            System.out.println((char) data);
        }
    }

}
