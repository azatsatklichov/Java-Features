package intro.javase.tutorials;

import java.util.Comparator;

public class LambdaComparator {

	public static void main(String[] args) {

		Comparator<Developer> byName = new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};

		System.out.println(byName);

	}
}

class Developer {

	private String name;

	public String getName() {
		return name;
	}

}
