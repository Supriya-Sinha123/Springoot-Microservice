package com.practice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.Product;
import com.practice.service.FlipkartService;

@RestController
public class FlipkartController {
	
	private static final Logger LOG = LogManager.getLogger(FlipkartController.class);
	
	@Autowired
	private FlipkartService flipkartService;

	@PostMapping
	public String createProduct(@RequestBody Product product) {
		LOG.info("request in create product....");
		String registerProduct = flipkartService.registerProduct(product);
		LOG.info("product created successfully...");
		return "product is created successfully"+registerProduct;
	}
}
