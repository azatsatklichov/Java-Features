package features.in.java9;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewCollectors {

	public static void main(String[] args) {

		/**
		 * See StreamsCollectors
		 */
		List<Integer> ints = Stream.of(1, 2, 3).map(n -> n * n).collect(Collectors.toList());
		System.out.println(ints);

		// odd and even numbers
		Map<Integer, List<Integer>> mapInts = Stream.of(1, 2, 3, 3, 45, 78)
				.collect(Collectors.groupingBy(i -> i % 2, Collectors.toList()));
		System.out.println(mapInts);

		List<Item> items = Arrays.asList(new Item(1, "bir"), new Item(2, "iki"), new Item(2, "ikki"),
				new Item(3, "uc"));

		 

	}

}

class Item {
	private Integer id;
	private String name;

	public Item(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Item {id=" + id + ", name=" + name + "}";
	}

}
