package tasks.algorithmic.solutions;

import java.util.Arrays;

public class Improve {

	public static void main(String[] args) {

		String[] arrayA = { "A", "B", "C", null, null };
		String[] arrayB = { "A", "B", "F", null };
		System.out.println(isInBothwithJava8("C", arrayA, arrayB));

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

	private static boolean isArrayContainsValue(String value, String[] arrayB) {
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
	 * @param arrayA - not null and not contains any null values
	 * @param arrayB - - not null and not contains any null values
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
