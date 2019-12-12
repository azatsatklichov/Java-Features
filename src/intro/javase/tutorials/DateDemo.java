package intro.javase.tutorials;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

    public static void main(String args[]) {
        // Instantiate a Date object
        Date date = new Date();

        // display time and date using toString()
        System.out.println(date.toString());

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        System.out.println("-- format via  SimpleDateFormat --- ");
        System.out.println("Current Date: " + ft.format(dNow));
        ft = new SimpleDateFormat("dd.mm.yyyy hh:mm:ss"); 
        System.out.println("Current Date: " + ft.format(dNow));

        System.out.println();

        System.out.println();
        System.out.println("-- format via  String.format --- ");
        // display time and date
        String str = String.format("Current Date/Time : %tc", date);
        System.out.printf(str);
        System.out.println();
        System.out.print(dNow);
        System.out.println();
        // display time and date
        System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);
        System.out.println();
        // display formatted date
        System.out.printf("%s %tB %<te, %<tY", "Due date:", date);
        /**
         * Desc:
         * 
         * <pre>
         Date and Time Conversion Characters
        
        
        Character
        
        Description
        
        Example
        
        c Complete date and time Mon May 04 09:51:52 CDT 2009 
        F ISO 8601 date 2004-02-09 
        D U.S. formatted date (month/day/year) 02/09/2004 
        T 24-hour time 18:05:19 
        r 12-hour time 06:05:19 pm 
        R 24-hour time, no seconds 18:05 
        Y Four-digit year (with leading zeroes) 2004 
        y Last two digits of the year (with leading zeroes) 04 
        C First two digits of the year (with leading zeroes) 20 
        B Full month name February 
        b Abbreviated month name Feb 
        m Two-digit month (with leading zeroes) 02 
        d Two-digit day (with leading zeroes) 03 
        e Two-digit day (without leading zeroes) 9 
        A Full weekday name Monday 
        a Abbreviated weekday name Mon 
        j Three-digit day of year (with leading zeroes) 069 
        H Two-digit hour (with leading zeroes), between 00 and 23 18 
        k Two-digit hour (without leading zeroes), between 0 and 23 18 
        I Two-digit hour (with leading zeroes), between 01 and 12 06 
        l Two-digit hour (without leading zeroes), between 1 and 12 6 
        M Two-digit minutes (with leading zeroes) 05 
        S Two-digit seconds (with leading zeroes) 19 
        L Three-digit milliseconds (with leading zeroes) 047 
        N Nine-digit nanoseconds (with leading zeroes) 047000000 
        P Uppercase morning or afternoon marker PM 
        p Lowercase morning or afternoon marker pm 
        z RFC 822 numeric offset from GMT -0800 
        Z Time zone PST 
        s Seconds since 1970-01-01 00:00:00 GMT 1078884319 
        Q Milliseconds since 1970-01-01 00:00:00 GMT 1078884319047
         * 
         * </pre>
         * 
         */
        System.out.println();
        System.out.println();
        System.out.println("Parsing Strings into Dates");
        ft = new SimpleDateFormat("yyyy-MM-dd");
        String input = args.length == 0 ? "1818-11-11" : args[0];

        System.out.print(input + " Parses as ");
        Date t;
        try {
            t = ft.parse(input);
            System.out.println(t);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }

        System.out.println("-- time milles --");
        try {
            long start = System.currentTimeMillis();
            System.out.println(new Date() + "\n");

            Thread.sleep(5 * 60 * 10);
            System.out.println(new Date() + "\n");

            long end = System.currentTimeMillis();
            long diff = end - start;
            System.out.println("Difference is : " + diff);
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }

    }
}