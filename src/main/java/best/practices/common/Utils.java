package best.practices.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {
    static ArrayList<String> getStrings(String fileName) throws IOException {
        ArrayList<String> strings;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            strings = reader.lines().filter(Utils::isValidEmail).collect(Collectors.toCollection(ArrayList::new));
        }
        return strings;
    }

    static boolean isValidEmail(String line) {
        Pattern pattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$"); //try Check RegExp
        Matcher matcher = pattern.matcher(line);
        //!line.isEmpty();//!TAB try
        return matcher.find() && line.contains("3");
    }
}
