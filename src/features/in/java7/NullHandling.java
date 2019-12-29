package features.in.java7;

public class NullHandling {
	/**
	 * This is one of my favorites. 
	 * java.util.Objects class has 9 useful static
	 * methods. Javadoc for this class:
	 * {@link http://download.java.net/jdk7/docs/api/java/util/Objects.html}
	 * 
	 * 
	 * nonNull - Similar to google preconditions 
	 * 
	 * toString methods-Handles null automatically 
	 * hash and hashCode methods - Does hashCode for single or
	 * multiple objects. Returns 0 if object is null. 
	 * 
	 * equals and deepEquals -
	 * Handles null automatically. Deep equals handles arrays also.
	 * 
	 * This post talks about them in more detail -
	 * http://www.baptiste-wicht.com/
	 * 2010/04/java-7-the-new-java-util-objects-class/
	 */
	public static void main(String[] args) {
		
		Car car = ... 
		Integer tilt = null; 
		if(car != null) { 
		   Sunroof sunroof = car.getSunroof()(; 
		   if(sunroof != null) { 
		       tilt = sunroof.getTilt(); 
		   } 
		} 

		Integer tilt = car?.getSunroof()?.getTilt(); 
		
		
	}
	
	



}
