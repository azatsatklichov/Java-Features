package tasks.algorithmic.solutions;

/**
 * In given text, find the longest word with most effective algorithmic solution
 * 
 * e.g. aabbbbcaaaxx
 * 
 * return bbbb
 * 
 * What complexity of an algorithm? Answer: O(n^2)). Is it possible to improve
 * it? (O(n) is possible). How?
 *
 */

class SolutionMine {

	public static void main(String[] args) {

		System.out.println("What complexity of an algorithm? (Answer: LoglogN < x <  O(N^2)). "
				+ "Is it possible to improve it? (O(n) is possible). How? ");
		System.out.println("aabbbbcaaaxx");

		// expected behaviour
		System.out.println(
				"This will return 'longest sub-identical-chars': " + longestSubStringWithIdenticalChars("aabbbbcaaa"));

		System.out.println("aabbbbcxxxxxxxsddsddddddsssaaaa");
		System.out.println("This will return 'longest sub-identical-chars': "
				+ longestSubStringWithIdenticalChars("aabbbbcxxxxxxxsddsddddddsssaaaa"));

		System.out.println("aabbbbcxxxxxxxsddsddwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		System.out.println("This will return 'longest sub-identical-chars': "
				+ longestSubStringWithIdenticalChars("aabbbbcxxxxxxxsddsddwwwwwwwwwwwwwwwwwwwwwwwwwwww"));

	}

	/**
	 * Best case O(n) e.g. abbbbb, Normally it runs with lglg(N) e.g.
	 * aaabbbbcccccdd, and worst case O(N^2) abcdefg
	 * 
	 * 
	 * @param txt
	 * @return
	 */
	public static String longestSubStringWithIdenticalChars(String txt) {
		String longestWord = "";
		if (txt == null || txt.length() == 0)
			// return longestWord;
			throw new IllegalArgumentException("Please, provide a non empty string text");

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
			/**
			 * if length of remaining sub-text is shorter than longestWord, then we can
			 * terminate method. This improvement is visible, e.g. longestWord=1000char or
			 * more, then we just win from calculation
			 */
		}

		return longestWord;
	}

}

class SolutionMine2 {

	public static void main(String[] args) {

		System.out.println("What complexity of an algorithm? (Answer: LoglogN < x <  O(N^2)). "
				+ "Is it possible to improve it? (O(n) is possible). How? ");
		System.out.println("aabbbbcaaaxx");

		// expected behaviour
		System.out.println("This will return 'longest sub-identical-chars': "
				+ findLongestSubStringWithIdenticalChars("aabbbbcaaa"));

		System.out.println("\n");
		System.out.println("aabbbbcxxxxxxxsddsddddddsssaaaa");
		System.out.println("This will return 'longest sub-identical-chars': "
				+ findLongestSubStringWithIdenticalChars("aabbbbcxxxxxxxsddsddddddsssaaaa"));

		System.out.println("\n");
		System.out.println("aabbbbcxxxxxxxsddsddwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		System.out.println("This will return 'longest sub-identical-chars': "
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

		if (txt == null || txt.length() == 0)
			throw new IllegalArgumentException("Please, provide a non empty string text");

		String longestWord = "";

		int count = 0, len = txt.length();
		for (int i = 0; i < len - 1; i++) {
			int j = i + 1;
			if (txt.charAt(i) == txt.charAt(j)) {
				count++;
				if (j == len - 1) {
					longestWord = getLongestSubString(txt, longestWord, count, i, j);
				}
			} else {
				longestWord = getLongestSubString(txt, longestWord, count, i, j);
				count = 0;
			}
		}

		System.out.println("--- URAAAA  O(N) complexity ");

		return longestWord;
	}

	private static String getLongestSubString(String txt, String longestWord, int count, int i, int j) {
		if (longestWord.length() < count) {
			longestWord = txt.substring(i - count, j);
			System.out.println(txt.charAt(i));
		}
		return longestWord;
	}

}

class Solution1Rsl {

	public static void main(String[] args) {
		System.out.println("aabbbbcaaaxx");
		System.out.println("Longest sub-identical-chars: " + longestSubStringWithIdenticalChars("aabbbbcaaa"));
		System.out.println("Longest sub-identical-chars: " + longestSubStringWithIdenticalChars("aasbbcccccbbdcaaa"));

	}

	public static String longestSubStringWithIdenticalChars(String txt) {
		String longestWord = "";

		if (txt == null || txt.length() == 0)
			throw new IllegalArgumentException("Please, provide a non empty string text");

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
			 * if(longestWord.length() > txt.substring(i, txt.length()).length()){
			 * System.out.println(i+ "optimization done ank skipped => "+txt.substring(i ,
			 * txt.length())); return longestWord; }
			 */

			// another optimization, jumping
			i = j;

		}

		return longestWord;
	}

}

class MockTaskWithSln {

	public static void main(String[] args) {
		// expected behaviour
		System.out.println("This will return 'bbbb': " + getLongestSubstringWithSameSymbols("aabbbbc"));

		System.out.println("This will return 'bbbb': " + getLongestSubstringWithSameSymbols("aabbbbacdsdsasdsda"));

		// wrong behaviour
		System.out.println("\n Implementation problems: ");
		System.err.println("This will return 'aabbbbca' instead expected 'bbbb' (why?): "
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
				}
			}
		}
		return str.substring(startPos, startPos + maxLen);
	}

}
