package com.practice.service;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

	private static final double INR_TO_USD = 88.76;
	
	public double convertInrToDollar(double amount) {
		double dollar = amount / INR_TO_USD;
		return dollar; 
	}
	
	public double convertDollarToInr(double amount) {
		double Inr = INR_TO_USD * amount;
		return Inr; 
	}
}
