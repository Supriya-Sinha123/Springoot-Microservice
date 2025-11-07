package com.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


import com.practice.dto.Product;

@Service
public class FlipkartService {
	
	private static final Logger LOG = LogManager.getLogger(FlipkartService.class);

	
	List<Product> list = new ArrayList<>();
	
	public String registerProduct(Product product) {
		Random r = new Random();
		int nextInt = r.nextInt(999);
		product.setId((long) nextInt);
		list.add(product);
		return ""+product.getId();
	}
}
