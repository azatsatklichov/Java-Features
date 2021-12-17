package com.joshcummings.cats;


public class BenchmarkComparison {
    private static void runOverAndOver(int times, Runnable r) {
        long start = System.nanoTime();
        String testName = Thread.currentThread().getStackTrace()[2].getMethodName();
        for (int i = 0; i < times; i++) {
            r.run();
        }
        double end = (System.nanoTime() - start) / 1_000_000d;
        System.out.printf("%s ran %f ops/ms%n", testName, times / end);
    }
    
    static double sqrt(double what) {
        return Math.exp(0.5 * Math.log(what));
    }
    
    static double what = 10d;
    static double placeholder;
    
    static double correct() {
        runOverAndOver(100_000_000, () -> { placeholder = sqrt(what); });
        return placeholder;
    }
    
    static double constantFolding() {
        runOverAndOver(100_000_000, () -> { placeholder = sqrt(10d); });
        return placeholder;
    }
    
    static void deadCodeElimination() {
        runOverAndOver(100_000_000, () -> sqrt(what));
    }
    
    static void deadCodeAndFolding() {
        runOverAndOver(100_000_000, () -> sqrt(10d));
    }
    
    public static void main(String[] args) throws Exception {
        String benchmark = "correct";
        if ( args.length == 0 ) {
            benchmark = "correct";
        } else {
            benchmark = args[0];
        }
        
        switch(benchmark) {
            case "correct" : correct(); break;
            case "deadCodeElimination" : deadCodeElimination(); break;
            case "constantFolding" : constantFolding(); break;
            case "deadCodeAndFolding" : deadCodeAndFolding(); break;
        }
    }
}