package intro.javase.tutorials;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilDemos2 {

    public static void main(String args[]) throws IOException {

        String current = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + current);
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);

        // for each name in the path array
        /*
         * for (String path : paths) { // prints filename and directory name
         * System.out.println(path); }
         */

        try {
            byte bWrite[] = { 11, 21, 3, 40, 5 };
            OutputStream os = new FileOutputStream("test.txt");
            for (int x = 0; x < bWrite.length; x++) {
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }

        String dirname = "/tmp/user/java/bin";
        File d = new File(dirname);

        // Create directory now.
        d.mkdirs();

    }
}

class ByteStreamTest {

    public static void main(String args[]) throws IOException {
        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);

        while (bOutput.size() != 10) {
            // Gets the inputs from the user
            bOutput.write("hello".getBytes());
        }
        byte b[] = bOutput.toByteArray();
        System.out.println("Print the content");

        for (int x = 0; x < b.length; x++) {
            // printing the characters
            System.out.print((char) b[x] + "   ");
        }
        System.out.println("   ");

        int c;
        ByteArrayInputStream bInput = new ByteArrayInputStream(b);
        System.out.println("Converting characters to Upper case ");

        for (int y = 0; y < 1; y++) {
            while ((c = bInput.read()) != -1) {
                System.out.println(Character.toUpperCase((char) c));
            }
            bInput.reset();
        }   
    }
}