package com.practice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.DTO.ProductDTO;
import com.practice.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="product controller", description="in this you can create,update and fetch all products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(value="/register",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@Operation(summary="register the product",
	           description="register product in database")
	public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO product) {
		ProductDTO registerProduct = productService.registerProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(registerProduct);
	}
	
//	@GetMapping(value="/{id}")
//	public ProductDTO productById(@PathVariable Long id) {
//		ProductDTO fetchProductById = productService.fetchProductById(id);
//		return fetchProductById;
//	}
	
	@PutMapping(value="/update/{id}",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product, @PathVariable Long id) {
		ProductDTO updateProduct = productService.updateProduct(product,id);
		return ResponseEntity.ok(updateProduct);
	}
	
	@GetMapping(value="/edit/{id}",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProductDTO> editProduct(@PathVariable Long id) {
		ProductDTO fetchProductById = productService.fetchProductById(id);
		if(fetchProductById.getId() == id) {
			return ResponseEntity.ok(fetchProductById);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
 
	
	@GetMapping(value="/listProduct",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<ProductDTO>> listProduct(){
		List<ProductDTO> fetchAll = productService.fetchAll();
		return ResponseEntity.ok(fetchAll);
	}
	
	@DeleteMapping(value="/delete/{id}",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable Long id) {
		Map<String,String> map =new HashMap<>();
		productService.deleteProduct(id);
		map.put("msg", "product is deleted: " +id);
		return ResponseEntity.ok(map);
	}
}
