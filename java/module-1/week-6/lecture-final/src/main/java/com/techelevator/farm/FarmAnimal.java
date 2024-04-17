package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;

	private boolean isAsleep;


	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}


	public void sleep(boolean isAsleep){
		this.isAsleep = isAsleep;
	}

	public abstract String eat();

	public String getName() {
		return name;
	}

	public final String getSound() {
		if(isAsleep){
			return "Zzzzz...";
		}

		return sound;
	}

}