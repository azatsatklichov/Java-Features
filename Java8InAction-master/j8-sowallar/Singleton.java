package com.java2novice.interview.programs;

//1-way
public class Singleton {

	private static Singleton INSTANCE = new Singleton();

	private Singleton() {
		/*
		 * if (INSTANCE == null) INSTANCE = new Singleton();
		 */
	}

	public static Singleton getInstance() {
		return INSTANCE;
	}
}

class Singleton2 {

	private static Singleton2 instance;

	// Vytvorime soukromy konstruktor
	private Singleton2() {
	}

	// Metoda pro vytvoreni objektu jedinacek
	public static Singleton2 getInstance() {
		// Je-li promenna instance null, tak se vytvori objekt
		if (instance == null) {
			instance = new Singleton2();
		}
		// Vratime jedinacka
		return instance;
	}

	// Pouziti
	public static void main(String[] args) {
		Singleton objekt = Singleton.getInstance();
	}
}


//singleton in STATIC block
class Singleton3 {
	private static final Singleton3 instance;

	static {
		try {
			instance = new Singleton3();
		} catch (Exception e) {
			throw new RuntimeException("Darn, an error occurred!", e);
		}
	}

	public static Singleton3 getInstance() {
		return instance;
	}

	private Singleton3() {
		// ....
	}
}

class SingletonTest {

	// Použití je stejné
	public static void main(String[] args) {
		Singleton objekt = Singleton.getInstance();
		Singleton2 objekt2 = Singleton2.getInstance();
		Singleton3 objekt3 = Singleton3.getInstance();
	}
}

class ClassicSingleton {

	private static ClassicSingleton instance = null;

	protected ClassicSingleton() {
		// Exists only to defeat instantiation.
	}

	public static ClassicSingleton getInstance() {
		if (instance == null) {
			instance = new ClassicSingleton();
		}
		return instance;
	}
}