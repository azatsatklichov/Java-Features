package cx55.and.cx65.ch6.strings.format.parse.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

public class SequenceInputStreamDemo {

    private static final String file = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\s.txt";
    private static final String file1 = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\s1.txt";

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
