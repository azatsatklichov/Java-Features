package measures.in.graalvm;

import org.graalvm.polyglot.Context;

/**
 * Polyglot Options You can configure a language engine for better throughput or
 * startup
 * 
 * https://www.graalvm.org/reference-manual/polyglot-programming/
 *
 */
class PolyglotOpt {
	public static void main(String[] args) {
		Context polyglot = Context.newBuilder().allowExperimentalOptions(true).option("js.shared-array-buffer", "true")
				.build();
		// the use of shared array buffer requires the 'js.shared-array-buffer' option
		// to be 'true'
		polyglot.eval("js", "new SharedArrayBuffer(1024)");
		System.out.println("done");
	}
}

class SystemPropertiesTest {

	//-Dpolyglot.js.strict=true
	public static void main(String[] args) {
		Context polyglot = Context.newBuilder().allowExperimentalOptions(true).build();
		// the use of shared array buffer requires the 'js.shared-array-buffer' option
		// to be 'true'
		polyglot.eval("js", "new SharedArrayBuffer(1024)");
		System.out.println("dn");
	}
}