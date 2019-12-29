package features.in.java7;

public class StringsInSwitch {
	 
	/*
	 * We could use byte, short, char, int and enum in Switches. With Java 7,
	 * Strings could also be used.
	 */
	// non-final variables and method calls cannot be used in Switch case.
	@SuppressWarnings("unused")
	private void testStringSwitch(final String key) {
		final String value = "test";
		String value2 = "test2";
		switch (key) {
		case value:
			break;
		case "foo":
			break;
//		case value2: // Non-final variables are not allowed
//			break;
		case "": //getStringValue(): // Method calls not allowed
			break;
		}
	}
}
