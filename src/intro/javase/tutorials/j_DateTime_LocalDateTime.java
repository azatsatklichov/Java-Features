package intro.javase.tutorials;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Desc:
 * 
 * <pre>
With Java 8, a new Date-Time API is introduced to cover the following drawbacks of old date-time API.

Not thread safe − java.util.Date is not thread safe, thus developers have to deal with concurrency
 issue while using date. The new date-time API is immutable and does not have setter methods.


Poor desig
n − Default Date starts from 1900, month starts from 1, and day starts from 0, so no uniformity. The old API had less direct methods for date operations. The new API provides numerous utility methods for such operations.


Difficult time zone handling − Developers had to write a lot of code to deal with timezone issues. 
The new API has been developed keeping domain-specific design in mind.
 * 
 * 
 * </pre>
 * 
 */

public class j_DateTime_LocalDateTime {

    public static void main(String args[]) {

        /**
         * Java 8 introduces a new date-time API under the package java.time.
         * Following are some of the important classes introduced in java.time
         * package.
         * 
         * <pre>
        
        Local − Simplified date-time API with no complexity of timezone handling.
        
        
        Zoned − Specialized date-time API to deal with various timezones.
         * 
         * 
         * </pre>
         * 
         */
        j_DateTime_LocalDateTime java8tester = new j_DateTime_LocalDateTime();
        java8tester.testLocalDateTime();
    }

    public void testLocalDateTime() {
        System.out.println();
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month:" + month + " day:" + day + " seconds:" + seconds);

        System.out.println();
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println(" date3: " + date3);

        // 22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
        System.out.println(date5.getHour());
        System.out.println(date5.getMinute());
        System.out.println(date5.getSecond());

        date5 = LocalTime.parse("20:15:30.232");

        System.out.println(date5.getNano());

        // System.out.println(date5.get(TemporalField));

        LocalTime tm = currentTime.toLocalTime();
        System.out.println("date1: " + tm);
    }

    /*
     * public static void test_addTo_weekBasedYears(TemporalField weekField,
     * TemporalField yearField) { // tests every day from 2012 to 2016 inclusive
     * LocalDate date = LocalDate.of(2012, 1, 2); int wby = 2012; int week = 1;
     * int dow = 1; for (int i = 1; i <= ((52 + 52 + 52 + 53 + 52) * 7); i++) {
     * for (int j = -5; j <= 5; j++) { LocalDate adjusted =
     * IsoFields.WEEK_BASED_YEARS.addTo(date, j);
     * assertEquals(adjusted.get(DAY_OF_WEEK), dow);
     * assertEquals(adjusted.get(weekField), (week == 53 && wbyLen(wby + j) ==
     * 52 ? 52 : week), "" + date + " " + adjusted); } if (dow == 7) { dow = 1;
     * week++; } else { dow++; } if (week > wbyLen(wby)) { week = 1; wby++; }
     * date = date.plusDays(1); } }
     */

}