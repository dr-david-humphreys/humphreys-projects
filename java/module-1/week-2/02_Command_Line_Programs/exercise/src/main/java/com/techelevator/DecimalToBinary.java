package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String input = scanner.nextLine();

		String[] values = input.split(" ");

		for (int i = 0; i < values.length; i++) {
			int decimal = Integer.parseInt(values[i]);
			String binary = decimalToBinary(decimal);
			System.out.println(decimal + " in binary is " + binary);
		}

		scanner.close();
	}
	public static String decimalToBinary(int decimal) {
		StringBuilder binary = new StringBuilder();
		if (decimal == 0) {
			return "0";
		}
		while (decimal > 0) {
			int remainder = decimal % 2;
			binary.insert(0, remainder);
			decimal /= 2;
		}
		return binary.toString();
	}

}