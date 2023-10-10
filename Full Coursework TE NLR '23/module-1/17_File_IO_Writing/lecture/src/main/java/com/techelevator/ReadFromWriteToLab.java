package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromWriteToLab {

    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        ReadFromWriteToLab readFromWriteToLab = new ReadFromWriteToLab();
        readFromWriteToLab.run();
    }

    public void run() {
        try (userInput) {

            // 1. Prompt user for the search word to remove - handle if user input is empty
            System.out.print("Enter the search word to remove: ");
            String searchWord = userInput.nextLine();

            if (searchWord.isEmpty()) {
                System.out.println("Search word cannot be empty.");
                return;
            }

            // 2. Prompt user for the location of the source file
            System.out.print("Enter the location of the source file (e.g., mysourcefile.txt): ");
            String fileName = userInput.nextLine();
            String sourceFilePath = "lecture/data/" + fileName;

            // 3. Validate the input source file
            File sourceFile = new File(sourceFilePath);
            if (!sourceFile.exists()) {
                System.out.println(sourceFilePath + " is not a file");
                return;
            }

            // 4. Prompt user for the location of the destination file - handle if user input is empty
            System.out.print("Enter the location of the destination file: ");
            String destinationFilePath = userInput.nextLine();

            // 5. Validate the destination file is a .txt file
            if (destinationFilePath.isEmpty()) {
                System.out.println("Destination file path cannot be empty.");
                return;
            }
            if (!destinationFilePath.endsWith(".txt")) {
                System.out.println("Destination file must be a .txt file.");
                return;
            }

            // 6. Remove search word entered on step 1
            try (Scanner fileScanner = new Scanner(sourceFile);
                 java.io.PrintWriter writer = new java.io.PrintWriter(destinationFilePath)) {

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String modifiedLine = line.replaceAll(searchWord, "");
                    writer.println(modifiedLine);
                }

                System.out.println("File modification complete.");

            } catch (FileNotFoundException e) {
                System.out.println("Error reading or writing files.");
            }

        } finally {
            userInput.close();
        }
    }
}