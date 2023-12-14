package com.jacaranda.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jacaranda.calculadora.model.Calculator;
import com.jacaranda.calculadora.model.CalculatorVatios;

@Controller
public class ControllerCalculadora {

	@GetMapping("/calculator")
	public String calculator(Model model) {
		Calculator calculator = new Calculator();
		CalculatorVatios calculatorVatios = new CalculatorVatios();
		model.addAttribute("calc", calculator);
		model.addAttribute("calcV", calculatorVatios);
		return "calculator";
	}

	@GetMapping("/resolver")
	public String resolver(@Validated Model model, @ModelAttribute("calc") Calculator calculatorUser ,BindingResult bindingResult) throws Exception {
		Calculator calculator = new Calculator();
		model.addAttribute("calc", calculator);
		CalculatorVatios calculatorVatios = new CalculatorVatios();
		model.addAttribute("calcV", calculatorVatios);
		
		if(bindingResult.hasErrors()) {
			return "calculator";
		}
		
		String result = null;
		try {
			result = calculatorUser.getResultString();			
		}catch (Exception e) {
			result=e.getMessage();
		}
		model.addAttribute("result", result);
				
		return "calculator";
	}
	@GetMapping("/resolverVatios")
	public String rsolverVatios(@Validated Model model, @ModelAttribute("calcV") CalculatorVatios calulatorVatiosUser, BindingResult bindingResult) throws Exception {
		Calculator calculator = new Calculator();
		model.addAttribute("calc", calculator);
		CalculatorVatios calculatorVatios = new CalculatorVatios();
		model.addAttribute("calcV", calculatorVatios);
		
		if(bindingResult.hasErrors()) {
			return "calculator";
		}
		
		String resultV = null;
		resultV = calulatorVatiosUser.getResult();			
		model.addAttribute("resultV", resultV);
		
		return "calculator";
	}
}

