package com.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.service.ExchangeService;

@RestController
public class CurrencyExchangeController {

	private ExchangeService service;

	public CurrencyExchangeController(ExchangeService service) {
		this.service = service;
	}
	
	@GetMapping(value="/inr-to-dollar/{amount}")
	public ResponseEntity<String> convertInrToDollar(@PathVariable double amount){
		double dollar = service.convertInrToDollar(amount);
		return ResponseEntity.ok("convert INR: " +amount+ "to dollar: " +dollar);
	}
	
	@GetMapping(value="/dollar-to-inr/{amount}")
	public ResponseEntity<String> convertDollarToInr(@PathVariable double amount){
		double inr = service.convertDollarToInr(amount);
		return ResponseEntity.ok("convert DOLLAR: " +amount+ "to inr: " +inr);
	}
	
}
