package tasks.algorithmic.solutions;

import java.util.Arrays;

/**
 * Program: Write a program to find common elements between two arrays.
 * 
 * Description:
 * 
 * Write a program to identify common elements or numbers between two given
 * arrays. You should not use any inbuilt methods are list to find common
 * values.
 * 
 * 
 * 
 */
public class CommonElementsInArray {

	public static void main(String a[]) {
		int[] arr1 = { 4, 7, 3, 9, 2 };
		int[] arr2 = { 4, 3, 2, 12, 9, 40, 32, 4 };
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					System.out.println(arr1[i]);
				}
			}
		}
	}
}

class CommonElement {

	public static void main(String[] args) {

		String[] arrayA = { "A", "B", "C", null, null };
		String[] arrayB = { "A", "B", "F", null };
		
		System.out.println(isInBothwithJava8("B", arrayA, arrayB));
		System.out.println(isInBothwithJava8("C", arrayA, arrayB));
		
		System.out.println(isInBoth("A", arrayA, arrayB));
		System.out.println(isInBoth("C", arrayA, arrayB));

		String[] arrayC = { "A", "B", "C", "D" };
		String[] arrayD = { "A", "B", "F", };
		System.out.println(isInBoth2("B", arrayC, arrayD));
		System.out.println(isInBoth2("C", arrayC, arrayD));

	}

	/**
	 * Java 8 way
	 * 
	 * @param value
	 * @param arrayA
	 * @param arrayB
	 * @return
	 */
	public static boolean isInBothwithJava8(String value, String[] arrayA, String[] arrayB) {
		if (null == arrayA || null == arrayB) {
			return false;
		}

		return Arrays.stream(arrayA).filter(val -> val != null).anyMatch(val -> value.equals(val))
				&& Arrays.stream(arrayB).filter(val -> val != null).anyMatch(val -> value.equals(val));
	}

	public static boolean isInBoth(String value, String[] arrayA, String[] arrayB) {
		if (null == arrayA || null == arrayB) {
			return false;
		}

		return isArrayContainsValue(value, arrayA) && isArrayContainsValue(value, arrayB);
	}

	private static boolean isArrayContainsValue(String value, String[] array) {
		if (null == array) {
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			if (value.equals(array[i])) {
				return true;
			}
		}
		return false;
	}

	private static boolean isArrayContainsValueBuggy(String value, String[] arrayB) {
		boolean found = false;
		for (String val : arrayB) {
			if (value.equals(val)) {
				found = true;
				break;
			}
			;
		}
		return found;
	}

	/**
	 * 
	 * @param value
	 * 
	 * @param arrayA - not null arr., and elements must not contain null
	 * @param arrayB - not null arr., and elements must not contain null
	 * 
	 * @return
	 */
	public static boolean isInBoth2(String value, String[] arrayA, String[] arrayB) {
		Arrays.sort(arrayA);
		boolean foundinA = Arrays.binarySearch(arrayA, value) > -1;

		Arrays.sort(arrayB);
		boolean foundinB = Arrays.binarySearch(arrayB, value) > -1;

		return foundinA && foundinB;
	}

}