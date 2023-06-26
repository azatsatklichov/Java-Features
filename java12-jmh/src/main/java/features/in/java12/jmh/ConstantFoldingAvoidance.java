package features.in.java12.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

/**
 * https://jenkov.com/tutorials/java-performance/jmh.html
 * 
 * Or even just return 3; directly. The JVM could even continue and never call
 * the testMethod() because it knows it always returns 3, and just inline the
 * constant 3 wherever the testMethod() was to be called.
 * 
 */
public class ConstantFoldingAvoidance {
	@State(Scope.Thread)
	public static class MyState {
		public int a = 1;
		public int b = 2;
	}

	@Benchmark
	public int testMethod(MyState state) {
		int sum = state.a + state.b;
		return sum;
	}

	/**
	 * Remember, if your benchmark method calculates multiple values you can pass
	 * them through a black hole instead of returning them, to also avoid the dead
	 * code elimination optimization. For instance:
	 */
	@Benchmark
	public void testMethod2(MyState state, Blackhole blackhole) {
		int sum1 = state.a + state.b;
		int sum2 = state.a + state.a + state.b + state.b;

		blackhole.consume(sum1);
		blackhole.consume(sum2);
	}

}
