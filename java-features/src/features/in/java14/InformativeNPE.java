package features.in.java14;

import java.util.Locale;

public class InformativeNPE {

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

class HelpfulNPEDemo {

	public static void main(String... args) {
		Object myObject = null;
		myObject.toString().hashCode(); 
	}

}


class HelpfulNPEDemo2 {

//	public static void main(String... args) { 
//		var a = null; // new A();
//		a.b = 1; // Exception in thread "main" java.lang.NullPointerException: Cannot assign
//					// field "b" because "a" is null
//		var a = new Object[][] { null };
//		a[0][1] = new Object(); // … Cannot store to object array because "a[0]" is null because "a" is null
//
//	}

}

//TBD
class A {
	int b;
}
