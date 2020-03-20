package features.in.java9;

/**
 * Java 9 comes with 2 major changes on how String behaves to lower memory usage
 * and improve performance.
 * 
 * History Java was originally developed to support UCS-2, also referred to as
 * Unicode at the time, using 16 bits per character allowing for 65,536
 * characters. It�s only in 2004 with Java 5 that UTF-16 support was introduced
 * by adding a method to extract 32 bits code point from chars.
 * 
 * https://www.infoq.com/news/2016/02/compact-strings-Java-JDK9/
 * https://www.youtube.com/watch?v=qh-4LRRAAFg
 * 
 * First of all, JDK 6 UseCompressedStrings taught us that many applications
 * enjoy 1-byte Strings, and the footprint/performance benefits are enormous.
 * Therefore, we (JEP developers) were convinced that the "big picture" is
 * correct, and we "just" need to work out little details.
 * 
 * Second, UseCompressedStrings feature was rather conservative: while
 * distinguishing between char[] and byte[] case, and trying to compress the
 * char[] into byte[] on String construction, it done most String operations on
 * char[], which required to unpack the String. Therefore, it benefited only a
 * special type of workloads, where most strings are compressible (so
 * compression does not go to waste), and only a limited amount of known String
 * operations are performed on them (so no unpacking is needed). In great many
 * workloads, enabling -XX:+UseCompressedStrings was a pessimization.
 * 
 *
 */
public class CompactAndIndifyStrings {
	public static void main(String[] args) {
		System.out.println("Compact Strings");
		/**
		 * 
		 * Compact Strings
		 * 
		 * //Lower memory usage
		 * 
		 * //Effective immediately without code changes 
		 * 
		 * invokedynamic bytocode
		 * 
		 * 
		 * String concatenation changes
		 * 
		 * - change concatenation translation strategy
		 * 
		 * - Groundwork for future improvements
		 * 
		 * 
		 * 
		 * 
		 * 
		 * The JEP 254 goal was to build a more memory efficient String when possible
		 * that would have at least the same performance as the current implementation.
		 * Instead of switching between char[] and byte[], it is always backed by a
		 * byte[]. If it only contains LATIN-1 characters, each one is stored in one
		 * byte, otherwise, the characters are stored as UTF-16 on 2 bytes - a code
		 * point can expand over more than 2 bytes. A marker has also been added to
		 * store the coder used.
		 * 
		 * The String methods have a specialised implementation for LATIN-1 and UTF-16.
		 * Most of these methods will be replaced by an optimised intrinsic at runtime.
		 * 
		 * This feature is enabled by default and can be switch off using the
		 * -XX:-CompactStrings.
		 * 
		 * Note that switching it off does not revert to a char[] backed implementation,
		 * it will just store all the Strings as UTF-16.
		 * 
		 * StringBuilder and StringBuffer are now also backed by a byte[] to match the
		 * String implementation.
		 */
		System.out.println(
				" -- This feature is enabled by default and can be switch off using the -XX:-CompactStrings --");

		// In Java 8 and previous - except for UseCompressedStrings - a String is
		// basically
		final char value[];

		// each method will access that char array. In Java 9 we now have
		final byte[] value2;
		final byte coder2;

		// where coder can be
		final byte LATIN1 = 0;
		final byte UTF16 = 1;

		// most of the methods then will check the coder and dispatch to the specific
		// implementation.
		/*
		 * public int indexOf(int ch, int fromIndex) { return isLatin1() ?
		 * StringLatin1.indexOf(value, ch, fromIndex) : StringUTF16.indexOf(value, ch,
		 * fromIndex); }
		 * 
		 * private boolean isLatin1() { return COMPACT_STRINGS && coder == LATIN1; }
		 */

		System.out.println("\n-- Indify String Concatenation --");
		System.out.println(
				"OptimizeStringConcat implementation is quite fragile and it�s easy to have the code fall outside the Abstract Syntax Tree pattern recognition");
		/**
		 * Indify String Concatenation addresses this problem by replacing the
		 * concatenation byte-code by an InvokeDynamic call, and a bootstrap method that
		 * will generate the concat call.
		 * 
		 * Now the optimisation won�t depend on the AST analyses, and the code is
		 * generated from java making it easier to maintain.
		 */
		String str = "foo" + "bar";

	}

}
