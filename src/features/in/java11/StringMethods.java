package features.in.java11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringMethods {
	/**
	 * {@link java.lang.String#trim() }
	 * {@link java.lang.String#strip }
	 * 
	 * {@see java.lang.String }
	 */
	public static void main(String[] args) {
		System.out.println(
				"We already have trim(). Then what’s the need of strip() ? strip() is Unicode-aware evolution of trim(). "
				+ "When trim() was introduced, Unicode wasn't fully evolved / standardized as today.");
		System.out.println("-- strip() , stripLeading() , stripTrailing() -- \n");
		/**
		 * When trim() was introduced, Unicode wasn’t evolved. Now, the new strip()
		 * removes all kinds of white spaces leading and trailing(check the method
		 * Character.isWhitespace(c) to know if a unicode is whitespace or not. 
		 * Unicode-aware trimming routines should use Character::isWhitespace(int).
		 * 
		 * The java lang.string.trim()is a built-in function that eliminates leading and trailing spaces. The Unicode value of space character is '\u0020'.
		 * The definition of space used by String::trim is any code point less than or equal to the space code point (\u0020), commonly referred to as ASCII or ISO control characters. ) 
		 */
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

		System.out.println("-- isBlank(), but we already have isEmpty() --");
		var word3 = "   ";
		System.out.println("isEmpty: " + word3.isEmpty());
		System.out.println("isBlank: " + word3.isBlank());
		word3 = "";
		System.out.println("isEmpty: " + word3.isEmpty());
		System.out.println("isBlank: " + word3.isBlank());
		System.out.println();

		System.out.println("-- lines()  --");
		var words = "falcon\neagle\nsky\nwood\nforest\nn";
		words.lines().forEach(System.out::println);
		str = "AB\nCD\nEF\nGH";
		System.out.println(str.lines().collect(Collectors.toList()));
		System.out.println();

		System.out.println("-- repeat(n) --");
		var word = "mekdep ";
		System.out.println(word);
		String newWord = word.repeat(5);
		System.out.println(newWord);
		System.out.println();

		// Local-Variable Syntax for Lambda Parameters
		System.out.println("J11 - Local-Variable Syntax for Lambda Parameters");
		/**
		 * local-Variable Syntax for Lambda Parameters is the only language feature
		 * release in Java 11. In Java 10, Local Variable Type Inference was introduced.
		 * Thus we could infer the type of the variable from the RHS – var list = new
		 * ArrayList<String>();
		 * 
		 */
		var list = new ArrayList<String>();
		System.out.println(list);
		var list2 = List.of();
		System.out.println(list2);
		var list3 = List.of("hello", "hi");
		System.out.println(list3);
	}
}
