package com.techelevator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SameFirstLastTest {

    @Test
    public void shouldReturnFalseWhenArrayIsEmpty() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {};

        boolean result = sameFirstLast.isItTheSame(nums);

        assertEquals(false, result);
    }

    @Test
    public void shouldReturnFalseWhenFirstAndLastElementsAreDifferent() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {1, 2, 3};

        boolean result = sameFirstLast.isItTheSame(nums);

        assertEquals(false, result);
    }

    @Test
    public void shouldReturnTrueWhenFirstAndLastElementsAreEqual() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {1, 2, 3, 1};

        boolean result = sameFirstLast.isItTheSame(nums);

        assertEquals(true, result);
    }

    @Test
    public void shouldReturnTrueWhenArrayHasSingleElement() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {5};

        boolean result = sameFirstLast.isItTheSame(nums);

        assertEquals(true, result);
    }
}
