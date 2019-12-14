package tasks.programmaing.paradigms;

class Alien {
	String invade(short ships) {
		return "a few";
	}

	String invade(short... ships) {
		return "many";
	}
}

class Defender {
	public static void main(String[] args) {
		// compilation error
		// DEMOTION(downcast) must be EXPLICIT
		// System.out.println(new Alien().invade(7));
	}
}

/**
 * What is the result?
 * 
 * <pre>
 * 
 *    A.  212
 *    B.  232
 *    C.  234
 *    D.  312
 *    E.  332
 *    F.  334
 *    G. Compilation fails
 * </pre>
 * 
 */
class Bertha {
	static String s = "";

	public static void main(String[] args) {
		/**
		 * A is correct.
		 * 
		 * It's legal to autobox and then widen. The first call to doStuff() boxes the
		 * int to an Integer then passes two objects.
		 * 
		 * The second call cannot widen and then box (making the Long method unusable),
		 * so it boxes the int to an Integer.
		 * 
		 * As always, a var-args method will be chosen only if no non-var-arg method is
		 * possible. The third call is passing two objects—they are of type 'short
		 * array.'
		 * 
		 * 
		 * B, C, D, E, F, and G are incorrect based on the above. (Objective 3.1)
		 */
		int x = 4;
		Boolean y = true;
		short[] sa = { 1, 2, 3 };
		doStuff(x, y);
		System.out.println(s);
		doStuff(x);
		System.out.println(s);
		doStuff(sa, sa);
		System.out.println(s);
	}

	static void doStuff(Object o) {
		s += "1";
	}

	static void doStuff(Object... o) {
		s += "2";
	}

	static void doStuff(Integer... i) {
		s += "3";
	}

	static void doStuff(Long L) {
		s += "4";
	}
}
