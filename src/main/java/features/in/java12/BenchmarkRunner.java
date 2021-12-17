package features.in.java12;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl.Mode;

public class BenchmarkRunner {

	public static void main(String[] args) {

	}

	//see:  workspace-JavaNew\Java-Features\java12-jmh
	@Benchmark
	//@BenchmarkMode(value = {Mode.All, Mode.AverageTime} )
	public void init() {
		// Do nothing
	}

}
