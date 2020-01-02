package tasks.programmaing.paradigms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Deque Implementations Since Java Deque is an interface you need to
 * instantiate a concrete implementation of the interface in order to use it.
 * You can choose between the following Deque implementations in the Java
 * Collections API:
 * 
 * java.util.LinkedList java.util.ArrayDeque
 *
 *
 * http://tutorials.jenkov.com/java-collections/deque.html
 */
public class DequeDemo {

	public static void main(String[] args) {

		Deque deque = new LinkedList();
		deque.add("element 1");
		deque.addFirst("element 1");
		deque.addLast("element 3");
		Object element = deque.peekFirst();
		System.out.println(element);
		/*
		 * Here is another example of creating a Java Deque by creating an ArrayDeque
		 * instance:
		 */

		Deque deque2 = new ArrayDeque();
		deque2.add("element 1");
		deque2.addFirst("element 1");
		deque2.addLast("element 3");
		element = deque2.peekLast();
		System.out.println(element);

		deque = new LinkedList();

		deque.add("element 0");
		deque.add("element 1");
		deque.add("element 2");

		System.out.println();
		Iterator iterator = deque.iterator();
		while (iterator.hasNext()) {
			String elm = (String) iterator.next();
			System.out.println(elm);
		}

		System.out.println();
		for (Object object : deque) {
			String elm = (String) object;
			System.out.println(elm);
		}
	}
}
