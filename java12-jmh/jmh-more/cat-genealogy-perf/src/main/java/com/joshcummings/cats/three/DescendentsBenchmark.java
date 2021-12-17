package com.joshcummings.cats.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.State;import org.openjdk.jmh.annotations.Setup;

import com.joshcummings.cats.CatLoader;
import com.joshcummings.cats.model.Cat;
import com.joshcummings.cats.model.DescendentCountingCat;
import com.joshcummings.cats.model.DescendentKnowingCat;
import com.joshcummings.cats.service.CatService;
import com.joshcummings.cats.service.SimpleCatService;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class DescendentsBenchmark {
    public enum CatServicePicker {
        KNOWING(DescendentKnowingCat.class), COUNTING(DescendentCountingCat.class);
        
        Class<? extends Cat> catType;
        
        CatServicePicker(Class<? extends Cat> catType) { this.catType = catType; }
        
        CatService getService() {
            return new SimpleCatService(catType);
        }
    }
    
    @State(Scope.Benchmark)
    public static class BaselineState {
        long baseline = 350;
    }

    @State(Scope.Benchmark)
    public static class CatServiceState {
        private CatLoader loader = new CatLoader();
        
        CatService service;
        @Param({ "KNOWING", "COUNTING" }) CatServicePicker catType;
        @Param({ "128", "256" }) long numberOfCats;
        
        @Setup(Level.Trial)
        public void init() {
            service = catType.getService();
            loader.loadCats(numberOfCats, service);
        }
        
        @TearDown(Level.Trial)
        public void clear() {
            loader.removeCats(service);
        }
        
    }
    
    @Benchmark
    public long baseline(BaselineState baseline) {
        return baseline.baseline;
    }

    @Benchmark
    public long listCats(BaselineState baseline, CatServiceState cat) {
        return cat.service.listCats().stream().mapToLong(c -> baseline.baseline).sum();
    }

    @Benchmark
    public long countCounting(CatServiceState cat) {
        return cat.service.listCats().stream().mapToLong(Cat::countDescendents).sum();
    }
}
