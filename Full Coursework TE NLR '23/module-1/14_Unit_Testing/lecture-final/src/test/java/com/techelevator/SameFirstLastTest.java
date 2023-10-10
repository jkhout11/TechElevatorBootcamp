package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SameFirstLastTest {

     /*
     Given an array of ints, return true if the array is length 1 or more, and the first element and
     the last element are equal.
     sameFirstLast([1, 2, 3]) → false
     sameFirstLast([1, 2, 3, 1]) → true
     sameFirstLast([1, 2, 1]) → true
     */

    @Test
    public void null_expectFalse() {
        //Arrange
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] inputArr = null;
        boolean expected = false;

        //Assert
        assertEquals(expected, sameFirstLast.isItTheSame(inputArr));
    }

    @Test
    public void arrayLength0_ExpectFalse() {
        //Arrange
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] inputArr = {};
        boolean expected = false;

        //Assert
        assertEquals(expected, sameFirstLast.isItTheSame(inputArr));
    }

    @Test
    public void arrayLength1_ExpectTrue() {
        //Arrange
        SameFirstLast exercises = new SameFirstLast();
        int[] inputArr = { 1 };
        boolean expected = true;

        //Assert
        assertEquals(expected, exercises.isItTheSame(inputArr));
    }

    @Test
    public void arrayLength2OrMore() {
        //Arrange
        SameFirstLast exercises = new SameFirstLast();
        int[] inputArr1 = { 1, 1 };
        boolean expected1 = true;

        int[] inputArr2 = { 1, 3, 1 };
        boolean expected2 = true;

        int[] inputArr3 = { 1, 3 };
        boolean expected3 = false;

        int[] inputArr4 = { 1, 3, 3 };
        boolean expected4 = false;



        //Assert
        assertEquals(expected1, exercises.isItTheSame(inputArr1));
        assertEquals(expected2, exercises.isItTheSame(inputArr2));
        assertEquals(expected3, exercises.isItTheSame(inputArr3));
        assertEquals(expected4, exercises.isItTheSame(inputArr4));

    }

}
