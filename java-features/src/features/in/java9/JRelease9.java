package features.in.java9;

public class JRelease9 {

	/**
	 * jar format
	 * 
	 * 
	 * In java 9, a new feature is introduced where a jar format has been enhanced
	 * to have different versions of java class or resources can be maintained and
	 * used as per the platform. In JAR, a file MANIFEST.MF file has a entry
	 * Multi-Release: true in its main section. META-INF directory also contains a
	 * versions subdirectory whose subdirectories (starting with 9 for Java 9 )
	 * store version-specific classes and resource files.
	 * 
	 * In this example, we'll be using a multi-release jar to have two versions of
	 * Tester.java file, one for jdk 7 and one for jdk 9 and run it on different jdk
	 * versions.
	 *
	 */
	public static void main(String[] args) {
		System.out.println("Java 9");
	}
}
