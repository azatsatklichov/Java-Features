package features.in.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class E_Files_readString_and_writeString {
    public static void main(String[] args) throws IOException {

        var words = "forest\nwood\nsky\nrock";

        Files.writeString(Path.of("words.txt"), words);
         

        var data = Files.readString(Path.of("words.txt"));

        System.out.println(data);
    }
}
