package features.in.java12;

import features.in.java11.PatternRecognizingMethod;

/**
 * {@link PatternRecognizingMethod}
 * 
 * https://openjdk.java.net/jeps/305
 *
 */
public class PatternMatching {
	public static void main(String[] args) {
		Object obj = "str obj from string pool";
		// old way
		/**
		 * There are three things going on here: a test (is obj a String?), a conversion
		 * (casting obj to String), and the declaration of a new local variable (s)
		 */
		if (obj instanceof String) {
			String s = (String) obj;
			System.out.println(s);
		}

		// new way is -- Early Java12
//		if (obj instanceof String x) {
//		 //NO CASTING NEEDED
//		    System.out.println(x);
//		} 
	}
}
