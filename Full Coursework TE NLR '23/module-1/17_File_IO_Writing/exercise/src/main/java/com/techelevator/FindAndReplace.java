package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FindAndReplace {

    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String sourceFile = userInput.nextLine();

        System.out.println("What is the destination file?");
        String destinationFile = userInput.nextLine();

        try {
            findAndReplaceInFile(searchWord, replacementWord, sourceFile, destinationFile);
            System.out.println("Find and replace completed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while performing find and replace.");
        }
    }

    private void findAndReplaceInFile(String searchWord, String replacementWord, String sourceFile, String destinationFile) throws IOException {
        File file = new File(sourceFile);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Invalid source file.");
            return;
        }

        Path sourcePath = file.toPath();
        Path destinationPath = Path.of(destinationFile);

        String content = Files.readString(sourcePath);
        String replacedContent = content.replace(searchWord, replacementWord);

        try (FileWriter writer = new FileWriter(destinationPath.toFile())) {
            writer.write(replacedContent);
        }
    }
}