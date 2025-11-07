package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/order")
public class OrderController {

	@Value("${server.port}")
	private String port;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="/place")
	public String placeOrder() {
		String response = restTemplate.getForObject("http://PAYMENT-SERVICE/payment/pay", String.class);
		return "Order placed successfully_!!"+response;
	}
}
