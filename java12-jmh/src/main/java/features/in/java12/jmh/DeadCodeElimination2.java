package features.in.java12.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

/**
 * https://jenkov.com/tutorials/java-performance/jmh.html
 * 
 * Avoiding Dead Code Elimination To avoid dead code elimination you must make
 * sure that the code you want to measure does not look like dead code to the
 * JVM. There are two ways to do that.
 * 
 * Return the result of your code from the benchmark method. Pass the calculated
 * value into a "black hole" provided by JMH.
 *
 * 
 * Passing Value to a Black Hole An alternative to returning a combined value is
 * to pass the calculated values (or returned / generated objects or whatever
 * the result of your benchmark is) into a JMH black hole. Here is how passing
 * values into a black hole looks:
 * 
 */
public class DeadCodeElimination2 {

	/**
	 * Notice how the testMethod() benchmark method now takes a Blackhole object as
	 * parameter. This will be provided to the test method by JMH when called.
	 * 
	 * Notice also how the calculated sum in the sum variable is now passed to the
	 * consume() method of the Blackhole instance. This will fool the JVM into
	 * thinking that the sum variable is actually being used.
	 * 
	 * If your benchmark method produces multiple results you can pass each of these
	 * results to a black hole, meaning calling consume() on the Blackhole instance
	 * for each value.
	 * 
	 * @param blackhole
	 */
	@Benchmark
	public void testMethod(Blackhole blackhole) {
		int a = 1;
		int b = 2;
		int sum = a + b;
		blackhole.consume(sum);
	}
}
