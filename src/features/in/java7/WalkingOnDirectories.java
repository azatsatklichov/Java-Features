package features.in.java7;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WalkingOnDirectories {
	public static void main(String[] args) {
		Path music = Paths.get("/Users/amiller/files/music"); 

		// External iterator 
		DirectoryStream<Path> mp3s = 
		     music.newDirectoryStream(“*.mp3”); 

		try { 
		     for(Path entry : mp3s) 
		        System.out.println(entry.getName()); 
		} finally { 
		     mp3s.close(); 
		} 

		// Internal iterator 
		Files.withDirectory(music, “*.mp3”, new FileAction<Path>() { 
		  public void invoke(Path entry) { 
		     System.out.println(entry.getName()); 
		   } 
		});  

	}
}
