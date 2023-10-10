package com.techelevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    @Test
    public void testGetCount() {
        // Arrange
        WordCount wordCount = new WordCount();

        // Input array
        String[] words = {"ba", "ba", "black", "sheep"};

        // Expected output
        Map<String, Integer> expectedOutput = new HashMap<>();
        expectedOutput.put("ba", 2);
        expectedOutput.put("black", 1);
        expectedOutput.put("sheep", 1);

        // Act
        Map<String, Integer> actualOutput = wordCount.getCount(words);

        // Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}
