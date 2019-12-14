package tasks.programmaing.paradigms;


class Knowing {
	static final long tooth = 343L;

	static long doIt(long tooth) {
		System.out.print(++tooth + " ");
		return ++tooth;
	}

	public static void main(String[] args) {
		System.out.print(tooth + " ");
		//shadowing
		final long tooth = 340L;
		new Knowing().doIt(tooth);
		System.out.println(tooth); 
		// mine
		System.out.print(tooth + " ");
	}
}

// 2-example
class Ouch {
	static int ouch = 7;

	public static void main(String[] args) {
		new Ouch().go(ouch);
		System.out.print(" " + ouch);
	}

	void go(int ouch) {
		ouch++;
		
		//compile error: duplicate  local variable
	//	for (int ouch = 3; ouch < 6; ouch++) ;
		
		System.out.print(" " + ouch);
	}
}