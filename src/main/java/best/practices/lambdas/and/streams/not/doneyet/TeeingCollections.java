package best.practices.lambdas.and.streams.not.doneyet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeeingCollections {
	/**
	 * Java 12 added a new static method teeing for Collectors that accepts two
	 * collectors and a function to merge their results.
	 * 
	 * So apply two collectors and combine them together at the end.
	 * 
	 * 
	 * Teeing Collector is the new collector utility introduced in the Streams API.
	 * 
	 * This collector has three arguments � Two collectors and a Bi-function. All
	 * input values are passed to each collector and the result is available in the
	 * Bi-function.
	 */
	public static void main(String[] args) {
		List<Employee> employeeList = Arrays.asList(new Employee(2, "B", 500, "Ford Fusion"),
				new Employee(1, "A", 1000, "Toyota RAV4 SUV"), new Employee(3, "C", 300, "Lada "),
				new Employee(4, "D", 900, "Subaru Forester SUV"), new Employee(2, "E", 250, "Nexia 2"));

		// downstream1 =max salary, downstream2 = min salary
		HashMap<String, Employee> result = employeeList.stream()
				.collect(Collectors.teeing(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
						Collectors.minBy(Comparator.comparing(Employee::getSalary)), (e1, e2) -> {
							HashMap<String, Employee> map = new HashMap();
							map.put("MAX", e1.get());
							map.put("MIN", e2.get());
							return map;
						}));

		System.out.println(result);

		// collect employees who has bigger salary, and SUV cars
		HashMap<String, Object> result1 = employeeList.stream()
				.collect(Collectors.teeing(Collectors.filtering(e -> e.getSalary() > 300, Collectors.toList()),
						Collectors.filtering(e -> e.getCarName().contains("SUV"), Collectors.toList()),
						(emps, suvCars) -> {
							HashMap<String, Object> map = new HashMap();
							map.put("GoodPaidEmps", emps);
							map.put("SUVCars", suvCars);
							return map;
						}));
		System.out.println(result1);

		// downstream1 =list of people who get more than 200, downstream2 = count of
		// those people
		employeeList = Arrays.asList(new Employee(1, "A", 100, ""), new Employee(2, "B", 200, ""),
				new Employee(3, "C", 300, ""), new Employee(4, "D", 400, ""));
		HashMap<String, Object> result2 = employeeList.stream()
				.collect(Collectors.teeing(Collectors.filtering(e -> e.getSalary() > 200, Collectors.toList()),
						Collectors.filtering(e -> e.getSalary() > 200, Collectors.counting()), (list, count) -> {
							HashMap<String, Object> map = new HashMap();
							map.put("list", list);
							map.put("count", count);
							return map;// insertion order unpredicted
						}));

		System.out.println(result2);
		var ints = Stream.of(45, 75, 67, 23);
		Long arithAverage = ints.collect(Collectors.teeing(Collectors.summingInt(Integer::valueOf),
				Collectors.counting(), (sum, count) -> sum / count));
		System.out.println("Arithmetic Average [sum of numbers]/[count] = " + arithAverage);

	}
}

class Employee {
	private long id;
	private String name;
	private double salary;
	private String carName;

	public Employee(long id, String name, double salary, String carName) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "Employee[id=" + id + ", name=" + name + ", salary=" + salary + ", carName=" + carName + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

}