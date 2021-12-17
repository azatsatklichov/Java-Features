package com.joshcummings.cats;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;

@State(Scope.Thread)
public class DistinctCatsUsingJmh {
	private static int[] unshuffled;
    private int[] dups;
    
    static {
		unshuffled = new Random().ints(100000, 0, 5).toArray();
	}
	
	@Setup
	public void setup() {
	    List<Integer> boxed = IntStream.of(unshuffled).boxed().collect(Collectors.toList());
	    Collections.shuffle(boxed);
	    dups = boxed.stream().mapToInt(i -> i).toArray();
	}
	 

	@Benchmark
	public Collection<Integer> testArrayList() {
		List<Integer> distinct = new ArrayList<>();
		for (int j = 0; j < dups.length; j++) {
			if (!distinct.contains(dups[j])) {
				distinct.add(dups[j]);
			}
		}
		return distinct;
	}

	@Benchmark
	public Collection<Integer> testLinkedList() {
		List<Integer> distinct = new LinkedList<>();
		for (int j = 0; j < dups.length; j++) {
			if (!distinct.contains(dups[j])) {
				distinct.add(dups[j]);
			}
		}
		return distinct;
	}

	
	@Benchmark
	public Collection<Integer> testHashSet() {
		Set<Integer> distinct = new HashSet<>();
		for (int j = 0; j < dups.length; j++) {
			distinct.add(dups[j]);
		}
		return distinct;
	}

	@Benchmark
	public int[] testStream() {
		return IntStream.of(dups).distinct().toArray();
	}

	@Benchmark
	public int[] testParallelStream() {
		return IntStream.of(dups).parallel().distinct().toArray();
	}
    
	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(DistinctCatsUsingJmh.class.getSimpleName()).forks(1).build();
		new Runner(opt).run();
	}
}
