package com.objectmaster.human;

public class Ninja extends Human {
	int stealth = 10;
	
	public void runAway(Human human) {
		human.health -= 10;
		System.out.println("After running away, their health is now at " + human.health);
	}
	public void steal (Human human) {
		human.health -= this.stealth;
		this.health += this.stealth;
		System.out.println("You've stolen from another player, their health is now at " + human.health);
	}
	

}
