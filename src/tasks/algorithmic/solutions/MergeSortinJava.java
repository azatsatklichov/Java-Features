package tasks.algorithmic.solutions;

import java.util.Arrays;

/**
 * Merge sort is one of the most efficient sorting techniques and it's based on
 * the “divide and conquer” paradigm.
 * 
 * https://www.baeldung.com/java-merge-sort
 * 
 * <pre>
 * The Algorithm
 * 
	Merge sort is a “divide and conquer” algorithm wherein we first divide the problem into subproblems. 
	When the solutions for the subproblems are ready, we combine them together to get the final solution to the problem.
	
	This is one of the algorithms which can be easily implemented using recursion as we deal with the subproblems rather than the main problem.
	
	The algorithm can be described as the following 2 step process:
	
	Divide: In this step, we divide the input array into 2 halves, the pivot being the midpoint of the array. This step is carried out recursively 
	for all the half arrays until there are no more half arrays to divide.
	
	Conquer: In this step, we sort and merge the divided arrays from bottom to top and get the sorted array.
	
	Complexity:  As merge sort is a recursive algorithm, the time complexity can be expressed as the following recursive relation: 
	
	T(n) = 2T(n/2) + O(n)
	
	
	2T(n/2) corresponds to the time required to sort the sub-arrays and 
	O(n) time to merge the entire array.
	When solved, the time complexity will come to O(nLogn).
	
 * </pre>
 * 
 */
public class MergeSortinJava {
	public static void main(String[] args) {
		int[] actual = { 5, 1, 6, 2, 3, 4 };
		int[] expected = { 1, 2, 3, 4, 5, 6 };
		mergeSort(actual, actual.length);
		System.out.println(Arrays.equals(expected, actual));
	}

	public static void mergeSort(int[] a, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(a, l, r, mid, n - mid);
	}

	public static void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}
}
