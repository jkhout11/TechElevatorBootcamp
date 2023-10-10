package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTests {

    @Test
    public void testGetBits() {
        // Arrange
        StringBits stringBits = new StringBits();
        String input = "Hello";
        String expectedOutput = "Hlo";

        // Act
        String result = stringBits.getBits(input);

        // Assert
        Assert.assertEquals(expectedOutput, result);
    }
}
