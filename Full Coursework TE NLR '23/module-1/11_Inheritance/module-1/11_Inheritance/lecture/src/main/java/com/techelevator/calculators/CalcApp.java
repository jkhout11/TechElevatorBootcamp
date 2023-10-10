package com.techelevator.calculators;

public class CalcApp {
    public static void main(String[] args) {
        // Create a new calculator



        System.out.println("=====================");
        System.out.println(" Calculator App");
        System.out.println("=====================");

        Calculator calc = new Calculator();


        //Add
        calc.add(5);
        System.out.println(calc.getResult());
        calc.add(10);
        System.out.println(calc.getResult());

        System.out.println();







    }
}
