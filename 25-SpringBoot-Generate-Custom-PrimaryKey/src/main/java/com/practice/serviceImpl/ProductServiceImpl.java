package com.practice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.ProductEntity;
import com.practice.repository.ProductRepository;
import com.practice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}



	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		ProductEntity savedProduct = productRepository. save(product);
		return savedProduct;
	}

}
