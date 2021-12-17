package com.joshcummings.cats;

public class LoftyBenchmark {
    private static void runOverAndOver(int times, Runnable r) {
        long start = System.nanoTime();
        String testName = Thread.currentThread().getStackTrace()[2].getMethodName();
        for (int i = 0; i < times; i++) {
            r.run();
        }
        double end = (System.nanoTime() - start) / 1_000_000d;
        System.out.printf("%s ran %f ops/ms%n", testName, times / end);
    }

    static double factor = 0.5;
    
    private static double sqrt(double what) {
        return Math.exp(factor * Math.log(what));
    }
    
    private static double testSqrt() {
        double[] placeholder = new double[1];
        runOverAndOver(100_000_000, () -> { placeholder[0] = sqrt(10); });
        return placeholder[0];
    }
    
    static double dummy = 1.0;
    
    private static double javaSqrt(double what) {
        return Math.sqrt(dummy * what);
    }
    
    private static double testJavaSqrt() {
        double[] placeholder = new double[1];
        runOverAndOver(100_000_000, () -> { placeholder[0] = javaSqrt(10); });
        return placeholder[0];
    }
    
    static double constant = 10.0;
    
    private static double constant() {
        return constant;
    }
    
    private static double testConstant() {
        double[] placeholder = new double[1];
        runOverAndOver(100_000_000, () -> { placeholder[0] = constant(); });
        return placeholder[0];
    }
    
    private static void nothing() {}
    
    private static void testNothing() {
        runOverAndOver(100_000_000, () -> nothing());
    }
    
    public static void main(String[] args) {
        if ( args.length == 1 ) {
            if ( "sqrt".equals(args[0]) ) {
                testSqrt(); 
            } else if ( "javasqrt".equals(args[0]) ) {
                testJavaSqrt();                
            } else if ( "constant".equals(args[0]) ) {
                testConstant();
            } else {
                testNothing();
            }
        } else {
            testSqrt();
            testJavaSqrt();
            testConstant();
            testNothing();
        }
    }
}
