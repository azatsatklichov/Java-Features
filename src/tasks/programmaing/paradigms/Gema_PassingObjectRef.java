package tasks.programmaing.paradigms;

import java.awt.Dimension;
import java.util.Arrays;

/**
 * When you pass an object variable into a method, you must keep in mind that
 * you're passing the object reference, and not the actual object itself.
 * 
 * Remember that a reference variable holds bits that represent (to the
 * underlying VM) a way to get to a specific object in memory (on the heap).
 * More importantly, you must remember that you aren't even passing the actual
 * reference variable, but rather a copy of the reference variable. A copy of a
 * variable means you get a copy of the bits in that variable, so when you pass
 * a reference variable, you're passing a copy of the bits representing how to
 * get to a specific object. In other words, both the caller and the called
 * method will now have identical copies of the reference, and thus both will
 * refer to the same exact (not a copy) object on the heap.
 * 
 * @author Admin
 * 
 */
public class Gema_PassingObjectRef {

	public static void main(String[] args) {
		Dimension d = new Dimension(5, 10);
		Gema_PassingObjectRef rt = new Gema_PassingObjectRef();

		System.out.println("Before modify() d.height = " + d.height);
		rt.modify(d);
		System.out.println("After modify() d.height = " + d.height);

		int[] a = { 0 };

		System.out.println("\n    --- Gema question --- ");
		System.out.println("Before modify() int[] a  = " + Arrays.toString(a));
		rt.modify(a);
		System.out.println("After modify() int[] a  = " + Arrays.toString(a));
	}

	void modify(Dimension dim) {
		dim.height = dim.height + 1;
		System.out.println("height = " + dim.height);
	}

	void modify(int[] a) {
		a[0] = 7;
		System.out.println("dim = " + a[0]);
	}

	/**
	 * The bottom line on pass-by-value: the called method can't change the caller's
	 * variable, although for object reference variables, the called method can
	 * change the object the variable referred to. What's the difference between
	 * changing the variable and changing the object? For object references, it
	 * means the called method can't reassign the caller's original reference
	 * variable and make it refer to a different object, or null. For example, in
	 * the following code fragment,
	 */
	void bar() {
		Fooq f = new Fooq();
		doStuff(f);
	}

	/**
	 * reassigning g does not reassign f! At the end of the bar() method, two
	 * ReturnTypeOverload objects have been created, one referenced by the local
	 * variable f and one referenced by the local (argument) variable g. Because the
	 * doStuff() method has a copy of the reference variable, it has a way to get to
	 * the original ReturnTypeOverload object, for instance to call the setName()
	 * method. But, the doStuff() method does not have a way to get to the f
	 * reference variable. So doStuff() can change values within the object f refers
	 * to, but doStuff() can't change the actual contents (bit pattern) of f. In
	 * other words, doStuff() can change the state of the object that f refers to,
	 * but it can't make f refer to a different object!
	 * 
	 * @param g
	 */

	void doStuff(Fooq g) {
		g.setName("Boo");
		g = new Fooq();
	}

}

class Fooq {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String string) {

	}

}
