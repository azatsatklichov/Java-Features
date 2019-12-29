package tasks.algorithmic.solutions;

/**
 * Program: Write a program to find perfect number or not.
 * 
 * Description:
 * 
 * A perfect number is a positive integer that is equal to the sum of its proper
 * positive divisors, that is, the sum of its positive divisors excluding the
 * number itself. Equivalently, a perfect number is a number that is half the
 * sum of all of its positive divisors. The first perfect number is 6, because
 * 1, 2 and 3 are its proper positive divisors, and 1 + 2 + 3 = 6. Equivalently,
 * the number 6 is equal to half the sum of all its positive divisors: ( 1 + 2 +
 * 3 + 6 ) / 2 = 6.
 * 
 * 
 * 
 */
public class IsPerfectNumber {

	public boolean isPerfectNumber(int number) {

		int temp = 0;
		System.out.print("sum of divisibles: ");
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				System.out.print(i + "  ");
				temp += i;
			}
		}
		System.out.print("is " + temp);
		System.out.println();
		if (temp == number) {
			System.out.println(number + " is a perfect number");
			return true;
		} else {
			System.out.println(number + " is NOT a perfect number");
			return false;
		}
	}

	public static void main(String a[]) {
		IsPerfectNumber ipn = new IsPerfectNumber();
		ipn.isPerfectNumber(6);
		ipn.isPerfectNumber(28);
		ipn.isPerfectNumber(35);
	}
}