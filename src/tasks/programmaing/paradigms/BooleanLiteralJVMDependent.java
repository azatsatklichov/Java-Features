package tasks.programmaing.paradigms;

/**
 * <p>
 * Description
 * </p>
 * 
 * <pre>
 * 
 * 
 * 
 *  The boolean type has exactly two values: true and false.
 * 
 * Where for integral types:
 * 
 *     The integral types are byte, short, int, and long, whose values are 8-bit, 16-bit, 
 *     32-bit and 64-bit signed two's-complement integers, respectively, and char, 
 *     whose values are 16-bit unsigned integers representing Unicode characters.
 * 
 * So you have required bit depth for integral types but it is solely up to you if your boolean will be 
 * represented in the memory as a single bit, byte or multibyte variable when you implement your own JVM.
 * 
 * </pre>
 */
class LotsOfBooleans {
	boolean a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
	boolean b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
	boolean c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
	boolean d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
	boolean e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
}

class LotsOfInts {
	int a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
	int b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
	int c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
	int d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
	int e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
}

class TestB {
	private static final int SIZE = 1000000;

	/**
	 * Desc:
	 * 
	 * <pre>
	 * Size for LotsOfBooleans: 95831400
	 * Average size: 95.8314
	 * Size for LotsOfInts: 337294624
	 * Average size: 337.294624
	 * 0
	 * </pre>
	 * 
	 */
	public static void main(String[] args) throws Exception {
		LotsOfBooleans[] first = new LotsOfBooleans[SIZE];
		LotsOfInts[] second = new LotsOfInts[SIZE];

		System.gc();
		long startMem = getMemory();

		for (int i = 0; i < SIZE; i++) {
			first[i] = new LotsOfBooleans();
		}

		System.gc();
		long endMem = getMemory();

		System.out.println("Size for LotsOfBooleans: " + (endMem - startMem));
		System.out.println("Average size: "
				+ ((endMem - startMem) / ((double) SIZE)));

		System.gc();
		startMem = getMemory();
		for (int i = 0; i < SIZE; i++) {
			second[i] = new LotsOfInts();
		}
		System.gc();
		endMem = getMemory();

		System.out.println("Size for LotsOfInts: " + (endMem - startMem));
		System.out.println("Average size: "
				+ ((endMem - startMem) / ((double) SIZE)));

		// Make sure nothing gets collected
		long total = 0;
		for (int i = 0; i < SIZE; i++) {
			total += (first[i].a0 ? 1 : 0) + second[i].a0;
		}
		System.out.println(total);
	}

	private static long getMemory() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();
	}
}
