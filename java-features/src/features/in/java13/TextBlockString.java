package features.in.java13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import features.in.java11.FilesReadStringWriteString;

public class TextBlockString {
	/**
	 * JEP 355: Preview Feature
	 */
	@SuppressWarnings("preview")
	public static void main(String[] args) {
		 String text = """
		    		Bu kop
		    		ha tarly
		    		soz"""; 
		    System.out.println(text);
		    showWhitespace(text);
		    
		String textBlock = """
					Hi
				"Hello\n\to"
				Yes""";  //no last line
				//"""; ///adds last line
		
		String textBlock2 = """
					Hi
				"Hello\n\to"
				Yes
			""";// .. play this (space preserved, or ... white-space essential)
		
		String textBlock3 = """
					Hi
				"Hello\n\to"
				Yes
	 """;// .. play this (space preserved, or ... white-space essential)
		System.out.println(textBlock);
		System.out.println(textBlock2);
		System.out.println(textBlock3);

		// Using a literal string
		String dqName = "Nusga Copy Kopirovat";
		String dqName2 = new String("Nusga Copy Kopirovat");

		// Using a text block
		String tbName = """
		                Nusga Copy Kopirovat""";

		System.out.println("Normal String Literal:\n" + dqName);
		System.out.println("Text Block Java13 String:\n" + tbName);

		System.out.println("Text Block and String Literal equals() Comparison: " + (tbName.equals(dqName)));
		System.out.println("Text Block and String Literal (in pool) == Comparison: " + (tbName == dqName));
		System.out.println("Text Block and String Literal (not in pool) == Comparison: " + (tbName == dqName2));
	}
	
	 private static void showWhitespace(String string) {
		    System.out.println(string.replaceAll(" ", "·").replaceAll("\n", "\\\\n\n"));
		  }
}

/**
 * New Methods in String Class for Text Blocks There are three new methods in
 * the String class, associated with the text blocks feature.
 * 
 * <pre>
 *   
 * formatted(Object� args): it�s similar to the String format() method. It�s
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
	public static void main(String[] args) throws IOException {
		//old formatter, using text-block as first-parameter is weird 
		String x = String.format("""
			    Name: %s
			    Released: %b
			    Download: %.2f
			    """, "Java13", true, 1000000.123); 
		System.out.println(x);
		
		//better way
		String output = """
			    Name: %s
			    Released: %b
			    Download: %.2f
			    """.formatted("Java13", true, 1000000.123);

		System.out.println(output);

		String htmlTextBlock = "<html>   \n" + "\t<body>\t\t \n" + "\t\t<p>Hello</p>  \t \n" + "\t</body> \n"
				+ "</html>";
		System.out.println(htmlTextBlock);
		System.out.println(htmlTextBlock.replace(" ", ""));
		System.out.println(htmlTextBlock.stripIndent().replace(" ", "*"));

		String str1 = "Hi\t\nHello \" /u0022 Java13\r";
		System.out.println(str1);
		var data = Files.readString(Path.of("wordz.txt"));		 
		//as you see all escapes printed directly 
		System.out.println(data);
		//really handy method especially once getting raw text, containing full-of escapes
		System.out.println(data.translateEscapes());
	}
}
