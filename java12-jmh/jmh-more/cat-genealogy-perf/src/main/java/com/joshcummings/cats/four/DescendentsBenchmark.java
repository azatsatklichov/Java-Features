package com.joshcummings.cats.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import com.joshcummings.cats.CatLoader;
import com.joshcummings.cats.model.Cat;
import com.joshcummings.cats.model.DescendentCountingCat;
import com.joshcummings.cats.model.DescendentKnowingCat;
import com.joshcummings.cats.service.CatService;
import com.joshcummings.cats.service.SimpleCatService;

@State(Scope.Benchmark)
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
        Integer baseline = 350;
    }
    
    @State(Scope.Benchmark)
    public static class CatServiceState {
        private CatLoader loader = new CatLoader();
        
        CatService service;
        
        @Param({ "KNOWING", "COUNTING" }) CatServicePicker catType;
        
        @Param({ "128", "256" }) Integer numberOfCats;
        
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
    public long baseline(BaselineState state) {
        return state.baseline;
    }
    
    @Benchmark
    public long listCats(BaselineState baseline, CatServiceState cat) {
        return cat.service.listCats().stream().mapToLong(c -> baseline.baseline).sum();
    }
   
    @Benchmark
    public long countCounting(CatServiceState state) {
        return state.service.listCats().stream().mapToLong(Cat::countDescendents).sum();
    }
    
    /**
     * NOTE: In the video, I don't have the for loop here in order
     * to keep the focus on the Blackhole class; however, I've added
     * it here for the same reason that the countDescendents set of
     * benchmarks loops through the entire tree. The second set of
     * results Benchmarking Using Blackholes is reflective of this
     * version of the code.
     */
    @Benchmark
    public void baselineAddRemove(CatServiceState state, Blackhole bh) {
        List<Cat> cats = new ArrayList<>(state.service.listCats());
        for ( int i = 0; i < cats.size(); i++ ) {
            Cat mom = cats.get(i);
            Cat dad = cats.get(( i + 1 ) % cats.size());
            bh.consume(cats);
            bh.consume(mom);
            bh.consume(dad);
        }
    }
    
    @Benchmark
    public void addRemove(CatServiceState state, Blackhole bh) {
        List<Cat> cats = new ArrayList<>(state.service.listCats());
        for ( int i = 0; i < cats.size(); i++ ) {
            Cat mom = cats.get(i);
            Cat dad = cats.get(( i + 1 ) % cats.size());

            bh.consume(cats);
            bh.consume(mom);
            bh.consume(dad);
            
            Cat added = state.service.addCat("Faloola", dad, mom);
            Cat removed = state.service.removeCat(added.getId());
            
            bh.consume(added);
            bh.consume(removed);
        }
    }
}