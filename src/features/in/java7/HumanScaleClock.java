package features.in.java7;

public class HumanScaleClock {
	public static void main(String[] args) {
		//Clock 

		// Use pre-defined system clock usually 
		Clock clock = Clock.system(); 

		// Create instant 
		Instant now = clock.instant(); 

		// Create human date / time 
		LocalDate today = clock.today(); 

	}
}
