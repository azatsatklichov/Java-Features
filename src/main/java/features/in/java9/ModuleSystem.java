package features.in.java9;

/**
 * 
 * Java 9 Modular System – Jigsaw Project
 * 
 * 
 * Java Module System is a major change in Java 9 version. Java added this
 * feature to collect Java packages and code into a single unit called module.
 * 
 * A Module is a self-describing collection of Code, Data, and some Resources.
 * It is a set of related Packages, Types (classes, abstract classes, interfaces
 * etc) with Code & Data and Resources.
 * 
 * Module, which is used to group a set of related Packages into a group.
 * 
 * 
 * In earlier versions of Java, there was no concept of module to create modular
 * Java applications, that why size of application increased and difficult to
 * move around. Even JDK itself was too heavy in size, in Java 8, rt.jar file
 * size is around 64MB.
 * 
 * 
 * One of the main motivations here is to provide modular JVM, which can run on
 * devices with a lot less available memory. The JVM could run with only those
 * modules and APIs which are required by the application. Check out this link
 * for a description of what these modules are.
 * 
 * 
 * Also, JVM internal (implementation) APIs like com.sun.* are no longer
 * accessible from application code.
 * 
 * Simply put, the modules are going to be described in a file called
 * module-info.java located in the top of java code hierarchy:
 * 
 * To deal with situation, Java 9 restructured JDK into set of modules so that
 * we can use only required module for our project.
 * 
 * 
 * 
 * The module system includes various tools and options that are given below.
 * 
 * <pre>
 *  
- Includes various options to the Java tools javac, jlink and java where we can specify module paths that locates to the location of module.

- Modular JAR file is introduced. This JAR contains module-info.class file in its root folder.

- JMOD format is introduced, which is a packaging format similar to JAR except it can include native code and configuration files.

- The JDK and JRE both are reconstructed to accommodate modules. It improves performance, security and maintainability.

- Java defines a new URI scheme for naming modules, classes and resources.

> java --list-modules
 * </pre>
 */

public class ModuleSystem {
	/**
	 * <pre>
	 * Mother of Java 9 Module System
	As of now, Java 9 Module System has 95 modules in Early Access JDK. Oracle Corp has separated JDK jars and Java SE Specifications into two set of Modules.
	
	All JDK Modules starts with “jdk.*”
	All Java SE Specifications Modules starts with “java.*”
	Java 9 Module System has a “java.base” Module. It’s known as Base Module. It’s an Independent module and does NOT dependent on any other modules. By default, all other Modules dependent on this module.
	
	That’s why “java.base” Module is also known as The Mother of Java 9 Modules.
	
	It’s default module for all JDK Modules and User-Defined Modules.
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java module");
	}
}
