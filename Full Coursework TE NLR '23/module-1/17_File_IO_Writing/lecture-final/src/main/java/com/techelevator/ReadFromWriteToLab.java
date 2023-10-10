package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadFromWriteToLab {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        ReadFromWriteToLab readFromWriteToLab = new ReadFromWriteToLab();
        readFromWriteToLab.run();
    }

    public void run() {
        //try (userInput) {  //note: end of this try block is the last line of runnable app code. Not required - be familiar if you see this

            /** Your code goes here */

            //1.  Prompt user for the search word to remove  - handle if user input is empty
            System.out.println("What is the search phrase?");
            String searchWord = userInput.nextLine();
            if (searchWord.isEmpty()) {  // if null check in needed: (searchWord == null) || (searchWord.isEmpty())
                System.out.println("The word to replace is empty");

            }

            //2.  Prompt user for the location of the source file

            System.out.println("What is the source file?");
            String path = userInput.nextLine();

            //3.  Validate the input source file.  Tools to consider: if, else if, exists() and isFile() methods
            File sourceFile = new File(path);
            if (!sourceFile.exists()) {
                System.out.println(path + " does not exist");

            } else if (!sourceFile.isFile()) {
                System.out.println(path + " is not a file");

            }

            //4.  Prompt user for the location of the destination file - handle IF user input is empty
            System.out.println("What is the destination file?");
            path = userInput.nextLine();
            File destinationFile = new File(path);

            //5.  Validate the destination file is a .txt file. Tools to consider: if, endsWith() String method
            if (path.isEmpty()) {
                System.out.println("The destination filename is empty");

            }
            if (!destinationFile.getName().endsWith(".txt")) {
                System.out.println("The destination file must end in .txt");

            }

            //6.  Remove search word entered on step 1.  Tools to consider: String method replaceAll()
            try (Scanner sourceScanner = new Scanner(sourceFile);
                 PrintWriter destWriter = new PrintWriter(destinationFile)) {
                while (sourceScanner.hasNextLine()) {
                    String line = sourceScanner.nextLine();
                    destWriter.println(line.replaceAll(searchWord, ""));
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
       // }
    }
}