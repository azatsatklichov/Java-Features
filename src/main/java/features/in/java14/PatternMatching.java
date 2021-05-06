package features.in.java14;

public class PatternMatching {

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
