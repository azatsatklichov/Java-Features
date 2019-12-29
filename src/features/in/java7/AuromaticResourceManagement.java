package features.in.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class AuromaticResourceManagement {

	// Automatic resource management:
	// Now:
	static String readLineFromFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// this is verbose, now within Java 7 they are automatically managed
	static String readLineFromFile7(String path) throws IOException {
			try (Reader fin = new FileReader(path); BufferedReader br = new BufferedReader(fin)) {
			return br.readLine();
			}
	}

	/**
	 * Automatic Resource Management
	 * 
	 * Some resources in Java need to be closed manually like InputStream,
	 * Writers, Sockets, Sql classes. This language feature allows the try
	 * statement itself to declare one of more resources. These resources are
	 * scoped to the try block and are closed automatically.
	 */

	public static void main(String[] args) {
		String path = "sdsd";
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(path));
			br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
		}
		
		//new
		try (BufferedReader br = new BufferedReader(new FileReader(path)) 
		{
			   return br.readLine();
		}
		
		//or You can declare more than one resource to close:
		try (
				InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dest))
		{
				 // code
		}
		
	}

}