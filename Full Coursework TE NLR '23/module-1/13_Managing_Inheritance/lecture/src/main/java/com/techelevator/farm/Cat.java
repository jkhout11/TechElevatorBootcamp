package com.techelevator.farm;

public class Cat extends FarmAnimal {

    public Cat(String name, String sound, boolean sleep) {
        super(name, sound, sleep);
    }

    @Override
    public String getSound() {
        return "Meow";
    }



}
