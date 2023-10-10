package com.techelevator;

import java.util.*;

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
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		names.add("Sam");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(2, "Neo");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(2);

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		boolean isInList = names.contains("Samwise");
		boolean isInList2 = names.contains("Sam");
		System.out.println("Samwise is in the list of names " + isInList); // not in list example
		System.out.println(names.contains("Sam is in the list of names " + isInList)); // in list example


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfGandalf = names.indexOf("Gandalf");
		System.out.println("Gandalf is located at index: " + indexOfGandalf);
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] namesArray = names.toArray(new String[0]);



			System.out.println("####################");
			System.out.println("Lists can be sorted");
			System.out.println("####################");


			System.out.println("####################");
			System.out.println("Lists can be reversed too");
			System.out.println("####################");


			System.out.println("####################");
			System.out.println("       FOREACH");
			System.out.println("####################");
			System.out.println();


			StringBuilder sb = new StringBuilder();
			sb.append("Hello");
			sb.append(" ");
			sb.append("World");
			String result = sb.toString(); // "Hello World"


			//---------------------QUEUES - CREATION AND FOREACH LOOP-------------------
			System.out.println("####################");
			System.out.println("       QUEUES");
			System.out.println("####################");
			System.out.println();


			//---------------------STACKS - CREATION AND FOREACH LOOP-------------------
			System.out.println("####################");
			System.out.println("       STACKS");
			System.out.println("####################");
			System.out.println();


		}
	}}