package features.in.java17;

class X {
	private static void foo(Object o) {
		switch (o) {
		case Integer i -> System.out.println("String:");
		case String s -> System.out.println("String: Hello World!");
		default -> System.out.println("Object");
		}
	}

	public static void main(String[] args) {
		foo("Hello World");
	}
}