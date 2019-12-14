package tasks.programmaing.paradigms;

/**
 * 
 * 
 * 
 * <pre>
 *  The garbage collection routines that Java provides are members of the Runtime
 * class. The Runtime class is a special class that has a single object (a
 * Singleton) for each main program. The Runtime object provides a mechanism for
 * communicating directly with the virtual machine. To get the Runtime instance,
 * you can use the method Runtime.getRuntime(), which returns the Singleton.
 * Once you have the Singleton you can invoke the garbage collector using the
 * gc() method. Alternatively, you can call the same method on the System class,
 * which has static methods that can do the work of obtaining the Singleton for
 * you. The simplest way to ask for garbage collection (remember—just a request)
 * is System.gc();
 * 
 * 
 * Theoretically, after calling System.gc(), you will have as much free memory
 * as possible. We say theoretically because this routine does not always work
 * that way. First, your JVM may not have implemented this routine; the language
 * specification allows this routine to do nothing at all. Second, another
 * thread (again, see the Chapter 9) might grab lots of memory right after you
 * run the garbage collector. This is not to say that System.gc() is a useless
 * method—it's much better than nothing. You just can't rely on System.gc() to
 * free up enough memory so that you don't have to worry about running out of
 * memory. The Certification Exam is interested in guaranteed behavior, not
 * probable behavior.
 * </pre>
 * 
 * 
 * @author Azat
 * 
 */
public class GC_HowManyObjsEligible {

}

class CardBoard {
	/**
	 * There is another way in which objects can become eligible for garbage
	 * collection, even if they still have valid references! We call this scenario
	 * "islands of isolation."
	 */
	Short story = 5;

	CardBoard go(CardBoard cb) {
		cb = null;
		return cb;
	}

	public static void main(String[] args) {
		CardBoard c1 = new CardBoard();
		CardBoard c2 = new CardBoard();
		CardBoard c3 = c1.go(c2); // here c2 is just copy of the reference,
									// original c2 is still NOT NULL
		c1 = null;
		// do Stuff

		// 2-objects are eligible for GC, c1 and story object of c1
		// object for c3 is not created yet

		// Only one CardBoard object (c1) is eligible, but it has an associated
		// Short wrapper object that is also eligible.
	}
}

// //2-example
class Dozens {
	int[] dz = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
}

/**
 * Which two are true about the objects created within main(), and eligible for
 * garbage collection when line this14 is reached?
 * 
 * <pre>
 * 
 *   A. Three objects were created
 *   B. Four objects were created
 *   C. Five objects were created
 *   D. Zero objects are eligible for GC
 *   E. One object is eligible for GC
 *   F. Two objects are eligible for GC
 *   G. Three objects are eligible for GC
 * </pre>
 * 
 */
class Eggsx {

	public static void main(String[] args) {
		// 1-object, it is just 1D array-object
		Dozens[] da = new Dozens[3];
		// 2-object, Dozens + each Dozens object that is created comes with its own "int
		// array" object.
		da[0] = new Dozens();
		// 3-object, Dozens + each Dozens object that is created comes with its own "int
		// array" object.
		Dozens d = new Dozens();
		da[1] = d;
		d = null;
		da[1] = null; /// only the Dozens object (and its "int array" object) are not reachable
		// this line14: do stuff

		/**
		 * Answer:
		 * 
		 * ® ✓ C and F are correct. da refers to an object of type "Dozens array,"
		 * and each Dozens object that is created comes with its own "int array" object.
		 * When line 14 is reached, only the second Dozens object (and its "int array"
		 * object) are not reachable.
		 * 
		 * 
		 * A, B, D, E, and G are incorrect based on the above. (Objective 7.4)
		 * 
		 * 
		 */
	}
}

// /3-example
class Beta {
}

class Alpha {
	static Beta b1; /// created in STACK, not in HEAP
	Beta b2;
}

/**
 * When line this16 is reached, how many objects will be eligible for garbage
 * collection?
 * 
 * <pre>
 * 
 *    A. 0
 *    B. 1
 *    C. 2
 *    D. 3
 *    E. 4
 *    F. 5
 * 
 * </pre>
 * 
 */
class Tester {
	public static void main(String[] args) {
		Beta b1 = new Beta();
		Beta b2 = new Beta();
		Alpha a1 = new Alpha();

		Alpha a2 = new Alpha();

		a1.b1 = b1;
		// Alpha.b1 = b1; actually this is the right way
		a1.b2 = b1;

		a2.b2 = b2; // for a2 no b1 set yet
		a1 = null;
		b1 = null;
		b2 = null;
		// this16 do stuff

		/**
		 * Answer:
		 * 
		 * ® ✓ B is correct. It should be clear that there is still a reference to
		 * the object referred to by a2, and that there is still a reference to the
		 * object referred to by a2.b2. What might be less clear is that you can still
		 * access the other Beta object through the static variable a2.b1—because it's
		 * static.
		 * 
		 * A, C, D, E, and F are incorrect based on the above. (Objective 7.4)
		 */
	}
}
