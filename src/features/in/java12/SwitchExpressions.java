package features.in.java12;

public class SwitchExpressions {

	// https://blog.codefx.org/java/java-12-guide/

	// https://wiki.eclipse.org/Java12/Examples

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

	public static void main(String[] argv) {
		new SwitchExpressions().foo(2);
		new SwitchExpressions().foo2(2);
	}

}

class Test {

	enum Day {
		MON, TUE, WED, THUR, FRI, SAT, SUN
	};

	@SuppressWarnings("preview")
	public String getDay_1(Day today) {
		String day = switch (today) {
		case MON, TUE, WED, THUR, FRI -> "Weekday";
		case SAT, SUN -> "Weekend";
		};
		return day;
	}
}