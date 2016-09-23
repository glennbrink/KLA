package com.gllenn.brink;

import java.math.BigDecimal;

public class Token {

	private boolean isNumeric;
	private BigDecimal number;
	private char operator;
	
	public Token(String num){
		System.out.println("num:" + num + "!");
		number = new BigDecimal(num);
		isNumeric = true;
	}
	public Token(BigDecimal num){
		System.out.println("num:" + num + "!");
		number = num;
		isNumeric = true;
	}
	public Token(Character op){
		operator = op;
		isNumeric = false;
	}
	
	@Override
	public String toString() {
		if(isNumeric){
			return number.toPlainString();
		}else{
			return Character.toString(operator);
		}
	}
	public boolean isOperatorType(char op){
		return Character.compare(operator, op) == 0;
	}
	public boolean isNumeric() {
		return isNumeric;
	}
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		isNumeric = true;
		this.number = number;
	}
	public char getOperator() {
		return operator;
	}
	public void setOperator(char operator) {
		isNumeric = false;
		this.operator = operator;
	}
	
	
}
