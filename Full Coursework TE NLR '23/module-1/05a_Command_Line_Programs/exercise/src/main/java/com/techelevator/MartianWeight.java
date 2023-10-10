package com.techelevator;

import java.util.Scanner;

/*
In case you've ever pondered how much you weigh on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth is 37 lbs. on Mars.
 235 lbs. on Earth is 88 lbs. on Mars.
 185 lbs. on Earth is 69 lbs. on Mars. 
 */
public class MartianWeight {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	;
		System.out.println("Welcome to Hello World's Martin Weight Converter");
		System.out.println("Enter a series of Earth weights (space-separated): ");
		String weights = scanner.nextLine();

		String[] weightsArray = weights.split(" ");

		for (int i = 0; i < weightsArray.length; i++){
			// Read the individual value as a double
			double earthWeight = Double.parseDouble(weightsArray[i]);

			// conversion of weights
			double marsWeight = earthWeight * 0.378;
			//input the weight conversion
			System.out.println("Earths weight: " + earthWeight + "lbs" + " Martian Weight: " + marsWeight + "lbs");
		}



}}