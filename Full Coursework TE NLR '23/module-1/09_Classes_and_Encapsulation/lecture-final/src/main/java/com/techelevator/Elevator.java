package com.techelevator;

public class Elevator {

    // Instance variables / properties / attributes / member variables
    private String elevatorTag;
    private int currentFloor = 1; //default
    private int numberOfFloors;
    private boolean doorOpen;


    //Constructor
    // explicitly created the default/empty constructor
    //    public Elevator(){
    //
    //    }


    public Elevator(String elevatorTag, int numberOfFloors) {
        this.elevatorTag = elevatorTag;
        this.numberOfFloors = numberOfFloors;
    }


    //Getters and Setters
    public String getElevatorTag() {
        return elevatorTag;
    }

    public void setElevatorTag(String elevatorTag) {
        this.elevatorTag = elevatorTag;
    }



    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    // Custom methods
    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }



    public void goUp(int desiredFloor) {
        if (!doorOpen && (desiredFloor > currentFloor) && (desiredFloor <= numberOfFloors)) {
            currentFloor = desiredFloor;
        }

    }

    public void goDown(int desiredFloor) {
        if (!doorOpen && (desiredFloor < currentFloor) && (desiredFloor >= 1)) {
            currentFloor = desiredFloor;
        }

    }
}
