package measures.in.graalvm;

/**
 * https://developers.redhat.com/articles/2021/06/23/how-jit-compiler-boosts-java-performance-openjdk#the_jit_compiler_in_openjdk
 * https://www.eclipse.org/openj9/docs/jit/
 */
public class JITDemo {
	//put whole param in JVM config:   -XX:+PrintCompilation
	//-XX:+PrintCompilation
	//if you use GraalVM then disable Grall: -XX:-UseJVMCICompiler -XX:+PrintCompilation
	public static void main(String[] args) {
		System.out.println("Hi JIT");
	}
	/**
	 * <pre>
			106    1             java.lang.String::hashCode (55 bytes)
		    108    2             java.lang.String::indexOf (70 bytes)
		    109    3             java.lang.String::charAt (29 bytes)
		    109    4             java.lang.Object::<init> (1 bytes)
		    110    5             java.lang.String::lastIndexOf (52 bytes)
		    110    6             java.lang.String::indexOf (166 bytes)
		    115    7             java.lang.String::equals (81 bytes)
	    Hi JIT
	 * </pre>
	 */
}
