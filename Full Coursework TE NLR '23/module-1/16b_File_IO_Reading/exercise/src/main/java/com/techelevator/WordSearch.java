package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordSearch {

	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		File inputFile;

		while (true) {
			System.out.println("What is the full name of the file that should be searched?");
			String path = userInput.nextLine();

			inputFile = new File(path);
			if (!inputFile.exists()) {
				System.out.println("File non-existent");
				continue;
			} else if (!inputFile.isFile()) {
				System.out.println("Invalid file");
				continue;
			}
			break;
		}

		System.out.println("What is the word you are searching for?");
		String searchWord = userInput.nextLine();

		System.out.println("Should the search be case sensitive? (Y/N)");
		boolean caseSensitive = userInput.nextLine().equalsIgnoreCase("Y");

		searchWordInFile(inputFile, searchWord, caseSensitive);
	}

	private void searchWordInFile(File inputFile, String searchWord, boolean caseSensitive) {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(inputFile);
			int lineNumber = 0;
			while (fileScanner.hasNextLine()) {
				lineNumber++;
				String line = fileScanner.nextLine();
				if (caseSensitive) {
					if (line.contains(searchWord)) {
						System.out.println(lineNumber + ") " + line);
					}
				} else {
					if (line.toLowerCase().contains(searchWord.toLowerCase())) {
						System.out.println(lineNumber + ") " + line);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error reading file: " + e.getMessage());
		} finally {
			if (fileScanner != null) {
				fileScanner.close();
			}
		}
	}
}