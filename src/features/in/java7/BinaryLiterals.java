package features.in.java7;

public class BinaryLiterals {
	public static void main(String[] args) {
		//how to convert binary number to decimal in Java6?
		//You could do it this way:
		Integer.parseInt("101010", 2);

		//But this is verbose, slow and could throw runtime exceptions.

		//New way:
		int binary = 0b101010; // Much easier right?
		
		/** Java code, due to its C heritage, has traditionally forced programmers to represent numbers in only decimal, octal, or hexadecimal.

		As quite a few domains are bit orientated, this restriction can introduce errors. You can now create binary numbers using an 0b prefix.

		*/
		int binary = 0b1001_1001;

	}
}
