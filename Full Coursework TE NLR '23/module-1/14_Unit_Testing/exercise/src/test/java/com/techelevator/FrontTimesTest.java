package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    @Test
    public void testGenerateString_StringChocolateAndN2_ReturnsChoCho() {
        // Arrange
        FrontTimes frontTimes = new FrontTimes();
        String str = "Chocolate";
        int n = 2;
        String expected = "ChoCho";

        // Act
        String result = frontTimes.generateString(str, n);

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGenerateString_StringChocolateAndN3_ReturnsChoChoCho() {
        // Arrange
        FrontTimes frontTimes = new FrontTimes();
        String str = "Chocolate";
        int n = 3;
        String expected = "ChoChoCho";

        // Act
        String result = frontTimes.generateString(str, n);

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGenerateString_StringAbcAndN3_ReturnsAbcAbcAbc() {
        // Arrange
        FrontTimes frontTimes = new FrontTimes();
        String str = "Abc";
        int n = 3;
        String expected = "AbcAbcAbc";

        // Act
        String result = frontTimes.generateString(str, n);

        // Assert
        Assert.assertEquals(expected, result);
    }

}
