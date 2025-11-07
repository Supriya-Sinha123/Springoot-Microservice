package com.practice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.DTO.ProductDTO;
import com.practice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(value="/register")
	public ProductDTO saveProduct(@RequestBody ProductDTO product) {
		ProductDTO registerProduct = productService.registerProduct(product);
		return registerProduct;
	}
	
//	@GetMapping(value="/{id}")
//	public ProductDTO productById(@PathVariable Long id) {
//		ProductDTO fetchProductById = productService.fetchProductById(id);
//		return fetchProductById;
//	}
	
	@PutMapping(value="/update/{id}")
	public ProductDTO updateProduct(@RequestBody ProductDTO product, @PathVariable Long id) {
		ProductDTO updateProduct = productService.updateProduct(product,id);
		return updateProduct;
	}
	
	@GetMapping(value="/edit/{id}")
	public ProductDTO editProduct(@PathVariable Long id) {
		ProductDTO fetchProductById = productService.fetchProductById(id);
		return fetchProductById;
	}
 
	
	@GetMapping(value="/listProduct")
	public List<ProductDTO> listProduct(){
		List<ProductDTO> fetchAll = productService.fetchAll();
		return fetchAll;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Map<String, String> deleteProduct(@PathVariable Long id) {
		Map<String,String> map =new HashMap<>();
		productService.deleteProduct(id);
		map.put("msg", "product is deleted: " +id);
		return map;
	}
}
