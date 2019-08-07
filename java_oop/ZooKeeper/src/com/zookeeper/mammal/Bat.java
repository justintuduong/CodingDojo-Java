package com.zookeeper.mammal;

public class Bat extends Mammal {
	int energyLevel = 300;
	
	public int fly() {
		this.energyLevel -= 50;
		System.out.println("FLAP FLAP FLAP!");
		return this.energyLevel;
	}
	public int eatHuman() {
		this.energyLevel += 25;
		System.out.println("Oh well, nevermind!");
		return this.energyLevel;
	}
	public int attackTown() {
		this.energyLevel -= 100;
		System.out.println("FLAME ON!");
		return this.energyLevel;
	}

}
