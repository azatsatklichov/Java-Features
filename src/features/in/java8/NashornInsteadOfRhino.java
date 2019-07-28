package features.in.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornInsteadOfRhino {

	public static void main(String[] args) {
		System.out.println(
				"\n Rhino is a JavaScript engine written fully in Java and managed by the Mozilla Foundation  as open source software. It is separate from the SpiderMonkey engine,"
						+ "\n SpiderMonkey is also developed by Mozilla, but written in C++ and used in Mozilla Firefox. "
						+ "\n V8 -  open source, developed by Google, written in C++ used in Chrome. The main difference here is that V8 doesn’t produce bytecode or any intermediate code"
						+ "\n Nashorn, open source as part of OpenJDK, written by Oracle Java Languages and Tool Group");

		System.out.println("See comparison: https://ariya.io/2014/03/nashorn-the-new-rhino-on-the-block");

		System.out.println(
				"\n\nOriginally, Rhino compiled all JavaScript code to Java bytecode in generated Java class files. This produced the best performance, often beating the C++ \n implementation of JavaScript run with just-in-time compilation (JIT), but suffered from two faults");
		/*
		 * First, compiling time was long since generating bytecode and loading the
		 * generated classes was a resource-intensive process. Also, the implementation
		 * effectively leaked memory since most Java Virtual Machines (JVM) didn't
		 * collect unused classes or the strings that are interned as a result of
		 * loading a class file
		 */

		System.out.println();
		System.out.println(
				"The most recent Java 8 release came with lots of new features, one of them is the brand-new \n"
						+ "JavaScript engine (Nashorn - (German for rhinoceros)) to replace the aging Rhino. ");

		/**
		 * Nashorn:
		 * 
		 * <pre>
		 * With Java 8, Nashorn, a much improved javascript engine is
		 * introduced, to replace the existing Rhino. Nashorn provides 2 to 10
		 * times better performance, as it directly compiles the code in memory
		 * and passes the bytecode to JVM. Nashorn uses invoke dynamics feature,
		 * introduced in Java 7 to improve performance.
		 * 
		 *Nashorn fully supports ECMAScript 5.1 specification along with some extensions, to 100% pure Java implementation and 100% complied to bytecode and not the interpreted mode as with Rhino. 
		 *
		 *Unlike Rhino, which has its own JavaScript debugger, The Nashorn does not provide it’s own JavaScript debugger but it provides an ability to remotely debug applications using an IDE like Eclipse, IntelliJ IDEA.
		 * 
		 * 
		 * </pre>
		 * 
		 */
		System.out.println();
		System.out.println("CALLING JAVASCRIPT  FROM JAVA");

		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

		String name = "Hornisse";
		Integer result = null;

		try {
			nashorn.eval("print('" + name + "')");
			result = (Integer) nashorn.eval("10 + 2");

			// or engine.eval(new FileReader("script.js"));

		} catch (ScriptException e) {
			System.out.println("Error executing script: " + e.getMessage());
		}
		System.out.println(result.toString());

	}

}
