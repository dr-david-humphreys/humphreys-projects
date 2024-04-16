package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class FarmApplication {
	public static void main(String[] args) {


		System.out.println("###############################################");
		System.out.println("            Farm Application 2.0 ");
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
		cow.sleep(false);

		Chicken chicken = new Chicken();
		chicken.sleep(false);

		Pig pig = new Pig();
		pig.sleep(false);

		Cat cat = new Cat();
		cat.sleep(false);

		//FarmAnimal farmAnimal = new FarmAnimal("PighorsecowThing", "oinknaay?????");

		Tractor tractor = new Tractor();

		System.out.println("_______________________________________________");
		System.out.println("            Old MacDonald Karaoke ");
		System.out.println("_______________________________________________");

		//List<FarmAnimal> farmAnimalList = new ArrayList<>();
		List<Singable> singableListList = new ArrayList<>();
		singableListList.add(cow);
		singableListList.add(chicken);
		singableListList.add(pig);
		singableListList.add(tractor);
		singableListList.add(cat);



		for (Singable singable : singableListList) {
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


		System.out.println();
		System.out.println("_______________________________________________");
		System.out.println("            Farmer's Market ");
		System.out.println("_______________________________________________");

		List<Sellable> sellableList = new ArrayList<>();
		//Egg egg = new Egg("Leghorn egg", new BigDecimal("1.20"));
		Egg egg = chicken.layEgg();
		sellableList.add(pig);
		sellableList.add(egg);

		for (Sellable sellable : sellableList) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}

	}
}