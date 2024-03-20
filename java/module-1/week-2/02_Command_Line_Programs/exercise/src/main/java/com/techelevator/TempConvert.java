package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the temperature: ");
		int temperature = scanner.nextInt();

		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit? " );
		String scale = scanner.next();

		if (scale.equalsIgnoreCase("F")) {
			double temperatureCelsius = (temperature - 32) / 1.8;
			System.out.println(temperature + "F is " + (int) temperatureCelsius + "C");
		} else if (scale.equalsIgnoreCase("C")) {
			double temperatureFahrenheit = temperature * 1.8 + 32;
			System.out.println(temperature + "C is " + (int) temperatureFahrenheit + "F");
		}
		scanner.close();
	}

}
