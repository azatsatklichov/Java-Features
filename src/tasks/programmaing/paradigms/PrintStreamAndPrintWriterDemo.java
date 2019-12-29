package tasks.programmaing.paradigms;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

class PrintStreamDemo {

    /**
     * The Java PrintStream class (java.io.PrintStream) enables you to write
     * formatted data to an underlying OutputStream. The PrintStream class can
     * format primitive types like int, long etc. formatted as text, rather than as
     * their byte values. That is why it is called a PrintStream, because it formats
     * the primitive values as text - like they would look when printed to the
     * screen (or printed to paper).
     * 
     * @param args
     */
    private static final String file = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\ps.txt";

    public static void main(String[] args) throws IOException {

        OutputStream outputStream = new FileOutputStream(file);
        PrintStream printStream = new PrintStream(outputStream);

        printStream.print(true);
        printStream.print((int) 123);
        printStream.print((float) 123.456);

        printStream.close();
    }

}

class PrintWriterDemo {

    /**
     * The Java PrintStream class (java.io.PrintStream) enables you to write
     * formatted data to an underlying OutputStream. The PrintStream class can
     * format primitive types like int, long etc. formatted as text, rather than as
     * their byte values. That is why it is called a PrintStream, because it formats
     * the primitive values as text - like they would look when printed to the
     * screen (or printed to paper).
     * 
     * @param args
     */
    private static final String file = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\pw.txt";

    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter(file);

        try (PrintWriter printWriter = new PrintWriter(writer)) {
            printWriter.write("Hello World");
            printWriter.write((int) 123);
        } 
    }

}
