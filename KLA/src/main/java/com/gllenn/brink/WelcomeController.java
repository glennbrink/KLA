package com.gllenn.brink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public String getCaluculate(Model model){
		
		model.addAttribute("expression", new Expression());
		return "calculate";
	}
	
	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public String postCaluculate(@ModelAttribute Expression expression){
		System.out.println("Expression POST: " + expression.getNumber());
		
		try{
			String value = MathUtil.CalculateExpression(expression);
			
			expression.setNumber(value);
		}catch(Exception e){
			expression.setNumber("Error");
		}
		
		return "calculate";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String showLoginPage(@ModelAttribute Expression expression) {
		System.out.println("Expression: " + expression.getNumber());
		
		return "calculate";
	}

}
