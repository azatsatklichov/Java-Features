package features.in.java12.jmh;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * https://jenkov.com/tutorials/java-performance/jmh.html
 * 
 * Constant Folding
 * 
 * Constant folding is another common JVM optimization. A calculation which is
 * based on constants will often result in the exact same result, regardless of
 * how many times the calculation is performed. The JVM may detect that, and
 * replace the calculation with the result of the calculation.
 */
public class ConstantFolding {

	@Benchmark
	public int testMethod() {
		int a = 1;
		int b = 2;
		int sum = a + b;

		return sum;
	}

	/**
	 * The JVM may detect that the value of sum is based on the two constant values
	 * 1 and 2 in a and b. It may thus replace the above code with this:
	 * 
	 * Or even just return 3; directly. The JVM could even continue and never call
	 * the testMethod() because it knows it always returns 3, and just inline the
	 * constant 3 wherever the testMethod() was to be called.
	 */
	@Benchmark
	public int testMethod2() {
		int sum = 3;

		return sum;
	}

}
