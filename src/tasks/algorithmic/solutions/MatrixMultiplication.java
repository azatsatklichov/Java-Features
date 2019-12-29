package tasks.algorithmic.solutions;

import java.util.Arrays;

/**
 * Thanks to QMU University time idea, below A=B*C is implemented according to
 * that
 * 
 * @author Azat
 *
 */
public class MatrixMultiplication {

	public static void main(String[] args) {
		System.out.println("Multiplication of TWO Matrixes");
		int[][] b = { { 1, 2, 3 }, { 2, 4, 5 } };
		int[][] c = { { 3, 3 }, { 4, 6 }, { 5, 7 } };
		multiplyTwoMatrices(b, c);

		System.out.println("\nMultiplication of TWO Matrixes");
		int[][] b2 = { { 1, 2, 3, 6 }, { 2, 4, 5, -7 }, { 2, 4, 5, -7 } };
		int[][] c2 = { { 3, 3, 0 }, { 4, 6, -9 }, { 5, 7, -1 }, { 0, -6, -7 } };
		multiplyTwoMatrices(b2, c2);

		System.out.println("\nMultiplication of TWO Matrixes");
		int[][] b3 = { { 2, 4, 5, -7 }, { 1, 2, 3, 6 }, { 2, 4, 5, -7 }, { 2, 4, 5, -7 } };
		int[][] c3 = { { 2, 4, 5, -7 }, { 1, 2, 3, 6 }, { 2, 4, 5, -7 }, { 2, 4, 5, -7 } };
		multiplyTwoMatrices(b3, c3);
	}

	/**
	 * A = B*C means a[i][j]=b[i][k]*c[k][j],
	 * 
	 * where i, j and k are indexes of given matrices. Also NOTE, matricess must be
	 * SQUARE or RECTANGLED matrices, and SATISFY below condition.
	 * 
	 * Number of COLUMNs of matrix B must EQUAL to number of RAWs of matrix C
	 * 
	 * @param b
	 * @param c
	 */
	public static void multiplyTwoMatrices(int[][] b, int[][] c) {
		if (b == null || c == null)
			throw new IllegalArgumentException("Enter valid MATRICEs");

		// validate if MATRICES can be multiplied
		if (b[0].length != c.length)
			throw new IllegalArgumentException(
					"Number of COLUMNs of FIRST(B) matrix  must EQUAL to number of RAWs of SECOND(C) matrix");

		// A = B*C means a[i][j]=b[j][k]*c[k][j]
		int[][] a = new int[b.length][c[0].length]; // [rows of B][columns of C]

		for (int i = 0; i < b.length; i++) { // rows of B
			for (int j = 0; j < c[i].length; j++) { // columns of C
				int sum = 0;
				for (int k = 0; k < c.length; k++) { // rows of C
					// below can be replaced by ABOVE
					// for (int k = 0; k < b[i].length; k++) { // rows of C / columns of B
					sum += b[i][k] * c[k][j];
				}
				a[i][j] = sum;
			}
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
}
