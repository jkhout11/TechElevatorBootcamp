package com.techelevator.calculators;

public class ProgrammingCalculator extends Calculator  {

    public ProgrammingCalculator(){
        //super(0.0);
    }


    public String toBinary(){
        String binaryString = Integer.toBinaryString((int)getResult());

        return binaryString;
    }


}
