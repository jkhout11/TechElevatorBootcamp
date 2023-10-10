package com.techelevator.calculators;

public class Calculator {

    // Instance variables - Properties
    private double result;


    //Constructors
    public Calculator(){

    }

    public Calculator(double result) {

    }

    public Calculator(int result) {

    }



    //Getter - no setters
    public double getResult(){
        return result;
    }


    // Custom methods
    public void reset(){
        result = 0;
    }

    public void enterNumber(double number){
        result = number;
    }

    public double add(double addend){
        result += addend;
        return result;
    }

    public double subtract(double subtrahend){
        result -= subtrahend;
        return result;
    }

    public double multiply(double multiplier){
        result *= multiplier;
        return result;
    }

    public double divide(double quotient){
        if(quotient == 0){
            result = Double.NaN;
        }
        else{
            result /= quotient;
        }
        return result;
    }

}
