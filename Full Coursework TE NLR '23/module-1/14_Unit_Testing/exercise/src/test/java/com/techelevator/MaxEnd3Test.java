package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    @Test
    public void testMakeArray_FirstElementIsLarger_ReturnsArrayWithAllElementsAsFirstElement() {
        // Arrange
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {1, 2, 3};
        int[] expected = {3, 3, 3};

        // Act
        int[] result = maxEnd3.makeArray(nums);

        // Assert
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testMakeArray_LastElementIsLarger_ReturnsArrayWithAllElementsAsLastElement() {
        // Arrange
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {11, 5, 9};
        int[] expected = {11, 11, 11};

        // Act
        int[] result = maxEnd3.makeArray(nums);

        // Assert
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testMakeArray_FirstAndLastElementsAreEqual_ReturnsArrayWithAllElementsAsEqual() {
        // Arrange
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {2, 11, 3};
        int[] expected = {3, 3, 3};

        // Act
        int[] result = maxEnd3.makeArray(nums);

        // Assert
        Assert.assertArrayEquals(expected, result);
    }
}
