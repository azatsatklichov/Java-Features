package features.in.java14;

public class JTest {

	public static void main(String[] args) {
		System.out.println("See: URLConnectionReader in JavaFeatures prj.");

		foo(2);
	}

	// https://wiki.eclipse.org/Java14/Examples
	public static void foo(int i) {
		switch (i) {
		case 0, 1, 2:
			System.out.println("Hello");
		default:
			System.out.println("World");
		}
	}
}

class X {
	public void foo(int i) {
		switch (i) {
		case 2 -> System.out.println("Hello");
		default -> System.out.println("World");
		}
	}

	public static void main(String[] argv) {
		new X().foo(2);
	}
}

class Test {

	enum Day {
		MON, TUE, WED, THUR, FRI, SAT, SUN
	};

	public String getDay_1(Day today) {
		String day = switch (today) {
		case MON, TUE, WED, THUR, FRI -> "Weekday";
		case SAT, SUN -> "Weekend";
		};
		return day;
	}
}


//Compile and run the following code:
@SuppressWarnings("preview")
record Point(int x, int y) {
}

class X1 {
	public static void main(String[] args) {
                Point p = new Point(100, 200);
		System.out.println(p.x());
	}
}
