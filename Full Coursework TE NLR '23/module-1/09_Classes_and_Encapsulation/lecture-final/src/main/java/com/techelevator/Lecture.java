package com.techelevator;

import com.techelevator.dogrescue.Dog;

public class Lecture {

    public static void main(String[] args) {

        System.out.println("############################");
        System.out.println("Classes and Encapsulation");
        System.out.println("############################");

        // Dog class & Elevator class

        Dog dog = new Dog("Giselle", 9, "Cockapoo");
        System.out.println("Dog object count " + Dog.dogCount);

        Dog dog2 = new Dog();
        System.out.println("Dog object count " + Dog.dogCount);

        dog2.setName("Snoopy");
        dog2.setAge(-5);



        String barkMessage = dog.bark();
        System.out.println(barkMessage);

        System.out.println("The Ancestor for all dog objects is " + Dog.ANCESTOR);




        System.out.println(dog.getName()+ " is " + dog.getAge());
        System.out.println(dog2.getName()+ " is " + dog2.getAge());

        System.out.println();
        System.out.println();
        System.out.println("############################");
        System.out.println("  Elevator Class            ");
        System.out.println("############################");
        Elevator elevator = new Elevator("OtisEV-1000", 18);

        System.out.println("Total number of floors: " + elevator.getNumberOfFloors());
        elevator.goUp(10);
        System.out.println("Arrived at floor: "+ elevator.getCurrentFloor());

        elevator.goDown(1);
        System.out.println("Arrived at floor: "+ elevator.getCurrentFloor());




    }
}
