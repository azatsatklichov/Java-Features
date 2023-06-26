package features.in.java12.jmh;

/**
 * A way, and a suite of microbenchmarks, to easily test the performance of JDK,
 * based on Java Microbenchmark Harness (JMH) will be added to JDK source code.
 * 
 * Microbenchmark Suite, JEP 230 feature adds a basic suite of microbenchmarks
 * to the JDK source code. This makes it easy for developers to run existing
 * microbenchmarks and create new ones.
 * 
 * One AArch64 Port, Not Two, JEP 344, removes all of the sources related to the
 * arm64 port while retaining the 32-bit ARM port and the 64-bit aarch64 port.
 * This allows contributors to focus their efforts on a single 64-bit ARM
 * implementation
 * 
 * 
 * NOTE: Current JVM experimentally supports Compiler Blackholes, and they are
 * in use. Please exercise extra caution when trusting the results, look into
 * the generated code to check the benchmark still works, and factor in a small
 * probability of new VM bugs. Additionally, while comparisons between different
 * JVMs are already problematic, the performance difference caused by different
 * Blackhole modes can be very significant. Please make sure you use the
 * consistent Blackhole mode for comparisons.
 * 
 * 
 * 
 * Compiler blackholes are instructing the compilers to carry all arguments
 * through the optimization phases, and then finally drop them when emitting the
 * generated code.
 * 
 */
public class z_MicrobenchmarkSuite {
	public static void main(String[] args) {
		/**
		 * http://tutorials.jenkov.com/java-performance/jmh.html
		 * 
		 * 
		 * Microbenchmarking?
		 * 
		 * Measure execution time
		 * 
		 * Small pieces of code
		 * 
		 * Compare alternatives
		 * 
		 * Prevent performance regaression
		 * 
		 */
		// Use Maven Archetype
		// jmh-java-benchmark-archetype
//		/@Benchmark
//		/@BenchmarkMode		
	}

}
