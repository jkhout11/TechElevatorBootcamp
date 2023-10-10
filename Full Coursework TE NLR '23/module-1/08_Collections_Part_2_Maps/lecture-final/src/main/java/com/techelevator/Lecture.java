package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Declaring and instantiating a Map
		     //Key   Value
		Map<String, String> nameToZip = new HashMap<>();

		// Adding an item to a Map
		nameToZip.put("Neo", "19801");
		nameToZip.put("Trinity", "19905");
		nameToZip.put("Morpheus", "19702");

		// Retrieving an item from a map using a Key
		System.out.println("Neo lives in " + nameToZip.get("Neo"));
		System.out.println("Trinity lives in " + nameToZip.get("Trinity"));
		System.out.println("Morpheus lives in " + nameToZip.get("Morpheus"));
		System.out.println();

		// Retrieving just the keys
		System.out.println("Retrieving and displaying names using for each loop");
		Set<String> keys = nameToZip.keySet(); // returns a collection of all of the keys in the Map
		for (String name : keys){
			System.out.println(name + " lives in " + nameToZip.get(name));  //name is the key defined in nameToZip
		}
		System.out.println();

		// Check to see if a key already exists
		if (nameToZip.containsKey("Neo")){
			System.out.println("Neo is in the Matrix!");
		}
		else{
			System.out.println("Key does not exists");
		}
		System.out.println();


		System.out.println("set 12345 for Key Neo");
		nameToZip.put("Neo", "12345"); //if key already exists, the value is updated, otherwise the key-value is added
		nameToZip.put("Tank", "12345");

		// Iterate through the key-value pairs in the Map
		for (Map.Entry<String, String> nameAndZip : nameToZip.entrySet()){
			System.out.println(nameAndZip.getKey() + " lives in " + nameAndZip.getValue());
		}


		// Remove an element from the Map
		nameToZip.remove("Neo");
		System.out.println("removed Neo");
		System.out.println();

		// loop through again to show Neo was removed
		for (Map.Entry<String, String> nameAndZip : nameToZip.entrySet()){
			System.out.println(nameAndZip.getKey() + " lives in " + nameAndZip.getValue());
		}
		System.out.println();



		/*
		 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
		 * number of times that String appears in the array.
		 *
		 *
		 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
		 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
		 * wordCount([]) → {}
		 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
		 *
		 */

		// Create an array of words
		String[] words = {"ba", "ba", "black", "sheep"};
		Map<String, Integer> wordMap = new HashMap<>();

		for (String word : words){
			if (!wordMap.containsKey(word)) {
				wordMap.put(word, 1);
			}else{
				wordMap.put(word, wordMap.get(word) + 1);
			}

		}


		//Print out the entries in the Map
		for (Map.Entry<String, Integer> word : wordMap.entrySet()){
			System.out.println(word.getKey() + " : " + word.getValue());
		}


		int homeTeamScore = 0;
		String favoriteMascot = null;

		if(favoriteMascot != null && favoriteMascot.length() > 2){
			System.out.println(favoriteMascot + " is not null.");
		}
		else{
			System.out.printf("is null");
		}

	}



}
