package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException { //not a best practice to add throws to main - avoid this; used here for demo code

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

//		System.out.println("Enter the path of a file or directory");
//		String path = userInput.nextLine();
//		File fileSysObj = new File(path);

		/*
		 * The File class allows us to inspect various attributes of a file system object
		 */

		/* ***************************
		 * INSPECTING THE FILESYSTEM
		 * ***************************/
//		System.out.println();
//		if(fileSysObj.exists()){
//			System.out.println("name: " + fileSysObj.getName());
//			System.out.println("absolutePath: " + fileSysObj.getAbsolutePath());
//			if(fileSysObj.isDirectory()){
//				System.out.println("type: directory");
//			}else if (fileSysObj.isFile()){
//				System.out.println("type: file");
//			}
//			System.out.println("size : " + fileSysObj.length());
//		}else{
//			System.out.println(path + " does not exist");
//		}



		/*
		 * The File class also allows us to manipulate file system objects
		 * */

		/* ************************
		 * CREATING A DIRECTORY
		 * ************************/
//		String path = "Data2";
//		System.out.println();
//		System.out.println("Let's create a new directory");
//		System.out.println("Enter the path of the new directory >>> ");
//		path = userInput.nextLine();
//		File newDirectory = new File(path);
//
//		if( newDirectory.exists()){
//			System.out.println("Sorry, " + newDirectory.getAbsolutePath() + " already exists.");
//
//		}else {
//			if (newDirectory.mkdir()){
//				System.out.println("New directory created at " + newDirectory.getAbsolutePath());
//			}else{
//				System.out.println("Could not create directory.");
//			}
//		}


		/* ************************
		 * CREATING A FILE
		 * ************************/
//		System.out.println();
//		System.out.println("Creating an new file.");
//		System.out.println("Enter a name for the new file >>> ");
//		String fileName = userInput.nextLine();
//		File newFile = new File(fileName);
//
//		newFile.createNewFile();
//		System.out.println("name: " + newFile.getName());
//		System.out.println("absolute path: " + newFile.getAbsolutePath());
//		System.out.println("size: " + newFile.length());

		/* ************************
		 * WRITING TO A FILE
		 * ************************/

//		System.out.println();
//		System.out.println("Write something to the new file");
//		System.out.println("Enter a message to be stored in the new file >>> ");
//		String message = userInput.nextLine();
//
//		try(PrintWriter writer = new PrintWriter(newFile)){
//			writer.println(message);
//		} // when we exit the try block, this causes the file to be closed and an automatic flush of the buffer
//
//		System.out.println();
//		System.out.println("name: " + newFile.getName());
//		System.out.println("absolute path: " + newFile.getAbsolutePath());
//		System.out.println("size: " + newFile.length());


		/* ************************
		 * APPEND TO A FILE
		 * ************************/
		String filePath = "data2/newfiletest.txt";
		File file = new File(filePath);

		String message = "Appreciate, Elevate, Participate";
		//boolean append = false;
		boolean append = file.exists() ? true : false;

		try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, append))){
			writer.println(message);
		} catch(FileNotFoundException ex){
			System.out.println("Exception: " + ex.getMessage());
		}


	}



}
