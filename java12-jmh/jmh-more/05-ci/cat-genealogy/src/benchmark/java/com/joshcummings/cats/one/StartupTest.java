package com.joshcummings.cats.one;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.joshcummings.cats.CatGenealogy;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class StartupTest {
    @Benchmark
    public CatGenealogy fails() {
        throw new IllegalStateException("guaranteed failure");
    }
    
    //@Test
    public void runBenchmarks() throws RunnerException {
        Options opt = new OptionsBuilder()
            .shouldFailOnError(true)
            .include(".*one.*Test")
            .forks(1)
            .jvmArgs("-Xmx256M")
            .output("/dev/null")
            .result("/dev/null")
            .build();

        new Runner(opt).run();
    }
}