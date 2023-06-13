package features.in.java9;

/**
 * @author Sun
 * @version Java 9
 * 
 * 
 *
 */
public class ImprovedJavaDoc {

	/**
	 * Java documentation can be generated using javadoc tool. Currently generates
	 * documentation in html 4.0 format. In java 9, we can generate documentation in
	 * html 5 format by using -html5 option in command line arguments.
	 * 
	 * You can search the Javadocs for the following:
	 * 
	 * Method parameter types (Such as Int, String�) Module names Types and members
	 * Packages
	 * 
	 * <p>
	 * Java 9
	 * </p> 
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Java 9 - We no longer need to use Google to find the right documentation. The new Javadoc came with \n"
				+ "search right in the API documentation itself. "
				+ "Moreover, the Javadoc output was HTML5 compliant. \n"
				+ "Every Javadoc page includes information on which JDK module the class or interface comes from.");
	}
}
