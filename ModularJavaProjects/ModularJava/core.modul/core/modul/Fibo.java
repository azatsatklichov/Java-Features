package core.modul;

public class Fibo {

	public static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String args[]) {
		int n = 19;
		System.out.println(fib(n));
		System.out.println(fib(5));
	}
}
