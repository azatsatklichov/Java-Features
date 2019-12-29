package tasks.algorithmic.solutions;

/**
 * Program: How to swap two numbers without using temporary variable?
 * 
 * Description:
 * 
 * Write a program to swap or exchange two numbers. You should not use any
 * temporary or third variable to swap.
 * 
 * SWAP is an IN=PLACE Algorithm
 * 
 * 
 * 
 */
public class SwapJustBetweenTwoNumbers {

	public static void main(String a[]) {
		int x = 10;
		int y = 20;
		System.out.println("Before swap:");
		System.out.println("x value: " + x);
		System.out.println("y value: " + y);
		swap(x, y);
		swap2(x, y);
		swapXOR(x, y);

		x = 110;
		y = 120;
		System.out.println("\nBefore swap:");
		System.out.println("x value: " + x);
		System.out.println("y value: " + y);
		swap(x, y);
		swap2(x, y);
		swapXOR(x, y);
		swap3(x, y);
	}

	private static void swap(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After swap:");
		System.out.println("x value: " + a);
		System.out.println("y value: " + b);
	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * using temp place holder
	 * 
	 * @param a
	 * @param b
	 */
	private static void swap2(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
		System.out.println("After swap:");
		System.out.println("x value: " + a);
		System.out.println("y value: " + b);
	}

	private static void swapXOR(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("After XOR swap:");
		System.out.println("x value: " + a);
		System.out.println("y value: " + b);
	}

	private static void swap3(int a, int b) {
		a = a * b;
		b = a / b;
		a = a / b;
		System.out.println("After swap3:");
		System.out.println("x value: " + a);
		System.out.println("y value: " + b);
	}

}
