package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalGroupNameTest {
    @Test
    public void provide_known_animal_name_expect_known_herd_name(){

        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        String animalName = "elephant";
        String expectedHerdName = "Herd";

        //Act
        String actualHerdName = animalGroupName.findHerd(animalName);
        //Assert
        Assert.assertEquals(expectedHerdName, actualHerdName);
    }

    @Test
    public void provide_known_animal_name_mixedcase_expect_known_herd_name(){

        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        String animalName
        //Act

        //Assert

    }

    @Test
    public void provide_unknown_animal_name_expect_unknown_herd_name(){

        //Arrange

        //Act

        //Assert

    }


}