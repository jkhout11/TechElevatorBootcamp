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
		Chicken chicken = new Chicken();
		Pig pig = new Pig();
		Dog dog = new Dog();
		Tractor tractor = new Tractor();
		Egg egg = new Egg();

		//Inheritance
//		List<FarmAnimal> farmAnimalList = new ArrayList<>();
//		farmAnimalList.add(cow);
//		farmAnimalList.add(chicken);
//		farmAnimalList.add(pig);
//		farmAnimalList.add(dog);

		//Interface
		List<Singable> singableList = new ArrayList<>();
		singableList.add(cow);
		singableList.add(chicken);
		singableList.add(pig);
		singableList.add(dog);
		singableList.add(tractor);



		System.out.println("_______________________________________________");
		System.out.println("            Old MacDonald Karaoke ");
		System.out.println("_______________________________________________");
		// polymorphic code
		for (Singable singable : singableList) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}



		System.out.println("_______________________________________________");
		System.out.println("            Auction Item Sale ");
		System.out.println("_______________________________________________");

		List<Sellable> sellableItemList = new ArrayList<>();
		sellableItemList.add(cow);
		sellableItemList.add(pig);
		sellableItemList.add(egg);


		for (Sellable sellableItem : sellableItemList) {
			System.out.println("Step right up and get your " + sellableItem.getName());
			System.out.println("Only $" + sellableItem.getPrice());
		}

	}
}