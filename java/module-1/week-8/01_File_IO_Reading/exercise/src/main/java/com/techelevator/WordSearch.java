package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		/* Your code goes here */

		System.out.println("What is the fully qualified name of the file that should be searched?");
		String filePath = userInput.nextLine();

		System.out.println("What is the search word you are looking for?");
		String searchWord = userInput.nextLine();

		System.out.println("Should the search be case sensitive? (Y/N)");
		boolean caseSensitive = userInput.nextLine().equalsIgnoreCase("Y");

		try {
			Scanner fileScanner = new Scanner(new File(filePath));
			int lineNumber = 0;
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				lineNumber++;
				if (caseSensitive) {
					if (line.contains(searchWord)) {
						System.out.println(lineNumber + ") " + line);
					}
				} else {
					if (line.toLowerCase().contains(searchWord.toLowerCase())) {
						System.out.println(lineNumber + ") " + line);
					}
				}
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}

	}

}
