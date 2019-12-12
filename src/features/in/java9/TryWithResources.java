package features.in.java9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <pre>
*The try-with-resources statement ensures that each resource is closed after the requirement finishes. 
*
*
*Any object implementing java.lang.AutoCloseable or java.io.Closeable, interface can be used as a resource.

Prior to Java 9, resources are to be declared before try or inside try statement as shown below in given example.
 * </pre>
 */
public class TryWithResources {
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
*Here we need to declare a resource br1 within try statement and then use it. 
*
*In Java9, we don't need to declare br1 anymore and following program will give the same result.
*
*Java 9 will give us this feature, available in the java.base module
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

class AnotherExample {
	public void resourceDeclaredWithinTryBlockJava7() throws SQLException {
		try (FileOutputStream fileStream = new FileOutputStream("javatpoint.txt");) {
			String greeting = "Welcome to javaTpoint.";
			byte b[] = greeting.getBytes();
			fileStream.write(b);
			System.out.println("File written");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void resourceDeclaredOutsideTryBlockJava9() throws SQLException, FileNotFoundException {
		// Will not work prior to Java 9
		FileOutputStream fileStream = new FileOutputStream("javatpoint.txt");
		try (fileStream) {
			String greeting = "Welcome to javaTpoint.";
			byte b[] = greeting.getBytes();
			fileStream.write(b);
			System.out.println("File written");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * In the above example, we defined the Connection object outside the
	 * try-with-resource block, hence we need to close it explicitly in the finally
	 * block. We can't put a dbCon object reference in our try-with-resource block,
	 * which was an obvious bug in Java 7. 
	 * 
	 * Fortunately, it was fixed in Java 9. See below.
	 * 
	 * @throws SQLException
	 */
	public void loadDataFromDBJava7() throws SQLException {
		Connection dbCon = DriverManager.getConnection("url", "user", "password");
		try (ResultSet rs = dbCon.createStatement().executeQuery("select * from emp")) {
			while (rs.next()) {
				System.out.println("In loadDataFromDB() =====>>>>>>>>>>>> " + rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Exception occurs while reading the data from DB ->" + e.getMessage());
		} finally {
			if (null != dbCon)
				dbCon.close();
		}
	}

	/**
	 * You can see that the object reference dbCon has been kept inside the
	 * try-with-resource block,
	 * 
	 * so any resource as a final or effectively final variable can be placed in
	 * try-with-resource blocks and would be eligible for automatic resource
	 * management.
	 */

	public void loadDataFromDB() throws SQLException {
		Connection dbCon = DriverManager.getConnection("url", "user", "password");
		try (dbCon; ResultSet rs = dbCon.createStatement().executeQuery("select * from emp")) {
			while (rs.next()) {
				System.out.println("In loadDataFromDB() =====>>>>>>>>>>>> " + rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Exception occurs while reading the data from DB ->" + e.getMessage());
		}
	}

}