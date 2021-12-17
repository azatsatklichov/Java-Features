package measures.in.graalvm;

//imports the base API for the Polyglot API.
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

/**
 * <pre>
 * Compile and Run a Polyglot Application 
GraalVM can run polyglot applications written in any language implemented with the Truffle 
language implementation framework. These languages are henceforth referenced as guest languages.

Complete the steps in this section to create a sample polyglot application that runs on 
GraalVM and demonstrates programming language interoperability.
 
 * </pre>
 *
 */

public class Polyglot {
	/**
	 * You now have a polyglot application that consists of a Java host application
	 * and guest language code that run on GraalVM.
	 */
	public static void main(String[] args) {

		Context polyglot = Context.create();
		Value array = polyglot.eval("js", "[1,2,42,4]");
		int result = array.getArrayElement(2).asInt();
		System.out.println(result);

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