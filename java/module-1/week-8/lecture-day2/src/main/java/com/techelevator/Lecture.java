package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.println("Enter the path of a file >>> ");
		String path = userInput.nextLine();
		File fileObj = new File(path);


		/* ***************************
		 * INSPECTING THE FILESYSTEM
		 * ***************************/

		System.out.println();
		if (fileObj.exists()){  // returns true if a file or directory exists at the file location, otherwise returns false
			System.out.println("name: " + fileObj.getName());
			System.out.println("absolute Path: " + fileObj.getAbsolutePath());
			if (fileObj.isDirectory()){
				System.out.println("type: directory");
			}else if (fileObj.isFile()){
				System.out.println("type: file");
			}
			System.out.println("size : " + fileObj.length());
		}else{
			System.out.println("File does not exists.");
		}

		//src/data/sourceFile.txt

		/* ************************
		 * CREATING A DIRECTORY
		 * ************************/

		System.out.println();
		System.out.println("Create a new directory");
		System.out.println("Enter the path of the new directory >>> ");
		path = userInput.nextLine();
		File newDirectory = new File(path);

		if(newDirectory.exists()){
			System.out.println("Sorry, " + newDirectory.getAbsolutePath() + " already exists.");
		}else{
			if(newDirectory.mkdir()){
				System.out.println("New directory created at "+ newDirectory.getAbsolutePath());
			}else{
				System.out.println("Could not create directory.");
			}
		}



		/* ************************
		 * CREATING A FILE
		 * ************************/
		System.out.println();
		System.out.println("Put a file in the directory.");
		System.out.println("Enter a name for the new file >>> ");
		String fileName = userInput.nextLine();
		File newFile = new File(newDirectory, fileName);

		newFile.createNewFile();
		System.out.println();
		System.out.println("name: " + newFile.getName());
		System.out.println("absolute path: " + newFile.getAbsolutePath());
		System.out.println("size: " + newFile.length());


		/* ************************
		 * WRITING TO A FILE
		 * ************************/
		System.out.println();
		System.out.println("Write something in the new file");
		System.out.println("Enter a message to be stored in the new file >>> ");
		String message = userInput.nextLine();

		try(PrintWriter writer = new PrintWriter(newFile)){
			writer.println(message);
		} //When we exit the try block (try-with-resources), this causes the file to be closed and an automatic flush of the buffer to be triggered.


		System.out.println();
		System.out.println("name: " + newFile.getName());
		System.out.println("absolute path: " + newFile.getAbsolutePath());
		System.out.println("size: " + newFile.length());

		/* ************************
		 * APPENDING TO A FILE
		 * ************************/

		String messageA = "Use the force Luke";

		boolean append = newFile.exists() ? false : true;

		try(PrintWriter writer = new PrintWriter(new FileOutputStream(newFile, append))){
			writer.println(messageA);
		}catch (FileNotFoundException e){
			System.out.println("Exception: " + e.getMessage());
		}


	}

}
