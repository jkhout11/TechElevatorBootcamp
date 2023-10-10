package com.techelevator.farm;

public class Dog extends FarmAnimal {

    public Dog() {
        super("Dog", "Woof!");

    }


    @Override
    public String eat(){
        return "Eating Dog food...";
    }
}
