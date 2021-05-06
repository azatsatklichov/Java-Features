package features.in.java15;

public class PatternMatching2Preview {

	// This JEP is a second preview of the pattern matching to gain additional
	// feedback, with no change to the API.

	private static void print(Object obj) {

		if (obj instanceof String) { // instanceof

			String s = (String) obj; // cast

			if ("java15".equalsIgnoreCase(s)) {
				System.out.println("Hello Java 15");
			}

		} else {
			System.out.println("not a string");
		}

	}

	private static void printWithPatternMatching(Object obj) {

		// instanceof, cast and bind variable in one line.
		if (obj instanceof String s) {

			if ("java15".equalsIgnoreCase(s)) {
				System.out.println("Hello Java 15");
			}

		} else {
			System.out.println("not a string");
		}

	}

	public static void main(String[] args) {
		String obj = "jdk14";
		// Before Java we use instanceof-and-cast to check the object’s type and cast to
		// a variable.
		if (obj instanceof String) { // instanceof
			String s = (String) obj; // cast
			if ("jdk14".equalsIgnoreCase(s)) {
				System.out.println(obj);
			}
		} else {
			System.out.println("not a string");
		}

		// Now with Java 14, no need two step, just one step
		if (obj instanceof String s) { // instanceof, cast and bind variable in one line.
			System.out.println(s instanceof String);
			if ("jdk14".equalsIgnoreCase(s)) {
				System.out.println(obj);
			}
		} else {
			System.out.println("not a string");
		}
	}

}
