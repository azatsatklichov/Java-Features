package intro.javase.tutorials;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Desc:
 * 
 * <pre>
Chrono Units Enum

java.time.temporal.ChronoUnit enum is added in Java 8 to replace the integer values used in old 
API to represent day, month, etc. Let us see them in action.

Create the following Java program using any editor of your choice in, say, C:\> JAVA.
 * 
 * 
 * </pre>
 * 
 */
public class j_zChronoUnits {
    public static void main(String[] args) {
        j_zChronoUnits java8tester = new j_zChronoUnits();
        java8tester.testChromoUnits();
    }

    public void testChromoUnits() {
        // Get the current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        // add 1 week to the current date
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: " + nextWeek);

        // add 1 month to the current date
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + nextMonth);

        // add 1 year to the current date
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Next year: " + nextYear);

        // add 10 years to the current date
        LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
        System.out.println("Date after ten year: " + nextDecade);
    }
}
