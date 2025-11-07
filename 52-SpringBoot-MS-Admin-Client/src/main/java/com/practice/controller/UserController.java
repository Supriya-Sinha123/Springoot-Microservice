package com.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping(value="/msg")
	public String getWishMsg() {
		return "Welcome to user service";
	}
}
