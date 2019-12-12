package intro.javase.tutorials;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 
 * Zoned Date-Time API
 * 
 * <pre>

Zoned date-time API is to be used when time zone is to be considered. Let us see them in action.

Create the following Java program using any editor of your choice in, say, C:\> JAVA.
 * 
 * </pre>
 * 
 */
public class j_DateTime_ZonedDateTime {

    public static void main(String[] args) {
        j_DateTime_ZonedDateTime java8tester = new j_DateTime_ZonedDateTime();
        java8tester.testZonedDateTime();
    }

    public void testZonedDateTime() {
        // Get the current date and time
        ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("CurrentZone: " + currentZone);
        System.out.println();
        System.out.println("All: " + ZoneId.SHORT_IDS);
    }

}
