package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter a number: ");
		int startingNumber = scanner.nextInt();

		int firstNumber = 0;
		int secondNumber = 1;

		System.out.print(firstNumber + ", " + secondNumber);

		int nextNumber = firstNumber + secondNumber;

		while (nextNumber <= startingNumber) {
			System.out.print(", " + nextNumber);
			firstNumber = secondNumber;
			secondNumber = nextNumber;
			nextNumber = firstNumber + secondNumber;
		}

		scanner.close();
	}

}
