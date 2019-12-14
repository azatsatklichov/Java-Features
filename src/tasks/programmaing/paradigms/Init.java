package tasks.programmaing.paradigms;

////hi hi, followed by an exception

class Mixer {
	Mixer() {
	}

	Mixer(Mixer m) {
		m1 = m;
	}

	Mixer m1;

	public static void main(String[] args) {
		Mixer m2 = new Mixer();
		Mixer m3 = new Mixer(m2);
		m3.go();
		Mixer m4 = m3.m1;
		m4.go();
		Mixer m5 = m2.m1;
		m5.go(); // hi hi Exception in thread "main" java.lang.NullPointerException
	}

	void go() {
		System.out.print("hi ");
	}
}

/**
 * What is the result?
 * 
 * <pre>
 * 
 *   A. 2
 *   B. 3
 *   C. 4
 *   D. 5
 *   E. Compilation fails
 *   F. An exception is thrown at runtime
 * </pre>
 * 
 */
class Dark {
	int x = 3;

	public static void main(String[] args) {
		new Dark().go1();
	}

	void go1() {
		int x; /// must be initialized before used
//		go2(++x); //Compilation fails
	}

	void go2(int y) {
		int x = ++y;
		System.out.println(x);
	}
}