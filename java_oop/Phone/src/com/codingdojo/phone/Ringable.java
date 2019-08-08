package com.codingdojo.phone;

public interface Ringable {
	
	static String ring() {
		return "ring from ringable";
	}
	
	static String unlock() {
		return "unlock from ringable";
	}
}
