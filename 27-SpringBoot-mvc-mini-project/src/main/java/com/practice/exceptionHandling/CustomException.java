package com.practice.exceptionHandling;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public String handlingResourceNotFoundException(ResourceNotFoundException ex, Model model) {
		model.addAttribute("msg", ex.getMessage());
		return "error-404";
	}
	
	@ExceptionHandler(Exception.class)
	public String handlingGeneralException(Exception ex, Model model) {
		model.addAttribute("msg", ex.getMessage());
		return "error";
	}
}
