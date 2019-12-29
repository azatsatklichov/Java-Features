package features.in.java7;

//import java.io.OutputStream;
import java.io.*; 
import java.nio.file.*; 
import static java.nio.file.StandardOpenOption.*; 

public class AppendingToFile {
	public static void main(String[] args) {
		Path journal = Paths.get("/Users/amiller/journal.txt"); 

		OutputStream stream =  journal.newOutputStream(CREATE, APPEND); 

		try { 
		      writeEntry(stream);  // normal stuff 
		} finally { 
		      stream.close(); 
		} 

	}

}
