package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingDemo {

    // One approach
    public static void main(String[] args) {
        //1.  Use this scanner(System.in) for all user input if needed. Don't create additional Scanners with System.in
        final Scanner userInput = new Scanner(System.in);

        //2.  Get the path of the input file
        String path = "src\\main\\java\\com\\techelevator\\data\\alices_adventures.txt";
        //String path = "src/main/java/com/techelevator/data/alices_adventures.txt";

        //3.  Create new file object
        File inputFile = new File(path);
        System.out.println(inputFile.getAbsoluteFile());

        if (!inputFile.exists()) {
            System.out.println(path + " does not exist");
        } else if (!inputFile.isFile()) {
            System.out.println(path + " is not a file");
        }

        //print the the first ten lines of alices_adventures.txt; skip blank lines.
        // 4. Create a new Scanner input file with a try with resources - try(...)
        int lineCount = 1;
        try (Scanner inputScanner = new Scanner(inputFile)) {
            while (inputScanner.hasNextLine() && lineCount <= 10) {
                String line = inputScanner.nextLine();
                if (!line.isEmpty()) {
                    System.out.println(line);
                }

                lineCount += 1;
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }




    }


}
