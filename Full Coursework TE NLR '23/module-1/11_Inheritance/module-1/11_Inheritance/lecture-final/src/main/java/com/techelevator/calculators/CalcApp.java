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


        //Subtract
        calc.subtract(3);
        System.out.println(calc.getResult());

        System.out.println("Programming Calculator");
        ProgrammingCalculator progCalc = new ProgrammingCalculator();
        progCalc.add(2);
        System.out.println(progCalc.getResult());
        progCalc.add(8);
        System.out.println(progCalc.getResult());

        System.out.println("Binary conversion:");
        String binaryString = progCalc.toBinary();
        System.out.println(binaryString);

        System.out.println();







    }
}
