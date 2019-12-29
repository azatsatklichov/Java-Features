package net.sahet.demo.intw;


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

	public int reverseNumber(int number) {

		int reverse = 0;
		while (number != 0) {
			reverse = (reverse * 10) + (number % 10);
			number = number / 10;
		}
		return reverse;
	}

	public static void main(String a[]) {
		NumberReverse nr = new NumberReverse();
		System.out.println("Result: " + nr.reverseNumber(17868));
	}
}