package features.in.java8.lambdasinaction;

public class PassingCodeWithBehaviorParameterization {
	public static void main(String[] args) {
		System.out.println("lambda  expressions, which let you represent a behavior or pass code in a concise way.");
		System.out.println(
				"Method references, a\r\n" + "useful new feature that goes hand in hand with lambda expressions.");
		System.out.println(
				"FilteringApples2::isHeavyApple, using :: means, use this means as a VALUE --> Passing code/behavior as a VALUE");
		System.out
				.println("Behavior parameterization is a software development pattern that lets you handle frequent\r\n"
						+ "requirement changes. In a nutshell, it means taking a block of code and making it available\r\n"
						+ "without executing it.");
		System.out.println("For instance, you could pass\r\n"
				+ "the block of code as an argument to another method that will execute it later. As a result, the\r\n"
				+ "method’s behavior is parameterized based on that block of code.");

		System.out.println("This is (see ApplePredicate)\r\n"
				+ "what behavior parameterization means: the ability to tell a method to take multiple behaviors\r\n"
				+ "(or strategies) as parameters and use them internally to accomplish different behaviors.");

		System.out.println();

		System.out.println(
				"In 'FilteringApples2', you saw that passing code with behavior parameterization is useful for\r\n"
						+ "coping with frequent requirement changes in your code.");
		System.out.println(
				"Method references, a\r\n" + "useful new feature that goes hand in hand with lambda expressions.");
		
		System.out.println("\nRemember, lambda expressions \nlet you provide the implementation of the abstract" + 
				"method of a functional interface directly inline, and they treat the whole expression as an\r\n" + 
				"instance of a functional interface.");

	}

}
