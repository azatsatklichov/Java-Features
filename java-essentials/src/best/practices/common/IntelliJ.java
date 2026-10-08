package best.practices.common;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;


public class IntelliJ {
    private static final int NUM = 1;
    private static final int NUM5 = 1;
    private static final int NUM3 = 1;
    private static final int NUM4 = 1;
    private static final int NUM2 = 1;
    public static void main(String[] args) throws IOException {
        classic(null);
        fancy(null, "mails.txt");
        extracted(null);

    }

    public static void classic(String[] args) throws IOException {
        //alt+enter    code suggestion your best friend
        BufferedReader reader = new BufferedReader(new FileReader(new File("mails.txt")));//F2 helps you navigate
        BufferedReader reader2 = new BufferedReader(new FileReader("mails.txt"));
        ArrayList<String> strings = new ArrayList<>();//1. ctrl+alt+V  or 2. just put VAR.

        String line = null;
        while ((line = reader.readLine()) != null) {
            if (Utils.isValidEmail(line)) { //try !TAB
                strings.add(line); //try to put semicilon in 3 ways (manual, ctm+shift+enter)
            }

        }
        System.out.println(strings);
    }

    //convert to fancy java
    public static void fancy(String[] args, String fileName) throws IOException {
        ArrayList<String> strings;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            strings = reader.lines().filter(Utils::isValidEmail).collect(Collectors.toCollection(ArrayList::new));
        }
        System.out.println(strings);
    }

    //convert to fancy java
    public static void extracted(String[] args) throws IOException {
        ArrayList<String> strings = Utils.getStrings("mails.txt");
        System.out.println(strings);
        int sasa = "sasa".length(); //multicusrso ALT+SHIFT
        int oraz = "oraz".length();
        int dopis = "dopis".length();
    }


    //inject language, but your collegue has to do same in his machine
    String sql1 = "select * from dual";//1

    //2 way
    //language=SQL
    //@Language("SQL")
    String sq2 = "select * from public.\"Student\"";


    //language=HTML
    String html = "<html><head><title></title></head><body></body></html>";

    /**
     * <pre>
     * Emmet (e.g. html,css) html:5, div>ul>li*5, | div.color, | div#idm, (JSish, React), image-tricks, custom emmets
     * table>tr*6>td&5
     * emmets not for Angular, COBOL, .. then use Snippets. Also share it: ~\User\snippets | local)
     * </pre>
     */
    String html2 = "<!--region Description-->\n" +
            "<!--region Description-->\n" +
            "<!--region Description-->\n" +
            "<!--region Description-->\n" +
            "<html>\n" +
            "<div>\n" +
            "    <li>dsds</li>\n" +
            "    sdsds\n" +
            "    <li>dfdf</li>\n" +
            "    fdfdf\n" +
            "    <li>dfdfd</li>\n" +
            "    <li></li>\n" +
            "    <li></li>\n" +
            "    <li></li>\n" +
            "    <li></li>\n" +
            "</div>\n" +
            "<table>\n" +
            "    <tr>\n" +
            "        <td></td>\n" +
            "        <td></td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td></td>\n" +
            "        <td></td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td></td>\n" +
            "        <td></td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td></td>\n" +
            "        <td></td>\n" +
            "    </tr>\n" +
            "</table>\n" +
            "</html>\n" +
            "<!--endregion-->\n" +
            "<!--endregion-->\n" +
            "<!--endregion-->\n" +
            "<!--endregion-->";

    //Language=CSS
    String css = "body";
}
