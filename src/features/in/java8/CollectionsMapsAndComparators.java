package features.in.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsMapsAndComparators {

	public static void main(String[] args) {
		List<String> l = List.of("A", "B", "C"); // immutable you can't modify
		l.stream().forEach(System.out::print);
		System.out.println();

		l = Arrays.asList("A", "Z", "M", "C"); // java.lang.UnsupportedOperationException: remove
		ArrayList<String> ll = new ArrayList<>(l);
		ll.removeIf(x -> "A".equals(x));
		ll.replaceAll(String::toLowerCase);
		// natural comparator
		ll.sort(Comparator.naturalOrder());
		// Consumer as a Parameter
		ll.stream().forEach(System.out::print);
		System.out.println();

		// Maps
		Map<String, Auto> maps = new HashMap<>();
		maps.put("citroen", new Auto("Citroen C1", "ABC 164521", 4));
		Auto ford = new Auto("Frod fusion", "FRD 12363", 5);
		maps.put("ford", ford);
		maps.put("dodge", new Auto("Dodge Ram", "KLM 845990", 3));
		// BiConsumer as a Parameter
		maps.forEach((k, v) -> System.out.println(k + "=" + v));
		// maps.forEach(System.out::print); can't

		// if no key
		Auto defaultAuto = new Auto("Skoda Fabia", "AMD 345591", 5);
		Auto auto = maps.getOrDefault("ford", defaultAuto);
		System.out.println("defaultAuto = " + auto);

		System.out.println("Auto = " + maps.get("dodge"));
		// erases existing one, and replace the value with new
		Auto z = new Auto("Dodge RammmZ", "zKLM 845990", 3);
		maps.put("dodge", z);
		System.out.println("Auto = " + maps.get("dodge"));
		// put if absent, so no replace happens
		Auto z2 = new Auto("Dodge RammmZ2", "z2KLM 845990", 3);
		maps.putIfAbsent("dodge", z2);
		System.out.println("Auto = " + maps.get("dodge"));

		// replace, so no replace happens
		Auto zam = new Auto("Dodge RammmZAM", "zamKLM 845990", 3);
		Auto newZam = new Auto("Dodge New", "new 845990", 3);
		maps.replace("dodge", zam);
		System.out.println("Auto = " + maps.get("dodge"));

		maps.replace("dodge", zam, newZam);
		System.out.println("Auto = " + maps.get("dodge"));

		// remove before Java 8
		//maps.remove("dodge");
		// remove Java 8
		maps.remove("dodge", zam);
		System.out.println(maps);

		// replaceAll
		maps.replaceAll((k, v) -> ford);
		System.out.println(maps);

		// Comparator
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		// Java 8 Comparator
		Comparator<String> cmp2 = Comparator.comparingInt(String::length);
		// chained Comparator (in CGI 2013 tried by old way)
		Comparator<String> cmp3 = Comparator.comparingInt(String::length).thenComparing(String::lastIndexOf);
		System.out.println();

		List<Auto> list = new ArrayList<>(Arrays.asList(new Auto("Citroen C1", "ABC 164521", 5),
				new Auto("Volvo V40", "XYZ 201845", 5), new Auto("Citroen C1", "ABC 164521", 4),
				new Auto("Dodge", "KLM 845990", 2), new Auto("Dodge Ram", "KLM 845990", 3)));

		// Java 8 Comparator
		// to use natural one, Object must implement Comparable
		System.out.println("Natural comparator via Comparable interface #compareTo");
		Collections.sort(list, Comparator.naturalOrder());
		System.out.println(list);

		System.out.println("Comparator via Comparator interface#compare()");
		Comparator<Auto> comparatorByBrand = Comparator.comparing(Auto::getBrand);
		Collections.sort(list, comparatorByBrand);
		System.out.println(list);
		// chained Comparator (in CGI 2013 tried by old way)
		Comparator<Auto> comparatorByBrandAndDoors = Comparator.comparing(Auto::getBrand)
				.thenComparing(Auto::getNoOfDoors);
		Collections.sort(list, comparatorByBrandAndDoors);
		System.out.println(list);

		Comparator<Auto> comparatorByBrandAndDoorsReversed = comparatorByBrandAndDoors.reversed();
		Collections.sort(list, comparatorByBrandAndDoorsReversed);
		System.out.println(list);

		// or shorter
		Collections.sort(list, comparatorByBrand.reversed());
		System.out.println(list);

		System.out.println("Comparator nullsFirst");
		Comparator<String> nullsFirstCmp = Comparator.nullsFirst(Comparator.naturalOrder());
		l = Arrays.asList("A", null, "Z", "C", null); // List.of not allow nulls
		ll = new ArrayList<>(l);

		Collections.sort(ll, nullsFirstCmp);
		System.out.println(ll);

		Comparator<String> nullsLastCmp = Comparator.nullsLast(Comparator.naturalOrder());
		l = Arrays.asList("A", null, "Z", "C", null); // List.of not allow
		ll = new ArrayList<>(l);

		Collections.sort(ll, nullsLastCmp);
		System.out.println(ll);

	}

}

class Auto implements Comparable<Auto> {
	public String brand;
	public String numberPlate;
	public int noOfDoors;

	public Auto(String brand, String numberPlate, int noOfDoors) {
		this.brand = brand;
		this.numberPlate = numberPlate;
		this.noOfDoors = noOfDoors;
	}

	@Override
	public String toString() {
		return "Auto [brand=" + brand + ", numberPlate=" + numberPlate + ", noOfDoors=" + noOfDoors + "]";
	}

	public String getBrand() {
		return brand;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	@Override
	public int compareTo(Auto o) {
		return numberPlate.compareTo(o.numberPlate);
	}

}
