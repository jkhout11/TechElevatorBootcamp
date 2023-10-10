package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    @Test
    public void testGetATable_Stylishness5And10_Returns2() {
        // Arrange
        DateFashion dateFashion = new DateFashion();
        int you = 5;
        int date = 10;
        int expected = 2;

        // Act
        int result = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetATable_Stylishness5And2_Returns0() {
        // Arrange
        DateFashion dateFashion = new DateFashion();
        int you = 5;
        int date = 2;
        int expected = 0;

        // Act
        int result = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetATable_Stylishness5And5_Returns1() {
        // Arrange
        DateFashion dateFashion = new DateFashion();
        int you = 5;
        int date = 5;
        int expected = 1;

        // Act
        int result = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(expected, result);
    }

}
