package tasks.programmaing.paradigms;

interface ConstructorTips_InterfaceNotPartOfObjectInheritanceTree {

	void hello();

}

class TestAbove {

	public static void main(String[] args) {
		ConstructorTips_InterfaceNotPartOfObjectInheritanceTree test = new ConstructorTips_InterfaceNotPartOfObjectInheritanceTree() {

			@Override
			public void hello() {
				System.out.println("hello");

			}
		};

		test.hello();

		System.out
				.println(" Interfaces do not have constructors. Interfaces are not part of an object's  inheritance tree. BUT see below");
		System.out.println(test.hashCode());

		if (test instanceof Object)
			System.out.println("you see, it is instance of Object");
		else
			System.out.println("you see, it is not");
	}
}





interface NotPartOfObjectInheritanceTree {
}

class Imp implements NotPartOfObjectInheritanceTree {
	public static void main(String[] args) {
		NotPartOfObjectInheritanceTree ref = new Imp();
		System.out.println("ref. can call any Object methods so HOW, and WHY");
	}
}

/**
 * What happens if the super constructor has arguments? Constructors can have
 * arguments just as methods can, and if you try to invoke a method that takes,
 * say, an int, but you don't pass anything to the method, the compiler will
 * complain as follows:
 * 
 * @author Admin
 * 
 */
// Crucial point: if your superclass does not have a no-arg
class AnimalXz {
	AnimalXz(String name) {
	}

}

class Horsev extends AnimalXz {
	Horsev() {
		// super(); // Problem!
		super("Yhhymmil");
	}
}

class Barr {
	void takeInt(int x) {
	}
}

class UseBarr {
	public static void main(String[] args) {
		Barr b = new Barr();
		// b.takeInt(); // Try to invoke a no-arg takeInt() method
		System.out
				.println("Hayirlisi, 3-gezek ang boljak bolyan, bye bye rpt21, ims, inwk unfair 'equality world' ");
		
		System.out
        .println("zato, RPT like IMS de ishlap yorun, but other way project looks like ICM Logica   ");
	}
}
