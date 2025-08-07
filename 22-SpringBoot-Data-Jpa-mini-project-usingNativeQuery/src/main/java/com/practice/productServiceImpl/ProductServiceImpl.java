package com.practice.productServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.practice.entity.ProductEntity;
import com.practice.repository.ProductRepository;
import com.practice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	private ProductRepository productRepository;


	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		ProductEntity save = productRepository.save(product);
		return save;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity product) {
		ProductEntity updatedProduct = productRepository.save(product);
		return updatedProduct;
	}
	
	@Override
	public ProductEntity getProductById(Long id) {
		return productRepository.getProductById(id);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteProduct(id);
	}

	
	@Override
	public List<ProductEntity> getAllProducts() {
        return productRepository.getAllProducts();
    }
	
	
}
