package com.techelevator.model;

public class GumBall {
    private final int COLOR_RED = 0;
    private final int COLOR_BLUE = 1;
    private final int COLOR_GREEN = 2;

    private final int NUMBER_OF_COLORS = 3;

    public final String[] COLORS = {"Red", "Blue", "Green"};

    private final int FLAVOR_MANGO = 0;
    private final int FLAVOR_LEMON = 1;

    private final int NUMBER_OF_FLAVORS = 4;

    public final String[] FLAVORS = {"Mango", "Lemon"};

    private int color;
    private int flavor;

    public GumBall(int color, int flavor){
        this.color  = color;
        this.flavor = flavor;
    }



}
