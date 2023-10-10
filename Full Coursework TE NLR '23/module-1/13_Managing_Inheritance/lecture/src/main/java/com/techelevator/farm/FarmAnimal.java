package com.techelevator.farm;

public class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean sleep;

	public FarmAnimal(String name, String sound, boolean sleep) {
		this.name = name;
		this.sound = sound;
		this.sleep = false;
	}

	public String getName( ) {
		return name;
	}
	public String getSound( ) {
		return sound;
	}
	public boolean getSleep() {
		return sleep;
	}

}