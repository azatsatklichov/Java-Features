package jvm.memory.management;

import java.lang.ref.WeakReference;

class WeakRefDemo {

	/*
	 * jvm.memory.management.Person@76ed5528 
	 * jvm.memory.management.Person@76ed5528
	 * null
	 */

	public static void main(String[] args) {
		Person person = new Person();
		WeakReference<Person> wr = new WeakReference<Person>(person); // wraps strong reference

		Person p1 = wr.get(); // strong reference exist
		System.out.println(p1); //jvm.memory.management.Person@76ed5528 

		person = null; // strong reference NULLified, but GC has not kicked of yet
		p1 = null;
		Person p2 = wr.get(); // That is why Object (still live) is still reachable via weak reference
		System.out.println(p2); //jvm.memory.management.Person@76ed5528

		p2 = null;
		System.gc(); // GC kicked off, object removed
		Person p3 = wr.get(); // No live object, and so NULL
		System.out.println(p3); // null
	}
}

class Person {

}
