package com.joshcummings.cats.zero;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.joshcummings.cats.CatGenealogy;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(1)
@Measurement(iterations = 2)
@Warmup(iterations = 2)
public class StartupTest {
    @Benchmark
    public Object baseline() {
        return new Object();
    }
    
    @Benchmark
    public CatGenealogy startup() {
        return new CatGenealogy();
    }
    
    //@Test
    public void runBenchmarks() throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(".*zero.*")
            .jvmArgs("-Xmx256m")
            .build();
        new Runner(opt).run();
    }
}
