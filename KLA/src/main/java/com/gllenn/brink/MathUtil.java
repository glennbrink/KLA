package com.gllenn.brink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathUtil {

	private static List<Character> operators = (List<Character>) Arrays.asList(new Character[]{'*','/','+','-'});
	
	public static ArrayList<Token> parseExpression(Expression expression){
		ArrayList<Token> tokens = new ArrayList<Token>();
		String number = expression.getNumber();
		
		int previous = 0;
		
		for(int i = 0; i < number.length(); i++){
			if(operators.contains(number.charAt(i))){
				Token a = new Token(number.substring(previous, i));
				
				tokens.add(a);
				tokens.add(new Token(number.charAt(i)));
				
				previous = i + 1;
			}
		}
		
		Token b = new Token(number.substring(previous));
		tokens.add(b);
		
		return tokens;
	}
	
	public static String CalculateExpression(Expression expression){
		
		ArrayList<Token> tokens = parseExpression(expression);

		//order of operations
		for(char operator : operators){
		
			//multiples of same operator
			boolean found = true;
			while(found){
				found = false;
				
				//finding the first of the operator
				for(int i = 0; i < tokens.size(); i++){
					if(!tokens.get(i).isNumeric() && tokens.get(i).isOperatorType(operator)){
						Token c = reduce(tokens.get(i-1), tokens.get(i), tokens.get(i+1));
						
						tokens.remove(i+1);
						tokens.remove(i);
						tokens.remove(i-1);
						
						tokens.add(i-1, c);
						found = true;
						break;
					}
				}
			}
		}
		
		return tokens.get(0).getNumber().toString();
	}
	
	private static Token reduce(Token a, Token op, Token b){
		
		Token c;
		switch (op.getOperator()) {
		case '*':
			c = new Token(a.getNumber().multiply(b.getNumber()));
			break;
		case '/':
			c = new Token(a.getNumber().divide(b.getNumber()));
			break;
		case '+':
			c = new Token(a.getNumber().add(b.getNumber()));
			break;
		case '-':
			c = new Token(a.getNumber().subtract(b.getNumber()));
			break;
		default:
			c = null;
			break;
		}
		
		return c;
	}
}
