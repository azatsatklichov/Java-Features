package features.in.java13;

/**
 * 1. from java 13 onwards - multi-label case statements
 * 
 * 2. A new keyword ‘yield’ is introduced to return a value from the switch.
 *
 */
public class SwitchEnhancements {
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
		 * A new keyword ‘yield’ is introduced to return a value from the switch.
		 * 
		 * P.S This is a preview language feature in Java 13
		 */
		int x = switch (choice) {
		case 1, 2, 3:
			yield choice;
		default:
			yield -1;
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
