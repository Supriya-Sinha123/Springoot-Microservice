package com.practice.service;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.DTO.ProductDTO;

@Service
public class ProductService {

	
//    Object ---------> Gson ----->Serialization
	public String convertToGson(ProductDTO product) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(product);
		return json;
	}
	
	
//	Gson ----------> Object ------->Deserialization
	public ProductDTO convertToObject(String json) {
		Gson gson = new Gson();
		ProductDTO fromJson = gson.fromJson(json, ProductDTO.class);
		return fromJson;
	}
}
