package com.techelevator.farm.codelab;

/**
Shape Application:

Each shape has a name, a color, and dimensions. The dimensions needed depend upon the shape. The application supports rectangles, squares, and circles.

To allow polymorphism and reuse common code, all the other shapes inherit from the base Shape class.
However, the Shape class doesn't include any dimensions of its own, so you can't use it in the application as a Shape.


Step One: Implement the Shape class
The Shape class can't be directly instantiated. It has two instance variables, name and color, that are readonly. Add a constructor that looks like this:

public Shape(String name, String color)
It also has one public method that subclasses must implement. getArea() takes no parameters and returns an integer representing the total area of the Shape.

 */

public abstract class Shape {

    private String name;
    private String color;


    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public abstract int getArea();

}
