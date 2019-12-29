package com.java2novice.interview.programs;

public class _Test_and_Ruslans {

	public static void main(String[] args) {
		System.out.println("aabbbbcaaaxx");
		// System.out.println("This will return 'longest sub-identical-chars': "
		// + findLongestSubStringWithIdenticalChars(null));

		// expected behaviour
		System.out.println("This will return 'longest sub-identical-chars': "
				+ findLongestSubStringWithIdenticalChars("aabbbbcaaa"));
		System.out.println("This will return 'longest sub-identical-chars': "
				+ findLongestSubStringWithIdenticalChars("aasbbcccccbbdcaaa"));

		

	}

	public static String findLongestSubStringWithIdenticalChars(String txt) {
		String longestWord = "";
		
		if (txt == null || txt.length() == 0)
			// return longestWord;
			throw new IllegalArgumentException(
					"Please, provide a non empty string text");

		int len = txt.length();
		// StringBuilder sb = new StringBuilder(longestWord);

		int longestWordLen = 0;
		for (int i = 0; i < len - 1;) {
			int j = i;
			while (j < len && txt.charAt(i) == txt.charAt(j)) {
				longestWordLen++;
				j++;
			}

			if (longestWord.length() < longestWordLen) {
				longestWord = txt.substring(i, i + longestWordLen);
				longestWordLen = 0;
			}

			// first optimization, no need to go remaining string
			/*
			 * if(longestWord.length() > txt.substring(i,
			 * txt.length()).length()){ System.out.println(i+
			 * "optimization done ank skipped => "+txt.substring(i ,
			 * txt.length())); return longestWord; }
			 */

			// another optimization, jumping
			i = j;

		}

		return longestWord;
	}

}

class Rslans {

	public static void main(String[] args) {
		// expected behaviour
		System.out.println("This will return 'bbbb': "
				+ getLongestSubstringWithSameSymbols("aabbbbc"));

		System.out.println("This will return 'bbbb': "
				+ getLongestSubstringWithSameSymbols("aabbbbacdsdsasdsda"));

		System.out
				.println("What complexity of an algorithm? (Answer: O(n^2)). "
						+ "Is it possible to improve it? (O(n) is possible). How? ");

		// wrong behaviour
		System.out.println("\n Implementation problems: ");
		System.err
				.println("This will return 'aabbbbca' instead expected 'bbbb' (why?): "
						+ getLongestSubstringWithSameSymbols("aabbbbcac"));
		System.err.println("This will throw an exception (why?):  which exception --> StringIndexOutOfBoundsException"
				+ getLongestSubstringWithSameSymbols(""));
	}

	public static String getLongestSubstringWithSameSymbols(String str) {
		int startPos = -1;
		int maxLen = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j) && j - i + 1 > maxLen) {
					startPos = i;
					maxLen = j - i + 1;
				} /*
				 * else break;
				 */
			}
		}
		return str.substring(startPos, startPos + maxLen);
	}

}
 