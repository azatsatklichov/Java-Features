package features.in.java9;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class JavaTimeImprovement {

	public static void main(String[] args) {
//		dividedBy
//		truncatedTo
//		Clock systemUTC  //most precise clock
//		LocalDate.datesUntil 
//		
 	
		LocalDate bD = LocalDate.of(1977, 6, 10);
		System.out.println(bD);
		long leapYearCount = bD.datesUntil(LocalDate.now(), Period.ofYears(1)).map(d -> Year.of(d.getYear())).filter(Year::isLeap).count();
		System.out.println(leapYearCount);

	}
}
