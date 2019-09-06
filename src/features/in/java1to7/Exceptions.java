package features.in.java1to7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exceptions {

}

/**
 * The Three Kinds of Exceptions
 * 
 * <pre>
 * The first kind of exception is the checked exception. These are exceptional
 * conditions that a well-written application should anticipate and recover
 * from. For example, suppose an application prompts a user for an input file
 * name, then opens the file by passing the name to the constructor for
 * java.io.FileReader. Normally, the user provides the name of an existing,
 * readable file, so the construction of the FileReader object succeeds, and the
 * execution of the application proceeds normally. But sometimes the user
 * supplies the name of a nonexistent file, and the constructor throws
 * java.io.FileNotFoundException. A well-written program will catch this
 * exception and notify the user of the mistake, possibly prompting for a
 * corrected file name.
 * 
 * Checked exceptions are subject to the Catch or Specify Requirement. All
 * exceptions are checked exceptions, except for those indicated by Error,
 * RuntimeException, and their subclasses.
 * 
 * The second kind of exception is the error. These are exceptional conditions
 * that are external to the application, and that the application usually cannot
 * anticipate or recover from. For example, suppose that an application
 * successfully opens a file for input, but is unable to read the file because
 * of a hardware or system malfunction. The unsuccessful read will throw
 * java.io.IOError. An application might choose to catch this exception, in
 * order to notify the user of the problem � but it also might make sense for
 * the program to print a stack trace and exit.
 * 
 * Errors are not subject to the Catch or Specify Requirement. Errors are those
 * exceptions indicated by Error and its subclasses.
 * 
 * The third kind of exception is the runtime exception. These are exceptional
 * conditions that are internal to the application, and that the application
 * usually cannot anticipate or recover from. These usually indicate programming
 * bugs, such as logic errors or improper use of an API. For example, consider
 * the application described previously that passes a file name to the
 * constructor for FileReader. If a logic error causes a null to be passed to
 * the constructor, the constructor will throw NullPointerException. The
 * application can catch this exception, but it probably makes more sense to
 * eliminate the bug that caused the exception to occur.
 * 
 * Runtime exceptions are not subject to the Catch or Specify Requirement.
 * Runtime exceptions are those indicated by RuntimeException and its
 * subclasses.
 * 
 * Errors and runtime exceptions are collectively known as unchecked exceptions.
 * 
 * </pre>
 * 
 */
class THreeKindOfExceptions {

    public static void main(String[] args) {

        System.out.println(
                "Definition: An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions. ");

        System.out.println(
                "\nThe first kind of exception is the checked exception. These are exceptional conditions that a well-written application "
                        + "should anticipate and recover from.");
        System.out.println(
                "Checked exceptions are subject to the Catch or Specify Requirement. All exceptions are checked exceptions, except for those indicated by Error, RuntimeException, and their subclasses.");
        System.out.println(
                "... These are exceptional conditions that a well-written application should anticipate and recover from."
                        .toUpperCase());
        /**
         * These are exceptional conditions that a well-written application
         * should anticipate and recover from. For example, suppose an
         * application prompts a user for an input file name, then opens the
         * file by passing the name to the constructor for java.io.FileReader.
         * Normally, the user provides the name of an existing, readable file,
         * so the construction of the FileReader object succeeds, and the
         * execution of the application proceeds normally. But sometimes the
         * user supplies the name of a nonexistent file, and the constructor
         * throws java.io.FileNotFoundException. A well-written program will
         * catch this exception and notify the user of the mistake, possibly
         * prompting for a corrected file name.
         */

        System.out.println(
                "\nThe second kind of exception is the error. These are exceptional conditions that are external to the application, and that the application usually cannot anticipate or recover from. ");
        System.out.println(
                "Errors are not subject to the Catch or Specify Requirement. Errors are those exceptions indicated by Error and its subclasses.");
        System.out.println("...These are exceptional conditions that are external to the application, not recoverable"
                .toUpperCase());
        /**
         * The second kind of exception is the error. These are exceptional
         * conditions that are external to the application, and that the
         * application usually cannot anticipate or recover from. For example,
         * suppose that an application successfully opens a file for input, but
         * is unable to read the file because of a hardware or system
         * malfunction.
         * 
         * The unsuccessful read will throw java.io.IOError.
         * 
         * An application might choose to catch this exception, in order to
         * notify the user of the problem � but it also might make sense for the
         * program to print a stack trace and exit.
         */

        System.out.println(
                "\nThe third kind of exception is the runtime exception. These are exceptional conditions that are internal to the application, and that the application usually cannot anticipate or recover from. ");
        System.out.println(
                "These usually indicate programming bugs, such as logic errors or improper use of an API. Runtime exceptions are not subject to the Catch or Specify Requirement. Runtime exceptions are those indicated by RuntimeException and its subclasses.");
        System.out.println("...These are exceptional conditions that are internal to the application, not recoverable"
                .toUpperCase());/**
                                 * The third kind of exception is the runtime
                                 * exception. These are exceptional conditions
                                 * that are internal to the application, and
                                 * that the application usually cannot
                                 * anticipate or recover from. These usually
                                 * indicate programming bugs, such as logic
                                 * errors or improper use of an API. For
                                 * example, consider the application described
                                 * previously that passes a file name to the
                                 * constructor for FileReader. If a logic error
                                 * causes a null to be passed to the
                                 * constructor, the constructor will throw
                                 * NullPointerException. The application can
                                 * catch this exception, but it probably makes
                                 * more sense to eliminate the bug that caused
                                 * the exception to occur.
                                 */

    }
}

class ListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new Integer(i));
        }
    }

    /*
     * public void writeList() { // The FileWriter constructor throws
     * IOException, which must be caught. PrintWriter out = new PrintWriter(new
     * FileWriter("OutFile.txt"));
     * 
     * for (int i = 0; i < SIZE+1; i++) { // The get(int) method throws
     * IndexOutOfBoundsException, which must // be caught.
     * out.println("Value at: " + i + " = " + list.get(i)); } out.close(); }
     */
}

class ListOfNumbers2 {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers2() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }

    public static void main(String[] args) {
        new ListOfNumbers2().writeList();
    }

    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));

            for (int i = 0; i < SIZE + 1; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
}

class ListOfNumbersJava8 {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbersJava8() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }

    public static void main(String[] args) {
        new ListOfNumbers2().writeList();
    }

    public void writeList() {

        try (PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));) {
            System.out.println("Entering try statement");

            for (int i = 0; i < SIZE + 1; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public void writeList2() {

        try (PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));) {
            System.out.println("Entering try statement");

            for (int i = 0; i < SIZE + 1; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException | IOException e) {
            System.err.println("Caught: " + e.getMessage());
        }
    }

    public void writeList3() throws IOException, IndexOutOfBoundsException {

        try (PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));) {
            System.out.println("Entering try statement");

            for (int i = 0; i < SIZE + 1; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        }
    }

    // or
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    static String readFirstLineFromFile2(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
            //catch (FileNotFoundException | IOException e) { //The exception FileNotFoundException is already caught by the alternative IOException
        } catch (IOException e) {
            System.err.println("Caught: " + e.getMessage());
        }
        return null;
    }
     
    static String readFirstLineFromFile3(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (FileNotFoundException e) {
            // TODO  
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }
    
   
    
    

    public static void writeToFileZipFileContents(String zipFileName, String outputFileName)
            throws java.io.IOException {

        java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with
        // try-with-resources statement

        try (java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
                java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)) {
            // Enumerate each entry
            for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName = ((java.util.zip.ZipEntry) entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

    public static void viewTable(Connection con) throws SQLException {

        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");

                System.out.println(coffeeName + ", " + supplierID + ", " + price + ", " + sales + ", " + total);
            }
        } catch (SQLException e) {
            // JDBCTutorialUtilities.printSQLException(e);
        }
    }

    public static void viewTable7(Connection con) throws SQLException {

        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");

                System.out.println(coffeeName + ", " + supplierID + ", " + price + ", " + sales + ", " + total);
            }
        } catch (SQLException e) {
            // JDBCTutorialUtilities.printSQLException(e);
        }
    }

}

/**
 * Desc:
 * 
 * 
 * An exception can be thrown from the block of code associated with the
 * try-with-resources statement. In the example writeToFileZipFileContents, an
 * exception can be thrown from the try block, and up to two exceptions can be
 * thrown from the try-with-resources statement when it tries to close the
 * ZipFile and BufferedWriter objects.
 * 
 * If an exception is thrown from the try block and one or more exceptions are
 * thrown from the try-with-resources statement, then those exceptions thrown
 * from the try-with-resources statement are suppressed, and the exception
 * thrown by the block is the one that is thrown by the
 * writeToFileZipFileContents method. You can retrieve these suppressed
 * exceptions by calling the Throwable.getSuppressed method from the exception
 * thrown by the try block.
 * 
 * 
 */
class SuppressedExceptions {
    public static void main(String[] args) {

        System.out.println("In exception can be thrown from the try block, and UP TO TWO exceptions can be thrown \n"
                + "from the try-with-resources statement when it tries to close the ZipFile and BufferedWriter objects..");

        System.out.println(
                "If an exception is thrown from the try block and one or more exceptions are thrown from the try-with-resources statement, then those exceptions thrown from the try-with-resources statement are suppressed, and the exception thrown by the block is the one that is thrown by the writeToFileZipFileContents method. ");
        System.out.println(
                "You can retrieve these suppressed exceptions by calling the Throwable.getSuppressed method from the exception thrown by the try block.");

    }

    public static void writeToFileZipFileContents(String zipFileName, String outputFileName)
            throws java.io.IOException {

        java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with
        // try-with-resources statement

        try (java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
                java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)) {
            // Enumerate each entry
            for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName = ((java.util.zip.ZipEntry) entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

}

class SuppressedExceptions2 {
    public static void main(String[] args) throws Exception {
        try {
            callTryFinallyBlock();
        } catch (Exception e) {
            e.printStackTrace(); // Only Finally Exception is Caught**
        }
    }

    private static void callTryFinallyBlock() throws Exception {
        try {
            throw new TryException(); // This is lost**
        } finally {
            FinallyException fEx = new FinallyException();
            throw fEx;
        }
    }
}

class TryException extends Exception {
}

class FinallyException extends Exception {
}

class TryWithResources_Suppressed {

    public static void main(String[] args) throws Exception {

        try (OpenDoor door = new OpenDoor()) {
            door.swing(); /* this throws a SwingExecption */
        } catch (Exception e) {
            System.out.println("Is there a draft? " + e.getClass());
            int suppressedCount = e.getSuppressed().length;
            for (int i = 0; i < suppressedCount; i++) {
                System.out.println("Suppressed: " + e.getSuppressed()[i]);
            }
        } finally {
            System.out.println("I'm putting a sweater on, regardless. ");
        }
    }

}

class OpenException extends Exception {
}

class SwingException extends Exception {
}

class CloseException extends Exception {
}

/**
 * Classes That Implement the AutoCloseable or Closeable Interface
 * 
 * See the Javadoc of the AutoCloseable and Closeable interfaces for a list of
 * classes that implement either of these interfaces. The Closeable interface
 * extends the AutoCloseable interface. The close method of the Closeable
 * interface throws exceptions of type IOException while the close method of the
 * AutoCloseable interface throws exceptions of type Exception. Consequently,
 * subclasses of the AutoCloseable interface can override this behavior of the
 * close method to throw specialized exceptions, such as IOException, or no
 * exception at all.
 * 
 * @author asatklic
 *
 */
class OpenDoor implements AutoCloseable {

    // The close method of the Closeable interface throws exceptions of type
    // IOException while the close method of the
    // AutoCloseable interface throws exceptions of type Exception.

    public OpenDoor() throws Exception {
        System.out.println("The door is open.");
    }

    public void swing() throws Exception {
        System.out.println("The door is becoming unhinged.");
        throw new SwingException();
    }

    public void close() throws Exception {
        System.out.println("The door is closed.");
        throw new CloseException(); /* throwing CloseException */
    }

}

class MoreAboutSuppressedExceptions {

    /**
     * Suppressed Exceptions
     * 
     * <pre>
     *  
     * Suppressed exceptions were introduced at the same time as the
     * try-with-resource feature. This is because in a try-with-resource two
     * exceptions may be thrown (one from the try block and one from the
     * implicit call to close()), and since a method can throw at most one
     * exception, the other exception must be suppressed.
     * 
     * 
     * </pre>
     *
     */
    public static void main(String[] args) {
        Exception exc = new Exception();
        exc.addSuppressed(new Exception("Sup. 1"));
        exc.addSuppressed(new Exception("Sup. 2"));

        System.out.println(Arrays.toString(exc.getSuppressed()));

    }
}

class Advantages_of_Exceptions {

    public static void main(String[] args) {
        System.out.println("Advantage 1: Separating Error-Handling Code from Regular Code");
        /**
         * Desc:
         * 
         * <pre>
         readFile {
        open the file;
        determine its size;
        allocate that much memory;
        read the file into memory;
        close the file;
        }
        
        
        At first glance, this function seems simple enough, but it ignores all the following potential errors.
        �What happens if the file can't be opened?
        �What happens if the length of the file can't be determined?
        �What happens if enough memory can't be allocated?
        �What happens if the read fails?
        �What happens if the file can't be closed?
         * 
         * </pre>
         * 
         */

        System.out.println("Advantage 2: Propagating Errors Up the Call Stack");
        
        
        
        
        System.out.println("Advantage 3: Grouping and Differentiating Error Types");
    }

}
