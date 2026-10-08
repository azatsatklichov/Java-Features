package features.in.java11;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TimeUnitConversion {

	/**
	 * This method is used to convert the given time to a unit like DAY, MONTH, YEAR
	 * and for time too.
	 */
	public static void main(String[] args) {
		TimeUnit c = TimeUnit.DAYS;
		long convert = c.convert(Duration.ofHours(24));
		System.out.println(convert);
		long convert2 = c.convert(Duration.ofHours(50));
		System.out.println(convert2); 
	}
}
