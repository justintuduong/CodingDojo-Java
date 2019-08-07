package com.zookeeper.mammal;

public class Gorilla extends Mammal {
	
	
	public int eatBanana() {
		this.energyLevel+= 10;
		System.out.println("Gorilla has eaten a banana!");
		return this.displayEnergy();
	}
	
	public int climb() {
		this.energyLevel-= 10;
		System.out.println("Gorilla climbed the Empire State Building!");
		return this.displayEnergy();
	}
	
	public int throwSomething(){
		this.energyLevel -= 5;
		System.out.println("Gorilla has thrown a boat!");
		return this.energyLevel;
	}
}
