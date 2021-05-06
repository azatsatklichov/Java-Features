package features.in.java12;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl.Mode;

public class BenchmarkRunner {

	public static void main(String[] args) {

	}

	@Benchmark
	@BenchmarkMode(value = { null })
	public void init() {
		// Do nothing
	}

}
