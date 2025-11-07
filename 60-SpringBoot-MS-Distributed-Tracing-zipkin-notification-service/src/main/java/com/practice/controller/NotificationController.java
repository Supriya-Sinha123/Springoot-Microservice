package com.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/notification")
public class NotificationController {

	
	@GetMapping(value="/send")
	public String processPayment() {
		return "notification got successful";
	}
}
