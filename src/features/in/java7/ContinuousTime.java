package features.in.java7;

import javax.xml.datatype.Duration;

public class ContinuousTime {
	public static void main(String[] args) {
		/*
		 * Instants, Intervals, and Durations
		 */

//Create some instants in seconds 
Instant start2008 = Instant.instant(1199167200); 
Instant start2009 = Instant.instant(1230789600); 
assert start2008.isBefore(start2009); 

//Create an interval - [inclusive, exclusive] by default 
InstantInterval year2008 = 
InstantInterval.intervalBetween(start2008, start2009); 
assert year2008.contains(start2008); 
assert ! year2008.contains(start2009); 

//Create a duration in seconds 
Duration minute = Duration.duration(60); 
Duration hour = minute.multipliedBy(60); 
Duration duration2008 = Duration.durationBetween( 
start2008, start2009); 

	}
}
