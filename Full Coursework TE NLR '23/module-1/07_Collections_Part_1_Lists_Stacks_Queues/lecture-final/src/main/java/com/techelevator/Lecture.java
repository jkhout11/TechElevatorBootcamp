package com.techelevator;

import java.util.*;
import java.util.Collections;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> names = new ArrayList<>();
		names.add("Frodo");
		names.add("Sam");
		names.add("Pippin");
		names.add("Merry");
		names.add("Gandalf");
		names.add("Aragorn");
		names.add("Boromir");
		names.add("Gimli");
		names.add("Legolas");

		List<Integer> numbers = new ArrayList<>();
		numbers.add(5);

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		for (int i = 0; i < names.size(); i++){
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		names.add("Sam2");

		for (int i = 0; i < names.size(); i++){
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(2, "Neo");

		for (int i = 0; i < names.size(); i++){
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		names.remove(2);
		for (int i = 0; i < names.size(); i++){
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		boolean isInList = names.contains("Samwise");
		boolean isInList2 = names.contains("Sam");
		System.out.println("Samwise is in the list of names: " + isInList); //not in list example
		System.out.println("Sam is in the list of names: " + isInList2); //in the list example


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		int indexOfGandalf = names.indexOf("Gandalf");
		System.out.println("Gandalf is located at index: " + indexOfGandalf);


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		String[] namesArray = names.toArray(new String[0]);
		for (int i = 0; i < namesArray.length; i++){
			System.out.println(namesArray[i]);
		}


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");
		Collections.sort(names); // Sort() modifies the original list, doesn't require assignment.
		for (int i = 0; i < names.size(); i++){
			System.out.println(names.get(i));
		}




		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");
		Collections.reverse(names); //Reverse() modifies the original list, doesn't require assignment
		for (int i = 0; i < names.size(); i++){
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		// Loop the names list again using the for-each loop.

		// for each name in names
		for (String name : names){
			// print the name
			System.out.println(name);
		}




		//Extended content not part of collections - relative to strings when a lot of string manipulation/cancentation is required.
//		StringBuilder sb = new StringBuilder();
//		sb.append("Hello");
//		sb.append(" ");
//		sb.append("World");
//		String result = sb.toString(); // "Hello World"



		//---------------------QUEUES - CREATION AND FOREACH LOOP-------------------
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		//Queue<String> customers = new LinkedList<String>();
		Queue<String> customers = new LinkedList<>(); // same as above, another way of declaring
		customers.offer("Batman");
		customers.offer("The Joker");
		customers.offer("Robin");

		//checking to see what's next for processing
		String nextCustomer = customers.peek(); // checking next element - reading it using peek
		System.out.println(nextCustomer);
		System.out.println("Remaining customers: " + customers.size());

		//Handle customer call/issue - issue complete customer is processed.
		nextCustomer = customers.poll(); // taking action on the next customer element - removing element using poll
		System.out.println(nextCustomer);
		System.out.println("Remaining customers: " + customers.size());

		//for each---
		for(String customer : customers){
			System.out.println(customer);
		}



		//---------------------STACKS - CREATION AND FOREACH LOOP-------------------
		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();
		//Stack<Integer> warehousePallets = new Stack<Integer>();
		Stack<Integer> warehousePallets = new Stack<>();
		warehousePallets.push(1010);
		warehousePallets.push(2020);
		warehousePallets.push(5130);

		Integer nextPallet = warehousePallets.peek();

		System.out.println(warehousePallets.size());

		Integer processedPallet = warehousePallets.pop();

		System.out.println(warehousePallets.size());







	}
}
