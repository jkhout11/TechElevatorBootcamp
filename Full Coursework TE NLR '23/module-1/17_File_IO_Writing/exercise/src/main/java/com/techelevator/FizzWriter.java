package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FizzWriter {

	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		System.out.println("What is the destination file?");
		String destinationFile = userInput.nextLine();

		try {
			writeFizzBuzzToFile(destinationFile);
			System.out.println("FizzBuzz successfully written to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred while writing to the file.");
		}
	}

	private void writeFizzBuzzToFile(String destinationFile) throws IOException {
		File file = new File(destinationFile);

		try (FileWriter writer = new FileWriter(file)) {
			for (int i = 1; i <= 300; i++) {
				String line = getFizzBuzzLine(i);
				writer.write(line);
				writer.write(System.lineSeparator());
			}
		}
	}

	private String getFizzBuzzLine(int number) {
		if (number % 3 == 0 && number % 5 == 0) {
			return "FizzBuzz";
		} else if (number % 3 == 0) {
			return "Fizz";
		} else if (number % 5 == 0) {
			return "Buzz";
		} else {
			return Integer.toString(number);
		}
	}
}
