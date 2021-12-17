package com.joshcummings.cats.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import com.joshcummings.cats.CatLoader;
import com.joshcummings.cats.model.Cat;
import com.joshcummings.cats.model.DescendentCountingCat;
import com.joshcummings.cats.model.DescendentKnowingCat;
import com.joshcummings.cats.service.CatService;
import com.joshcummings.cats.service.SimpleCatService;

@State(Scope.Benchmark)
@Fork(1)
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class DescendentsBenchmark {
    private CatLoader loader = new CatLoader();
    
    private CatService knowing = new SimpleCatService(DescendentKnowingCat.class);
    private CatService counting = new SimpleCatService(DescendentCountingCat.class);

    private long baseline = 350;
    private long numberOfCats = 128;

    public DescendentsBenchmark() {
        loader.loadCats(numberOfCats, counting);
    }

    @Benchmark
    public long baseline() {
        return baseline;
    }

    @Benchmark
    public long listCats() {
        return counting.listCats().stream().mapToLong(c -> baseline).sum();
    }

    @Benchmark
    public long countCounting() {
        return counting.listCats().stream().mapToLong(Cat::countDescendents).sum();
    }
}
