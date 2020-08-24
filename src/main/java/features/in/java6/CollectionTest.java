package features.in.java6;

import java.util.HashSet;
import java.util.Iterator;

public class CollectionTest {
	public static void main(String[] args) {
		System.out.println("Collection Example!\n");
		int size;
		// Create a collection
		HashSet<String> collection = new HashSet<String>();
		String str1 = "Yellow", str2 = "White", str3 = "Green", str4 = "Blue";
		Iterator iterator;
		// Adding data in the collection
		collection.add(str1);
		collection.add(str2);
		collection.add(str3);
		collection.add(str4);
		System.out.print("Collection data: ");
		// Create a iterator
		iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		// Get size of a collection
		size = collection.size();
		if (collection.isEmpty()) {
			System.out.println("Collection is empty");
		} else {
			System.out.println("Collection size: " + size);
		}
		System.out.println();
		// Remove specific data
		collection.remove(str2);
		System.out.println("After removing [" + str2 + "]\n");
		System.out.print("Now collection data: ");
		iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		size = collection.size();
		System.out.println("Collection size: " + size + "\n");
		// Collection empty
		collection.clear();
		size = collection.size();
		if (collection.isEmpty()) {
			System.out.println("Collection is empty");
		} else {
			System.out.println("Collection size: " + size);
		}
	}
}