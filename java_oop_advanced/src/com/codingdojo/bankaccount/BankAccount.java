package com.codingdojo.bankaccount;

import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double savings;
	private double checking;
	private static int numberOfAccounts = 0; // exists at class level
	private static double total = 0.0;
	
	public BankAccount() {
		this.accountNumber = this.generateAccountNumber();
		
		numberOfAccounts ++;
	}
	
	private String generateAccountNumber() {
		String acc = "";				// will populate with random #'s
		Random r = new Random();
		for(int i=0; i<10; i++) {
			acc += String.valueOf(r.nextInt(9));	// valueOf casts to a string
		}
		return acc;
	}
	
	public double deposit(String accountType, double amount) {
		if (accountType.equals("checking")) {
			this.checking += amount;
			total += amount;
			return this.checking;
			
		} else {
			this.savings += amount;
			total += amount;
			return this.savings;
		}
	}
	public double withdraw(String accountType, double amount) {
		if (accountType.equals("checking")) {
			if (this.checking >= amount) {
				total -= amount;
				return this.checking;
			} else {
				return this.checking;			// not enough money
			}
			
		} else {
			if (this.savings >= amount) {
				total -= amount;
				return this.savings;
			} else {
				return this.savings;			// not enough money
			}
		}
	}
	
	
	
	
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	

	public double getSavings() {
		return savings;
	}

	public double getChecking() {
		return checking;
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public static double getTotal() {
		return total;
	}


	
}
