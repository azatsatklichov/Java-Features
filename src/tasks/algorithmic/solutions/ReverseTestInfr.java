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
public class ReverseTestInfr {

	static int reverseNumber(int n) {
		int rev = 0;
		while (n != 0) {
			rev = rev * 10 + (n % 10);
			n = n / 10;
		}
		return rev;
	}

	/**
	 * Reverse array only using in-place algorithm.
	 * 
	 * No allowed to use new array, or Java build-in methods
	 * 
	 * @param n
	 * @return
	 */
	static char[] reverseCharArr(char[] arr) {
		int len = arr.length;
		boolean hasMidElement = len % 2 != 0;
		for (int i = 0; i < len / 2; i++) {
			if (hasMidElement || i == len / 2) {
				swap(arr, len, i);
				break;
			}
			swap(arr, len, i);
		}

		return arr;
	}

	/**
	 * in place
	 * 
	 * @param arr
	 * @return
	 */
	static int[] reverseCharArrOrcl(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len / 2; i++) {
			arr[i] = arr[i] + arr[len - i];
			arr[len - i] = arr[i] - arr[len - i];
			arr[i] = arr[i] - arr[len - i];
		}

		return arr;
	}

	private static void swap(char[] arr, int len, int i) {
		int j = len - i - 1;
		char tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}

	public static void main(String a[]) {

		int num = 143303;
		System.out.println(num);
		System.out.println(reverseNumber(num));

		num = 254790054;
		System.out.println(num);
		System.out.println(reverseNumber(num));

		System.out.println();

		char[] arr = "ABCDEF".toCharArray();
		System.out.println(arr);
		System.out.println(reverseCharArr(arr));

		System.out.println();
		arr = "ABCDEFG".toCharArray();
		System.out.println(arr);
		System.out.println(reverseCharArr(arr));
	}
}