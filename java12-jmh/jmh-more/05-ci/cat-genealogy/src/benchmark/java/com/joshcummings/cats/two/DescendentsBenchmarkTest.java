package com.joshcummings.cats.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.GroupThreads;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.joshcummings.cats.model.Cat;
import com.joshcummings.cats.model.DescendentCountingCat;
import com.joshcummings.cats.model.DescendentKnowingCat;
import com.joshcummings.cats.model.ParallelDescendentCountingCat;
import com.joshcummings.cats.service.CatService;
import com.joshcummings.cats.service.SimpleCatService;

@State(Scope.Benchmark)
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class DescendentsBenchmarkTest {
    public enum CatServicePicker {
        KNOWING(DescendentKnowingCat.class), COUNTING(DescendentCountingCat.class),
            PARALLEL(ParallelDescendentCountingCat.class);
        
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
        
        @Param({ "KNOWING", "COUNTING", "PARALLEL" }) CatServicePicker catType;
        
        @Param({ "128", "256", "512", "1024", "2048", "4096", "8192" }) Integer numberOfCats;        

        @Setup(Level.Trial)
        public void init() {
            service = catType.getService();
            loader.loadCats(numberOfCats, service);
        }
    }
    
    
    @Benchmark
    public long baseline(BaselineState state) {
        return state.baseline;
    }
    
    @Benchmark
    @Threads(3)
    public long listCats(BaselineState baseline, CatServiceState cat) {
        return cat.service.listCats().stream().mapToLong(c -> baseline.baseline).sum();
    }
   
    @Benchmark
    @Group(readWrite)
    @GroupThreads(3)
    public long countCounting(CatServiceState state) {
        return state.service.listCats().stream().mapToLong(Cat::countDescendents).sum();
    }
    
    @Benchmark
    @Threads(1)
    public void baselineAddRemove(CatServiceState state, Blackhole bh) { }
    
    private static final String readWrite = "readWrite";
        
    @Benchmark
    @Group(readWrite)
    @GroupThreads(1)
    public void addRemove(CatServiceState state, Blackhole bh) {
        List<Cat> cats = new ArrayList<>(state.service.listCats());
        for ( int i = 0; i < cats.size(); i++ ) {
            Cat dad = cats.get(i);
            Cat mom = cats.get(( i + 1 ) % cats.size());
            bh.consume(cats);
            bh.consume(dad);
            bh.consume(mom);
            
            Cat cat = state.service.addCat("Faloola", dad, mom);
            Cat removed = state.service.removeCat(cat.getId());
            
            bh.consume(cat);
            bh.consume(removed);
        }
    }
    
    //@Test
    public void runBenchmark() throws RunnerException {
        for ( int i = 2; i < 32; i*=2 ) {
            Options opt = new OptionsBuilder()
                .shouldFailOnError(true)
                .include(".*two.*Test.readWrite")
                .forks(1)
                .threads(i)
                .threadGroups(new int[] { 1, i - 1 })
                .operationsPerInvocation(128)
                .jvmArgs("-Xmx256M")
                //.output("/dev/null")
                //.result("/dev/null")
                .build();
    
            new Runner(opt).run();
        }
    }
}
