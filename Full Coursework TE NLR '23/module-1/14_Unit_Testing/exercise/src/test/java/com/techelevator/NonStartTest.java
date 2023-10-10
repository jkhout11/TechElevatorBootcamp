package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonStartTest {

    @Test
    public void testGetPartialString() {
        // Arrange
        NonStart nonStart = new NonStart();
        String a = "Hello";
        String b = "There";
        String expected = "ellohere";

        // Act
        String actual = nonStart.getPartialString(a, b);

        // Assert
        assertEquals(expected, actual);
    }
}
