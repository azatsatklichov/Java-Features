package com.java2novice.interview.programs;

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
		int[] arr2 = { 3, 2, 12, 9, 40, 32, 4 };
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					System.out.println(arr1[i]);
				}
			}
		}
	}
}