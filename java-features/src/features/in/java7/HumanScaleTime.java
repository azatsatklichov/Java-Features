package features.in.java7;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class HumanScaleTime {
	public static void main(String[] args) {
		// in Java 7 YODA timer lib was used
		// Local*, Offset*, Zoned*

		// Local human-scale (not tied to TimeZone or Instant)
		LocalDate myBirthday = null; // LocalDate.date(1974, MonthOfYear.May, 1); //JAVA7
		LocalTime quittingTime = null; // LocalTime.time(17, 0); //JAVA7
		LocalDateTime start2008 = null; //LocalDateTime.dateMidnight(2008, MonthOfYear.JANUARY, 1); //JAVA7

		// Tie to time zone offset of -6 hours from UTC
		OffsetDateTime start2008Offset = null; //OffsetDateTime.dateTime(start2008, ZoneOffset.zoneOffset(-6)); //JAVA7

		// Tie to current local time zone
		ZonedDateTime start2008Zoned =null; // ZonedDateTime.dateTime(start2008, Clock.system().timeZone()); //JAVA7

	}
}
