package features.in.java16;

import java.util.Arrays;

/**
 * https://openjdk.java.net/jeps/338
 * 
 * An explicit way to implement the equivalent vector computation using the
 * Vector API is as follows:
 * 
 */
public class VectorAPIDemo {

	/**
	 * Here is a simple scalar computation over elements of arrays. We assume that
	 * the array arguments will be of the same size
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	void scalarComputation(float[] a, float[] b, float[] c) {
		for (int i = 0; i < a.length; i++) {
			c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
		}
	}

	/**
	 * An explicit way to implement the equivalent vector computation using the
	 * Vector API is as follows:
	 */
	// static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_256;

//	void vectorComputation(float[] a, float[] b, float[] c) {
//
//		for (int i = 0; i < a.length; i += SPECIES.length()) {
//			var m = SPECIES.indexInRange(i, a.length);
//			// FloatVector va, vb, vc;
//			var va = FloatVector.fromArray(SPECIES, a, i, m);
//			var vb = FloatVector.fromArray(SPECIES, b, i, m);
//			var vc = va.mul(va).add(vb.mul(vb)).neg();
//			vc.intoArray(c, i, m);
//		}
//	}

}

class VectorizationMicroBenchmark {
	private static float[] square(float[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] * a[i]; // line 11
		}
		return a;
	}

	public static void main(String[] args) throws Exception {
		float[] a = new float[1024];
		// repeatedly invoke the method under test. this
		// causes the JIT compiler to optimize the method
		for (int i = 0; i < 1000 * 1000; i++) {
			float[] square = square(a);
			System.out.println(Arrays.toString(square));
		}
	}
}
