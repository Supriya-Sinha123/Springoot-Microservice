package com.practice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AccountController {

	private int balance=1000;
	
	@GetMapping(value="/deduct")
	public String deductEmail() {
		balance=balance-100;
		return "emi deducted for 100 and remaining balance is" + balance; 
	}
}
