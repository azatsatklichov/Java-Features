package features.in.java12;

/**
 * Switch Expressions This is a preview feature.
 * 
 * There are two main changes to switch in Java with this JEP:
 * 
 * Introduction of case L -> syntax that removes the need for break statements,
 * because only the statements next to -> is executed.
 * 
 * switch can be an expression, so it can have a value, or it can return a
 * value.
 * 
 * javac -Xlint:preview --enable-preview -source 12 src/main/java/SwitchExpressions.java
 *
 */
public class SwitchExpressions {

	public static void main(String[] args) {
		// day of week, starting from 1-sunday
		final int day = 3;

		// traditional switch
		switch (day) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.println("weekday 3,4,5,6");
			break;
		case 7:
		case 1:
			System.out.println("weekend");
			break;
		default:
			System.out.println("invalid");
		}

		// case L -> syntax no break necessary, only code next to -> runs
		switch (day) {
		case 2, 3, 4, 5, 6 -> System.out.println("weekday -> 3,4,5,6");
		case 7, 1 -> System.out.println("weekend");
		default -> System.out.println("invalid");
		}

		// switch expression
		final String attr = switch (day) {
		case 2, 3, 4, 5, 6 -> "workings day";
		case 7, 1 -> "weekend";
		// it is possible to do this without a block and break
		// so default -> "invalid"; is actually enough here
		default ->  "invalid"; 
		};
 
		System.out.println();
		System.out.println("VALUE returned by SWITCH -> "+attr);
		System.out.println();

		
		new SwitchExpressions().foo(2);
		new SwitchExpressions().foo2(2);

	}

	public void foo(int i) {
		switch (i) {
		case 0, 1, 2:
			System.out.println("Hello");
		default:
			System.out.println("World");
		}
	}

	@SuppressWarnings("preview")
	public void foo2(int i) {
		switch (i) {
			case 2 -> System.out.println("Hello2");
			default -> System.out.println("World2");
		}
	}

}

class Test {
	
	public static void main(String[] args) {
		String day_1 = getDay_1(Day.THUR);
		System.out.println(day_1);
	}

	enum Day {
		MON, TUE, WED, THUR, FRI, SAT, SUN
	};

	@SuppressWarnings("preview")
	public static String getDay_1(Day today) {
		String day = switch (today) {
		case MON, TUE, WED, THUR, FRI -> " today's working day is = "+today;
		case SAT, SUN -> "Weekend";
		};
		return day;
	}
}