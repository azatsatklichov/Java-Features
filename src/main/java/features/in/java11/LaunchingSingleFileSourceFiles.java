package features.in.java11;

public class LaunchingSingleFileSourceFiles {
	public static void main(String[] args) {
		/**
		 * It is possible to launch single-file Java source files without prior
		 * compilation with javac.
		 * 
		 * You can directly run the file with java command and it implicitly compiles.
		 * 
		 * This helps new programmers learn the basics of Java and promotes creating
		 * simpler programs.
		 * 
		 * We do not clutter up our space with byte-code files and we do not need to
		 * worry about Java packaging rules.
		 *  
		 */

		// set Java12 env-var
		// open folder here
		// run>java LaunchingSingleFileSourceFiles.java
		// run2 way absensence of java >java --source 12 LaunchingSingleFileSourceFiles
		// java --source 12 LaunchingSingleFileSourceFiles.java

		// in old way 1.you use javac LaunchingSingleFileSourceFiles.java, 2. then >java
		// LaunchingSingleFileSourceFiles
		System.out.println(
				"Java 11, for a single source file, blends these two steps into one: \nYou can directly run the file with java command and it implicitly compiles");

		/**
		 * This feature allows executing your Java source code directly using the java
		 * interpreter.
		 * 
		 * The source code is compiled in memory and then executed by the interpreter.
		 * The limitation is that all the classes have to be defined in the same file.
		 * 
		 * SEE: C:\workspace\Java-Features\bin\features\in\java11
		 * 
		 * This feature is particularly useful for someone who is starting to learn Java
		 * and wants to try simple programs. This feature, along with jshell, will be a
		 * great toolset for any beginners in learning the language.
		 * 
		 * https://dzone.com/articles/launch-single-file-source-code-programs-in-jdk-11
		 * 
		 * Using Modules
			The in-memory compiled code is ran as part of an unnamed module with the option --add-modules=ALL-DEFAULT. 
			This enables the code to use different modules without the need to explicitly declare dependency using the module-info.java
		 * 
		 * 
		 */
		System.out.println("The limitation is that all the classes have to be defined in the same file.");
		
		

	}

	class Matematika {

		public double simpleInterest(int principal, int rate, int period) {
			return (principal * rate * period * 1.0) / 100;
		}
	}

}
