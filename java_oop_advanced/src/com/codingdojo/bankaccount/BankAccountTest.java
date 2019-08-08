 package com.codingdojo.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount b1 = new BankAccount();
		BankAccount b2 = new BankAccount();
		
		System.out.println(b1.getAccountNumber());
		System.out.println(b2.getAccountNumber());
		
		
		b1.deposit("checking", 500);
		b1.deposit("savings", 10);
		
		System.out.println(b1.getChecking());
		System.out.println(b1.getSavings());
		
		System.out.println(BankAccount.getTotal());
		System.out.println(BankAccount.getNumberOfAccounts());
		
		
	}

}
