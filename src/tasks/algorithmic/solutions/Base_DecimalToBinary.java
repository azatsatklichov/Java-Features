package tasks.algorithmic.solutions;

/**
 * Program: Write a program to convert decimal number to binary format.
 * 
 * Description:
 * 
 * Write a program to convert decimal number to binary format using numeric
 * operations. Below example shows how to convert decimal number to binary
 * format using numeric operations.
 * 
 * 
 * 
 */
public class Base_DecimalToBinary {

	public void printBinaryFormat(int number) {
		int binary[] = new int[25];
		int index = 0;
		while (number > 0) {
			binary[index++] = number % 2;
			number = number / 2;
		}
		for (int i = index - 1; i >= 0; i--) {
			System.out.print(binary[i]);
		}
	}

	public static void main(String a[]) {

		Base_DecimalToBinary dtb = new Base_DecimalToBinary();
		dtb.printBinaryFormat(25);
	}
}

/**
 * <pre>
	Time complexity: O(len(n))
	Auxiliary space: O(len(n))
	where len() is the total digits contain in number n.
 * </pre>
 */
class DecimalNumberToBinary {

	/*
	 * Function to convert decimal to binary upto k-precision after decimal point
	 * 
	 */
	static String decimalToBinary(double num, int k_prec) {
		String binary = "";

		// Fetch the integral part of decimal number
		int integral = (int) num;
		double fractional = num - integral;

		/*
		 * Conversion of integral part to binary equivalent
		 * 
		 */
		while (integral > 0) {
			int rem = integral % 2;

			// Append 0 in binary
			binary += ((char) (rem + '0'));

			integral /= 2;
		}

		// Reverse string to get original binary
		// equivalent
		binary = reverse(binary);

		// Append point before conversion of
		// fractional part
		binary += ('.');

		// Conversion of fractional part to
		// binary equivalent
		while (k_prec-- > 0) {
			// Find next bit in fraction
			fractional *= 2;
			int fract_bit = (int) fractional;

			if (fract_bit == 1) {
				fractional -= fract_bit;
				binary += (char) (1 + '0');
			} else {
				binary += (char) (0 + '0');
			}
		}

		return binary;
	}

	static String reverse(String input) {
		char[] temparray = input.toCharArray();
		int left, right = 0;
		right = temparray.length - 1;

		for (left = 0; left < right; left++, right--) {
			// Swap values of left and right
			char temp = temparray[left];
			temparray[left] = temparray[right];
			temparray[right] = temp;
		}
		return String.valueOf(temparray);
	}

	// Driver code
	public static void main(String[] args) {
		double n = 4.47;
		int k = 3;
		System.out.println(decimalToBinary(n, k));

		n = 6.986;
		k = 5;
		System.out.println(decimalToBinary(n, k));
	}
}