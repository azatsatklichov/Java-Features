package features.in.java5;

import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {

	public static void main(String[] args) {
		beforeJava5Generics();
		withJava5Generics();
	}

	private static void beforeJava5Generics() {
		List integers = new ArrayList();
		integers.add(new Integer(1));
		integers.add(new Integer(2));
		integers.add(new Integer(3));

		// you get an Object back from a List
		for (Object integer : integers) {
			// cast
			Integer num = (Integer) integer;
			System.out.println(num);
		}
	}

	private static void withJava5Generics() {
		List<Integer> integers = new ArrayList<Integer>();
		integers.add(4);
		integers.add(5);
		integers.add(6);

		// you get an Object back from a List
		for (Integer integer : integers) {
			System.out.println(integer);
		}
	}
}