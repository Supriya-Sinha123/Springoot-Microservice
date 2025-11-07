package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.ProductDTO;
import com.practice.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping(value="/allProduct")
	public Flux<ProductDTO> getAllData(){
		Flux<ProductDTO> allProduct = service.getAllProduct();
		return allProduct;
	}
	
	@GetMapping(value="/product/{id}")
	public Mono<ProductDTO> getByProductId(@PathVariable("id") Long id){
		Mono<ProductDTO> byProduct = service.getProductById(id);
		return byProduct;
	}
	
	@PostMapping(value="/registerProduct")
	public Mono<ProductDTO> createProduct(@RequestBody ProductDTO product){
		Mono<ProductDTO> product2 = service.createProduct(product);
		return product2;
	}
	
	@PutMapping(value="/updateProduct")
	public Mono<ProductDTO> editProduct(@RequestBody ProductDTO product){
		Mono<ProductDTO> product2 = service.updateProduct(product);
		return product2;
	}
}
