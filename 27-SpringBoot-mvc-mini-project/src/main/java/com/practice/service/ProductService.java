package com.practice.service;

import java.util.List;

import com.practice.dto.ProductDTO;

public interface ProductService {

	
	public ProductDTO registerProduct(ProductDTO product);
	public ProductDTO updateProduct(ProductDTO product);
	public ProductDTO fetchProductById(long id);
	public List<ProductDTO> fetchAllProduct();
	public void deleteProduct(long id);
}
