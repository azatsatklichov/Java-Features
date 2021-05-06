package features.in.java13;
public class TextBlockDemo {

  public static void main(String[] args) {
    String text = "Hello";
    System.out.println(text);
  }

  private static void showWhitespace(String string) {
    System.out.println(string.replaceAll(" ", "·").replaceAll("\n", "\\\\n\n"));
  }

}
