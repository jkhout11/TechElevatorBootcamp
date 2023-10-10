package com.techelevator;

public class ScratchPad {

    public static void main(String[] args) {
                                          //index   0             1             2
        String[] flightsArray = new String[] { "AirBus-100", "US Air-701", "Delta-350"};
        String currentFlight = "NA";
        //currentFlight.length();
        String firstFlight = flightsArray[0];
        String secondFlight = flightsArray[1];
        String thirdFlight = flightsArray[2];

        System.out.println(firstFlight);
        System.out.println(secondFlight);
        System.out.println(thirdFlight);


        // for loop
        for(int i = 0; i < flightsArray.length; i++){
            currentFlight = flightsArray[i];
            System.out.println(currentFlight);
        }

        // for-each
        for(String flight : flightsArray ){
            currentFlight = flight;
            System.out.println(currentFlight);
        }


        //Ternary Operator  - alternate to if /else statement
        //condition ? true : false

        int age = 21;
        String message;

        if(age >= 16){
            message = "Can Drive!";
        }else{
            message = "No, cant drive. Need permit";
        }

        String anotherMessage = (age >= 16) ? "Can Drive!" : "No, cant drive. Need permit";


        System.out.println(message);
        System.out.println(anotherMessage);


        String firstName = "Bruce";
        String lastName = "Wayne";
        String superHeroName = "Batman";

        String fullName = String.format("%s ---- %s - %s", lastName , firstName, superHeroName);
        System.out.println(fullName);

        System.out.println(String.format("%s ---- %s - %s", lastName , firstName, superHeroName));
        System.out.printf("%s ---- %s - %s", lastName , firstName, superHeroName);





    }

}
