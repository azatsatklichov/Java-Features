package features.in.java16;

//https://mkyong.com/java/what-is-new-in-java-16/
public class PatternMatchingDemo {

	public static void main(String[] args) {
		String obj = "";
		Object obj2 = null; // some object
		if (obj instanceof String) {
			String s = (String) obj; // cast
		}
		// Now we can heck the object’s type and cast it automatically
		if (obj2 instanceof String s) {
			// ... s is a string
		}

		// common check and cast example
		if (obj2 instanceof String)

		{
			String s = (String) obj2;
			if (s.length() > 5) {
				if (s.equalsIgnoreCase("java16")) {
					// ...
				}
			}
		}

		// alternative, can be refactored with pattern matching
		if (obj2 instanceof String s && s.length() > 5) {
			if (s.equalsIgnoreCase("java16")) {
				// ...
			}
		}

	}
}
