package com.zookeeper.mammal;

public class MammalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gorilla g = new Gorilla();
		
		System.out.println(g.throwSomething());
		System.out.println(g.throwSomething());
		System.out.println(g.throwSomething());
	
		System.out.println(g.eatBanana());
		System.out.println(g.eatBanana());
		
		System.out.println(g.climb());
		
		Bat b = new Bat();
		System.out.println(b.attackTown());
		System.out.println(b.attackTown());
		System.out.println(b.attackTown());
		System.out.println(b.eatHuman());
		System.out.println(b.eatHuman());
		System.out.println(b.fly());
		System.out.println(b.fly());
	}

}
