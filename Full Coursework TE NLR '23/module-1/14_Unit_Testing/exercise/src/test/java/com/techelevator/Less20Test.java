package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    @Test
    public void testIsLessThanMultipleOf20_Number18_ReturnsTrue() {
        // Arrange
        Less20 less20 = new Less20();
        int n = 18;
        boolean expected = true;

        // Act
        boolean result = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIsLessThanMultipleOf20_Number19_ReturnsTrue() {
        // Arrange
        Less20 less20 = new Less20();
        int n = 19;
        boolean expected = true;

        // Act
        boolean result = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIsLessThanMultipleOf20_Number20_ReturnsFalse() {
        // Arrange
        Less20 less20 = new Less20();
        int n = 20;
        boolean expected = false;

        // Act
        boolean result = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(expected, result);
    }

}
