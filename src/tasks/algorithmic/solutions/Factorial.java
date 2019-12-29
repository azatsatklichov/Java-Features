package tasks.algorithmic.solutions;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * Factorial: N*(N-1)* ... 1 = n!
 */
public class Factorial {

	public static void main(String a[]) {

		System.out.println("Classic iterative way");
		for (int i = 1; i < 16; i++) {
			System.out.print(iterativeFactorial(i) + ", ");
		}
		System.out.println();

		System.out.println("\nRecursive way");
		for (int i = 1; i < 16; i++) {
			System.out.print(recursiveFactorial(i) + ", ");
		}

		System.out.println();
		System.out.println("\nUsing Java8 Streams");
		for (int i = 0; i < 16; i++) {
			System.out.print(factorialByJava8Streams(i) + ", ");
		}

		System.out.println();
		System.out.println("\nUsing BigInteger way");
		for (int i = 0; i < 16; i++) {
			System.out.print(factorialByJava8Streams(i) + ", ");
		}
	}

	private static int iterativeFactorial(int N) {
		int factorial = 1;
		for (int i = 2; i < N; i++) {
			factorial *= i;
		}

		return factorial;
	}

	// Complexity N*lgN
	private static long recursiveFactorial(long N) {
		if (N == 0 || N == 1) {
			return N;
		}

		return N * recursiveFactorial(N - 1);
	}

	public static long factorialByJava8Streams(int n) {
		return LongStream.rangeClosed(1, n).reduce(1, (long x, long y) -> x * y);
	}

	public BigInteger factorialHavingLargeResult(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; i++)
			result = result.multiply(BigInteger.valueOf(i));
		return result;
	}

	public static BigInteger factorialWithBigInteger2(int number) {
		BigInteger f = new BigInteger("1");
		for (int i = 2; i <= number; i++) {
			f = f.multiply(BigInteger.valueOf(i));
		}
		return f;
	}
}
