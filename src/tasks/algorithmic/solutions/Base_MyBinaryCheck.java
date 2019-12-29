package com.java2novice.interview.programs;

/**
 * Program: Write a program to check the given number is binary number or not?
 * 
 * Description:
 * 
 * The binary numeral system, or base-2 number system, represents numeric values
 * using two symbols: 0 and 1. More specifically, the usual base-2 system is a
 * positional notation with a radix of 2. Because of its straightforward
 * implementation in digital electronic circuitry using logic gates, the binary
 * system is used internally by almost all modern computers.
 * 
 * 
 * 
 */
public class Base_MyBinaryCheck {

	public boolean isBinaryNumber(int binary) {

		boolean status = true;
		while (true) {
			if (binary == 0) {
				break;
			} else {
				int tmp = binary % 10;
				if (tmp > 1) {
					status = false;
					break;
				}
				binary = binary / 10;
			}
		}
		return status;
	}

	public static void main(String a[]) {
		Base_MyBinaryCheck mbc = new Base_MyBinaryCheck();
		System.out
				.println("Is 1000111 binary? :" + mbc.isBinaryNumber(1000111));
		System.out.println("Is 10300111 binary? :"
				+ mbc.isBinaryNumber(10300111));
	}
}