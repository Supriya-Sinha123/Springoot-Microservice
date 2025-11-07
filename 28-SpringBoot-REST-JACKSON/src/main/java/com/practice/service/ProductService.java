package com.practice.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.DTO.ProductDTO;

@Service
public class ProductService {

	
//	java to json -------------------> serialization
	
	public String convertToJson(ProductDTO product) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(product);
		return json;
	}
	
//	json to java -------------------> de-serialization
	
	public ProductDTO convertToObject(String json) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ProductDTO product = mapper.readValue(json, ProductDTO.class);
		return product;
	}
}
