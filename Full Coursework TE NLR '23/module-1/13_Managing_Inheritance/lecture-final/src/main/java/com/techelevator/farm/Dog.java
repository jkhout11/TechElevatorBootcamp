package com.techelevator.farm;

public class Dog extends FarmAnimal {

    public Dog() {
        super("Dog", "Woof!");

    }

    @Override
    public String eat(){
        return "Eating Dog food...";
    }


    @Override
    public String toString(){
        //String dogDisplay = getName() + " - Sound made: " + getSound();
        //Using String.format
        String dogDisplay = String.format("%s - Sound made: %s", getName(), getSound());  //use %d for int / numeric values
        return dogDisplay;
    }
}
