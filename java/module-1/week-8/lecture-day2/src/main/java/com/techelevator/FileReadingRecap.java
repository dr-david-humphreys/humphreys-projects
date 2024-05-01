package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;

public class FileReadingRecap {

    public static void main(String[] args) {
        //User Story: As a CLI [-] App user I need to print the the first ten lines of alices_adventures.txt file; skipping blank lines.


        //Use this scanner(System.in) for all user input if needed. Don't create additional Scanners with System.in
        //final Scanner scannerUserInput = new Scanner(System.in);
        //System.out.println("Enter the file path >>> ");

        // Reading a file:
        //1.  Get the path of the input file
        //String path = scannerUserInput.nextLine();
        String path = "src/data/sourceFile.txt";


        //2.  Create a new file object
        File inputFile = new File(path);

        System.out.println(inputFile.getAbsoluteFile());

        if(!inputFile.exists()){
            System.out.println(path +  "does not exists");
        } else if (!inputFile.isFile()) {
            System.out.println(path + " is not a file");
        }


        // 3. Create a new Scanner input file with a try with resources - try(...)
        try(Scanner scannerFileInput = new Scanner(inputFile)){
            int lineCount = 1;
            while(scannerFileInput.hasNextLine() && lineCount <=10){
                String line = scannerFileInput.nextLine();
                if(!line.isEmpty()){
                    System.out.println(line);
                }
            }

        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());

        }




    }

}
