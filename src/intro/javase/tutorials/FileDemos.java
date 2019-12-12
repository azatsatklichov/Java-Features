package intro.javase.tutorials;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The java.io package contains nearly every class you might ever need to
 * perform input and output (I/O) in Java. All these streams represent an input
 * source and an output destination. The stream in the java.io package supports
 * many data such as primitives, object, localized characters, etc.
 * 
 * <pre>

Stream

A stream can be defined as a sequence of data. There are two kinds of Streams −

InputStream − The InputStream is used to read data from a source.


OutputStream − The OutputStream is used for writing data to a destination.
 * 
 * </pre>
 * 
 */
public class FileDemos {

    /**
     * 
     * Byte Streams
     * 
     * 
     * <pre>
    Java byte streams are used to perform input and output of 8-bit bytes. 
    Though there are many classes related to byte streams but the most frequently used classes are, 
    
    FileInputStream and FileOutputStream. Following is an example which makes use of these two classes to copy 
    an input file into an output file −
     * 
     * </pre>
     * 
     */
    public static void main(String args[]) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("input.txt");
            out = new FileOutputStream("output.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}

class CharStreams {

    /**
     * 
     * 
     * Character Streams
     * 
     * 
     * <pre>
     * Java Byte streams are used to perform input and output of 8-bit bytes,
     * whereas Java Character streams are used to perform input and output for
     * 16-bit unicode. Though there are many classes related to character
     * streams but the most frequently used classes are, FileReader and
     * FileWriter. Though internally FileReader uses FileInputStream and
     * FileWriter uses FileOutputStream but here the major difference is that
     * FileReader reads two bytes at a time and FileWriter writes two bytes at a
     * time.
     * 
     * We can re-write the above example, which makes the use of these two
     * classes to copy an input file (having unicode characters) into an output
     * file −
     * 
     * Example
     * </pre>
     */
    public static void main(String args[]) throws IOException {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("input.txt");
            out = new FileWriter("output.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

class StandardStreams {
    /**
     * Standard Streams
     * 
     * <pre>
     * 
     * 
     * All the programming languages provide support for standard I/O where the
     * user's program can take input from a keyboard and then produce an output
     * on the computer screen. If you are aware of C or C++ programming
     * languages, then you must be aware of three standard devices STDIN, STDOUT
     * and STDERR. Similarly, Java provides the following three standard streams
     * −
     * 
     * Standard Input − This is used to feed the data to user's program and
     * usually a keyboard is used as standard input stream and represented as
     * System.in.
     * 
     * 
     * Standard Output − This is used to output the data produced by the user's
     * program and usually a computer screen is used for standard output stream
     * and represented as System.out.
     * 
     * 
     * Standard Error − This is used to output the error data produced by the
     * user's program and usually a computer screen is used for standard error
     * stream and represented as System.err.
     * 
     * 
     * Following is a simple program, which creates InputStreamReader to read
     * standard input stream until the user types a "q"
     * 
     * 
     * </pre>
     * 
     * @throws IOException
     * 
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader cin = null;

        try {
            cin = new InputStreamReader(System.in);
            System.out.println("Enter characters, 'q' to quit.");
            char c;
            do {
                c = (char) cin.read();
                System.out.print(c);
            } while (c != 'q');
        } finally {
            if (cin != null) {
                cin.close();
            }
        }
    }
}