package com.techelevator.farm;

import java.math.BigDecimal;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public Egg layEgg() {
		System.out.println("Chicken laid an egg!");
		return new Egg("egg", new BigDecimal("1.20")); // Composition via method: A Chicken creates an Egg
	}

	@Override
	public String eat(){
		return "Eating chicken food...";
	}



}