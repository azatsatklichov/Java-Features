package intro.javase.tutorials;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * GregorianCalendar Class
 * 
 * <pre>
 * 
 * 
 * GregorianCalendar is a concrete implementation of a Calendar class that
 * implements the normal Gregorian calendar with which you are familiar. We did
 * not discuss Calendar class in this tutorial, you can look up standard Java
 * documentation for this.
 * 
 * The getInstance( ) method of Calendar returns a GregorianCalendar initialized
 * with the current date and time in the default locale and time zone.
 * GregorianCalendar defines two fields: AD and BC. These represent the two eras
 * defined by the Gregorian calendar.
 * 
 * There are also several constructors for GregorianCalendar objects
 * 
 * </pre>
 * 
 */
public class GregorianCalendarDemo {

    public static void main(String args[]) {
        String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

        int year;
        // Create a Gregorian calendar initialized
        // with the current date and time in the
        // default locale and timezone.

        GregorianCalendar gcalendar = new GregorianCalendar();
        /**
         *  new BuddhistCalendar(zone, aLocale);
                    break;
                case "japanese":
                    cal = new JapaneseImperialCalendar(zone, aLocale);
                    break;
                case "gregory":
                    cal = new GregorianCalendar(zone, aLocale);
                    break;
         */
        //Calendar c = Calendar.getInstance();

        // Display current time and date information.
        System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));

        // Test if the current year is a leap year
        if (gcalendar.isLeapYear(year)) {
            System.out.println("The current year is a leap year");
        } else {
            System.out.println("The current year is not a leap year");
        }
    }

}
