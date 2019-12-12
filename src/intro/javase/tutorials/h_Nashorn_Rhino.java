package intro.javase.tutorials;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class h_Nashorn_Rhino {

    public static void main(String[] args) {
        System.out.println(
                "\n Rhino is a JavaScript engine written fully in Java and managed by the Mozilla Foundation \n"
                        + "as open source software. It is separate from the SpiderMonkey engine,\n which is also developed by Mozilla, but written in C++ and used in Mozilla Firefox. ");

        System.out.println(
                "Originally, Rhino compiled all JavaScript \ncode to Java bytecode in generated Java class files. This produced the best performance, often beating the C++ \n implementation of JavaScript run with just-in-time compilation (JIT), but suffered from two faults");

        System.out.println();
        System.out.println(" --- Nashorn ---");
        System.out.println(
                "Nashorn (JavaScript engine) - the new default JavaScript engine for the JVM, starting at Java 8");
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
         * 
         * </pre>
         * 
         */
        System.out.println();
        System.out.println("https://www.tutorialspoint.com/java8/java8_nashorn_java_script.htm");
        System.out.println("https://ariya.io/2014/03/nashorn-the-new-rhino-on-the-block");

        System.out.println("cALLING JAVASCRIPT  FROM JAVA");

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "Mahesh";
        Integer result = null;

        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");

        } catch (ScriptException e) {
            System.out.println("Error executing script: " + e.getMessage());
        }
        System.out.println(result.toString());

    }

}
