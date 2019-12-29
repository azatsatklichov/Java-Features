package cx55.and.cx65.ch6.strings.format.parse.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamExample {
    /**
     * The Java DataInputStream class, java.io.DataInputStream, enables you to read
     * Java primitives (int, float, long etc.) from an InputStream instead of only
     * raw bytes. You wrap an InputStream in a DataInputStream and then you can read
     * Java primitives via ' the DataInputStream. That is why it is called
     * DataInputStream - because it reads data (numbers) instead of just bytes.
     */
    private static final String file = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\dos.txt";

    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));

        dataOutputStream.writeInt(123);
        dataOutputStream.writeFloat(123.45F);
        dataOutputStream.writeLong(789);

        dataOutputStream.close();

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));

        int int123 = dataInputStream.readInt();
        float float12345 = dataInputStream.readFloat();
        long long789 = dataInputStream.readLong();

        dataInputStream.close();

        System.out.println("int123     = " + int123);
        System.out.println("float12345 = " + float12345);
        System.out.println("long789    = " + long789);
    }
}
