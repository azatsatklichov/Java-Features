package com.java2novice.interview.programs;

/**
 * Program: Write a program to convert decimal number to binary format.
 * 
 * Description:
 * 
 * Write a program to convert decimal number to binary format using numeric
 * operations. Below example shows how to convert decimal number to binary
 * format using numeric operations.
 * 
 * 
 * 
 */
public class Base_DecimalToBinary {

	public void printBinaryFormat(int number) {
		int binary[] = new int[25];
		int index = 0;
		while (number > 0) {
			binary[index++] = number % 2;
			number = number / 2;
		}
		for (int i = index - 1; i >= 0; i--) {
			System.out.print(binary[i]);
		}
	}

	public static void main(String a[]) {
		  
		Base_DecimalToBinary dtb = new Base_DecimalToBinary();
		dtb.printBinaryFormat(25);
	}
}