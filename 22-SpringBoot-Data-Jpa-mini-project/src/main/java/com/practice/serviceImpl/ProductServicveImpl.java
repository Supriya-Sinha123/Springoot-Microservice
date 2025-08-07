package com.practice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.ProductEntity;
import com.practice.repository.ProductRepository;
import com.practice.service.ProductService;

@Service
public class ProductServicveImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	public ProductServicveImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ProductEntity saveProduct(ProductEntity product) {
		ProductEntity savedProduct = productRepository.save(product);
		return savedProduct;
	}
	
	public ProductEntity updateProduct(ProductEntity product) {
		ProductEntity updatedProduct = productRepository.save(product);
		return updatedProduct;
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	public ProductEntity fetchProductById(Long id) {
		Optional<ProductEntity> productById = productRepository.findById(id);
		return productById.get();
	}
	
	public List<ProductEntity> fetchAllProductBy(){
		List<ProductEntity> All = productRepository.findAll();
		return All;
	}
	
}
