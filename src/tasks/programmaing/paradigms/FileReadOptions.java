package tasks.programmaing.paradigms;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://www.baeldung.com/java-read-file
 * https://www.baeldung.com/reading-file-in-java
 * 
 * 
 * In this tutorial we'll explore different ways to read from a File in Java;
 * weâ€™ll make use of BufferedReader, Scanner, StreamTokenizer, DataInputStream,
 * SequenceInputStream and FileChannel.
 * 
 * i.a Hayirlisi, INWK happening, ....
 * 
 * i.a. either Solution Architect or Principal Software Engineer
 * 
 * 
 *
 */
public class FileReadOptions {

    public static final String file = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\s.txt";
    private static final String file1 = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\s1.txt";
    private static final String file2 = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\s2.txt";
    private static final String file3 = "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\mgm.txt";

    /**
     * Let's start with a simple way to read from file using BufferedReader; the
     * file itself contains
     * 
     * @throws IOException
     */
    @Test
    public void whenReadWithBufferedReader_thenCorrect() throws IOException {
        String expected_value = "Hello world";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        reader.close();

        assertEquals(expected_value, currentLine);
    }

    @Test
    public void whenReadWithScanner_thenCorrect() throws IOException {
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(" ");

        assertTrue(scanner.hasNext());
        assertEquals("Hello", scanner.next());
        assertEquals("world", scanner.next());
        // assertEquals(1, scanner.nextInt());

        scanner.close();
    }

    @Test
    public void whenReadWithStreamTokenizer_thenCorrectTokens() throws IOException {
        FileReader reader = new FileReader(file1);
        StreamTokenizer tokenizer = new StreamTokenizer(reader);

        // token 1
        tokenizer.nextToken();
        assertEquals(StreamTokenizer.TT_WORD, tokenizer.ttype);
        assertEquals("Hello", tokenizer.sval);

        // token 2
        tokenizer.nextToken();
        assertEquals(StreamTokenizer.TT_NUMBER, tokenizer.ttype);
        assertEquals(1, tokenizer.nval, 0.0000001);

        // token 3
        tokenizer.nextToken();
        assertEquals(StreamTokenizer.TT_EOF, tokenizer.ttype);
        reader.close();
    }

    /**
     * Java DataInputStream class allows an application to read primitive data from
     * the input stream in a machine-independent way.
     * 
     * The DataInputStream is handy if the data you need to read consists of Java
     * primitives larger than one byte each, like int, long, float, double etc. The
     * DataInputStream expects the multi byte primitives to be written in network
     * byte order (Big Endian - most significant byte first).
     * 
     * @throws IOException
     */
    @Test
    public void whenReadWithDataInputStream_thenCorrect() throws IOException {
        String expectedValue = "world";
        DataInputStream reader = new DataInputStream(new FileInputStream(file2));
        String result = reader.readUTF();
        reader.close();

        assertEquals(expectedValue, result);
    }

    @Test
    public void whenReadWithFileChannel_thenCorrect() throws IOException {
        String expected_value = "Hello world";
        RandomAccessFile reader = new RandomAccessFile(file, "r");
        FileChannel channel = reader.getChannel();

        int bufferSize = 1024;
        if (bufferSize > channel.size()) {
            bufferSize = (int) channel.size();
        }
        ByteBuffer buff = ByteBuffer.allocate(bufferSize);
        channel.read(buff);
        buff.flip();

        assertEquals(expected_value, new String(buff.array()));
        channel.close();
        reader.close();
    }

    /**
     * If we want to read the int stored at specific location, we can use the
     * following method:
     * 
     * 
     * @param filename
     * @param position
     * @return
     * @throws IOException
     */
    private int readFromPosition(String filename, long position) throws IOException {
        int result = 0;
        RandomAccessFile reader = new RandomAccessFile(filename, "r");
        reader.seek(position);
        result = reader.readInt();
        reader.close();
        return result;
    }

    @Test
    public void whenReadUTFEncodedFile_thenCorrect() throws IOException {
        String expected_value = "é�’ç©º";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file2), "UTF-8"));
        String currentLine = reader.readLine();
        reader.close();

        assertEquals(expected_value, currentLine);
    }

    @Test
    public void whenReadFileContentsIntoString_thenCorrect() throws IOException {
        String expected_value = "Hello worldn";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String currentLine = reader.readLine();
        while (currentLine != null) {
            builder.append(currentLine);
            builder.append("n");
            currentLine = reader.readLine();
        }

        reader.close();
        assertEquals(expected_value, builder.toString());
    }

    @Test
    public void givenUsingJava7_whenReadViaFiles_thenCorrect() throws IOException {
        String expected = "Hello world";

        Path path = Paths.get(file);

        byte[] readAllBytes = Files.readAllBytes(path);

        String string = new String(readAllBytes);
        assertEquals(expected, string);

        // helps to get ridoff ICM PDF like issues
        string = new String(readAllBytes, StandardCharsets.UTF_8);
        System.out.println(string);

        // or
        System.out.println("String to byte array: " + Arrays.toString(readAllBytes));

        byte[] byteArr = "test-files".getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(byteArr));
        System.out.println(new String(byteArr));
        byte[] byteArray1 = { 80, 65, 78, 75, 65, 74 };// pankaj
        String str = new String(byteArray1, 0, 3, StandardCharsets.UTF_8);
        System.out.println(str);
        str = new String(byteArray1, StandardCharsets.UTF_8);
        System.out.println(str);
    }

    @Test
    public void whenReadSmallFileJava7_thenCorrect() throws IOException {
        String expected_value = "Hello world";

        Path path = Paths.get(file);

        List<String> readAllLines = Files.readAllLines(path);
        String read = readAllLines.get(0);
        assertEquals(expected_value, read);
    }

    /**
     * MGM aydypdy SMALL file diyip
     * 
     * @throws IOException
     */
    @Test
    public void whenReadSmallFileJava7_MGM() throws IOException {
        Path path = Paths.get(file3);

        List<Mgm> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(line -> {
                addMgm(list, line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(4, list.size());
    }

    @Test
    public void whenReadBigFile_MGM() throws IOException {
        List<Mgm> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file3))) {
            String line;
            while ((line = br.readLine()) != null) {
                addMgm(list, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(4, list.size());
    }

    @Test
    public void whenReadByScanner_MGM() throws IOException {
        List<Mgm> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(file3))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                addMgm(list, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(4, list.size());
    }

    private void addMgm(List<Mgm> list, String line) {
        System.out.println(line);
        String[] split = line.toString().split(";");
        Mgm mgm = new Mgm(split[0], new Integer(split[1]));
        list.add(mgm);
    }

    /**
     * MGM and HPE uchin gereklidi
     * 
     * @throws IOException
     */
    @Test
    public void whenReadLargeFileJava7_thenCorrect() throws IOException {
        Path path = Paths.get(file3);

        // String line = reader.readLine();
        int count = 0;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(4, count);
    }

    @Test
    public void whenReadWithLineNumberReader_thenCorrect() throws IOException {

        String expect = null;
        String line = null;
        try (LineNumberReader lineNumberReader2 = new LineNumberReader(new FileReader(file))) {
            line = lineNumberReader2.readLine();
            while (line != null) {
                System.out.println(line);
                line = lineNumberReader2.readLine();
            }
        }

        assertEquals(expect, line);
    }

    @Test
    public void whenListFiles_thenCount() throws IOException {
        File search = new File(
                "C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io");

        String[] files = search.list();
        for (String fn : files)
            System.out.println("found:  " + fn + "; nameLength = " + fn.length());
        assertEquals(62, files.length);
    }

    @Test()
    public void whenReadByConsole_thenCorrect() throws IOException {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Console c = System.console();
            String u = c.readLine("%s", "username: ");
            System.out.println("hello " + u);
            String pw; // must be char[]
            // if(c != null && (pw = c.readPassword("%s", "password: ")) != null)
            // check for valid password
            assertEquals("hello", u);
        });

    }

    private void fileWrappers() throws IOException {
        BufferedWriter b2 = new BufferedWriter(new FileWriter("f1"));
        BufferedWriter b3 = new BufferedWriter(new PrintWriter("f2"));
        Writer bw = null;// do it
        BufferedWriter b4 = new BufferedWriter(new BufferedWriter(bw));
    }

    @Test()
    public void whenReadByURLConnection_thenCorrect() throws IOException {
        String file3 = "file:///C:\\workspace\\_MainJava\\scjp(cx55-cx65)\\cx55\\and\\cx65\\ch6\\strings\\format\\parse\\io\\mgm.txt";

        URL url = new URL(file3);// http://sahet.net/src/downloads/presentation.pdf
        // file:///C:/MINE/kitaplar/Enterprise%20Java%20Beans%20%28Ejb%29%203%20In%20Action%20%5B2007%5D.pdf
        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();
        int data = input.read();
        while (data != -1) {
            System.out.print((char) data);
            data = input.read();
        }
        input.close();
    }

    @Test()
    public void whenReadByXmlProperties_thenCorrect() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("props.xml")) {
            properties.loadFromXML(fileInputStream);
            System.out.println(properties);
            assertEquals("value3", properties.get("property3"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test()
    public void whenReadByPropertiesFromClassPath_thenCorrect() throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = FileReadOptions.class.getResourceAsStream("props.properties")) {
            properties.load(inputStream);
            System.out.println(properties);
            assertEquals("value3", properties.get("property3"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Properties getFoldersList() throws FileNotFoundException, IOException {
        Properties p = new Properties();

        if (Files.exists(new File(file).toPath())) {
            FileInputStream in = new FileInputStream(new File(file2));
            p.loadFromXML(in);
            BiConsumer<Object, Object> bi = (x, y) -> {
                p.getProperty(x.toString(), new File(y.toString()).getName());
            };
            p.forEach(bi);

        }
        return p;
    }

}

class Mgm {
    private String domain;
    private int accessCount;

    public Mgm(String domain, int accessCount) {
        this.domain = domain;
        this.accessCount = accessCount;
    }

    public String getDomain() {
        return domain;
    }

    public int getAccessCount() {
        return accessCount;
    }

    @Override
    public String toString() {
        return "domain: " + domain + "; accessCount:" + accessCount;
    }

}

class ReadWriteDemo {
    public static void main(String[] args) throws IOException {

        Reader reader = new FileReader(FileReadOptions.file);

        char[] theChars = new char[128];

        /**
         * Reading an array of characters at a time is faster than reading a single
         * character at a time from a Java Reader.
         */
        int charsRead = reader.read(theChars, 0, theChars.length);
        while (charsRead != -1) {
            System.out.println(new String(theChars, 0, charsRead));
            charsRead = reader.read(theChars, 0, theChars.length);
        }

        /**
         * Transparent Buffering via BufferedReader You can add transparent, automatic
         * reading and buffering of an array of bytes from a Reader using a Java
         * BufferedReader .
         */
        try (BufferedReader br = new BufferedReader(new FileReader(FileReadOptions.file), 1024 * 1024)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}