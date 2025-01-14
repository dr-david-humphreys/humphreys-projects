package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" -> "Crash").
	 *
	 * The animal name should be case-insensitive so "elephant", "Elephant", and
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
	 * animalGroupName("") → "unknown"
	 * animalGroupName("walrus") → "unknown"
	 * animalGroupName("Rhino") → "Crash"
	 * animalGroupName("rhino") → "Crash"
	 * animalGroupName("elephants") → "unknown"
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

		if (animalName == null || animalName.isEmpty()) {
			return "unknown";
		}

		animalName = animalName.toLowerCase();

		return animalGroups.getOrDefault(animalName, "unknown");
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
	 * The item number should be case-insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("spaceship9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		Map<String, Double> isOnSale = new HashMap<>();
		isOnSale.put("kitchen4001", 0.20);
		isOnSale.put("garage1070", 0.15);
		isOnSale.put("livingroom", 0.10);
		isOnSale.put("kitchen6073", 0.40);
		isOnSale.put("bedroom3434", 0.60);
		isOnSale.put("bath0073", 0.15);

		if (itemNumber == null || itemNumber.isEmpty()) {
			return 0.00;
		}

		itemNumber=itemNumber.toLowerCase();

		return isOnSale.getOrDefault(itemNumber, 0.00);
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10.
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
		if (peterPaul.containsKey("Peter") && peterPaul.containsKey("Paul")) {
			int peterMoney = peterPaul.get("Peter");
			int paulMoney = peterPaul.get("Paul");

			if (peterMoney > 0 && paulMoney < 1000) {
				int transferAmount = (peterMoney / 2);
				peterPaul.put("Peter", peterMoney - transferAmount);
				peterPaul.put("Paul", paulMoney + transferAmount);
			}
		}

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
		if (peterPaul.containsKey("Peter") && peterPaul.containsKey("Paul")) {
			int peterMoney = peterPaul.get("Peter");
			int paulMoney = peterPaul.get("Paul");

			if (peterMoney >= 5000 && paulMoney >= 10000) {
				int peterContribution = peterMoney / 4;
				int paulContribution = paulMoney / 4;

				peterPaul.put("Peter", peterMoney - peterContribution);
				peterPaul.put("Paul", paulMoney - paulContribution);
				peterPaul.put("PeterPaulPartnership", peterContribution + paulContribution);
			}
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
			String firstChar = word.substring(0,1);
			String lastChar = word.substring(word.length() - 1);

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
		Map<String, Integer> result = new HashMap<>();

		for (String word : words) {
			result.put(word, result.getOrDefault(word, 0) + 1);
		}

		return result;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> result = new HashMap<>();

		for (int num : ints) {
			result.put(num, result.getOrDefault(num, 0) +1);
		}
		return result;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["apple", "banana", "apple", "carrot", "banana"]) → {"banana": true, "carrot": false, "apple": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map<String, Boolean> result = new HashMap<>();
		Map<String, Integer> count = new HashMap<>();

		for (String word : words) {
			count.put(word, count.getOrDefault(word, 0) + 1);
		}

		for (String word : words) {
			result.put(word, count.get(word) >= 2);
		}

		return result;
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
		// Create new map to consolidate inventory
		Map<String, Integer> consolidatedInventory = new HashMap<>(mainWarehouse);

		//Merge the remoteWarehouse with the mainWarehouse
		for (Map.Entry<String, Integer> entry : remoteWarehouse.entrySet()) {
			String sku = entry.getKey();
			int quantity = entry.getValue();

			// If the SKU exists in the consolidate inventory, add the quantities
			if (consolidatedInventory.containsKey(sku)) {
				int existingQuantity = consolidatedInventory.get(sku);
				consolidatedInventory.put(sku, existingQuantity + quantity);
			} else {
				// If the SKU doesn't exist, add it to the consolidate inventory
				consolidatedInventory.put(sku, quantity);
			}

		}

		return consolidatedInventory;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, its last2 count is the number of times that a subString length 2
	 * appears in the String and also as the last 2 chars of the String.
	 *
	 * We don't count the end subString, so "hixxxhi" has a last2 count of 1, but the subString may overlap a prior
	 * position by one.  For instance, "xxxx" has a count of 2: one pair at position 0, and the second at position 1.
	 * The third pair at position 2 is the end subString, which we don't count.
	 *
	 * Return a Map<String, Integer> where the keys are the Strings from the array and the values are the last2 counts.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		Map<String, Integer> last2Count = new HashMap<>();

		for (String word : words) {
			if (word.length() < 2) {
				last2Count.put(word, 0);
				continue;
			}

			String last2Chars = word.substring(word.length() - 2);
			int count = 0;

			for (int i = 0; i < word.length() - 2; i++) {
				if (word.substring(i, i+2).equals(last2Chars)) {
					count++;
				}
			}

			last2Count.put(word, count);
		}
		return last2Count;
	}

}
