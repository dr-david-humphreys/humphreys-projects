package com.techelevator.farm;

public class Cow extends FarmAnimal {


	public Cow() {
		super("Cow", "moo!");
	}

	@Override
	public String eat(){
		return "Eating cow food...";
	}

}