package features.in.java8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * <pre>
 Java 8, new Date-Time API is introduced to cover the following drawbacks of old date-time API.
 
Not thread safe − java.util.Date is not thread safe, thus developers have to deal with concurrency issue while using date. The new date-time API is immutable and does not have setter methods.

Poor design − Default Date starts from 1900, month starts from 1, and day starts from 0, so no uniformity. The old API had less direct methods for date operations. The new API provides numerous utility methods for such operations.

Difficult time zone handling − Developers had to write a lot of code to deal with timezone issues. The new API has been developed keeping domain-specific design in mind.

Java 8 introduces a new date-time API under the package java.time. Following are some of the important classes introduced in java.time package.

Local − Simplified date-time API with no complexity of timezone handling.

Zoned − Specialized date-time API to deal with various timezones.
 * </pre>
 *
 */
public class NewDateTimeAPI {
}

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

class LocalDateTimeDemo {

	public static void main(String args[]) {

		/**
		 * Java 8 introduces a new date-time API under the package java.time. Following
		 * are some of the important classes introduced in java.time package.
		 * 
		 * <pre>
		
		Local − Simplified date-time API with no complexity of timezone handling.
		
		
		Zoned − Specialized date-time API to deal with various timezones.
		 * 
		 * 
		 * </pre>
		 * 
		 */
		LocalDateTimeDemo ts = new LocalDateTimeDemo();
		ts.testLocalDateTime();
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
	 * LocalDate date = LocalDate.of(2012, 1, 2); int wby = 2012; int week = 1; int
	 * dow = 1; for (int i = 1; i <= ((52 + 52 + 52 + 53 + 52) * 7); i++) { for (int
	 * j = -5; j <= 5; j++) { LocalDate adjusted =
	 * IsoFields.WEEK_BASED_YEARS.addTo(date, j);
	 * assertEquals(adjusted.get(DAY_OF_WEEK), dow);
	 * assertEquals(adjusted.get(weekField), (week == 53 && wbyLen(wby + j) == 52 ?
	 * 52 : week), "" + date + " " + adjusted); } if (dow == 7) { dow = 1; week++; }
	 * else { dow++; } if (week > wbyLen(wby)) { week = 1; wby++; } date =
	 * date.plusDays(1); } }
	 */

}

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
class ZonedDateTimeDemo {

	public static void main(String[] args) {
		ZonedDateTimeDemo ts = new ZonedDateTimeDemo();
		ts.testZonedDateTime();
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

/**
 * Backward Compatibility
 * 
 * <pre>

A toInstant() method is added to the original Date and Calendar objects, which can be used to convert them to the new Date-Time API. Use an ofInstant(Insant,ZoneId) method to get a LocalDateTime or ZonedDateTime object. Let us see them in action.

Create the following Java program using any editor of your choice in, say, C:\> JAVA.
 * 
 * </pre>
 * 
 */
class BackwardCompatibility {
	public static void main(String args[]) {
		BackwardCompatibility pad = new BackwardCompatibility();
		pad.testBackwardCompatability();
	}

	public void testBackwardCompatability() {

		// Get the current date
		Date currentDate = new Date();
		System.out.println("Current date: " + currentDate);

		// Get the instant of current date in terms of milliseconds
		Instant now = currentDate.toInstant();
		ZoneId currentZone = ZoneId.systemDefault();

		LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
		System.out.println("Local date: " + localDateTime);

		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
		System.out.println("Zoned date: " + zonedDateTime);
	}
}

class PeriodAndDuration {
	public static void main(String[] args) {
		System.out.println("Period  - It deals with DATE based amount of time.");

		System.out.println("Duration  - It deals with TIME based amount of time.");
		PeriodAndDuration pad = new PeriodAndDuration();
		pad.testPeriod();
		System.out.println();
		pad.testDuration();
	}

	public void testPeriod() {
		// Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("Current date: " + date1);

		// add 1 month to the current date
		LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + date2);
		System.out.println();

		Period period = Period.between(date2, date1);
		System.out.println("Period: " + period);
	}

	public void testDuration() {
		LocalTime time1 = LocalTime.now();

		Duration twoHours = Duration.ofHours(2);
		LocalTime time2 = time1.plus(twoHours);
		// LocalTime time2 = time1.plus(2, ChronoUnit.HOURS);

		Duration duration = Duration.between(time1, time2);

		System.out.println("Duration: " + duration);
	}
}

class TemporalAdjustersDemo {
	public static void main(String args[]) {
		TemporalAdjustersDemo ts = new TemporalAdjustersDemo();
		ts.testAdjusters();
	}

	public void testAdjusters() {
		// Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("Current date: " + date1);

		// get the next tuesday
		LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("Next Tuesday on : " + nextTuesday);

		// get the second saturdmonth
		LocalDate firstInYear = LocalDate.of(date1.getYear(), date1.getMonth(), 1);
		LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
				.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday on : " + secondSaturday);
	}
}