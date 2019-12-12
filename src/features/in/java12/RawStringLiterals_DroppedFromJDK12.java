package features.in.java12;

public class RawStringLiterals_DroppedFromJDK12 {
	public static void main(String args[]) { 
	    
	    
	    String daysInAWeekStr = "Days in a week \n" +
                "\t\t\tSunday\n" +
                 "\t\t\tMonday\n" +
                "\t\t\tTuesday\n" +
                "\t\t\tWednesday\n" +
                 "\t\t\tThursday\n" +
                 "\t\t\tFriday\n" +
                 "\t\t\tSaturday\n";
	    System.out.println(daysInAWeekStr);

	    
	    //In Java 12
	    /**
	     * This feature is now (as of writing this blog) available as a preview feature in JDK 12 
	     * early access builds. In order to enable this use, pass the --enable-preview argument.
	     * 
	     * Use backtick 
	     */
	    String daysInAWeekStr = `Days in a week
                Sunday
                 Monday
                 Tuesday
                 Wednesday
                 Thursday
                 Friday
                 Saturday`;
	    System.out.println(daysInAWeekStr);
	    
 

	  }

}
