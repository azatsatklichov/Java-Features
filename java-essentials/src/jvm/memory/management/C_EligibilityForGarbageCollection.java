package jvm.memory.management;

import java.util.Date;

class NullifyingAReference {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hey GC");
		System.out.println(sb); // not eligible for collection
		sb = null; // Nulling a Reference makes it Eligible for GC
		// Now StringBuffer object is eligible for collection
	}

}

/**
 * We can also decouple a reference variable from an object by setting the
 * reference variable to refer to another object.
 *
 */
class ReassigningAReference {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("Hello GC");
		StringBuffer sb2 = new StringBuffer("Hi GC");
		System.out.println(sb1); // "Hello GC" not eligible for collection
		sb1 = sb2; // sb2 re-referenced to "Hi GC" object
		// Now "Hello GC" object is eligible for collection
	}

}

/**
 * Objects that are created in a method also need to be considered. When a
 * method is invoked, any local variables created exist only for the duration of
 * the method. Once the method has returned, the objects created in the method
 * are eligible for garbage collection. There is an obvious exception, however.
 * If an object is returned from the method, its reference might be assigned to
 * a reference variable in the method that called it; hence, it will not be
 * eligible for collection. Examine the following code:
 * 
 * This method creates two objects: a Date and a StringBuffer containing the
 * date information. Since the method returns the Date object, it will not be
 * eligible for collection even after the method has completed. The StringBuffer
 * object, though, will be eligible, even though we didn't explicitly set the
 * now variable to null.
 *
 */
class AfterMethodCall {

	public static void main(String[] args) {
		Date d = getDate();
		// some more operation ...
		System.out.println("d = " + d);
	}

	public static Date getDate() {
		Date d2 = new Date();
		StringBuffer now = new StringBuffer(d2.toString());
		System.out.println(now);
		return d2;
		// StringBuffer object will be eligible for Collection
		// Date object will not be
	}

}

/**
 * Isolating A Reference
 * 
 * There is another way in which objects can become eligible for garbage
 * collection, even if they still have valid references! We call this scenario
 * "islands of isolation." A simple example is a class that has an instance
 * variable that is a reference variable to another instance of the same class.
 * 
 * Now imagine that two such instances exist and that they refer to each other.
 * 
 * If all other references to these two objects are removed, then even though
 * each object still has a valid reference, there will be no way for any live
 * thread to access either object.
 * 
 * When the garbage collector runs, it can usually discover any such islands of
 * objects and remove them.
 *
 */
class IsolatingAReference {

	IsolatingAReference i;

	public static void main(String[] args) {
		IsolatingAReference i2 = new IsolatingAReference();
		IsolatingAReference i3 = new IsolatingAReference();
		IsolatingAReference i4 = new IsolatingAReference();
		i2.i = i3; // i2 refers to i3
		i3.i = i4; // i3 refers to i4
		i4.i = i2; // i4 refers to i2
		i2 = null;
		i3 = null;
		i4 = null;
		// do calc  
	}
}