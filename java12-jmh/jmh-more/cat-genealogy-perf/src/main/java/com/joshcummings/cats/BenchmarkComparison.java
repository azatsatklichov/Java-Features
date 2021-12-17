package com.joshcummings.cats;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;

@State(Scope.Benchmark)
@Fork(1)
public class BenchmarkComparison {
    public double sqrt(double what) {
        return Math.exp(0.5 * Math.log(what));
    }
    
    private double what = 10d;
    
    @Benchmark
    public double baseline() {
        return Math.sqrt(what);
    }

    @Benchmark    
    public double correct() {
        return sqrt(what);
    }
    
    @Benchmark
    public double constantFolding() {
        return sqrt(10d);
    }
    
    @Benchmark
    public void deadCodeElimination() {
        sqrt(what);
    }
    
    @Benchmark
    public void deadCodeAndFolding() {
        sqrt(10d);
    }
}
