package tasks.algorithmic.solutions;

/**
 * Program: Write a program to find the given number is Armstrong number or not?
 * 
 * Description:
 * 
 * Armstrong numbers are the sum of their own digits to the power of the number
 * of digits. It is also known as narcissistic numbers.
 * 
 * 
 */
public class ArmstrongNumber {

	public boolean isArmstrongNumber(int number) {

		int tmp = number;
		int noOfDigits = String.valueOf(number).length();
		int sum = 0;
		int div = 0;
		while (tmp > 0) {
			div = tmp % 10;
			int temp = 1;
			for (int i = 0; i < noOfDigits; i++) {
				temp *= div;
			}
			sum += temp;
			tmp = tmp / 10;
		}
		if (number == sum) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String a[]) {
		ArmstrongNumber man = new ArmstrongNumber();
		System.out.println("Is 371 Armstrong number? " + man.isArmstrongNumber(371));
		System.out.println("Is 523 Armstrong number? " + man.isArmstrongNumber(523));
		System.out.println("Is 153 Armstrong number? " + man.isArmstrongNumber(153));
	}
}