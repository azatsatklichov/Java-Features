package tasks.algorithmic.solutions;

/**
 * Desc:
 * 
 * <pre>
 * Program: Write a program to reverse a number.
 * 
 * Description:
 * 
 * Write a program to reverse a number using numeric operations. 
 * Below example shows how to reverse a number using numeric operations.
 * </pre>
 * 
 */
public class NumberReverse {

	static int reverse(int n) {
		int rev = 0;
		while (n != 0) {
			rev = rev * 10 + (n % 10);
			n = n / 10;
		}
		return rev;
	}

	public static void main(String a[]) {

		System.out.println(reverse(143303));
	}
}