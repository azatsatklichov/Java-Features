package features.in.java15;
public class TextBlocks {
    public static void main(String... args) {
        String jsonString = """
            {
                  "firstName": "Sander",
                  "lastName": "%s"
            }""".formatted("Mak");

        System.out.println(jsonString);
    }
}
