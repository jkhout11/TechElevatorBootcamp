package com.techelevator;

public class Lecture {

    //Loops and Arrays Exercises

    /**
  Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle
  elements.
  middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
  middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
  middleWay([5, 2, 9], [1, 4, 5]) → [2, 4]
  */
    public int[] middleWay(int[] a, int[] b)
    {
        int middleArry[] = new int[] { a[1], b[1] };
        //return new int[] { a[1], b[1] };
        return middleArry;
    }


    //String Exercises
    /**
	 Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
	 string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
	 yields the empty string "". Note that str.length() returns the length of a string.
	 firstTwo("Hello") → "He"
	 firstTwo("abcdefg") → "ab"
	 firstTwo("ab") → "ab"
	 */
    public String firstTwo(String str) {
        if (str.length() < 2) {
            return str;
        }
        return str.substring(0, 2);
    }



}
