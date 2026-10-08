package features.in.java9;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.stream.Stream;

public class DatesUntil {

    public static void main(String... args) {
        LocalDate start = LocalDate.of(1977, 10, 6);
        Stream<LocalDate> dates = start.datesUntil(start.plusDays(7));
        dates.forEach(System.out::println);  


        LocalDate birthday = LocalDate.of(1977, 10, 6);

        long leapYears = birthday
                .datesUntil(LocalDate.now(), Period.ofYears(1))
                .map(d -> Year.of(d.getYear()))
                .filter(Year::isLeap)
                .count();

        System.out.printf("%d leap years since Azat was born on %s", leapYears, birthday);
    }
}
