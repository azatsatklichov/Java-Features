package features.in.java13;

/**
 * This JEP extends class-data sharing feature, introduced in Java 10.
 * 
 * This JEP enhanced the JEP 310 Application Class-Data Sharing
 * 
 * https://openjdk.java.net/jeps/310
 *
 * which was introduced in Java 10, by simplifying the process of creating CDS
 * archives.
 * 
 * <pre>
*

The CDS archives will be created if the program exists with -XX:ArchiveClassesAtExit


$ java -XX:ArchiveClassesAtExit=test.jsa -cp test.jar Test

$  bin/java -XX:SharedArchiveFile=test.jsa -cp test.jar Test
 * </pre>
 * 
 * The idea behind Class Data Sharing (CDS) is a feature to improve startup
 * performance by creating class-data archive once and then reuse it, so that
 * the JVM need not recreate it again.
 */
public class JEP350DynamicCDSArchives {

	/**
	 * Now, the creation of CDS archive and using it is much easier.
	 * 
	 * <pre>
	*	> java -XX:ArchiveClassesAtExit=my_app_cds.jsa -cp my_app.jar
	*
	*   > java -XX:SharedArchiveFile=my_app_cds.jsa -cp my_app.jar
	 * 
	 * </pre>
	 */
	public static void main(String[] args) {

		/**
		 * 
		 * Dynamic CDS Archives
		 * 
		 * 
		 * Class Data Sharing (CDS) was introduced back in Java 5.
		 * 
		 * The goal of CDS is to shorten the start times of Java applications by storing
		 * certain information about classes in Class Data Sharing archives. This data
		 * can then be loaded at runtime and used by several JVMs.
		 * 
		 * Until Java 10, however, the shared archives were only accessible for the
		 * Bootstrap Class Loader. Starting with Java 10, CDS was extended by
		 * Application Class Data Sharing (AppCDS). AppCDS enables the built-in system
		 * and platform class loader as well as user-defined class loaders to access the
		 * CDS archives. Class lists are required to create the CDS archives in order to
		 * identify the classes to be loaded.
		 * 
		 * Since Java 12, default CDS archives are delivered with the JDK by default,
		 * which are based on the class list of the JDK.
		 * 
		 * in Java 13
		 * 
		 * Dynamic CDS Archives now build on this. The goal is to save the additional
		 * test runs of the application. After an application has been executed, only
		 * the newly loaded application and library classes that are not already
		 * contained in the Default/Base Layer CDS are archived. Dynamic archiving is
		 * activated with command line commands. In a future extension, the archiving of
		 * classes could then run completely automatically and transparently.
		 */

		// Dynamic AppCDS Archives
		System.out.println("This JEP simplifying the process of creating CDS archives.");
		/**
		 * 
		 * The Class Data Sharing (CDS) improves startup performance by creating a
		 * class-data archive once and reusing it so that the JVM needs not to recreate
		 * it again.
		 * 
		 * <pre>
		 * $ java -XX:ArchiveClassesAtExit=hello.jsa -cp hello.jar Hello
		 * 
		 * 
		 * </pre>
		 */

	}

}
