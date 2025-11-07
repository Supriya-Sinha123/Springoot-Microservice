package com.practice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.DTO.ProductDTO;
import com.practice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value="to-gson")
	public String generateJson() throws JsonProcessingException {
		ProductDTO product = new ProductDTO(101, "Referigator", 25000.00, "Samsung", "X-X1101A",new Date());
		String convertToJson = productService.convertToGson(product);
		return convertToJson;
	}
	
	

	@GetMapping(value="to-object")
	public ProductDTO generateObject() throws JsonProcessingException {
	    String obj = "{\r\n" 
	                 +" \"id\":101,\r\n"
	                 +" \"name\":\"Referigetor\",\r\n"
	                 +" \"price\":25000.00,\r\n"
	                 +" \"brand\":\"Samsung\"\r\n"
	                 +"}";

	    ProductDTO convertToObject = productService.convertToObject(obj);
	    System.out.println("Converted Object: " + convertToObject);
	    return convertToObject;
	}

}
