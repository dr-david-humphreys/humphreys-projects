package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		final double METERS_TO_FEET = 0.3048;
		final double FEET_TO_METERS = 3.2808399;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter the length: ");
		int length = scanner.nextInt();

		System.out.print("Is the measurement in (m)eters, or (f)eet? ");
		String scale = scanner.next();

		if (scale.equalsIgnoreCase("f")) {
			int lengthMeters = (int) (length * METERS_TO_FEET);
			System.out.println(length + "f is " + lengthMeters + "m.");
		} else if (scale.equalsIgnoreCase("m")) {
			int lengthFeet = (int) (length * FEET_TO_METERS);
			System.out.println(length + "m is " + lengthFeet + "f.");
		}
		scanner.close();
	}

}
