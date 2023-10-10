package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class FarmSimulator {
	public static void main(String[] args) {
		System.out.println("###############################################");
		System.out.println("            Farm Simulator 2.0 ");
		System.out.println("###############################################");
		System.out.println(
				"                              __.----.___\n" +
						" ||            ||  (\\(__)/)-'||      ;--` ||\n" +
						"_||____________||___`(QQ)'___||______;____||_\n" +
						"-||------------||----)  (----||-----------||-\n" +
						"_||____________||___(o  o)___||______;____||_\n" +
						"-||------------||----`--'----||-----------||-\n" +
						" ||            ||       `|| ||| || ||     ||jgs\n" +
						"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println();

		Cow cow = new Cow();
		cow.sleep(true);  // make cow sleep

		Chicken chicken = new Chicken();

		Pig pig = new Pig();
		pig.sleep(true); // make pig sleep

		Dog dog = new Dog();
		System.out.println("Printing dog to the console");
		System.out.println(dog);


		Cat cat = new Cat();
		cat.sleep(true); //make cat sleep



		Tractor tractor = new Tractor();
		Egg egg = new Egg();





		List<Singable> singableList = new ArrayList<>();
		singableList.add(cow);
		singableList.add(chicken);
		singableList.add(pig);
		singableList.add(dog);
		singableList.add(cat);
		singableList.add(tractor);


		System.out.println("_______________________________________________");
		System.out.println("            Old MacDonald Karaoke ");
		System.out.println("_______________________________________________");
		// polymorphic code

		for (Singable singable : singableList) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}



		System.out.println("_______________________________________________");
		System.out.println("            Farm Item Auction ");
		System.out.println("_______________________________________________");

		List<Sellable> sellableList = new ArrayList<>();
		sellableList.add(cow);
		sellableList.add(pig);
		sellableList.add(egg);



		for (Sellable sellable : sellableList) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Bid price starting at only $" + sellable.getPrice());
		}
	}
}