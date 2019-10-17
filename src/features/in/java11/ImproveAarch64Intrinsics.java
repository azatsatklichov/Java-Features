package features.in.java11;

/**
 * 
 * Improve the existing string and array intrinsics, and implement new
 * intrinsics for the java.lang.Math sin, cos and log functions, on AArch64
 * processors.
 * 
 * ARM, previously Advanced RISC Machine, originally Acorn RISC Machine, is a
 * family of reduced instruction set computing (RISC) architectures for computer
 * processors, configured for various environments
 * 
 * Motivation
 * 
 * Specialized CPU architecture-specific code patterns improve the performance
 * of user applications and benchmarks.
 * 
 * Intrinsics are used to leverage CPU architecture-specific assembly code which
 * is executed instead of generic Java code for a given method to improve
 * performance. While most of the intrinsics are already implemented in AArch64
 * port, optimized intrinsics for the following java.lang.Math methods are still
 * missing:
 * 
 * sin (sine trigonometric function)
 * 
 * cos (cosine trigonometric function)
 * 
 * log (logarithm of a number)
 * 
 * 
 *
 */
public class ImproveAarch64Intrinsics {

	public static void main(String[] args) {
		//https://bell-sw.com/java/arm/performance/2019/01/15/the-status-of-java-on-arm/
		System.out.println(
				"Today, as Arm processors are primarily viewed as targeting the embedded market, and justifiably so, "
				+ "\nmultiple hardware vendors are using this architecture to build server CPUs and to compete with Intel "
				+ "in the cloud and High Performance Computing (HPC) segment. ");
		System.out.println("Availability of Java on Arm");
		
		/**
		 * <pre>
		 * OUTPUT=~/out
			bin/jlink --module-path jmods --compress=2 --add-modules java.base --output $OUTPUT
			rm -r $OUTPUT/lib/client $OUTPUT/lib/server
			echo "-minimal KNOWN" > $OUTPUT/lib/jvm.cfg
		 * </pre>
		 */
		
		
	}

}
