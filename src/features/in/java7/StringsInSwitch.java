package features.in.java7;

public class StringsInSwitch {
	public static void main(String[] args) {
		String s = "foo";
		switch(s) {
		 case "quux":
		    processQuux(s);
		    // fall-through

		  case "foo":
		  case "bar":
		    processFooOrBar(s);
		    break;

		  case "baz":
		     processQuux(s);
		    // fall-through

		  default:
		    processQuux(s);
		    break;
		}

	}

	/*
	 * We could use byte, short, char, int and enum in Switches. With Java 7,
	 * Strings could also be used.
	 */
	// non-final variables and method calls cannot be used in Switch case.
	private void testStringSwitch(final String key) {
		final String value = "test";
		String value2 = "test2";
		switch (key) {
		case value:
			break;
		case "foo":
			break;
		case value2: // Non-final variables are not allowed
			break;
		case getStringValue(): // Method calls not allowed
			break;
		}
	}

	static boolean isStooge(String stooge) { 
		   switch(input) { 
		      case “Moe”: 
		      case “Curly”: 
		      case “Larry”: 
		      case “Shemp”: 
		         return true; 
		      default: 
		         return false; 
		   } 
		}
}
