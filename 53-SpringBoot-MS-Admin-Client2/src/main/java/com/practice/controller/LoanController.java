package com.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	@GetMapping(value="/msg")
	public String getWishMsg() {
		return "Welcome to loan service";
	}
}
