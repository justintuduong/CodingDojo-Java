package com.codingdojo.calculator;

public class Calculator {
	// constructors
	double operandOne;
	double operandTwo;
	double result;
	String operation;


	public double performOperation(double operandOne, double operandTwo) {
		if (this.operation.equals("+")){
			this.result = operandOne + operandTwo;
			return this.result;
		} else if (this.operation.equals("-")) {
			this.result = operandOne - operandTwo;
			return this.result;
		} else {							// will error out if not "+" or "-"
			this.result = 000.00;
			return this.result;
		}		
	}


	//	------------------------------------------------------------------------------------------
	//	getters
	//	------------------------------------------------------------------------------------------

	public double getOperandOne() {
		return operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}
	public String getOperation() {
		return operation;
	}
	public double getResults() {
		return this.result;
	}

	//	------------------------------------------------------------------------------------------
	//	setters
	//	------------------------------------------------------------------------------------------

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

}
