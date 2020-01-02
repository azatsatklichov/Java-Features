package features.in.java6;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
	public static void main(String[] args) {
		System.out.println("Linked List Example!");
		LinkedList<Integer> list = new LinkedList<Integer>();
		int num1 = 11, num2 = 22, num3 = 33, num4 = 44, num5 = 3;
		int size;
		Iterator iterator;
		// Adding data in the list
		list.add(num1);
		list.add(num2);
		list.add(num3);
		list.add(num4);
		list.add(num5);
		size = list.size();
		System.out.print("Linked list data: ");
		// Create a iterator
		iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		// Check list empty or not
		if (list.isEmpty()) {
			System.out.println("Linked list is empty");
		} else {
			System.out.println("Linked list size: " + size);
		}
		System.out.println("Adding data at 1st location: 55");
		// Adding first
		list.addFirst(55);
		System.out.print("Now the list contain: ");
		iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		System.out.println("Now the size of list: " + list.size());
		System.out.println("Adding data at last location: 66");
		// Adding last or append
		list.addLast(66);
		System.out.print("Now the list contain: ");
		iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		System.out.println("Now the size of list: " + list.size());
		System.out.println("Adding data at 3rd location: 55");
		// Adding data at 3rd position
		list.add(2, 99);
		System.out.print("Now the list contain: ");
		iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		System.out.println("Now the size of list: " + list.size());
		// Retrieve first data
		System.out.println("First data: " + list.getFirst());
		// Retrieve lst data
		System.out.println("Last data: " + list.getLast());
		// Retrieve specific data
		System.out.println("Data at 4th position: " + list.get(3));

		// Remove first
		int first = list.removeFirst();
		System.out.println("Data removed from 1st location: " + first);
		System.out.print("Now the list contain: ");
		iterator = list.iterator();
		// After removing data
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		System.out.println("Now the size of list: " + list.size());
		// Remove last
		int last = list.removeLast();
		System.out.println("Data removed from last location: " + last);
		System.out.print("Now the list contain: ");
		iterator = list.iterator();
		// After removing data
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		System.out.println("Now the size of list: " + list.size());
		// Remove 2nd data
		int second = list.remove(1);
		System.out.println("Data removed from 2nd location: " + second);
		System.out.print("Now the list contain: ");
		iterator = list.iterator();
		// After removing data
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		System.out.println("Now the size of list: " + list.size());
		// Remove all
		list.clear();
		if (list.isEmpty()) {
			System.out.println("Linked list is empty");
		} else {
			System.out.println("Linked list size: " + size);
		}
	}
}