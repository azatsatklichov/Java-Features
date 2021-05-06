package features.in.java14;

import java.util.Locale;

public class SwitchExpressions {

	public static void main(String... args) {
		String food = "cheese";

		Locale locale = switch (food) {
		case "burger", "donut" -> Locale.US;
		case "cheese" -> Locale.forLanguageTag("nl");
		case "maple syrup" -> Locale.CANADA;
		default -> Locale.getDefault();
		};

		System.out.println(locale);

		/// err
		String monthName = "January";
		switch (monthNumber) {
		case 1 -> monthName = "January";
		case 2 -> monthName = "February";
		case 3:monthName = "March"; // ERR
		}
	}

	// we can use yield to return a value from a switch.
	private static int getValueViaYield(String mode) {
		int result = switch (mode) {
		case "a", "b":
			yield 1;
		case "c":
			yield 2;
		case "d", "e", "f":
			// do something here...
			System.out.println("Supports multi line block!");
			yield 3;
		default:
			yield -1;
		};
		return result;
	}

	// Or via a label rules or arrows.
	private static int getValueViaArrow(String mode) {
		int result = switch (mode) {
		case "a", "b" -> 1;
		case "c" -> 2;
		case "d", "e", "f" -> {
			// do something here...
			System.out.println("Supports multi line block!");
			yield 3;
		}
		default -> -1;
		};
		return result;
	}

}
