package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/order")
public class OrderControoller {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value="/create")
	public String createOrder() {
		return "order-created ->" + restTemplate.getForObject("http://localhost:4546/payment/process", String.class);
	}
}
