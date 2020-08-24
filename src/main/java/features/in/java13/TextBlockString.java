package features.in.java13;

public class TextBlockString {
	/**
	 * JEP 355: Preview Feature
	 */
	@SuppressWarnings("preview")
	public static void main(String[] args) {
		String textBlock = """
				Hi
				Hello
				Yes""";
		
		String textBlock2 = """
				Hi
				Hello
				Yes
			""";// .. play this (space preserved, or ... white-space essential)

		String str = "Hi\nHello\nYes";

		System.out.println("Text Block Java13 String:\n" + textBlock);
		System.out.println("Normal String Literal:\n" + str);

		System.out.println("Text Block and String Literal equals() Comparison: " + (textBlock.equals(str)));
		System.out.println("Text Block and String Literal == Comparison: " + (textBlock == str));
	}
}

/**
 * New Methods in String Class for Text Blocks There are three new methods in
 * the String class, associated with the text blocks feature.
 * 
 * <pre>
 *   
 * formatted(Object… args): it’s similar to the String format() method. It’s
 * added to support formatting with the text blocks.
 * 
 * stripIndent(): used to remove the incidental white space characters from the
 * beginning and end of every line in the text block. This method is used by the
 * text blocks and it preserves the relative indentation of the content.
 * 
 * translateEscapes(): returns a string whose value is this string, with escape
 * sequences translated as if in a string literal.
 *
 * </pre>
 */
class NewMethodsInStringClassForTextBlocks {

	@SuppressWarnings("preview")
	public static void main(String[] args) {
		String output = """
			    Name: %s
			    Released: %b
			    Download: %.2f
			    """.formatted("Java13", true, 1000000.123);

		System.out.println(output);

		String htmlTextBlock = "<html>   \n" + "\t<body>\t\t \n" + "\t\t<p>Hello</p>  \t \n" + "\t</body> \n"
				+ "</html>";
		System.out.println(htmlTextBlock.replace(" ", ""));
		System.out.println(htmlTextBlock.stripIndent().replace(" ", "*"));

		String str1 = "Hi\t\nHello \" /u0022 Java13\r";
		System.out.println(str1);
		System.out.println(str1.translateEscapes());
	}
}
