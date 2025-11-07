package com.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class loanController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="/emi")
	public ResponseEntity<String> deductEmail(){
		String forObject = restTemplate.getForObject("htp://account-service/deduct", String.class);
		return ResponseEntity.ok("emi deducted from account service"+ forObject);
	}
}
