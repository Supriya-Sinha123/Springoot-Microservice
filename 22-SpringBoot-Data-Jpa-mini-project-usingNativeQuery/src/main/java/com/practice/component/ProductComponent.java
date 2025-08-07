package com.practice.component;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.entity.ProductEntity;
import com.practice.service.ProductService;

@Component
public class ProductComponent {

	@Autowired
	private ProductService productService;


//	
	public ProductEntity createProduct() {
		ProductEntity pEntity = new ProductEntity();
		pEntity.setName("POCO");
		pEntity.setModel("C-75");
		pEntity.setPrice("7699");
		pEntity.setMfd(LocalDate.now());
		pEntity.setWarranty(1);
		
		ProductEntity savedProduct = productService.saveProduct(pEntity);
		return savedProduct;
	}
	
	public ProductEntity updateProduct() {
		ProductEntity pEntity = new ProductEntity();
		pEntity.setId(2l);
		pEntity.setName("POCO-New");
		pEntity.setModel("C-75");
		pEntity.setPrice("7699");
		pEntity.setMfd(LocalDate.now());
		pEntity.setWarranty(2);
		
		ProductEntity savedProduct = productService.saveProduct(pEntity);
		return savedProduct;
	}
	
	public void deleteProduct(Long id) {
		productService.deleteProduct(id);
	}
	
	public ProductEntity fetchProductById(Long id) {
		ProductEntity fetchProductById = productService.getProductById(id);
		return fetchProductById;
	}
//	
	public List<ProductEntity> fetchAll(){
		List<ProductEntity> fetchAllProduct = productService.getAllProducts();
		return fetchAllProduct;
	}
}
