package com.joshcummings.cats.four;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.joshcummings.cats.CatGenealogy;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class StartupTest {
    @Benchmark
    public Object baseline() {
        return new Object();
    }

    @Benchmark
    public CatGenealogy startup() {
        return new CatGenealogy();
    }

    @Test
    public void runBenchmarks() throws RunnerException {
        Options opt = new OptionsBuilder()
            .shouldFailOnError(true)
            .include(".*four.*Test")
            .forks(1)
            .jvmArgs("-Xmx256M")
            .output("/dev/null")
            .result("/dev/null")
            .build();
            
        Collection<RunResult> results = new Runner(opt).run();

        for (RunResult result : results) {
            Result primary = result.getPrimaryResult();
            Assert.assertTrue("method should complete in one nanosecond",
                primary.getScore() <= 1);
        }
    }
}
