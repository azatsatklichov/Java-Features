package com.java2novice.interview.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program: Write a program to remove duplicates from sorted array.
 * 
 * Description:
 * 
 * Given array is already sorted, and it has duplicate elements. Write a program
 * to remove duplicate elements and return new array without any duplicate
 * elements. The array should contain only unique elements.
 * 
 * @author Azat
 * 
 */
public class DuplicateElements {

	public static int[] removeDuplicates(int[] input) {

		int j = 0;
		int i = 1;
		// return if the array length is less than 2
		if (input.length < 2) {
			return input;
		}
		// { 2, 3, 6, 6, 8, 9, 10, 10, 10, 12, 12 };
		while (i < input.length) {
			if (input[i] == input[j]) {
				i++;
			} else {
				input[++j] = input[i++];
			}
		}
		int[] output = new int[j + 1];
		for (int k = 0; k < output.length; k++) {
			output[k] = input[k];
		}

		return output;
	}

	public static int[] removeDuplicates2(int[] input) {

		int j = 0;
		int i = 1;
		// return if the array length is less than 2
		if (input.length < 2) {
			return input;
		}
		// { 2, 3, 6, 6, 8, 9, 10, 10, 10, 12, 12 };
		while (i < input.length) {
			if (input[i] == input[j]) {
				i++;
			} else {
				input[++j] = input[i++];
			}
		}
		int[] output = new int[j -1];
		System.arraycopy(input, 0, output, 0, j-1);

		return output;
	}

	public static void main(String a[]) {

		List<String> l1 = new ArrayList<String>();
		List<Integer> l2 = new ArrayList<Integer>();
		System.out.println(l1.getClass() == l2.getClass());

		int[] input1 = { 2, 3, 6, 6, 8, 9, 10, 10, 10, 12, 12 };
		int[] output = removeDuplicates(input1);
		for (int i : output)
			System.out.print(i + ", ");

		System.out.println();
		System.out.println(Arrays.toString(removeDuplicates2(input1)));

	}
}