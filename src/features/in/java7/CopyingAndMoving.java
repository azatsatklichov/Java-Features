package features.in.java7;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyingAndMoving {
	public static void main(String[] args) {
		Path home = Paths.get("/Users/amiller"); 
		Path secrets = home.resolve("secrets.txt"); 

		// Steal secrets 
		secrets.copyTo(home.resolve("stolenSecrets.txt")); 

		// Hide secrets 
		secrets.moveTo(Paths.get("/Users/dvader/secrets.txt")); 

	}

}
