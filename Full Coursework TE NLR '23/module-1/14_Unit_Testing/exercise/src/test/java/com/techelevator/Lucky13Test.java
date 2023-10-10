package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {

    @Test
    public void testGetLucky_ArrayWithNoOnesAndThrees_ReturnsTrue() {
        // Arrange
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {0, 2, 4};
        boolean expected = true;

        // Act
        boolean result = lucky13.getLucky(nums);

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetLucky_ArrayWithOnes_ReturnsFalse() {
        // Arrange
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {1, 2, 3};
        boolean expected = false;

        // Act
        boolean result = lucky13.getLucky(nums);

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetLucky_ArrayWithThrees_ReturnsFalse() {
        // Arrange
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {1, 2, 4};
        boolean expected = false;

        // Act
        boolean result = lucky13.getLucky(nums);

        // Assert
        Assert.assertEquals(expected, result);
    }
}
