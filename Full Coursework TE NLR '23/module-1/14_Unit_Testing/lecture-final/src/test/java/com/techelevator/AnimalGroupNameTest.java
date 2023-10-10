package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {

    @Test
    public void provide_known_animal_name_expect_known_herd_name(){
        /*
         * Given the name of an animal, return the name of a group of that animal
         * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
         *
         * The animal name should be case insensitive so "elephant", "Elephant", and
         * "ELEPHANT" should all return "Herd".
         *
         * If the name of the animal is not found, null, or empty, return "unknown".
         *
         * Rhino -> Crash
         * Giraffe -> Tower
         * Elephant -> Herd
         * Lion -> Pride
         * Crow -> Murder
         * Pigeon -> Kit
         * Flamingo -> Pat
         * Deer -> Herd
         * Dog -> Pack
         * Crocodile -> Float
         *
         * findHerd("giraffe") → "Tower"
         * findHerd("") -> "unknown"
         * findHerd("walrus") -> "unknown"
         * findHerd("Rhino") -> "Crash"
         * findHerd("rhino") -> "Crash"
         * findHerd("elephants") -> "unknown"
         *
         */

        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        String animalName = "giraffe";
        String expectedHerdName = "Tower";

        // Act
        String actualHerdName = animalGroupName.findHerd(animalName);

        //Assert
        Assert.assertEquals(expectedHerdName, actualHerdName);

    }

    @Test
    public void provide_known_animal_name_mixedcase_expect_known_herd_name(){

        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        String animalName = "giRAffE";
        String expectedHerdName = "Tower";

        // Act
        String actualHerdName = animalGroupName.findHerd(animalName);

        //Assert
        Assert.assertEquals(expectedHerdName, actualHerdName);

    }

    @Test
    public void provide_unknown_animal_name_expect_unknown_herd_name(){

        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        String animalNameEmptyString = "";
        String animalNameNotPresent = "elephants";

        String expectedHerdName = "unknown";


        // Act
        String actualHerdName = animalGroupName.findHerd(animalNameEmptyString);
        String actualHerdName2 = animalGroupName.findHerd(animalNameNotPresent);

        //Assert
        Assert.assertEquals("ERROR: Please verify the return value: ", expectedHerdName, actualHerdName);
        Assert.assertEquals("ERROR: Please verify the return value: ",expectedHerdName, actualHerdName2);


    }
}
