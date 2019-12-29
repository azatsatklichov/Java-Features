package features.in.java7;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingPath {

	public static void main(String[] args) {

		// FileSystems -> FileSystem -> Path
		FileSystem fileSystem = FileSystems.getDefault();
		Path homeDir = fileSystem.getPath("/Users/amiller");

		// Shortcut with Paths helper class
		homeDir = Paths.get("/Users/amiller");

		// Resolve one path in terms of another
		Path relativeTemp = Paths.get("temp");
		Path absoluteTemp = relativeTemp.resolve(homeDir);
		absoluteTemp.getNameCount();

		// Get relative path from a base
		Path absoluteProfile = Paths.get("/Users/amiller/.profile");
		Path relativeProfile = absoluteProfile.relativize(homeDir);
		assert relativeProfile.isAbsolute(); //isRelative()
		assert relativeProfile.getNameCount() == 1;
	}

}
