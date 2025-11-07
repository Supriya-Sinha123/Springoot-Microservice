package com.practice.service;

import java.util.List;

import com.practice.dto.ProductDTO;

public interface ProductService {

	public List<ProductDTO> getAllProduct();
	public ProductDTO getProductById(Long id);
	public ProductDTO registerProduct(ProductDTO product);
	public ProductDTO updateProduct(ProductDTO product, Long id);
	public String deleteProduct(Long id);
}
