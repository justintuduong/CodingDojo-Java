package com.codingdojo.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator c = new Calculator();
		Calculator c2 = new Calculator();
		
		c.setOperandOne(10.5);
		c.setOperandTwo(5.2);
		c.setOperation("+");
		c.performOperation(c.getOperandOne(), c.getOperandTwo());
		System.out.println(c.getResults());
		
		c2.setOperandOne(10.5);
		c2.setOperandTwo(5.2);
		c2.setOperation("-");
		c2.performOperation(c2.getOperandOne(), c2.getOperandTwo());
		System.out.println(c2.getResults());
	}

}
