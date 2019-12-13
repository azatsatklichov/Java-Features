package tasks.algorithmic.solutions;

import java.util.ArrayList;
import java.util.List;

public class PTest2 {
	// https://www.hackerrank.com/tests/info
	// https://www.hackerrank.com/tests/sample
	//https://www.hackerrank.com/interview/interview-preparation-kit?h_l=domains&h_r=hrw&utm_source=hrwCandidateFeedback

	public static void main(String[] args) {
		System.out.println("Test");
		int[] arr = {2, 34, 36, 43, 56, 58}; 
		countPairs(1, arr, 2); 
	}

	static void  countPairs(int array_count, int[] arr, int diff) { 
		List<Pair> numPairs = new ArrayList();
		for (int m = 0; m < arr.length; m++) {
			for (int n = 0; n < arr.length; n++) {
				if (arr[m] - arr[n] == diff) {
					numPairs.add(new Pair(arr[m], arr[n]));
				}
			}
		}
		System.out.println(numPairs);
 
	}

	static class Pair {
		int a;
		int b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}
		
		@Override
		public String toString() {
			return "("+a+", " + b + ")";
		}

	}

}
