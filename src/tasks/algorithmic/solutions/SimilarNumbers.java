package tasks.algorithmic.solutions;

import java.util.Random;
import java.util.stream.IntStream;

public class SimilarNumbers {

	public static void main(String[] args) {

		int n = 1213;
		displaySimilarNumbers(n);

		n = 1;
		displaySimilarNumbers(n);
		n = 100;
		displaySimilarNumbers(n);
	}

	private static void displaySimilarNumbers(int n) {
		if (n == 0 || n == 1 || n % 10 == 0) {
			System.out.println(n);
			return;
		}
		String strNum = Integer.toString(n);
		char[] charArray = strNum.toCharArray();
		for (int i = 0; i < factorial(strNum.length()) / 2; i++) {
			System.out.println(randomize(charArray));
		}
	}

	private static char[] randomize(char[] arr) {
		Random r = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int j = r.nextInt(i);
			swap(arr, i, j);
		}
		return arr;
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int factorial(int n) {
		return IntStream.rangeClosed(1, n).reduce(1, (int x, int y) -> x * y);
	}

}