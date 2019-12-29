package net.sahet.demo.intw;

import java.util.stream.Stream;

/**
 * Program: Write a program to print fibonacci series.
 * 
 * Description:
 * 
 * In mathematics, the Fibonacci numbers or Fibonacci series or Fibonacci
 * sequence are the numbers in the following integer sequence: 0, 1, 1, 2, 3, 5,
 * 8, 13, 21, 34, 55, 89, 144... By definition, the first two numbers in the
 * Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the
 * previous two. Below example shows how to create fibonacci series.
 * 
 * 
 * 
 */
public class Fibonacci {

	public static void main(String a[]) {

		int febCount = 15;
		int[] feb = new int[febCount];
		feb[0] = 0;
		feb[1] = 1;
		for (int i = 2; i < febCount; i++) {
			feb[i] = feb[i - 1] + feb[i - 2];
		}

		for (int i = 0; i < febCount; i++) {
			System.out.print(feb[i] + " ");
		}
		
		
		
		
		int[] fibs = {0, 1};
		Stream<Integer> fibonacci = Stream.generate(() -> {
		    int result = fibs[1];
		    int fib3 = fibs[0] + fibs[1];
		    fibs[0] = fibs[1];
		    fibs[1] = fib3;
		    return result;
		}).limit(44); 
		//fibonacci.forEach(System.out::println);
		 
		fibonacci.forEach(x -> {  
			System.out.print(x+ ",  ");
		});
	}
}
