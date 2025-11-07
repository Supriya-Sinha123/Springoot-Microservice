package com.practice.service;

import java.util.List;

import com.practice.DTO.ProductDTO;


public interface ProductService {

	public ProductDTO registerProduct(ProductDTO product);
	public List<ProductDTO> fetchAll();
	public ProductDTO fetchProductById(Long id);
	public ProductDTO updateProduct(ProductDTO product, Long id);
	public void deleteProduct(Long id);
}
