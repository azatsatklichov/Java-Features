package features.in.java11;

import static java.util.function.Predicate.not;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//Predicate.not()
public class NegatePredicate {

	public static void main(String[] args) {

		List<Person> people = List.of(new Person(1), new Person(18), new Person(2));
		System.out.println(" all the adult ones");
		people.stream().filter(Person::isAdult).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("\n all non-adult ones");
		// we are forced to let go of the method reference, even though easier to read.
		people.stream().filter(person -> !person.isAdult()).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("\n all non-adult ones - work-around use method");
		// You can not define method if you inherit it or via API
		people.stream().filter(Person::isNotAdult).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("\n Java 11 arrives with the Predicate.not() method");
		people.stream().filter(Predicate.not(Person::isAdult)).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println(" even shorter");//
		people.stream().filter(not(Person::isAdult)).collect(Collectors.toList()).forEach(System.out::println);

	}
}



class Person {
	private static final int ADULT_AGE = 18;

	private int age;

	public Person(int age) {
		this.age = age;
	}

	public boolean isAdult() {
		return age >= ADULT_AGE;
	}

	public boolean isNotAdult() {
		return !isAdult();
	}

	@Override
	public String toString() {
		return "Person age: " + age;
	}
}
