package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/welcome")
public class WelcomeController {

	@GetMapping("/wish")
	public String welocome() {
		return "index";
	}
	
	@GetMapping("/greet")
	public String welocomeMsg(Model model) {
		model.addAttribute("msg", "Good morning everyone");
		return "greeting";
	}
}
