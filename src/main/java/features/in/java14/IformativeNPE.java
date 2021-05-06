package features.in.java14;

import java.util.Locale;

public class IformativeNPE {

	/**
	 * Improved the description of NullPointerExceptions by telling which variable
	 * was null. Add -XX:+ShowCodeDetailsInExceptionMessages option to enable this
	 * feature.
	 * 
	 * 
	 * Before Java 14
	 * 
	 * Exception in thread "main" java.lang.NullPointerException at
	 * Test.showUpperCase(Test.java:15) at Test.main(Test.java:9)
	 * 
	 * 
	 * After Java 14
	 * 
	 * Exception in thread "main" java.lang.NullPointerException: Cannot invoke
	 * "String.toUpperCase(java.util.Locale)" because "str" is null at
	 * features.in.java14.IformativeNPE.showUpperCase(IformativeNPE.java:21) at
	 * features.in.java14.IformativeNPE.main(IformativeNPE.java:15)
	 * 
	 */
	public static void main(String[] args) {

		String input = null;
		String result = showUpperCase(input); // NullPointerException
		System.out.println(result);

	}

	public static String showUpperCase(String str) {
		return str.toUpperCase(Locale.US);
	}

}
