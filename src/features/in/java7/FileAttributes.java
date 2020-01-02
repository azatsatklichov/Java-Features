package features.in.java7;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class FileAttributes {
	public static void main(String[] args) {
		Path file = Paths.get("/usr/bin/perl");

		// true here means follow symbolic links
		BasicFileAttributes attrs = null; // Attributes.readPosixFileAttributes(file, true);
		Set<PosixFilePermission> perms = null; // attrs.permissions();

		// System.out.format("%s %s %s", PosixFilePermission.toString(perms),
		// attrs.owner(), attrs.group());

		// rwxr-xr-x root wheel

	}

}
