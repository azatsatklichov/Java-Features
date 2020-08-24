package features.in.java9;

/**
 * Java 9 New Version-String Scheme Java version-string is a format that
 * contains version specific information. This version-string consists of major,
 * minor, security and patch update releases.
 * 
 * In Java 9, a new version-string scheme is introduced that looks like the
 * below.
 * 
 * $MAJOR.$MINOR.$SECURITY.$PATCH
 *
 */
public class VersionInfoExample {
	public static void main(String[] args) {
		Runtime.Version version = Runtime.version(); // Getting runtime version instance
		System.out.println("Current version is " + version); // Getting current Java version
		System.out.println("Major version number " + version.major()); // Getting major version number
		System.out.println("Minor version number " + version.minor()); // Getting minor version number
		System.out.println("Security version number " + version.security()); // Getting security version number
		System.out.println("Pre-released information " + version.pre()); // Getting pre-release version information
		System.out.println("Build Number " + version.build()); // Getting Optional build number
	}
}
