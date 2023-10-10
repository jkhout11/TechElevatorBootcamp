package com.techelevator;

public class StringMethodsDemo {

    /*
     Given a string of even length, return a string made of the middle two chars, so the string "string"
     yields "ri". The string length will be at least 2.
     middlePart("string") → "ri"
     middlePart("code") → "od"
     middlePart("Practice") → "ct"
     */
    public String middlePart(String str) {
        String result;
        int len = str.length(); // get the length to use it in our substring to determine our begin and end index
        int beginIndex = len / 2 - 1;
        int endIndex = len /2 + 1;
        result = str.substring(beginIndex, endIndex);  // len/2 gives us the exact middle reference for an even string

        return result;
    }



    /*
	 Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
	 repeatX("axxbb") → true
	 repeatX("axaxax") → false
	 repeatX("xxxxx") → true
	 */
    public boolean repeatX(String str) {
        boolean result = false;
        int firstX = str.indexOf('x'); //use indexOf to provide the index of the first occurrence of x
        if(firstX < str.length() - 1){ //if x is not equal to the last character (means it's index < length() - 1
            result = str.charAt(firstX + 1) == 'x'; //set result = to the boolean expression is the character at the index of firstX + 1 is also = 'x'
        }
        return result;
    }



    /*
	 Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
	 stringParts("Helol") → "Hlo"
	 stringParts("Hi") → "H"
	 stringParts("Heeololeo") → "Hello"
	 */
    public String stringParts(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++){
            if (i % 2 == 0){
                result += str.charAt(i);
                //result = result + str.charAt(i);  //same as line above += shorthand
            }
        }

        return result;
    }


    /*
	 Suppose the string "moon" is unlucky. Given a lowercase string, return a version where all the "moon" are removed.
	 The "moon" strings will not overlap.
	 stringRemoveMoon("planetmoon") → "planet"
	 stringRemoveMoon("sunmoonplanet") → "sunplanet"
	 stringRemoveMoon("moon123pie") → "123pie"
	 */
    public String stringRemoveMoon(String str) {
        int posMoon = str.indexOf("moon");
        while (posMoon != -1){
            str = str.substring(0, posMoon) + str.substring(posMoon + 4);
            posMoon = str.indexOf("moon");
        }
        return str;
    }


    /*
	 Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the
	 middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting
	 at index i and going up to but not including index j.
	 makeOutWord("<<>>", "Yay") → "<<Yay>>"
	 makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
	 makeOutWord("[[]]", "word") → "[[word]]"
	 */
    public String makeOutWord(String out, String word) {
        String result;
        result = out.substring(0, 2) + word + out.substring(2);

        return result;
    }

}
