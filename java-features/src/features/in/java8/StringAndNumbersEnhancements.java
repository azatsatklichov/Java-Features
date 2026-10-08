package features.in.java8;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class StringAndNumbersEnhancements {

	public static void main(String[] args) {
		// String in Java 8
		IntStream is = "ABCDEFG".chars();

		// long count = is.mapToObj(letter ->
		// (char)letter).peek(System.out::print).count();

		is.mapToObj(letter -> (char) letter).peek(System.out::print).forEach(x -> {
			System.out.println("Heyjanelek janelek cakga cakyp bereyin, gurbaganyn ayagyna yupler dakyp bereyin  " + x);
		});

		// Concatenation
		// Before Java 7 this was creating many obsolete objects. With Java 7 internally
		// StringBuilder is used, so nice now
		String s = "A" + "B" + "C";
		System.out.println(s);

		// Then StringBuffer and StringBuilder started to be used
		StringBuilder sb = new StringBuilder();
		sb.append("A").append("B").append("C");
		String str = sb.toString();
		System.out.println(str);
		System.out.println();

		System.out.println("now Java8 way");
		StringJoiner sj = new StringJoiner(", ");
		sj.add("A").add("B").add("C");
		String str2 = sj.toString();
		System.out.println(str2);
		// with delimiter, prefix and postfix, quite handy
		sj = new StringJoiner(", ", "[", "]");
		System.out.println(sj);
		sj.add("A").add("B").add("C");
		sj.add("DD");
		System.out.println(sj);

		System.out.println();
		String join = String.join(":", "A", "B", "C", "D");
		System.out.println(join);

		String[] arr = { "A", "B", "C", "D" };
		join = String.join(":", arr);
		System.out.println(join);

		System.out.println();
		System.out.println("Java 8 news on Numbers");
		System.out.println("Max = " + Long.max(34, -90));
		// reduction Operation
		/**
		 * {@link StreamsCollectors}
		 */
		List<Integer> ints = List.of(34, 5, -7, 78);
		int sumOfValues = ints.stream().reduce(0, (a, b) -> a + b).intValue();
		System.out.println(sumOfValues);
		// sum method
		sumOfValues = ints.stream().reduce(0, Integer::sum).intValue();
		System.out.println(sumOfValues);

		// hash code calc, no Need Box/Unbox
		long l = 4454545452202L;
		System.out.println("hashCode: " + new Long(l).hashCode());
		System.out.println("hashCode: " + Long.hashCode(l));

	}

}
