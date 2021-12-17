package features.in.java11;

public class A_LaunchingSingleFileSourceFiles {
	/**
	 * C:\workspace-JavaNew\Java-Features\src\main\java\features\in\java11>java
	 * A_LaunchingSingleFileSourceFiles.java
	 * 
	 * Java 11 example
	 * 
	 * time JVM compiles source file (because it sees source code file rather than
	 * binary (class) file) Just during Run.
	 * 
	 * >java A_LaunchingSingleFileSourceFiles.java
	 * 
	 * >java --source 11 A_LaunchingSingleFileSourceFiles.java
	 * 
	 * >java --source 17 A_LaunchingSingleFileSourceFiles.java
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * It is possible to launch single-file Java source files without prior
		 * compilation with javac. This helps new programmers learn the basics of Java
		 * and promotes creating simpler programs.
		 * 
		 * We do not clutter up our space with byte-code files and we do not need to
		 * worry about Java packaging rules.
		 */
		System.out.println("Java 11 example");
		/**
		 * This is a simple Java source file. Note that the file does not have to be
		 * located in com/zetcode subdirectory.
		 * 
		 * $ ~/bin/jdk-11/bin/java SimpleEx.java Java 11 example We launch the program
		 * with java tool.
		 */
	}

}
