package jvm.memory.management;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

class Main4 {

	public static void main(String[] args) {
		ReferenceQueue<Person4> queue = new ReferenceQueue<Person4>();
		ArrayList<FinalizePerson4> list = new ArrayList<FinalizePerson4>();
		ArrayList<Person4> people = new ArrayList<Person4>();

		for (int i = 0; i < 10; i++) {
			Person4 p = new Person4();
			people.add(p);
			list.add(new FinalizePerson4(p, queue));
		}

		people = null;
		System.gc();

		for (PhantomReference<Person4> reference : list) {
			System.out.println(reference.isEnqueued());
		}

		Reference<? extends Person4> referenceFromQueue;
		while ((referenceFromQueue = queue.poll()) != null) {
			((FinalizePerson4) referenceFromQueue).cleanup();
		}

	}
}

class FinalizePerson4 extends PhantomReference<Person4> {

	public FinalizePerson4(Person4 referent, ReferenceQueue<? super Person4> q) {
		super(referent, q);
	}

	public void cleanup() {
		System.out.println("Person4 is finalizing resources");
	}

}

class Person4 {
}
