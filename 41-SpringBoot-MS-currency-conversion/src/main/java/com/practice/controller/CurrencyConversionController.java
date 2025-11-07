package com.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.feignclient.CurrencyExchangeClient;

@RestController
public class CurrencyConversionController {

	private CurrencyExchangeClient client;

	public CurrencyConversionController(CurrencyExchangeClient client) {
		this.client = client;
	}
	
	@GetMapping(value="/inr-to-dollar/{amount}")
	public ResponseEntity<String> convertInrToDollar(@PathVariable double amount){
		String msg = client.getInrToDollar(amount);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping(value="/dollar-to-inr/{amount}")
	public ResponseEntity<String> convertDollarToInr(@PathVariable double amount){
		String msg = client.getDollarToInr(amount);
		return ResponseEntity.ok(msg);
	}
}
