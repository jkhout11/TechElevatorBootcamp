package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {

    private AnimalGroupName animalGroupName;

    @Before
    public void setup() {
        animalGroupName = new AnimalGroupName();
    }

    @Test
    public void testGetHerd_ValidAnimalName_ReturnsGroupName() {
        // Arrange
        String animalName = "giraffe";
        String expectedGroupName = "Tower";

        // Act
        String actualGroupName = animalGroupName.getHerd(animalName);

        // Assert
        Assert.assertEquals(expectedGroupName, actualGroupName);
    }

    @Test
    public void testGetHerd_EmptyAnimalName_ReturnsUnknown() {
        // Arrange
        String animalName = "";

        // Act
        String actualGroupName = animalGroupName.getHerd(animalName);

        // Assert
        Assert.assertEquals("unknown", actualGroupName);
    }

    @Test
    public void testGetHerd_InvalidAnimalName_ReturnsUnknown() {
        // Arrange
        String animalName = "walrus";

        // Act
        String actualGroupName = animalGroupName.getHerd(animalName);

        // Assert
        Assert.assertEquals("unknown", actualGroupName);
    }

    @Test
    public void testGetHerd_CaseInsensitiveAnimalName_ReturnsGroupName() {
        // Arrange
        String animalName = "Rhino";
        String expectedGroupName = "Crash";

        // Act
        String actualGroupName = animalGroupName.getHerd(animalName);

        // Assert
        Assert.assertEquals(expectedGroupName, actualGroupName);
    }

    @Test
    public void testGetHerd_NullAnimalName_ReturnsUnknown() {
        // Arrange
        String animalName = null;

        // Act
        String actualGroupName = animalGroupName.getHerd(animalName);

        // Assert
        Assert.assertEquals("unknown", actualGroupName);
    }
}