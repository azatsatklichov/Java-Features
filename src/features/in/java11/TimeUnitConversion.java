package features.in.java11;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TimeUnitConversion {

	/**
	 * his method is used to convert the given time to a unit like DAY, MONTH, YEAR
	 * and for time too.
	 */
	public static void main(String[] args) {
		TimeUnit c = TimeUnit.DAYS;
		c.convert(Duration.ofHours(24));
		c.convert(Duration.ofHours(50));
	}
}
