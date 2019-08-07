package com.objectmaster.human;

public class Samurai extends Human {
	
	static int totalSamurai = 0;
	int health = 200;
	
	public Samurai() {
		totalSamurai += 1;
	}
	
	public void deathBlow(Human human) {
		human.health = 0;
		this.health = this.health/2;
		System.out.println("You've killed the other player and your health has been reduced by half. Health: " + this.health + " Opponent's health: " + human.health);
	}
	public void meditate() {
		this.health += (this.health /2);
		System.out.println("You've meditated, health: " + this.health);
	}
	public void howMany() {
		System.out.println("There are " + Samurai.totalSamurai + "Samurai's");
	}
	
	

}
