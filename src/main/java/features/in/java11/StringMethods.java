package features.in.java11;

import java.util.stream.Collectors;

public class StringMethods {
	/**
	 * {@link java.lang.String#trim() } {@link java.lang.String#strip }
	 * 
	 * {@see java.lang.String }
	 */
	public static void main(String[] args) {
		System.out.println(
				"We already have trim(). Then whatâ€™s the need of strip() ? strip() is Unicode-aware evolution of trim(). "
						+ "When trim() was introduced, Unicode wasn't fully evolved / standardized as today.");

		/**
		 * When trim() was introduced, Unicode wasnâ€™t evolved. Now, the new strip()
		 * removes all kinds of white spaces leading and trailing(check the method
		 * Character.isWhitespace(c) to know if a unicode is whitespace or not.
		 * Unicode-aware trimming routines should use Character::isWhitespace(int).
		 * 
		 * The java lang.string.trim() is a built-in function that eliminates leading
		 * and trailing spaces. The Unicode value of space character is '\u0020'. The
		 * definition of space used by String::trim is any code point less than or equal
		 * to the space code point (\u0020), commonly referred to as ASCII or ISO
		 * control characters. )
		 */

		boolean trimEq = "\n\t  hello   \u2005".trim().equals("hello   \u2005");
		boolean stripEq = "\n\t  hello   \u2005".strip().equals("hello   \u2005");
		/**
		 * Notice how trim() was able to trim the leading whitespace, but it didn't trim
		 * the trailing whitespace. This is because trim() is not aware of Unicode
		 * whitespace characters and hence does not consider '\u2005' a whitespace
		 * character.
		 */
		System.out.println("By trim = " + trimEq + ",  by strip = " + stripEq);

		System.out.println("-- strip() , stripLeading() , stripTrailing() -- \n");
		String str = " JD ";
		System.out.print("Start");
		System.out.print(str.strip()); // removes both sides
		System.out.println("End");
		System.out.println();

		System.out.print("Start");
		System.out.print(str.stripLeading());// beginning
		System.out.println("End");
		System.out.println();

		System.out.print("Start");
		System.out.print(str.stripTrailing());// ending
		System.out.println("End");
		System.out.println();

		var word2 = "\tnice blue\t";
		System.out.println(word2 + "sky");
		System.out.println(word2.stripLeading() + "sky");
		System.out.println(word2.stripTrailing() + "sky");
		System.out.println(word2.strip() + "sky");
		System.out.println();

		System.out.println("-- isBlank(), but we already have isEmpty(). --");
		var word3 = "   ";
		System.out.println("isEmpty: " + word3.isEmpty());
		System.out.println("isBlank: " + word3.isBlank());
		word3 = "";
		System.out.println("isEmpty: " + word3.isEmpty());
		System.out.println("isBlank: " + word3.isBlank());
		System.out.println(
				"-- But Similarly, the isBlank() method is aware of Unicode whitespace characters, where isEmpty NOT --");
		boolean isEmpty = "\n\t\u2005".isEmpty();
		boolean isBlank = "\n\t\u2005".isBlank();
		System.out.println("By isEmpty = " + isEmpty + ",  by isBlank = " + isBlank);
		System.out.println();

		System.out.println("-- lines()  --");
		// A line terminator is one of the following: â€œ\nâ€�, â€œ\râ€�, or "\r\n".
		var words = "falcon\neagle\nsky\nwood\nforest\nn";
		words.lines().forEach(System.out::println);
		str = "AB\nCD\nEF\nGH";
		System.out.println(str.lines().collect(Collectors.toList()));
		System.out.println();

		String multilineStr = "This is\n \n a multiline\n string.";
		long lineCount = multilineStr.lines().filter(String::isBlank).count();
		System.out.println("empty lineCount = " + lineCount);
		System.out.println(
				"!!!! line() method should be preferred over split(), as it provides better performance for breaking multi-line input.");

		System.out.println("\n-- repeat(n) --");
		var word = "mekdep ";
		System.out.println(word);
		String newWord = word.repeat(5);
		System.out.println(newWord);
		System.out.println();

	}
}
