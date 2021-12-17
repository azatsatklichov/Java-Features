package measures.in.graalvm;

/**
 * <pre>
 * Compile and Run a Polyglot Application 
GraalVM can run polyglot applications written in any language implemented with the Truffle language implementation framework. These languages are henceforth referenced as guest languages.

Complete the steps in this section to create a sample polyglot application that runs on GraalVM and demonstrates programming language interoperability.

1. Create a hello-polyglot project directory.

2. In your project directory, add a HelloPolyglot.java file that includes the following code:
 * </pre>
 *
 */

import org.graalvm.polyglot.*;//imports the base API for the Polyglot API.
 

public class HelloPolyglot {
	/**
	 * You now have a polyglot application that consists of a Java host application
	 * and guest language code that run on GraalVM.
	 */
	public static void main(String[] args) {
		System.out.println("Hello Java!");
		try (Context context = Context.create()) { // Context provides an execution environment for guest languages.
			context.eval("js", "print('Hello JavaScript!');");
		}
		
		try (Context context = Context.create()) {
		    Value function = context.eval("js", "x => x+1");
		    assert function.canExecute();
		    int x = function.execute(41).asInt();
		    assert x == 42; 
		}
	}
}
