package features.in.java9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * <pre>
*The try-with-resources statement ensures that each resource is closed after the requirement finishes. 
*
*
*Any object implementing java.lang.AutoCloseable or java.io.Closeable, interface can be used as a resource.

Prior to Java 9, resources are to be declared before try or inside try statement as shown below in given example. 
In this example, we'll use BufferedReader as resource to read a string and then BufferedReader is to be closed.
 * </pre>
 */
public class TrywithResources {
    public static void main(String[] args) throws IOException {
        System.out.println(readData("test"));
    }

    static String readData(String message) throws IOException {
        Reader inputString = new StringReader(message);
        BufferedReader br = new BufferedReader(inputString);
        try (BufferedReader br1 = br) {
            return br1.readLine();
        }
    }
}

/**
 * 
 * <pre>
*Here we need to declare a resource br1 within try statment and then use it. 
*In Java9, we don't need to declare br1 anymore and following program will give the same result.
 * </pre>
 */
class TryWithInJava9 {
    public static void main(String[] args) throws IOException {
        System.out.println(readData("test"));
    }

    static String readData(String message) throws IOException {
        Reader inputString = new StringReader(message);
        BufferedReader br = new BufferedReader(inputString);
        try (br) {
            return br.readLine();
        }
    }
}