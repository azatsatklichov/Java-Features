package tasks.algorithmic.solutions;

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

		System.out.println("Classic iterative way");
		iterativeFibo(16);

		System.out.println("\nRecursive way");
		for (int i = 0; i < 16; i++) {
			System.out.print(recursiveFibo(i) + " ");
		}

		System.out.println("\nUsing Java8 Streams");
		// fiboByJava8Streams().forEach(System.out::println);
		fiboByJava8Streams(15).forEach(x -> {
			System.out.print(x + " ");
		});

	}

	private static void iterativeFibo(int febCount) {
		int[] feb = new int[febCount];
		feb[0] = 0;
		feb[1] = 1;
		for (int i = 2; i < febCount; i++) {
			feb[i] = feb[i - 1] + feb[i - 2];
		}

		for (int i = 0; i < febCount; i++) {
			System.out.print(feb[i] + " ");
		}
	}

	// Complexity N*lgN
	private static long recursiveFibo(long N) {
		if (N == 0 || N == 1) {
			return N;
		}

		return recursiveFibo(N - 1) + recursiveFibo(N - 2);
	}

	private static Stream<Integer> fiboByJava8Streams(final int febCount) {
		int[] fibs = { 0, 1 };
		Stream<Integer> fibonacci = Stream.generate(() -> {
			int result = fibs[1];
			int fib3 = fibs[0] + fibs[1];
			fibs[0] = fibs[1];
			fibs[1] = fib3;
			return result;
		}).limit(febCount);
		return fibonacci;
	}
}
