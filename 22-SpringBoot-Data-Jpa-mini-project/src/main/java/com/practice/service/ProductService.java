package com.practice.service;

import java.util.List;

import com.practice.entity.ProductEntity;

public interface ProductService {

	
	public ProductEntity saveProduct(ProductEntity product);
	
	public ProductEntity updateProduct(ProductEntity product);
	
	public void deleteProduct(Long id);
	
	public ProductEntity fetchProductById(Long id);
	
	public List<ProductEntity> fetchAllProductBy();
}
