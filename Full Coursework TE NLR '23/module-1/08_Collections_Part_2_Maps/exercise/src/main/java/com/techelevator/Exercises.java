package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		Map<String, String> animalGroups = new HashMap<>();
		animalGroups.put("rhino", "Crash");
		animalGroups.put("giraffe", "Tower");
		animalGroups.put("elephant", "Herd");
		animalGroups.put("lion", "Pride");
		animalGroups.put("crow", "Murder");
		animalGroups.put("pigeon", "Kit");
		animalGroups.put("flamingo", "Pat");
		animalGroups.put("deer", "Herd");
		animalGroups.put("dog", "Pack");
		animalGroups.put("crocodile", "Float");

		if (animalName != null) {
			String lowercaseAnimalName = animalName.toLowerCase();
			if (animalGroups.containsKey(lowercaseAnimalName)) {
				return animalGroups.get(lowercaseAnimalName);
			}
		}
		return "unknown";
	}
	/*
	 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		Map<String, Double> saleItems = new HashMap<>();
		saleItems.put("kitchen4001", 0.20);
		saleItems.put("garage1070", 0.15);
		saleItems.put("livingroom", 0.10);
		saleItems.put("kitchen6073", 0.40);
		saleItems.put("bedroom3434", 0.60);
		saleItems.put("bath0073", 0.15);

		if (itemNumber == null || itemNumber.isEmpty()) {
			return 0.00;
		}

		String lowercaseItemNumber = itemNumber.toLowerCase();
		if (saleItems.containsKey(lowercaseItemNumber)) {
			return saleItems.get(lowercaseItemNumber);
		} else {
			return 0.00;
		}
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 * robPeterToPayPaul({"Peter": 101, "Paul": 500}) → {"Peter": 51, "Paul": 550}
	 * robPeterToPayPaul({"Peter": 0, "Paul": 500}) → {"Peter": 0, "Paul": 500}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		int peterMoney = peterPaul.getOrDefault("Peter", 0);
		int paulMoney = peterPaul.getOrDefault("Paul", 0);

		if (peterMoney > 0 && paulMoney < 1000) {
			int transferAmount = peterMoney / 2;
			peterMoney -= transferAmount;
			paulMoney += transferAmount;
		}

		peterPaul.put("Peter", peterMoney);
		peterPaul.put("Paul", paulMoney);

		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		int peterMoney = peterPaul.getOrDefault("Peter", 0);
		int paulMoney = peterPaul.getOrDefault("Paul", 0);

		if (peterMoney >= 5000 && paulMoney >= 10000) {
			int peterContribution = peterMoney / 4;
			int paulContribution = paulMoney / 4;
			int partnershipContribution = peterContribution + paulContribution;

			peterMoney -= peterContribution;
			paulMoney -= paulContribution;

			peterPaul.put("Peter", peterMoney);
			peterPaul.put("Paul", paulMoney);
			peterPaul.put("PeterPaulPartnership", partnershipContribution);
		}

		return peterPaul;
	}


	/*
	 * Given an array of non-empty strings, return a Map<String, String> where, for every String in the array,
	 * there is an entry whose key is the first character of the string.
	 *
	 * The value of the entry is the last character of the String. If multiple Strings start with the same letter, then the
	 * value for that key should be the later String's last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["code", "bug", "cat"]) → {"b": "g", "c": "t"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> result = new HashMap<>();

		for (String word : words) {
			String firstChar = String.valueOf(word.charAt(0));
			String lastChar = String.valueOf(word.charAt(word.length() - 1));

			result.put(firstChar, lastChar);
		}

		return result;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> wordCountMap = new HashMap<>();

		for (String word : words) {
			if (wordCountMap.containsKey(word)) {
				int count = wordCountMap.get(word);
				wordCountMap.put(word, count + 1);
			} else {
				wordCountMap.put(word, 1);
			}
		}

		return wordCountMap;
	}
	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> integerCountMap = new HashMap<>();

		for (int num : ints) {
			if (integerCountMap.containsKey(num)) {
				int count = integerCountMap.get(num);
				integerCountMap.put(num, count + 1);
			} else {
				integerCountMap.put(num, 1);
			}
		}

		return integerCountMap;
	}


	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map<String, Boolean> wordCountMap = new HashMap<>();

		for (String word : words) {
			if (wordCountMap.containsKey(word)) {
				wordCountMap.put(word, true);
			} else {
				wordCountMap.put(word, false);
			}
		}

		return wordCountMap;
	}
	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
													 Map<String, Integer> remoteWarehouse) {
		Map<String, Integer> consolidatedInventory = new HashMap<>(mainWarehouse);

		for (Map.Entry<String, Integer> entry : remoteWarehouse.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();

			consolidatedInventory.merge(key, value, Integer::sum);
		}

		return consolidatedInventory;
	}


	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		Map<String, Integer> last2CountMap = new HashMap<>();

		for (String word : words) {
			if (word.length() < 2) {
				last2CountMap.put(word, 0);
			} else {
				String last2 = word.substring(word.length() - 2);
				int count = 0;

				for (int i = 0; i < word.length() - 2; i++) {
					if (word.substring(i, i + 2).equals(last2)) {
						count++;
					}
				}

				last2CountMap.put(word, count);
			}
		}

		return last2CountMap;
	}


}
