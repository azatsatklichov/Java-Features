package best.practices.lambdas.and.streams;

public class BMeaningOfThis {

	public final String value = "23s";

	public static void main(String... args) {
		BMeaningOfThis m = new BMeaningOfThis();

		m.doIt();
		m.scopeExperiment();

	}

	public void doIt() {
		String value = "Ysn105";
		Runnable r = new Runnable() {
			public final String value = "Inner Wow";

			@Override
			public void run() {
				String value = "10i";
				System.out.println("Inner class 'this' means its own field =  " + this.value);
			}
		};
		r.run();
	}

	public String scopeExperiment() {
		Fooo fooIC = new Fooo() {
			String value = "Inner class value";

			@Override
			public String method(String string) {
				System.out.println("Inner class 'this' means its own field =  " + this.value);
				return this.value;
			}
		};
		String resultIC = fooIC.method("");

		Fooo fooLambda = parameter -> {
			String value = "saa";
			System.out.println("Lambda 'this' means outer instance of class, field =  " + this.value);
			return this.value;
		};
		String resultLambda = fooLambda.method("");

		return "Results: resultIC = " + resultIC + ", resultLambda = " + resultLambda;
	}

}

@FunctionalInterface
interface Fooo {
	String method(String string);

	default void defaultMethod() {
	}
}