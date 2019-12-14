package tasks.programmaing.paradigms;

/*
 *  What is the result?
 A.   true true
 B.   false true
 C.   true false
 D.   false false
 E.  Compilation fails
 F. An exception is thrown at runtime
 */
class Fizz {
	int x = 5;

	/**
	 * A is correct.
	 * 
	 * The references f1, z, and f3 all refer to the same instance of Fizz. The
	 * final modifier assures that a reference variable cannot be referred to a
	 * different object, but final doesn’t keep the object’s state from
	 * changing.
	 */
	public static void main(String[] args) {
		final Fizz f1 = new Fizz();
		Fizz f2 = new Fizz();
		Fizz f3 = FizzSwitch(f1, f2);
		System.out.println((f1 == f3) + " " + (f1.x == f3.x));
	}

	static Fizz FizzSwitch(Fizz x, Fizz y) {
		final Fizz z = x;
		z.x = 6;
		return z;
	}
}

// /2-example

class Box {
	int size;

	Box(int s) {
		size = s;
	}
}

/**
 * What is the result?
 * 
 * <pre>
 * 
 *    A.  4 4
 *    B.  5 4
 *    C.  6 4
 *    D.  4 5
 *    E.  5 5
 *    F. Compilation fails
 * </pre>
 * 
 */
class Laser {
	public static void main(String[] args) {
		Box b1 = new Box(5);
		Box[] ba = go(b1, new Box(6));
		ba[0] = b1;
		for (Box b : ba)
			System.out.print(b.size + " ");

		/**
		 * Answer:
		 * 
		 * 
		 * ® ✓ A is correct. Although main()'s b1 is a different reference
		 * variable than go()'s b1, they refer to the same Box object.
		 * 
		 * 
		 * ®˚ B, C, D, E, and F are incorrect based on the above. (Objective
		 * 7.3)
		 */
	}

	static Box[] go(Box b1, Box b2) {
		b1.size = 4;
		Box[] ma = { b2, b1 };
		return ma;
	}
}
