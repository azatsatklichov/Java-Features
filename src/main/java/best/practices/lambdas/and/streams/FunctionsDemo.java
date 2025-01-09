package best.practices.lambdas.and.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class FunctionsDemo {
	/**
	 * {@docRoot FunctionalInterfaces}
	 * @param args
	 */
	public static void main(String[] args) {
		// In Lambdas
		BiFunction<Integer, Integer, Integer> summer = (Integer num1, Integer num2) -> {
			return num1 + num2;
		};

		Integer number1 = 10;
		Integer number2 = 20;

		System.out.println(number1 + " + " + number2 + " = " + summer.apply(number1, number2));

		BiFunction<Integer, Integer, Long> summer2 = (num1, num2) -> {
			return (long) (number1 + number2);
		};

		System.out.println(number1 + " + " + number2 + " = " + summer2.apply(number1, number2));

		List<Integer> intList = Arrays.asList(5, 2, 4, 2, 1);
		Collections.sort(intList, (a, b) -> a.compareTo(b));

		List<String> strList = Arrays.asList("Red", "Blue", "Green");
		Collections.sort(strList, (a, b) -> a.compareTo(b));
	}

}
