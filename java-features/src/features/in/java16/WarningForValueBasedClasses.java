package features.in.java16;

/**
 * JEP 390: Warnings for Value-Based Classes This JEP provides a new warning if
 * we synchronize instances of value-based classes; Also deprecating the
 * primitive wrapper class (value-based) constructors for removal.
 * 
 * 11.1 How to identify value-based classes? The
 * annotation @jdk.internal.ValueBased tells if a class is a value-based class.
 * Review the following two classes, and we can tell both the primitive wrapper
 * class Double and Optional are value-based classes.
 * 
 */
public class WarningForValueBasedClasses {
	/**
	 * <pre>
	 * 
	 * &#64;jdk.internal.ValueBased
	 * public final class Optional<T> {
	 * 	// ...
	 * }
	 * 
	 * &#64;jdk.internal.ValueBased
	 * public final class Double extends Number implements Comparable<Double>, Constable, ConstantDesc {
	 * 
	 * 	// ...
	 * }
	 * 
	 * &#64;jdk.internal.ValueBased
	public final class Double extends Number
	    implements Comparable<Double>, Constable, ConstantDesc {
	
	&#64;Deprecated(since="9", forRemoval = true)
	public Double(double value) {
	  this.value = value;
	}
	
	&#64;Deprecated(since="9", forRemoval = true)
	public Double(String s) throws NumberFormatException {
	 * 
	 * 
	 * </pre>
	 */

	public static void main(String[] args) {

		Double d = 20.0;
		synchronized (d) {
		} // javac warning & HotSpot warning

	}

}
