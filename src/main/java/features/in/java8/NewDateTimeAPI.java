package features.in.java8;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
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
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

/**
 * <pre>
 * 
 * Regarding to below issues, it is already in Java 7, joda-time library started used. 
 * And Java 8 is based on joda-time library. 
 * 
 * 
 Java 8, new Date-Time API is introduced to cover the following drawbacks of old date-time API.
 
java.util.Date is Mutable, this cause a corrupted data. Otherwise you need to solve the issue with Defencive copying 

 
Not thread safe  java.util.Date is not thread safe, thus developers have to deal with concurrency issue while using date. 
The new date-time API is immutable and does not have setter methods.

Poor design  Default Date starts from 1900, month starts from 1, and day starts from 0, so no uniformity. 
The old API had less direct methods for date operations. The new API provides numerous utility methods for such operations.

Difficult time zone handling  Developers had to write a lot of code to deal with timezone issues. 
The new API has been developed keeping domain-specific design in mind.

Java 8 introduces a new date-time API under the package java.time. 
Following are some of the important classes introduced in java.time package.

Local  Simplified date-time API with no complexity of timezone handling.

Zoned  Specialized date-time API to deal with various timezones.
 * </pre>
 *
 */
public class NewDateTimeAPI {
}

class LocalDateTimeDemo {

	public static void main(String args[]) {

		/**
		 * Java 8 introduces a new date-time API under the package java.time. Following
		 * are some of the important classes introduced in java.time package.
		 * 
		 * <pre>
		
		Local  Simplified date-time API with no complexity of timezone handling.
		
		
		Zoned  Specialized date-time API to deal with various timezones.
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
		LocalTime date4 = LocalTime.of(22, 15); //.of(27, 15) Exception in thread "main" java.time.DateTimeException: Invalid value for HourOfDay (valid values 0 - 23): 27
		System.out.println("date4: " + date4);
		System.out.println("date4.getMinute(): " + date4.getMinute());
		System.out.println("date4.getHour(): " + date4.getHour());
		System.out.println("date4.getSecond(): " + date4.getSecond());

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

		// bed time cal
		LocalTime time2Sleep = LocalTime.of(23, 49);
		LocalTime wakeUp = time2Sleep.plusHours(7); // LocalTime.of(7, 33);
		System.out.println("time to sleep: "+time2Sleep );
		System.out.println("wake up time: " + wakeUp);

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
		System.out.println("All short IDs: " + ZoneId.SHORT_IDS.size());
		System.out.println("All short IDs: " + ZoneId.SHORT_IDS);
		System.out.println();		
		
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println("All available Zones: " + availableZoneIds.size() );
		int ctn = 0;
		for (String val : availableZoneIds) {
			ctn++;
			if(ctn % 40 == 0) {
				System.out.println();
			}
			System.out.print(val + ", ");			
		}
		System.out.println(availableZoneIds);

		ZoneId dubai = ZoneId.of("Asia/Dubai");
		System.out.println(dubai);
		ZonedDateTime date = ZonedDateTime.now(dubai);
		System.out.println("Time in Dubai now: " + date);

		// custom
		ZonedDateTime meeting = ZonedDateTime.of(1733, Month.MAY.getValue(), 18, 30, 0, 0, 0, ZoneId.of("Asia/Ashgabat"));
		System.out.println("Time in Ashgabat Turkmenistan now: " + meeting);

		// meeting organizing
		meeting = ZonedDateTime.of(LocalDate.of(2020, Month.APRIL, 1), LocalTime.of(9, 30), ZoneId.of("Europe/Prague"));
		System.out.println("Meeting time Prague: " + meeting);
		// Returns a copy of this date-time with the specified amount added
		meeting = meeting.plus(Period.ofWeeks(1)); // example of immutable
		System.out.println("next Meeting in a week: " + meeting);

		meeting = meeting.plus(Period.ofMonths(1));
		System.out.println("next Meeting in a Month: " + meeting);

		meeting = meeting.plus(Period.ofMonths(4));
		System.out.println("next Meeting after 3 month: " + meeting);

		// to setup it to your collegues in different timeZone
		meeting = meeting.withZoneSameInstant(ZoneId.of("US/Central"));
		System.out.println("next Meeting with Venkat: " + meeting);

	}

}

class InstantDurationAndPeriod {
	public static void main(String[] args) throws InterruptedException {
		InstantDurationAndPeriod pad = new InstantDurationAndPeriod();

		System.out.println("Duration  - It deals with TIME based amount of time. "
				+ "So Duration is an amount between two Instants");
		pad.testDuration();
		System.out.println();

		// Some cases are not an Instance(time) based, but Date based, e.g. Let's meet
		// tomorrow at 14:00
		System.out.println("Period  - It deals with DATE based amount of time. Period is amount between two dates");
		pad.testPeriod();

	}

	public void testDuration() throws InterruptedException {

		System.out.println("Instant - is a point on Timeline, measured with nanosecond. It is IMMUTABLE");
		Instant.now();
		/*
		 * Instant o means 1970 at midnight GMT Instant.MAX = 31.Dec 1000000000 year or
		 * 1 billion years after
		 * 
		 * Instant.MIN - 1 billion years ago;
		 * 
		 * Instant
		 */
		Instant start = Instant.now();
		Thread.currentThread().sleep(3000);
		Instant end = Instant.now();
		Duration elapsed = Duration.between(start, end);
		System.out.println("Duration  elapsed = " + elapsed);

		LocalTime time1 = LocalTime.now();

		Duration twentyFiveHours = Duration.ofHours(28);
		LocalTime time2 = time1.plus(twentyFiveHours);
		// LocalTime time2 = time1.plus(2, ChronoUnit.HOURS);

		Duration duration = Duration.between(time1, time2);

		System.out.println("Duration: " + duration);
		System.out.println("Days" + duration.toDays());
		System.out.println("Hours: " + duration.toHours());
		System.out.println("Nanos  = " + duration.toNanos());
		System.out.println("Days  = " + duration.toDays());
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

		LocalDate birth = LocalDate.of(1733, Month.MAY, 18);
		System.out.println(birth);
		Period yearsPassed = birth.until(LocalDate.now());
		System.out.println("Years passed: " + yearsPassed.getYears());
		System.out.println("Days passed (ramins after years, if you want exact number, then use ChronoUnit.DAYS ): " + yearsPassed.getDays());

		long years2Way = birth.until(LocalDate.now(), ChronoUnit.YEARS);
		System.out.println("Years passed: " + years2Way);

		long asyr = birth.until(LocalDate.now(), ChronoUnit.CENTURIES);
		System.out.println("Asyr passed: " + asyr);

		long days = birth.until(LocalDate.now(), ChronoUnit.DAYS);
		System.out.println("days passed: " + days);

		System.out.println("Period: P286Y9M24D Period, 286 year 9 month 24 day " + yearsPassed);
		System.out.println(yearsPassed.get(ChronoUnit.YEARS));
		System.out.println(yearsPassed.get(ChronoUnit.MONTHS));
		System.out.println(yearsPassed.get(ChronoUnit.DAYS));

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

		// get the second saturday of month
		LocalDate firstInYear = LocalDate.of(date1.getYear(), date1.getMonth(), 1);
		LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
				.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday on : " + secondSaturday);

		// shows week day in month, so first friday in this month
		LocalDate daysOfWeekInMonth = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.FRIDAY));
		System.out.println("first friday : " + daysOfWeekInMonth);
		// after five weeks (4 weeks for this month), Friday
		daysOfWeekInMonth = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(5, DayOfWeek.FRIDAY));
		System.out.println("5th friday : " + daysOfWeekInMonth);
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
class BackwardCompatibilityBrdgesBetweenAPIs {
	public static void main(String args[]) {
		BackwardCompatibilityBrdgesBetweenAPIs pad = new BackwardCompatibilityBrdgesBetweenAPIs();
		pad.testBackwardCompatability();
	}

	public void testBackwardCompatability() {

		System.out.println();
		Instant instant = Instant.now();
		System.out.println("Instant: " + instant);
		System.out.println();
		System.out.println("from Instant to Legacy Date and back");
		// from Instant to Legacy Date
		Date legacyDate = Date.from(instant);
		System.out.println(legacyDate);

		// from Legacy Date to Instant
		Instant instant2 = legacyDate.toInstant();
		System.out.println(instant2);

		System.out.println();
		System.out.println("from Instant to Legacy Timestamp and back");

		// from Instant to legacyTimestamp
		Timestamp legacyTimestamp = Timestamp.from(instant);
		System.out.println(legacyTimestamp);

		// from legacyTimestamp to Instant
		Instant instant3 = legacyTimestamp.toInstant();
		System.out.println(instant3);

		System.out.println();
		LocalDate date = LocalDate.now();
		Instant nowi  = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
		ZoneId currentZone = ZoneId.systemDefault();

		LocalDateTime localDateTime = LocalDateTime.ofInstant(nowi, currentZone);
		System.out.println("Local date: " + localDateTime);

		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(nowi, currentZone);
		System.out.println("Zoned date: " + zonedDateTime);

	}
}

class DateTimeFormatters {

	public static void main(String args[]) {
		System.out.println("old DateTime API way");
		Locale locale = new Locale("fr", "FR");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(new Date());
		System.out.print(date);
		System.out.println();
		System.out.println();

		// http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
		String pattern = "EEEEE dd MMMMM yyyy HH:mm:ss.SSSZ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("da", "DK"));

		date = simpleDateFormat.format(new Date());
		System.out.println(date);
		System.out.println();

		locale = new Locale("en", "UK");
		DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
		dateFormatSymbols.setWeekdays(new String[] { "Unused", "Sam Sunday", "Manic Monday", "Thriving Tuesday",
				"Wet Wednesday", "Total Thursday", "Fat Friday", "Super Saturday", });

		pattern = "EEEEE MMMMM yyyy";
		simpleDateFormat = new SimpleDateFormat(pattern, dateFormatSymbols);

		date = simpleDateFormat.format(new Date());
		System.out.println(date);

		System.out.println("\nnew DateTime API way");
		ZonedDateTime meeting = ZonedDateTime.of(LocalDate.of(2020, Month.APRIL, 1), LocalTime.of(9, 30),
				ZoneId.of("Europe/Prague"));
		System.out.println(meeting);
		System.out.println("ISO_DATE_TIME formatted = " + DateTimeFormatter.ISO_DATE_TIME.format(meeting));
		System.out.println("RFC_1123_DATE_TIME formatted = " + DateTimeFormatter.RFC_1123_DATE_TIME.format(meeting));

		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		System.out.println("BASIC_ISO_DATE formatted = " + formatter.format(meeting));

		System.out.println();
		LocalDate now = LocalDate.now();
		String formattedDate = formatter.format(now);
		System.out.println(now);
		System.out.println("formattedLocaleDate = " + formattedDate);

		ZonedDateTime zonedNow = ZonedDateTime.now();
		String formattedZonedDate = formatter.format(zonedNow);
		System.out.println(zonedNow);
		System.out.println("formattedZonedDate = " + formattedZonedDate);

	}

}