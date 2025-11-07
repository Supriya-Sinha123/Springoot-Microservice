package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loan")
public class LoanController {

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to loan service";
	}
	
	@GetMapping("/interest-rate-home-loan")
	public String homeloan() {
		return "current intrest rate is 8.0";
	}
	@GetMapping("/interest-rate-personal-loan")
	public String personalloan() {
		return "current intrest rate is 10.75";
	}
}
