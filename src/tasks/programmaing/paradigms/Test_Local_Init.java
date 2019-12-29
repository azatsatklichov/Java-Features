package tasks.programmaing.paradigms;


public class Test_Local_Init {

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
class Dark2 {
	int x = 3;

	public static void main(String[] args) {
		new Dark2().go1();
	}

	void go1() {
		int x; ///must be initialized before used
//		go2(++x); //Compilation fails
	}

	void go2(int y) {
		int x = ++y;
		System.out.println(x);
	}
}
