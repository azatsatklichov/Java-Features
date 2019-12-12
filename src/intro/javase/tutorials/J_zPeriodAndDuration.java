package intro.javase.tutorials;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Desc:
 * 
 * <pre>
Period and Duration

With Java 8, two specialized classes are introduced to deal with the time differences.

Period − It deals with date based amount of time.


Duration − It deals with time based amount of time.


Let us see them in action.

Create the following Java program using any editor of your choice in, say, C:\> JAVA.
 * 
 * </pre>
 * 
 */
public class J_zPeriodAndDuration {
    public static void main(String[] args) {
        System.out.println("Period − It deals with DATE based amount of time.");

        System.out.println("Duration − It deals with TIME based amount of time.");
        J_zPeriodAndDuration java8tester = new J_zPeriodAndDuration();
        java8tester.testPeriod();
        java8tester.testDuration();
    }

    public void testPeriod() {
        // Get the current date
        LocalDate date1 = LocalDate.now();
        System.out.println("Current date: " + date1);

        // add 1 month to the current date
        LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + date2);

        Period period = Period.between(date2, date1);
        System.out.println("Period: " + period);
    }

    public void testDuration() {
        LocalTime time1 = LocalTime.now();
        
        Duration twoHours = Duration.ofHours(2);
        LocalTime time2 = time1.plus(twoHours);
        //LocalTime time2 = time1.plus(2, ChronoUnit.HOURS);
        
        Duration duration = Duration.between(time1, time2);

        System.out.println("Duration: " + duration);
    }
}