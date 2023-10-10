package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Word Count (Lecture Lab)
 *
 * Write a program that, given a  path for a text file, reads the contents of the file,
 * and displays both the number of words and the number of sentences in the file.
 *
 * Hint 1: words are delimited by space characters
 * Hint 2: sentences are terminated by either a period, an exclamation mark, or a question mark.
 *
 * alices_adventures.txt
 * -----------------------------------
 * Expected Word Count: 30355
 * Expected Sentence Count: appx 1116
 */
public class FileReadingLab {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        FileReadingLab fileReadingLab = new FileReadingLab();
        fileReadingLab.run();
    }

    public void run() {
        /* Your code goes here */

        // Get the path of the user input file
        File inputFile;
        while (true) {
            System.out.println("alices_adventures.txt");

            String path = userInput.nextLine();

            // Validate the input file
            inputFile = new File(path); // 2. Update "" with correct code; What do you need to pass in the File() constructor initialize your inputFile object- hint:
            if (!inputFile.exists()) {
                System.out.println(path + " does not exist");
                continue;
            } else if (!inputFile.isFile()) {
                System.out.println(path + " is not a file");
                continue;
            }
            break;
        }
        // Count the words and sentences
        int wordCount = 0;
        int sentenceCount = 0;
        try (Scanner inputScanner = new Scanner(inputFile)){
            while (inputScanner.hasNextLine()) { // 3. Replace true with correct code
                String line = inputScanner.nextLine(); //4. Replace "" with correct code
                if (!line.isEmpty()) {   //5. Blank lines should be skipped - replace true with correct code
                    String[] words = line.trim().split("\\s+");   	// Split the line into individual words.
                    wordCount += words.length;						// The length of the array of words is the number of words. Doh!
                    //
                    // 6. Create logic to:
                    // Loop through words, add one to each 'sentence terminated' "." or "?" or "!" word found
                    for (String word : words) {
                        if (word.endsWith(".") || word.endsWith("?") || word.endsWith("!"));
                    } sentenceCount += 1;
                    //
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Display the word and sentence counts
        System.out.println("Word count: " + wordCount);
        System.out.println("Sentence count: " + sentenceCount);



    }

}
