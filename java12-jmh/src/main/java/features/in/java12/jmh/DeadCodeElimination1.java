package features.in.java12.jmh;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * 
 * https://jenkov.com/tutorials/java-performance/jmh.html
 * 
 * Avoiding Dead Code Elimination To avoid dead code elimination you must make
 * sure that the code you want to measure does not look like dead code to the
 * JVM. There are two ways to do that.
 * 
 * Return the result of your code from the benchmark method. Pass the calculated
 * value into a "black hole" provided by JMH.
 *
 */
public class DeadCodeElimination1 {
	/**
	 * Return Value From Benchmark Method
	 * 
	 * Returning a computed value from the JMH benchmark method could look like
	 * this:
	 * 
	 * Notice how the testMethod() method now returns the sum variable. This way the
	 * JVM cannot just eliminate the addition, because the return value might be
	 * used by the caller. JMH will take of tricking the JVM into believing that the
	 * return value is actually used.
	 * 
	 * If your benchmark method is calculating multiple values that might end up
	 * being eliminated as dead code, you can either combine the two values into a
	 * single, and return that value (e.g. an object with both values in).
	 * 
	 * @return
	 */
	@Benchmark
	public int testMethod() {
		int a = 1;
		int b = 2;
		int sum = a + b;

		return sum;
	}
}
