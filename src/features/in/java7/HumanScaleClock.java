package features.in.java7;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;

public class HumanScaleClock {
	public static void main(String[] args) {
		
		//in Java 7 YODA timer lib was used
		// Clock

		// Use pre-defined system clock usually
		Clock clock = null; // Clock.system(); Java 7

		// Create instant
		Instant now = clock.instant();

		// Create human date / time
		LocalDate today = null;//  clock.today();   Java 7

	}
}
