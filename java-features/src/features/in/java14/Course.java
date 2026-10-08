package features.in.java14;

import java.time.Duration;

//https://docs.oracle.com/en/java/javase/15/language/records.html
public record Course(String name, Duration duration, int rating) {

	//int ii = 9; // you can not define instance fields

	public static int i = 9;

	void hii() {
		System.out.println("aleale");
	}

	static void hi() {
		System.out.println("ole");
	}

	// COMPACT constructor
	/**
	 * is just syntactic sugar and you can still use the old way of specifying
	 * constructor with all fields, see line 45
	 * 
	 * The compact constructor can be used for example to validate fields — only
	 * unchecked exceptions can be thrown and you won’t be able to declare checked
	 * exceptions by adding throws declaration.
	 * 
	 * Repeating the record class's components in the signature of the canonical
	 * constructor can be tiresome and error-prone. To avoid this, you can declare a
	 * compact constructor whose signature is IMPLICIT (derived from the components
	 * automatically).
	 * 
	 * @param name
	 * @param duration
	 * @param rating
	 */
	public Course {
		/*
		 * this.rating=6; rating=7;
		 */
		
		if (rating > 5) {
			throw new IllegalArgumentException(); // only unchecked exceptions can be throws
		}
	}

	// CANONICAL constructor starts with explicit invocation of constructor
//	public Course(String name, Duration duration, int rating) {
//		// NO ned to call  default constructor
//		//EQUIVALENT TO COMPACT constructor
//		if (rating > 5) {
//			throw new IllegalArgumentException();
//		}
//	}

	// CANONICAL constructor starts with explicit invocation of constructor
	public Course(String name, int rating) {		
		// try disable below calling default constructor
		this(name, null, rating);
		
		/*
		 * this.rating=6; rating=7;
		 */
		if (rating > 5) {
			throw new IllegalArgumentException();
		}
	}

	/*
	 * public Course() { //try diable below this("ss", null, "rating"); }
	 */

	/**
	 * Explicit Declaration of Record Class Members
	 * 
	 * You can explicitly declare any of the members derived from the header, such
	 * as the public accessor methods that correspond to the record class's
	 * components, for example:
	 */
	// Public accessor method
	public String name() {
		System.out.println("RECORD name is" + name);
		return name;
	}
}
