package com.techelevator;

public class Inventory {

    public static void main(String[] args) {
        // Method for splitting up the inventory lines...
        String line = "01|Yoda|989|FP10";


        String[] parts = line.split("\\|");

        for( String part : parts) {
            System.out.println(part);

        }

        for( String part : parts) {
            System.out.print(part + "~");
        }

        //hint join may be useful - maybe not needed
    }
}
