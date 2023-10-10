package com.techelevator;

import java.util.Scanner;

public class Tutorial {

    public static void main(String[] args) {

        // ***********  Step 1: Use the *new* operator to create Strings on the Heap  *************
        char[] helloChars = new char[] {'h', 'e', 'l', 'l', 'o', '!'};
        String greeting = new String(helloChars);
        System.out.println("Greeting: " + greeting);
        String salutation = new String("Welcome my friend");
        System.out.println("Salutation: " + salutation);
        String toast = "May the compiler rise up to meet you.";
        System.out.println("Toast: " + toast);
        // ***********  Step 2: Try out some String methods  *************
        System.out.print("Please type a sentence: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        System.out.println(sentence);
        String uppercaseSentence = sentence.toUpperCase();
        System.out.println(uppercaseSentence);
        System.out.println(sentence.toLowerCase());
        // ***********  Step 3: Compare Strings  *************





    }
}
