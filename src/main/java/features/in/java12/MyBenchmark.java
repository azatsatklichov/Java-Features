package com.example;

import org.openjdk.jmh.runner.*;
import org.openjdk.jmh.runner.options.*;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class MyBenchmark {

    @Param({"1", "12345", "2147483647"})
    String toParse;

    @Benchmark
    public Integer parseInt() throws Exception {
      return Integer.parseInt(toParse);
    }

}
