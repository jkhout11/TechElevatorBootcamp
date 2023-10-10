package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileSplitter {

	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FileSplitter fileSplitter = new FileSplitter();
		fileSplitter.run();
	}

	public void run() {
		System.out.println("Where is the input file (please include the path to the file)?");
		String inputFile = userInput.nextLine();

		System.out.println("How many lines of text (max) should there be in the split files?");
		int maxLinesPerFile = userInput.nextInt();

		try {
			splitFile(inputFile, maxLinesPerFile);
			System.out.println("File split completed successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while splitting the file.");
		}
	}

	private void splitFile(String inputFile, int maxLinesPerFile) throws IOException {
		File file = new File(inputFile);
		if (!file.exists() || !file.isFile()) {
			System.out.println("Invalid input file.");
			return;
		}

		Path inputPath = file.toPath();
		String inputFileName = file.getName();

		try (Scanner fileScanner = new Scanner(file)) {
			int fileNumber = 1;
			int lineCount = 0;

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				lineCount++;

				if (lineCount > maxLinesPerFile) {
					lineCount = 1;
					fileNumber++;
				}

				String outputFileName = getOutputFileName(inputFileName, fileNumber);
				writeLineToFile(line, outputFileName);
			}
		}
	}

	private String getOutputFileName(String inputFileName, int fileNumber) {
		String fileNameWithoutExtension = inputFileName.substring(0, inputFileName.lastIndexOf('.'));
		String fileExtension = inputFileName.substring(inputFileName.lastIndexOf('.'));
		return fileNameWithoutExtension + "-" + fileNumber + fileExtension;
	}

	private void writeLineToFile(String line, String outputFileName) throws IOException {
		try (PrintWriter writer = new PrintWriter(new File(outputFileName))) {
			writer.println(line);
		}
	}
}
