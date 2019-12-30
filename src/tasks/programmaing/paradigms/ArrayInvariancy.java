package tasks.programmaing.paradigms;

public class ArrayInvariancy {
	public static void main(String[] args) {
		Zippy zippy = new Zippy();
		System.out.println(zippy.a[0][1]);
		System.out.println(zippy.d);
		System.out.println(zippy.ii.length);
		System.out.println(zippy.xx);

	}
}

// compilation OK
class Zippy {
	String[] x;
	int[] a[] = { { 1, 2 }, { 1 } };
	Object c = new long[4];
	Object[] d = x;
	// Integer[] i = x;
	Integer[] ii = new Integer[2];
	Object xx = ii;
}

class ArrCasting {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, }, { 3, 4 } };
		int[] b = (int[]) a[1];
		Object o1 = a;
		int[][] a2 = (int[][]) o1;
		int[] b2 = (int[]) o1; // ClassCastException: [[I cannot be cast to [I
		// correction
		int[][] b22 = (int[][]) o1; // ClassCastException: [[I cannot be cast to [I
		System.out.println(b[1]);
	}
}