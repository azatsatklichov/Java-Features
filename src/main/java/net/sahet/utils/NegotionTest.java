package net.sahet.utils;

import java.util.List;

public class NegotionTest {

	public static void main(String[] args) {
		List<String> variable = List.of("A", "B");
		List<String> variable2 = List.of("A", "B");

		if (!variable.isEmpty() && !variable2.isEmpty()) {
			System.out.println("optimized algo");
		}

		if (!(variable.isEmpty() || variable2.isEmpty())) {
			System.out.println("commz optimized algo");
		}

		String var = "oo";
		if (var != null && !(var instanceof String)) {
			System.out.println("Ole");
		}
		
		if (!(var == null || var instanceof String )) {
			System.out.println("Ole");
		}
	}

}
