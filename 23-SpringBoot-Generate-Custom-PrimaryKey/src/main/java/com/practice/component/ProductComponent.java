package com.practice.component;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.entity.ProductEntity;
import com.practice.service.ProductService;

@Component
public class ProductComponent {
	
	@Autowired
	private ProductService productService;

	public ProductComponent(ProductService productService) {
		this.productService = productService;
	}
	
	public ProductEntity createProduct() {
		ProductEntity savedProduct = null;
		for(int i=1;i<=10;i++) {
			ProductEntity entity = new ProductEntity();
			entity.setName("POCO");
			entity.setModel("C-75");
			entity.setPrice("7699");
			entity.setWarranty(1);
			entity.setMfd(LocalDate.now());
			savedProduct = productService.saveProduct(entity);
			}
		return savedProduct;
		}

	}

