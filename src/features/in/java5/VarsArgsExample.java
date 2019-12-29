package features.in.java5;

import java.util.Arrays;

public class VarsArgsExample {

	public static void main(String[] args) {
		VarsArgsExample test = new VarsArgsExample();
		test.print();
		test.print("One");
		test.print("One", "Two");
		test.print("One", "Two", "Three");
	}

	public void print(String... varArgs) {
		if (varArgs.length == 0) {
			System.out.println("Paramters: " + Arrays.toString(varArgs));
		}
		for (String str : varArgs) {
			System.out.println("Paramters: " + str);
		}
		System.out.println("");
	}
}
