package features.in.java7;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
public class FileAttributes {
	public static void main(String[] args) {
		Path file = Paths.get(“/usr/bin/perl”); 

		// true here means follow symbolic links 
		BasicFileAttributes attrs = 
		   Attributes.readPosixFileAttributes(file, true); 
		Set<PosixFilePermission> perms = attrs.permissions(); 

		System.out.format("%s %s %s", 
		   PosixFilePermission.toString(perms), 
		   attrs.owner(), 
		   attrs.group()); 

		// rwxr-xr-x root wheel 

	}

}
