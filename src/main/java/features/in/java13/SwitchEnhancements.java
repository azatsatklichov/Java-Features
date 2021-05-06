package features.in.java13;

/**
 * 1. from java 13 onwards - multi-label case statements
 * 
 * 2. A new keyword �yield� is introduced to return a value from the switch.
 *
 */
public class SwitchEnhancements {

	// traditional
	private static String getNumber(int number) {
		String result = "";
		switch (number) {
		case 1:
		case 2:
			result = "one or two";
			break;
		case 3:
			result = "three";
			break;
		case 4:
		case 5:
		case 6:
			result = "four or five or six";
			break;
		default:
			result = "unknown";
		}
		;
		return result;
	}

	// In Java 12, we can use break to return a value from a switch.
//	private static String getNumberViaBreak(int number) {
//	      String result = switch (number) {
//	          case 1, 2:
//	              break "one or two";
//	          case 3:
//	              break "three";
//	          case 4, 5, 6:
//	              break "four or five or six";
//	          default:
//	              break "unknown";
//	      };
//	      return result;
//	  }

	// Dropped “break value” favor of added “yield” keyword to return value from
	// switch expression
	private static String getNumberViaYield(int number) {
		return switch (number) {
		case 1, 2:
			yield "one or two";
		case 3:
			yield "three";
		case 4, 5, 6:
			yield "four or five or six";
		default:
			yield "unknown";
		};
	}

	// or other way in Java 13
	private static String getNumberViaYield2(int number) {
		return switch (number) {
		case 1, 2:
			yield "one or two";
		case 3:
			yield "three";
		case 4, 5, 6:
			int i = 0;
			i++;
			yield "four or five or six : " + i;
		default:
			yield "unknown";
		};
	}

	// The rule labels or arrow or case L is still supported in Java 13.
	private static String getNumberViaCaseL(int number) {
		return switch (number) {
		case 1, 2 -> "one or two";
		case 3 -> "three";
		case 4, 5, 6 -> "four or five or six";
		default -> "unknown";
		};
	}

	// Or like this, mixed the use of arrow syntax and yield.
	//switch expression becomes a standard feature in Java 14 JEP 361
	private static String getNumberViaCaseL2(int number) {
		return switch (number) {
		case 1, 2 -> "one or two";
		case 3 -> "three";
		case 4, 5, 6 -> {
			int i = 0;
			i++;
			yield "four or five or six :" + 1;
		}
		default -> "unknown";
		};
	}
	


	@SuppressWarnings("preview")
	public static void main(String[] args) {
		int choice = 2;

		switch (choice) {
		case 1:
			System.out.println(choice);
			break;
		case 2:
			System.out.println(choice);
			break;
		case 3:
			System.out.println(choice);
			break;
		default:
			System.out.println("integer is greater than 3");
		}

		// from java 13 onwards - multi-label case statements
		switch (choice) {
		case 1, 2, 3:
			System.out.println(choice);
			break;
		default:
			System.out.println("integer is greater than 3");
		}

		// switch expressions, use yield to return, in Java 12 it was break
		/**
		 * A new keyword �yield� is introduced to return a value from the switch. Python
		 * has similar concept.
		 * 
		 * P.S This is a preview language feature in Java 13
		 */
		int x = switch (choice) {
		case 1, 2, 3:
			yield choice;
		default:
			yield -1;// doing a role of return
		};
		System.out.println("x = " + x);

		System.out.println("getDay = " + Day.SUN);
		System.out.println("getText = " + getText(3));

	}

	enum Day {
		SUN, MON, TUE
	};

	@SuppressWarnings("preview")
	public static String getDay(Day d) {
		String day = switch (d) {
		case SUN -> "Sunday";
		case MON -> "Monday";
		case TUE -> "Tuesday";
		};
		return day;
	}

	@SuppressWarnings("preview")
	private static String getText(int number) {
		return switch (number) {
		case 1, 2 -> "one or two";
		case 3 -> "three";
		case 4, 5, 6 -> "four or five or six";
		default -> "unknown";
		};
	}
}
