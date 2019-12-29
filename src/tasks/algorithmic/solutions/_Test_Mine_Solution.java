package com.java2novice.interview.programs;

public class _Test_Mine_Solution {

	public static void main(String[] args) {

		System.out
				.println("What complexity of an algorithm? (Answer: LoglogN < x <  O(N^2)). "
						+ "Is it possible to improve it? (O(n) is possible). How? ");
		System.out.println("aabbbbcaaaxx");

		// expected behaviour
		System.out.println("This will return 'longest sub-identical-chars': "
				+ findLongestSubStringWithIdenticalChars("aabbbbcaaa"));

		System.out.println("aabbbbcxxxxxxxsddsddddddsssaaaa");
		System.out
				.println("This will return 'longest sub-identical-chars': "
						+ findLongestSubStringWithIdenticalChars("aabbbbcxxxxxxxsddsddddddsssaaaa"));

		System.out.println("aabbbbcxxxxxxxsddsddwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		System.out
				.println("This will return 'longest sub-identical-chars': "
						+ findLongestSubStringWithIdenticalChars("aabbbbcxxxxxxxsddsddwwwwwwwwwwwwwwwwwwwwwwwwwwww"));

	}

	/**
	 * Best case O(n) e.g. abbbbb, Normally it runs with lglg(N) e.g.
	 * aaabbbbcccccdd, and worst case O(N^2) abcdefg
	 * 
	 * 
	 * @param txt
	 * @return
	 */
	public static String findLongestSubStringWithIdenticalChars(String txt) {
		String longestWord = "";
		if (txt == null || txt.length() == 0)
			// return longestWord;
			throw new IllegalArgumentException(
					"Please, provide a non empty string text");

		// StringBuilder sb = new StringBuilder(longestWord);

		int count = 0;
		for (int i = 0; i < txt.length() - 1;) {
			int j = i + 1;
			while (txt.charAt(i) == txt.charAt(j)) {
				count++;
				j++;
				if (j >= txt.length())
					break;
			}

			if (longestWord.length() < count) {
				longestWord = txt.substring(i, i + count + 1);
			}

			count = 0;

			// optimization via jumping
			i = j;

			// /optimization can be done on remaining parts

		}

		return longestWord;
	}

}

class _Test2_HP {

	public static void main(String[] args) {

		System.out
				.println("What complexity of an algorithm? (Answer: LoglogN < x <  O(N^2)). "
						+ "Is it possible to improve it? (O(n) is possible). How? ");
		System.out.println("aabbbbcaaaxx");

		// expected behaviour
		System.out.println("This will return 'longest sub-identical-chars': "
				+ findLongestSubStringWithIdenticalChars("aabbbbcaaa"));

		System.out.println("\n");
		System.out.println("aabbbbcxxxxxxxsddsddddddsssaaaa");
		System.out
				.println("This will return 'longest sub-identical-chars': "
						+ findLongestSubStringWithIdenticalChars("aabbbbcxxxxxxxsddsddddddsssaaaa"));

		System.out.println("\n");
		System.out.println("aabbbbcxxxxxxxsddsddwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		System.out
				.println("This will return 'longest sub-identical-chars': "
						+ findLongestSubStringWithIdenticalChars("aabbbbcxxxxxxxsddsddwwwwwwwwwwwwwwwwwwwwwwwwwwww"));

	}

	/**
	 * Best case O(n)
	 * 
	 * 
	 * @param txt
	 * @return
	 */
	public static String findLongestSubStringWithIdenticalChars(String txt) {
 
		if (txt == null || txt.length()  == 0)
			throw new IllegalArgumentException(
					"Please, provide a non empty string text");

		String longestWord = "";

		int count = 0, len = txt.length();
		for (int i = 0; i < len - 1; i++) {
			int j = i + 1;
			if (txt.charAt(i) == txt.charAt(j)) {
				count++;
				if (j == len - 1) {
					longestWord = getLongestSubString(txt, longestWord, count,
							i, j);
				}
			} else {
				longestWord = getLongestSubString(txt, longestWord, count, i, j);
				count = 0;
			}
		}

		System.out.println("--- URAAAA  O(N) complexity ");

		return longestWord;
	}

	private static String getLongestSubString(String txt, String longestWord,
			int count, int i, int j) {
		if (longestWord.length() < count) {
			longestWord = txt.substring(i - count, j);
			System.out.println(txt.charAt(i));
		}
		return longestWord;
	}

}
