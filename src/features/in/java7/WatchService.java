package features.in.java7;

import static java.nio.file.StandardWatchEventKind.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKind.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKind.ENTRY_MODIFY;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;

public class WatchService {

	/*
	 * Monitor changes in file system:
	 * 
	 * This feature is very useful if your application needs to know about the
	 * changes in file system and update itself accordingly. Look at these
	 * classes in Java7:
	 * 
	 * WatchService -
	 * http://java.sun.com/javase/7/docs/api/java/nio/file/WatchService.html
	 * WatchKey -
	 * http://java.sun.com/javase/7/docs/api/java/nio/file/WatchKey.html
	 */

	public static void main(String[] args) {
		Path deploy = Paths.get(“deploy”); 
		WatchService watcher=FileSystems.getDefault().newWatchService(); 
		WatchKey key = deploy.register(watcher, 
		  ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY); 

		for(;;) { 
		  key = watcher.take();         // blocks, also can poll 
		  for(WatchEvent<?> ev : key.pollEvents()) { 
		     switch(ev.kind()) { 
		       case ENTRY_CREATE: 
		         Path file = (Path)ev.getContext(); //relative to deploy 
		         //   deploy new stuff 
		       case ENTRY_MODIFY: ... 
		       case ENTRY_DELETE: ... 
		     } 
		   } 
		  key.reset();      // reset after processing 
		} 

		
	}
}
