package modul.client;

import modul.core.api.Fibo;
import static modul.core.api.Fibo.fib;;

public class FiboClient {

	public static void main(String[] args) {
		Fibo.main(args); 
		System.out.println(fib(1));
		System.out.println(fib(3));
		System.out.println(fib(6));
	}
}
