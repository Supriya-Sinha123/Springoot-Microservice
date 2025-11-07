package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/payment")
public class PaymentController {
	
	@Autowired
	private RestTemplate restTemplate;

	
	@GetMapping(value="/process")
	public String processPayment() {
		return "payment successful"  + restTemplate.getForObject("http://localhost:4547/notification/send", String.class);
	}
}
