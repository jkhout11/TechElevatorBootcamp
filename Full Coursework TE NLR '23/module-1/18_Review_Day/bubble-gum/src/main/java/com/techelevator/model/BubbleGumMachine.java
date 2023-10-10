package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class BubbleGumMachine {

    private int availableCents;
    private int totalCents;
    private int capacity;
    private int costPerGumBall;
    private List<GumBall> gumBalls;


    public BubbleGumMachine(int capacity, int costPerGumBall){
        this.capacity = capacity;
        this.costPerGumBall = costPerGumBall;
        this.availableCents = 0;
        this.totalCents = 0;
        this.gumBalls = new ArrayList<>();
    }

    public int addCents(int cents){
        availableCents += cents;
        return availableCents;
    }

}
