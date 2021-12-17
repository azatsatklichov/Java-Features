package features.in.java14;

import java.time.Duration;

//see the packahe: net.sahet.record 
public class RecordsDemo {
	public static void main(String... args) {
		Course course = new Course("What's New in Java 14", Duration.ofHours(1), 5);
		Course course2 = new Course("What's New in Java 14", Duration.ofHours(1), 5);

		System.out.println(course == course2);
		System.out.println(course.equals(course2));
		
		course2 = new Course("What's New in Java 14", Duration.ofHours(1), 6);

		System.out.println(course == course2);
		System.out.println(course.equals(course2));
	}
}

class RecordExamples {
	record Point(int x, int y) {
	}

	public static void main(String[] args) {

		Point p1 = new Point(10, 20);
		System.out.println(p1.x()); // 10
		System.out.println(p1.y()); // 20

		Point p2 = new Point(11, 22);
		System.out.println(p2.x()); // 11
		System.out.println(p2.y()); // 22

		Point p3 = new Point(10, 20);
		System.out.println(p3.x()); // 10
		System.out.println(p3.y()); // 20

		System.out.println(p1.hashCode()); // 330
		System.out.println(p2.hashCode()); // 363
		System.out.println(p3.hashCode()); // 330

		System.out.println(p1.equals(p2)); // false
		System.out.println(p1.equals(p3)); // true
		System.out.println(p2.equals(p3)); // false

	}
}