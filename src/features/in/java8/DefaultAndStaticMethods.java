package features.in.java8;

public class DefaultAndStaticMethods {

	public static void main(String[] args) {
		System.out.println(
				"Java 8 introduces a new concept of default method implementation in  interfaces. This capability is added for backward compatibility \n"
						+ "so that old interfaces can be used to leverage the lambda expression capability of Java 8 e.g. Iterable#forEach \n");

		System.out.println("ambiguity resolution\n");

		Vehicle v1 = new Car();
		v1.print();
		v1.print2();
		v1.print3();

		System.out.println();

		Vehicle v2 = new Car2();
		v2.print();
		v2.print2();
		v2.print3();

		System.out.println(
				"\n Java interface static method is similar to default method except that we can’t override them in the implementation classes. \n");
		Car2 obj = new Car2();
		obj.print("IFace");
		System.out.println();

		obj.isNull("abc");
	}
}

interface Vehicle {

	default void print() {
		System.out.println("I am a vehicle!");
	}

	void print2();

	default void print3() {
		System.out.println("print3 - I am a vehicle! ");
	}

	default void print(String str) {
		System.out.println();
		if (!isNull(str))
			System.out.println("MyData Print::" + str);
	}

	/**
	 * Java interface static method is similar to default method except that we
	 * can’t override them in the implementation classes. This feature helps us in
	 * avoiding undesired results in case of poor implementation in implementation
	 * classes.
	 * 
	 * @param str
	 * @return
	 */
	static boolean isNull(String str) {
		System.out.println("Interface Null Check");
		return str == null ? true : "".equals(str) ? true : false;
	}
}

interface FourWheeler {

	default void print() {
		System.out.println("I am a four wheeler!");
	}
}

/**
 * Multiple Defaults
 * 
 * With default functions in interfaces, there is a possibility that a class is
 * implementing two interfaces with same default methods. The following code
 * explains how this ambiguity can be resolved. Adds more difficulty for DIMOND
 * cases
 * 
 */
class Car implements FourWheeler, Vehicle { // overrides who comes first:
											// Vehicle, FourWheeler

	// overrides
	public void print() {
		// FourWheeler.super.print();
		System.out.println("I am a four wheeler car vehicle!");
	}

	// implements
	public void print2() {
		System.out.println("Car print2 impl");
	}
}

/**
 * Second solution is to call the default method of the specified interface
 * using super.
 */
class Car2 implements Vehicle, FourWheeler {

	// default of vehicle, overrides
	public void print() {
		Vehicle.super.print(); // I am a vehicle!
		// Vehicle.print(); Cannot make a static reference to the non-static method
		// print() from the type Vehicle
	}

	// implements
	public void print2() {
		System.out.println("Car2  print2 impl");
	}

	// @Override
	/*
	 * just shadowing, nothing related with overrides, test it with @Override - The
	 * method isNull(String) of type MyDataImpl must override or implement a
	 * supertype method
	 */
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}

}
