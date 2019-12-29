package features.in.java7;

public class HumanScaleTime {
	public static void main(String[] args) {
		Local*, Offset*, Zoned* 

		// Local human-scale (not tied to TimeZone or Instant) 
		LocalDate myBirthday = 
		   LocalDate.date(1974, MonthOfYear.May, 1); 
		LocalTime quittingTime = LocalTime.time(17, 0); 
		LocalDateTime start2008 = LocalDateTime.dateMidnight( 
		   2008, MonthOfYear.JANUARY, 1); 

		// Tie to time zone offset of -6 hours from UTC 
		OffsetDateTime start2008Offset = OffsetDateTime.dateTime( 
		   start2008, ZoneOffset.zoneOffset(-6)); 

		// Tie to current local time zone 
		ZonedDateTime start2008Zoned = ZonedDateTime.dateTime( 
		   start2008, Clock.system().timeZone()); 

	}
}
