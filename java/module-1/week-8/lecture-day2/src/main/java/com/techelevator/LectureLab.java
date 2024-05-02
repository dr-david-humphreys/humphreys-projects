package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class LectureLab {

    public static void main(String[] args) {

        //Get the search word
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the search word> >>> ");
        String searchWord = userInput.nextLine();
        if((searchWord == null) || (searchWord.isEmpty())){
            System.out.println("The search word is empty, try again");
        }


        System.out.println("What is the replacement word? >>> ");
        String replacementWord = userInput.nextLine();
        if((replacementWord == null) || (replacementWord.isEmpty())){
            System.out.println("The replacement word is empty, try again");
        }


        // Replace word / create new file PrintWriter  println method, File
        String sourcePath = "src/data/sourceFile.txt";
        File sourceFile = new File(sourcePath);

        String destPath = "src/data/destFile2.txt";
        File destinationFile = new File(destPath);

        try(Scanner sourceScanner = new Scanner(sourceFile);
            PrintWriter destinationWriter = new PrintWriter(destinationFile)){
            while (sourceScanner.hasNextLine()){
                String line = sourceScanner.nextLine();
                destinationWriter.println(line.replaceAll(searchWord, replacementWord));
            }


        }catch(FileNotFoundException e){
            System.out.println("Exception: " + e.getMessage());
        }


        //append to file -  PrintWriter  println method and FileOutputStream
        String message = "Live long and prosper";
        boolean append = destinationFile.exists() ? true : false;

        try(PrintWriter writer = new PrintWriter(new FileOutputStream(destinationFile, append))){
            writer.println(message);
        }catch(FileNotFoundException e){
            System.out.println("Exception: " + e.getMessage());
        }

    }



}
