package features.in.java14;

public class TextBlocks {

	/**
	 * The first preview appeared in Java 13 JEP 354, now added two more new escape
	 * sequences:
	 * 
	 * \<end-of-line> suppresses the line termination. 
	 * 
	 * \s is translated into a single space.
	 * 
	 * 
	 * @param args
	 */
	    public static void main(String[] args) {

	        String html = "<html>\n" +
	                      "   <body>\n" +
	                      "      <p>Hello, World</p>\n" +
	                      "   </body>\n" +
	                      "</html>\n";

	        String java13 = """
	                        <html>
	                            <body>
	                                <p>Hello, World</p>
	                            </body>
	                        </html>
	                        """;

	        //\  <end-of-line> suppresses the line termination.  \s is translated into a single space.
	        String java14 = """
	                        <html>
	                            <body>\
	                                <p>Hello, '\s' World "\s\s" oo</p>
	                            </body>
	                        </html>
	                        """;

	        System.out.println(html);
	        System.out.println(java13);
	        //useful to hold in single line 
	        System.out.println(java14);

	    }

	} 
