package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FileReverseLines {

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);

        // Prompt for source file name
        System.out.print("Enter the source file name: ");
        String sourceFileName = consoleScanner.nextLine();


        // Prompt for destination file name
        System.out.print("Enter the destination file name: ");
        String destinationFileName = consoleScanner.nextLine();

        // Initialize file handling
        File inputFile = new File(sourceFileName);
        //List<String> lines = new ArrayList<>();
        Stack<String> lines = new Stack<>();

        int lineCount = 0;

        try (Scanner fileScanner = new Scanner(inputFile)) {
            // Read lines from the source file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                //lines.add(line);
                lines.push(line);

            }

            lineCount = lines.size();

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + sourceFileName + "' does not exist.");
            return;
        }

        // Reverse the order of lines
        //Collections.reverse(lines); //comment out for stack

        // Write the reversed lines to the destination file
        try (PrintWriter writer = new PrintWriter(destinationFileName)) {
//            for (String line : lines) {
//                writer.println(line);
//            }

            while(!lines.isEmpty()){
                String lineText = lines.pop();
                writer.println(lineText);
            }



        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + destinationFileName);
            return;
        }

        // Output the number of lines processed
        System.out.println("Processed " + lineCount + " lines.");


    }
}
