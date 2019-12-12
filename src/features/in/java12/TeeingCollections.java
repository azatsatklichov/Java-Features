package features.in.java12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TeeingCollections {
	/**
	 * Java 12 added a new static method teeing for Collectors that accepts two
	 * collectors and a function to merge their results.
	 * 
	 * 
	 * Teeing Collector is the new collector utility introduced in the Streams API.
	 * 
	 * This collector has three arguments – Two collectors and a Bi-function. All
	 * input values are passed to each collector and the result is available in the
	 * Bi-function.
	 */
	public static void main(String[] args) {
		List<Employee> employeeList = Arrays.asList(new Employee(2, "B", 200), new Employee(1, "A", 100),
				new Employee(3, "C", 300), new Employee(4, "D", 400));

		HashMap<String, Employee> result = employeeList.stream()
				.collect(Collectors.teeing(
						Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
						Collectors.minBy(Comparator.comparing(Employee::getSalary)), 
						(e1, e2) -> {
							HashMap<String, Employee> map = new HashMap();
							map.put("MAX", e1.get());
							map.put("MIN", e2.get());
							return map;
						}));

		System.out.println(result + "\n");

		employeeList = Arrays.asList(new Employee(1, "A", 100), new Employee(2, "B", 200), new Employee(3, "C", 300),
				new Employee(4, "D", 400));

		HashMap<String, Object> result2 = employeeList.stream()
				.collect(Collectors.teeing(
						Collectors.filtering(e -> e.getSalary() > 200, Collectors.toList()),
						Collectors.filtering(e -> e.getSalary() > 200, Collectors.counting()), 
						(list, count) -> {
							HashMap<String, Object> map = new HashMap();
							map.put("list", list);
							map.put("count", count);
							return map;
						}));

		System.out.println(result2); 
	}
}

class Employee {
	private long id;
	private String name;
	private double salary;

	public Employee(long id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee[id=" + id + ", name=" + name + ", salary=" + salary + "]";
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
}