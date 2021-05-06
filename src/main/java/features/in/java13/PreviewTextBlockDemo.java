package features.in.java13;


class TextBlocksBefore {
		String html ="<html>\n" +
	            "   <body>\n" +
	            "      <p>Hello, World</p>\n" +
	            "   </body>\n" +
	            "</html>\n";
	
	
		String json ="{\n" +
	            "   \"name\":\"mkyong\",\n" +
	            "   \"age\":38\n" +
	            "}\n"; 	
}

class TextBlocksAfter{
		String html =  """
	            <html>
	                <body>
	                    <p>Hello, World</p>
	                </body>
	            </html>
	                    """;
	
		String json = """
	            {
	                "name":"mkyong",
	                "age":38
	            }
	            """;	
}



public class PreviewTextBlockDemo {

  public static void main(String[] args) {
    String text = """
          This is "definitely"
          a multi-line
          String
          """;

    showWhitespace(text);
  }

  private static void showWhitespace(String string) {
    System.out.println(string.replaceAll(" ", "·").replaceAll("\n", "\\\\n\n"));
  }

}
