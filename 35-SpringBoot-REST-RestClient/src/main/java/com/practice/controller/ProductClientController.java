package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.ProductDTO;
import com.practice.service.ProductService;

@RestController
public class ProductClientController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/fetchProduct")
	public ResponseEntity<List<ProductDTO>> getAllProduct(){
		List<ProductDTO> allProduct = productService.getAllProduct();
		System.out.println(allProduct);
		return ResponseEntity.ok(allProduct);
	}
	
	@GetMapping(value="/getProduct/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
		ProductDTO productById = productService.getProductById(id);
		System.out.println(productById);
		return ResponseEntity.ok(productById);
	}
	
	@PostMapping(value="/registerProduct")
	public ResponseEntity<ProductDTO> registerProduct(@RequestBody ProductDTO product){
		ProductDTO registerProduct = productService.registerProduct(product);
		System.out.println(registerProduct);
		return ResponseEntity.ok(registerProduct);
	}
	
	@PutMapping(value="/updateProduct/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product, @PathVariable Long id){
		ProductDTO updateProduct = productService.updateProduct(product, id);
		System.out.println(updateProduct);
		return ResponseEntity.ok(updateProduct);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		String deleteProduct = productService.deleteProduct(id);
		return ResponseEntity.ok(deleteProduct);
	}
}
