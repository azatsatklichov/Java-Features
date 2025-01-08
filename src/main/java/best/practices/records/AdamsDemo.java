
package best.practices.records;

/**
 * 
 * Passing immutable data between objects is one of the most common, but boring
 * staff in many Java applications.
 * 
 * Prior to Java 14, this required the creation of a class with boilerplate
 * fields and methods, which were susceptible to trivial mistakes and muddled
 * intentions.
 * 
 * A record is basically a “data class,�? a special kind of class that is
 * intended to hold pure data in it. Records seem to be an interesting choice
 * when modeling things like domain model classes (potentially to be persisted
 * via ORM), or data transfer objects (DTOs).
 * 
 * 
 * With the release of Java 14, we can now use records to remedy these problems.
 *
 * <pre>
 * Commonly, we write classes to simply hold data, such as database results, query results, or information from a service.
	
	In many cases, this data is immutable, since immutability ensures the validity of the data without synchronization.
	
	To accomplish this, we create data classes with the following:
	
	private, final field for each piece of data
	getter for each field
	public constructor with a corresponding argument for each field
	equals method that returns true for objects of the same class when all fields match
	hashCode method that returns the same value when all fields match
	toString method that includes the name of the class and the name of each field and its corresponding value
 * 
 * </pre>
 */
public class AdamsDemo {

	/**
	 * ‘record’ is a restricted identifier (like ‘var’) and isn’t a keyword (yet).
	 * So, the following code is valid: However, you should refrain from using
	 * record as an identifier because it could be included as a keyword in a future
	 * Java version.
	 */
	int record = 10;

	void record() {
	}

	public static void main(String[] args) {
		System.out.println("Boilerplate code");
		// there are two problems with it
		/**
		 * There is a lot of boilerplate code
		 * 
		 * We obscure the purpose of our class � to represent a person with a name and
		 * address
		 * 
		 * 
		 * In the first case, we have to repeat the same tedious process for each data
		 * class, monotonously creating a new field for each piece of data, creating
		 * equals, hashCode, and toString methods, and creating a constructor that
		 * accepts each field.
		 * 
		 * While IDEs can automatically generate many of these classes, they fail to
		 * automatically update our classes when we add a new field. For example, if we
		 * add a new field, we have to update our equals method to incorporate this
		 * field.
		 */
		Adam adam = new Adam("Adam", "Prague");
		System.out.println(adam);

		System.out.println("Java 14 record");
		AdamRec adam2 = new AdamRec("Adam", "Mary");
		System.out.println(adam2);

		System.out.println(adam2.name());
		System.out.println(adam2.hashCode());
		System.out.println(adam2.equals(adam2));
		// We also receive public getters methods – whose names match the name of our
		// field – for free.
		System.out.println(adam2.name());

		System.out.println();
		AdamRec1 adam1 = new AdamRec1("Okz");
		System.out.println(adam1);
		AdamRec11 adam11 = new AdamRec11();
		System.out.println(adam11);

		AdamRec4 adam4 = new AdamRec4("Ors", "Ptg");
		System.out.println(adam4);

		System.out.println();
		System.out.println("Static Variables & Methods");
		System.out.println(AdamRec5.UNKNOWN_ADDRESS);
		System.out.println(AdamRec5.unnamed("No Addr"));

		System.out.println();
		System.out.println("Override the default methods of Record");
		ForSpecSemantic adam6 = new ForSpecSemantic("Ors");
		System.out.println(adam6);

	}
}
