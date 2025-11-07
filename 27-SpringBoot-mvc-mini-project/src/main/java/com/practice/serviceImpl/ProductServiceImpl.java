package com.practice.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.ProductDTO;
import com.practice.entity.ProductEntity;
import com.practice.repository.ProductRepository;
import com.practice.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;

	
	@Override
	public ProductDTO registerProduct(ProductDTO product) {
		ProductEntity entity = new ProductEntity();
		BeanUtils.copyProperties(product, entity);
		ProductEntity save = productRepo.save(entity);
		BeanUtils.copyProperties(save, product);
		return product;
//		return registerOrUpdateProduct(product);
	}
	
//	public ProductDTO registerOrUpdateProduct(ProductDTO product) {
//		ProductEntity entity = new ProductEntity();
//		BeanUtils.copyProperties(product, entity);
//		ProductEntity save = productRepo.save(entity);
//		BeanUtils.copyProperties(save, product);
//		return product;
//	}

	@Override
	public ProductDTO updateProduct(ProductDTO product) {
		ProductEntity entity = new ProductEntity();
		BeanUtils.copyProperties(product, entity);
		ProductEntity save = productRepo.save(entity);
		BeanUtils.copyProperties(save, product);
		return product;
		//return registerOrUpdateProduct(product);
	}

	@Override
	public ProductDTO fetchProductById(long id) {
		ProductDTO dto = new ProductDTO();
		Optional<ProductEntity> product = productRepo.findById(id);
		if(product.isPresent()) {
			BeanUtils.copyProperties(product.get(), dto);
		}
		return dto;
	}

	@Override
	public List<ProductDTO> fetchAllProduct() {
		List<ProductDTO> products = new ArrayList<>();
		List<ProductEntity> allProducts = productRepo.findAll();
		allProducts.forEach(data -> {
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(data, dto);
			products.add(dto);
		});
		
		return products;
	}

	@Override
	public void deleteProduct(long id) {
		productRepo.deleteById(id);
		
	}

}
