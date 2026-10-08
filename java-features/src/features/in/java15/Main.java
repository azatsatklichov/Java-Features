package features.in.java15;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {
        Stream<Employee> employees =
                Stream.of(new Employee("1", "John", 1),
                          new Employee("2", "Pete", 2));

        System.out.println(lowestPaidEmployee(employees));
    }

    public static Employee lowestPaidEmployee(Stream<Employee> employees) {
        record Salary(Employee employee, int amount) {}

        return employees
                .map(emp -> new Salary(emp, findSalary(emp)))
                .sorted(Comparator.comparing(Salary::amount))
                .map(Salary::employee)
                .findFirst()
                .orElseThrow();
    }

    public static int findSalary(Employee emp) {
        return switch (emp.level()) {
            case 1 -> 2500;
            case 2 -> 3000;
            default -> 2000;
        };
    }
}

