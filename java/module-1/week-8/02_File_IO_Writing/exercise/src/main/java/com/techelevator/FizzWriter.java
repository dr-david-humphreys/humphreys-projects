package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.println("Enter the destination file path to save FizzBuzz numbers: ");
		String destinationFilePath = userInput.nextLine();

		File destinationFile = new File(destinationFilePath);

		try {
			writeFizzBuzzToFile(destinationFile);
			System.out.println("FizzBuzz numbers have been saved to " + destinationFilePath);
		} catch (FileNotFoundException e) {
			System.out.println("Error: Invalid destination file path.");
		}
	}

	private void writeFizzBuzzToFile(File destinationFile) throws FileNotFoundException {
		try (PrintWriter writer = new PrintWriter(destinationFile)) {
			for (int i = 1; i <= 300; i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					writer.println("FizzBuzz");
				} else if (i % 3 == 0) {
					writer.println("Fizz");
				} else if (i % 5 == 0) {
					writer.println("Buzz");
				} else {
					writer.println(i);
				}
			}
		}
	}
}
