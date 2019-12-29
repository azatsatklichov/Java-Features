package tasks.algorithmic.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparingExample {

	public static void main(String[] args) {

		List<Integer> ints = Arrays.asList(new Integer[] { 34, 5, -5, 55, 6 });
		Integer min = ints.stream().min(Comparator.comparing(item -> item)).get();
		System.out.println(min);
	}
}

class Car {
	public String brand;
	public String numberPlate;
	public int noOfDoors;

	public Car(String brand, String numberPlate, int noOfDoors) {
		this.brand = brand;
		this.numberPlate = numberPlate;
		this.noOfDoors = noOfDoors;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", numberPlate=" + numberPlate + ", noOfDoors=" + noOfDoors + "]";
	}
}

class SortingLists {
	public static void main(String[] args) {

		List<String> l = new ArrayList<String>();

		l.add("c");
		l.add("b");
		l.add("d");
		l.add("a");

		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
		Collections.sort(l, Comparator.reverseOrder());
		System.out.println(l);

		List<Car> carList = new ArrayList<>();

		carList.add(new Car("Volvo V40", "XYZ 201845", 5));
		carList.add(new Car("Citroen C1", "ABC 164521", 4));
		carList.add(new Car("Dodge Ram", "KLM 845990", 2));

		Comparator<Car> carBrandComparator = new Comparator<Car>() {
			@Override
			public int compare(Car car1, Car car2) {
				return car1.brand.compareTo(car2.brand);
			}
		};

		System.out.println(carList);
		Collections.sort(carList, carBrandComparator);
		System.out.println(carList);

		List<Car> list = new ArrayList<>();

		list.add(new Car("Volvo V40", "XYZ 201845", 5));
		list.add(new Car("Citroen C1", "ABC 164521", 4));
		list.add(new Car("Dodge Ram", "KLM 845990", 2));

		Comparator<Car> carBrandComparatorLambda = (car1, car2) -> car1.brand.compareTo(car2.brand);
		Comparator<Car> carNumberPlatComparatorLambda = (car1, car2) -> car1.numberPlate.compareTo(car2.numberPlate);
		Comparator<Car> carNoOfDoorsComparatorLambda = (car1, car2) -> car1.noOfDoors - car2.noOfDoors;

		System.out.println();
		Collections.sort(list, carBrandComparatorLambda);
		System.out.println(list);
		Collections.sort(list, carNumberPlatComparatorLambda);
		System.out.println(list);
		Collections.sort(list, carNoOfDoorsComparatorLambda);
		System.out.println(list);

	}
}