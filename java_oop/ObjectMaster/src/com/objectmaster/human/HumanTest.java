package com.objectmaster.human;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human Shawn = new Human();
		Human Devon = new Human();
		
//		----------------------------------------------------
//		Object Master p1
//		----------------------------------------------------
//		Shawn.attack(Devon);
//		Shawn.attack(Devon);
//		Shawn.attack(Devon);
//		Shawn.attack(Devon);
//		Shawn.attack(Devon);
	
//		----------------------------------------------------
//		Object Master p2
//		----------------------------------------------------
		
		Wizard Alex = new Wizard();
		Samurai Kaysee = new Samurai();
		Samurai Jack = new Samurai();
		Ninja Cameron = new Ninja();
		
		Alex.fireball(Kaysee);
		Alex.heal(Jack);
		Kaysee.deathBlow(Jack);
		Kaysee.meditate();
		Cameron.steal(Jack);
		Cameron.runAway(Alex);
		
		
	}

}
