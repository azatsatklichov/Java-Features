package best.practices.lambdas.and.streams.not.doneyet;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

// Sorting with function objects (Pages 193-4)
public class SortingFourWays {
	public static void main(String[] args) {
		List<String> words = Arrays.asList(args);

		// Anonymous class instance as a function object - obsolete! (Page 193)
		Collections.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});
		System.out.println(words);
		Collections.shuffle(words);

		// Lambda expression as function object (replaces anonymous class) (Page 194)
		Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(words);
		Collections.shuffle(words);

		// Comparator construction method (with method reference) in place of lambda
		// (Page 194)
		Collections.sort(words, comparingInt(String::length));
		System.out.println(words);
		Collections.shuffle(words);

		// Default method List.sort in conjunction with comparator construction method
		// (Page 194)
		words.sort(comparingInt(String::length));
		System.out.println(words);
	}
}

class Sorting {

	public static void main(String... args) {
		// 1
		List<Apple> inventory = new ArrayList<>();
		inventory.addAll(Arrays.asList(new Apple(80, "GREEN"), new Apple(155, "GREEN"), new Apple(120, "RED")));

		// [Apple{color=GREEN, weight=80}, Apple{color=RED, weight=120},
		// Apple{color=GREEN, weight=155}]
		inventory.sort(new AppleComparator());
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(30, "GREEN"));

		// 2
		// [Apple{color=GREEN, weight=30}, Apple{color=GREEN, weight=80},
		// Apple{color=GREEN, weight=155}]
		inventory.sort(new Comparator<Apple>() {

			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight() - a2.getWeight();
			}
		});
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(20, "RED"));

		// 3
		// [Apple{color=RED, weight=20}, Apple{color=GREEN, weight=30},
		// Apple{color=GREEN, weight=155}]
		inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(10, "RED"));

		// 4
		// [Apple{color=RED, weight=10}, Apple{color=RED, weight=20}, Apple{color=GREEN,
		// weight=155}]
		inventory.sort(comparing(Apple::getWeight));
		System.out.println(inventory);
	}

	static class AppleComparator implements Comparator<Apple> {

		@Override
		public int compare(Apple a1, Apple a2) {
			return a1.getWeight() - a2.getWeight();
		}

	}

}
