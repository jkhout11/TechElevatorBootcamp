 package com.techelevator;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
 import java.util.*;
 public class MakeChange{
		 public static void main(String[] args) {
			 Scanner keyboard = new Scanner(System.in);

			 System.out.println("HELLO WORLD INC. POINT OF SALE SYSTEM");

			 System.out.print("Please enter the amount of the bill: ");
			 double billAmount = Double.parseDouble(keyboard.nextLine());

			 System.out.println("Please enter the amount tendered: ");
			 double amountTendered = Double.parseDouble(keyboard.nextLine());

			 double changeRequired = amountTendered - billAmount;
			 System.out.println("Change Required: " + changeRequired);
		 }
 }