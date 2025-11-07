package com.practice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/payment")
public class PaymentController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping(value="pay")
	public String pay() {
		return "payment proccessed successfully by instance running on port:_"+port;
	}
}
