package cx55.and.cx65.ch6.strings.format.parse.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

/**
 * https://www.baeldung.com/java-write-to-file
 * 
 * 
 * In this tutorial we'll explore different ways to write to a file using Java.
 * We'll make use of BufferedWriter, PrintWriter, FileOutputStream,
 * DataOutputStream, RandomAccessFile, FileChannel and the Java 7 Files utility
 * class.
 * 
 * We'll also take a look at locking the file while writing and discuss some
 * final take-aways on writing to file.
 * 
 * Notes
 * 
 * After exploring so many methods of writing to a file, let's discuss some
 * important notes:
 * 
 * If we try to read from a file that doesn't exist, a FileNotFoundException
 * will be thrown If we try to write to a file that doesn't exist, the file will
 * be created first and no exception will be thrown It is very important to
 * close the stream after using it, as it is not closed implicitly, to release
 * any resources associated with it In output stream, the close() method calls
 * flush() before releasing the resources which forces any buffered bytes to be
 * written to the stream Looking at the common usage practices, we can see – for
 * example – that PrintWriter is used to write formatted text; FileOutputStream
 * to write binary data; DataOutputStream to write primitive data types;
 * RandomAccessFile to write to a specific position; FileChannel to write faster
 * in larger files. Some of the APIs of these classes do allow more, but this is
 * a good place to start.
 * 
 *
 */
public class FileWriteOptions {

    private static final String file = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\sw.txt";

    @Test
    public void whenWriteStringUsingBufferedWritter_thenCorrect() throws IOException {
        String str = "Hello";
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(str);

        writer.close();
    }

    @Test
    public void whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo() throws IOException {
        String str = "World";
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.append(' ');
        writer.append(str);

        writer.close();
    }

    /**
     * We can create the writer using FileWriter, BufferedWriter or even System.out.
     * 
     * @throws IOException
     */
    @Test
    public void givenWritingStringToFile_whenUsingPrintWriter_thenCorrect() throws IOException {
        FileWriter fileWriter = new FileWriter(file + "2", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("Some String");
        printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();
    }

    /**
     * Write with FileOutputStream Let's now see how we can use FileOutputStream to
     * write binary data to a file. The following code converts a String int bytes
     * and writes the bytes to file using a FileOutputStream:
     */
    @Test
    public void givenWritingStringToFile_whenUsingFileOutputStream_thenCorrect() throws IOException {
        String str = "Helloooo";
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] strToBytes = str.getBytes();
        outputStream.write(strToBytes);

        outputStream.close();
    }

    /**
     * Write with DataOutputStream Next – let's take a look at how we can use a
     * DataOutputStream to write a String to file:
     */
    @Test
    public void givenWritingToFile_whenUsingDataOutputStream_thenCorrect() throws IOException {
        String value = "Hello";
        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
        outStream.writeUTF(value);
        outStream.close();

        // verify the results
        String result;
        FileInputStream fis = new FileInputStream(file);
        DataInputStream reader = new DataInputStream(fis);
        result = reader.readUTF();
        reader.close();

        assertEquals(value, result);
    }

    @Test
    public void givenWritingToFile_whenUsinRandomAccessFile_thenCorrect() throws IOException {
        writeToPosition(file, 23, 90);
        int readFromPosition = readFromPosition(file, 90);
        assertEquals(23, readFromPosition);

        int data1 = 2014;
        int data2 = 1500;

        writeToPosition(file, data1, 4);
        assertEquals(data1, readFromPosition(file, 4));

        writeToPosition(file, data2, 4);
        assertEquals(data2, readFromPosition(file, 4));
    }

    /**
     * Write with RandomAccessFile
     * 
     * Let's now illustrate how to write and edit inside an existing file – rather
     * than just writing to a completely new file or appending to an existing one.
     * Simply put – we need random access.
     * 
     * RandomAccessFile enable us to write at a specific position in the file given
     * the offset – from the beginning of the file – in bytes. The following code
     * writes an integer value with offset given from the beginning of the file
     * 
     * {@link FileReadOptions#whenReadWithFileChannel_thenCorrect}
     */
    private static void writeToPosition(String filename, int data, long position) throws IOException {
        RandomAccessFile writer = new RandomAccessFile(filename, "rw");
        writer.seek(position);
        writer.writeInt(data);
        writer.close();
    }

    private static int readFromPosition(String filename, long position) throws IOException {
        int result = 0;
        RandomAccessFile reader = new RandomAccessFile(filename, "r");
        reader.seek(position);
        result = reader.readInt();
        reader.close();
        return result;
    }

    /**
     * Write with FileChannel If you are dealing with large files, FileChannel can
     * be faster than standard IO. The following code write String to a file using
     * FileChannel:
     */
    @Test
    public void givenWritingToFile_whenUsingFileChannel_thenCorrect() throws IOException {
        RandomAccessFile stream = new RandomAccessFile(file, "rw");
        FileChannel channel = stream.getChannel();
        String value = "Hello";
        byte[] strBytes = value.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);
        stream.close();
        channel.close();

        // verify
        RandomAccessFile reader = new RandomAccessFile(file, "r");
        assertEquals(value, reader.readLine());
        reader.close();
    }

    /**
     * Write with Files Class
     * 
     * Java 7 introduces a new way of working with the filesystem, along with a new
     * utility class – Files. Using the Files class, we can create, move, copy,
     * delete files and directories as well; it also can be used to read and write
     * to a file:
     */
    @Test
    public void givenUsingJava7_whenWritingToFile_thenCorrect() throws IOException {
        String str = "Hello";

        Path path = Paths.get(file);
        byte[] strToBytes = str.getBytes();

        Files.write(path, strToBytes);

        String read = Files.readAllLines(path).get(0);
        assertEquals(str, read);
    }

    @Test
    public void whenWriteToTmpFile_thenCorrect() throws IOException {
        String toWrite = "Hello";
        // C:\Users\ASUS\AppData\Local\Temp
        File tmpFile = File.createTempFile("test", ".tmp");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(toWrite);
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
        assertEquals(toWrite, reader.readLine());
        reader.close();
    }

    /**
     * Lock File Before Writing
     * 
     * Finally, when writing to a file, you sometimes need to make extra sure that
     * no one else is writing to that file at the same time. Basically – you need to
     * be able to lock that file while writing.
     */
    @Test
    public void whenTryToLockFile_thenItShouldBeLocked() throws IOException {
        RandomAccessFile stream = new RandomAccessFile(file, "rw");
        FileChannel channel = stream.getChannel();

        FileLock lock = null;
        try {
            lock = channel.tryLock();
        } catch (final OverlappingFileLockException e) {
            stream.close();
            channel.close();
        }
        stream.writeChars("test lock");
        lock.release();

        stream.close();
        channel.close();
    }

    public static void java11Files() {
        /*
         * var words = "forest\nwood\nsky\nrock";
         * 
         * Files.writeString(Path.of("words.txt"), words);
         * 
         * 
         * var data = Files.readString(Path.of("words.txt"));
         * 
         * System.out.println(data);
         * 
         * Path filePath1 = Files.createTempFile("file1", ".txt"); Path filePath2 =
         * Files.createTempFile("file2", ".txt"); Files.writeString(filePath1, "TESTů");
         * Files.writeString(filePath2, "TESTů");
         * 
         * long mismatch = Files.mismatch(filePath1, filePath2);
         */

    }

}