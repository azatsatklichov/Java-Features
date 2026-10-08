package javas.future.projects;

//https://openjdk.java.net/jeps/301
public class EnhancedEnums {

}

//enum Argument<X> { // declares generic enum
//	   STRING<
//	String>(String.class), INTEGER<Integer>(Integer.class),...;
//
//	Class<X> clazz;
//
//	Argument(Class<X> clazz) {
//		this.clazz = clazz;
//	}
//
//	Class<X> getClazz() {
//		return clazz;
//	}
//}

enum Primitive {
	BYTE, SHORT, INT, FLOAT, LONG, DOUBLE, CHAR, BOOLEAN;
}

/**
 * GOAL:
 * 
 * These two enhancements work together to enable enum constants to carry
 * constant-specific type information as well as constant-specific state and
 * behavior.
 * 
 * 
 * As stated above, an enum declaration is like a class, and can have
 * constructors; we can use this feature to keep track of the boxed class and
 * the default value of each primitive:
 */
enum Primitive2 {
	BYTE(Byte.class, 0), SHORT(Short.class, 0), INT(Integer.class, 0), FLOAT(Float.class, 0f), LONG(Long.class, 0L),
	DOUBLE(Double.class, 0d), CHAR(Character.class, 0), BOOLEAN(Boolean.class, false);

	final Class<?> boxClass;
	final Object defaultValue;

	Primitive2(Class<?> boxClass, Object defaultValue) {
		this.boxClass = boxClass;
		this.defaultValue = defaultValue;
	}

	Class<?> getClazz() {
		return boxClass;
	}

}

enum Primitive3 {
	INT(Integer.class, 0), FLOAT(Float.class, 0f);

	final Class<?> boxClass;
	final Object defaultValue;

	Primitive3(Class<?> boxClass, Object defaultValue) {
		this.boxClass = boxClass;
		this.defaultValue = defaultValue;
	}

	int mod(int x, int y) {
		if (this == INT) {
			return x % y;
		} else {
			throw new IllegalStateException();
		}
	}

	int add(int x, int y) {
		if (this == INT) {
			return x + y;
		} else {
			throw new IllegalStateException();
		}
	}

	long add(float x, float y) {
		if (this == FLOAT) {
			return (long) (x + y);
		} else {
			throw new IllegalStateException();
		}
	}
}
 