package com.joshcummings.cats.three;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class StartupTest {
    private static final String RUN_ID = java.util.UUID.randomUUID().toString();

    @Benchmark
    public Object baseline() {
        return new Object();
    }

    @Benchmark
    public CatGenealogy startup() {
        return new CatGenealogy();
    }

   // @Test
    public void runBenchmarks() throws RunnerException {
        Options opt = new OptionsBuilder()
            .shouldFailOnError(true)
            .include(".*three.*Test")
            .forks(1)
            .jvmArgs("-Xmx256M")
            .output("/dev/null")
            .result("/dev/null")
            .build();

        Collection<RunResult> results = new Runner(opt).run();

        publishResults(results);
    }

    protected void publishResults(Collection<RunResult> results) {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200").multiThreaded(true).build());
        JestClient client = factory.getObject();
        
        for (RunResult result : results) {
            Result primary = result.getPrimaryResult();
            String className = result.getParams().getBenchmark();
            className = className.substring(0, className.lastIndexOf("."));
            
            Map<String, Object> source = new HashMap<>();
            source.put("runId", RUN_ID);
            source.put("class", className);
            source.put("timestamp", new Date(System.currentTimeMillis()));
            source.put("benchmark", primary.getLabel());
            source.put("count", primary.getSampleCount());
            source.put("avg", primary.getScore());
            source.put("min", primary.getStatistics().getMin());
            source.put("max", primary.getStatistics().getMax());
            source.put("mean", primary.getStatistics().getMean());
            source.put("error", primary.getScoreError());
            source.put("units", primary.getScoreUnit());

            Index index = new Index.Builder(source).index("benchmarks").type("test").build();
            try {
                client.execute(index);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
