package measures.in.graalvm;

/**
 * https://developers.redhat.com/articles/2021/06/23/how-jit-compiler-boosts-java-performance-openjdk#the_jit_compiler_in_openjdk
 * https://www.eclipse.org/openj9/docs/jit/
 *
 */
public class JITDemo {
	//-XX:+PrintCompilation
	//if you use GraalVM then disable Grall: -XX:-UseJVMCICompiler -XX:+PrintCompilation
	public static void main(String[] args) {
		System.out.println("Hi JIT");
	}
}
