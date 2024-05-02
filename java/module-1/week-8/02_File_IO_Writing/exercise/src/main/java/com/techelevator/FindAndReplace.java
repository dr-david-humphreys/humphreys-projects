package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */
        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String sourceFilePath = userInput.nextLine();

        System.out.println("What is the destination file?");
        String destinationFilePath = userInput.nextLine();

        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        try {
            performFindAndReplace(searchWord, replacementWord, sourceFile,destinationFilePath);
            System.out.println("Replacement completed");
        } catch (FileNotFoundException e) {
            System.out.println("Destination is invalid: " + e.getMessage());
        }
    }

    private void performFindAndReplace(String searchWord, String replacementWord, File sourceFile, String destinationFilePath) throws FileNotFoundException {
        try (Scanner fileScanner = new Scanner(sourceFile);
             PrintWriter writer = new PrintWriter(destinationFilePath)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String replaceLine = line.replaceAll(searchWord, replacementWord);
                writer.println(replaceLine);
            }
        }
    }

}
