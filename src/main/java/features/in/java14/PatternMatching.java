package features.in.java14;

public class PatternMatching {

	public static void main(String[] args) {
		String obj = "jdk14";
		// Before Java we use instanceof-and-cast to check the object’s type and cast to
		// a variable.
		if (obj instanceof String) { // instanceof
			String s = (String) obj; // cast
			if ("jdk14".equalsIgnoreCase(s)) {
				System.out.println(obj);
			}
		} else {
			System.out.println("not a string");
		}

		Object obj1 = "";
		// Now with Java 14, no need two step, just one step
		if (obj1 instanceof String s) { // instanceof, cast and bind variable in one line.
			System.out.println(s instanceof String);
			if ("jdk14".equalsIgnoreCase(s)) {
				System.out.println(obj);
			}
		} else {
			System.out.println("not a string");
		}
		
		Circle cc = new Circle(3);
		//no need to test known Type ref
		  
		

		System.out.println(getPerimeter(new Circle(2.4)));

		// also in case statement
	//	System.out.println(getPerimeter2(new Circle(2.4)));

		Shape sh = new Circle(2.3);
		// BRILLIANT
		if (sh instanceof Circle c && c.radius() > 2) {
			 int x = (int) (2 * c.radius() * Math.PI);
			 return;
			// return 2 * s.length() + 2 * s.width(); //also fails
		}

		// another BRILLIANT one is, in equal method after instanceof no CAST, just
		// compare fields, ...

		// negation not work for PATTERN MATCHING
		if ((sh instanceof Rectangle s)) {
			 int x = (int) (2 * s.length() * Math.PI);
			return;
			// return 2 * s.length() + 2 * s.width(); //also fails
		}

//		if (!(sh instanceof Circle c) && c.radius() > 2) {
//			return 2 * sh.radius() * Math.PI;
//			// return 2 * s.length() + 2 * s.width(); //also fails
//		}
	}

	public static double getPerimeter(Shape shape) throws IllegalArgumentException {
		if (shape instanceof Rectangle r) {
			return 2 * r.length() + 2 * r.width(); // NO CAST needed
		} else if (shape instanceof Circle c) {
			return 2 * c.radius() * Math.PI;
		} else {
			throw new IllegalArgumentException("Unrecognized shape");
		}
	}

//	// FUTURE oriented
//	public static double getPerimeter2(Shape shape) {
//		return switch (shape) {
//		case Rectangle r -> 2 * r.length() + 2 * r.width();
//		case Circle c -> 2 * c.radius() * Math.PI;
//		default -> 5.5;
//		};
//	}
//
//	@SuppressWarnings("preview")
//	public static String format(Object o) {
//		return switch (o) {
//		case Integer i -> String.format("int %d", i);
//		case Long l -> String.format("int %d", l);
//		case Double d -> String.format("int %f", d);
//		case String s -> String.format("int %s", s);
//		default -> o.toString();
//		};
//	}

	/// record pattern
//	public static void recPattern() {
//		Shape o = new Rectangle(2.3);
//		if(o instanceof Rectangle(double a, double b)) {
//			System.out.println(a+b);
//		}
//	}

}

//TBD
interface Shape {
}

record Rectangle(double length, double width) implements Shape {
}

record Circle(double radius) implements Shape {
}
