package features.in.java7;

public class UnderscoresInNumbers {
	public static void main(String[] args) {

		int phoneNumber = 123_555_1212;
		long creditCardNumber = 1234_5678_9012_4456L;
		long socialSecurityNumber = 123_45_6789L;

		// all valid declarations in Java7. Underscores are ignored by compiler
		int result = (1_2 + 23_8) / 5_0; // (Result would be 5)

		System.out.println(phoneNumber + ", " + creditCardNumber + ", " + socialSecurityNumber + " result = " + result);
	}
}
