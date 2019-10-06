package features.in.java12;

import features.in.java11.PatternRecognizingMethod;

/**
 * {@link PatternRecognizingMethod}
 *
 */
public class PatternMatching {
	public static void main(String[] args) {
		String obj = "str obj from string pool";
		// old way
		if (obj instanceof String) {
			String s = (String) obj;
			System.out.println(s);
		}
		
		//new way is
//		if (obj instanceof String x) {
//		    System.out.println(x);
//		} 
}
}
