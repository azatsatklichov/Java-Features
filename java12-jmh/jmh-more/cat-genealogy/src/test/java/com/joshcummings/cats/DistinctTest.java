package com.joshcummings.cats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class DistinctTest {
	private static final int REPS = 1000;
	private static int[] dups;
	
	@BeforeClass
	public static void setUp() {
		dups = new Random().ints(100000, 0, 5).toArray();
	}

	
	@Test
	public void testArrayList() {
		runOverAndOver(REPS, () -> {
			List<Integer> distinct = new ArrayList<>();
			for ( int j = 0; j < dups.length; j++ ) {
				if ( !distinct.contains(dups[j]) ) {
					distinct.add(dups[j]);
				}
			}
		});
	}
	
	@Test
	public void testLinkedList() {
		runOverAndOver(REPS, () -> {
		    List<Integer> distinct = new LinkedList<>();
			for ( int j = 0; j < dups.length; j++ ) {
				if ( !distinct.contains(dups[j]) ) {
					distinct.add(dups[j]);
				}
			}
		});
	}
	
	@Test
	public void testHashSet() {
		runOverAndOver(REPS, () -> {
			Set<Integer> distinct = new HashSet<>();
			for ( int j = 0; j < dups.length; j++ ) {
				distinct.add(dups[j]);
			}
		});
	}
	
	@Test
	public void testStream() {
        runOverAndOver(REPS, () -> {
			int[] distinct = 
					IntStream.of(dups).distinct().toArray();
		});
	}
	
	@Test
	public void testParallelStream() {
		runOverAndOver(REPS, () -> {
			int[] distinct = 
					IntStream.of(dups).parallel().distinct().toArray();
		});
	}
	
	@AfterClass
	public static void showReport() {
	   for ( int i = 0; i < reports.length; i++ ) {
	       Map<String, Double> report = reports[i];
	       int iteration = (int)Math.pow(10, i);
	       System.out.printf("%nReport for %d iteration(s):%n%n", iteration);
    	   System.out.printf("%-20s\t%-9s\t%s%n", "TEST", "ITERATIONS", "AVERAGE");
    	   List<Map.Entry<String, Double>> tests = new ArrayList<>(report.entrySet());
    	   Collections.sort(tests, (test1, test2) -> test1.getValue().compareTo(test2.getValue()));
    	   for ( Map.Entry<String, Double> test : tests ) {
    	       System.out.printf("%-20s\t%-9s\t%f%n", test.getKey(), iteration, (iteration*1.0) / test.getValue());
    	   }   
	   }
	}
	
	private static final Map<String, Double>[] reports = new Map[(int)Math.log10(REPS)+1];
	
	private static final Map<String, Double> report = new HashMap<>();
	
	private void addToReport(String testName, int rep, long start) {
	    int index = (int)Math.ceil(Math.log10(rep+1));
	    Map<?, ?> report = reports[index];
	    if ( report == null ) {
	        reports[index] = new HashMap<String, Double>();
	    }
	    
	    reports[index].put(testName, (System.nanoTime() - start) / 1_000_000_000d);
	}
	
	private void runOverAndOver(int times, Runnable r) {
	    long start = System.nanoTime();
	    String testName = Thread.currentThread().getStackTrace()[2].getMethodName();
		for ( int i = 0; i < REPS; i++ ) {
		    if ( i > 0 && i % 100 == 0 ) {
		        System.out.printf("Took %f seconds so far, executed %d iterations%n", (System.nanoTime() - start) / 1_000_000_000d, i);
		    }
			r.run();
			addToReport(testName, i, start);
		}
		double end = (System.nanoTime() - start) / 1_000_000_000d;
		System.out.printf("%s took %f seconds%n", testName, end);
		report.put(testName, end);
	}
}
