package com.objectmaster.human;

public class Human {
	public int strength = 3;
	public int stealth = 3;
	public int intelligence = 3;
	public int health = 100;
	
	public void attack(Human Human) {
		Human.health -= this.strength;
		System.out.println("You have attacked another human.");
		System.out.println("Health: " + this.health + ", Opponent's Health: " + Human.health);
		
	}
	
	
}
