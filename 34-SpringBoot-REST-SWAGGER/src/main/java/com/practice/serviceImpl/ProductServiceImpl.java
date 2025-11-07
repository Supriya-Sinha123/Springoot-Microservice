package com.practice.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.DTO.ProductDTO;
import com.practice.entity.ProductEntity;
import com.practice.repository.ProductRepository;
import com.practice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public ProductDTO registerProduct(ProductDTO product) {
		ProductEntity productEntity=new ProductEntity();
		BeanUtils.copyProperties( product, productEntity);
		ProductEntity save = productRepo.save(productEntity);
		BeanUtils.copyProperties( save, product);
		return product;
	}

	@Override
	public List<ProductDTO> fetchAll() {
		List<ProductDTO> products = new ArrayList<>();
		List<ProductEntity> all = productRepo.findAll();
		all.forEach(data -> {
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(data, dto);
			products.add(dto);
		});
		return products;
	}

	@Override
	public ProductDTO fetchProductById(Long id) {
		ProductDTO dto = new ProductDTO();
		Optional<ProductEntity> byId = productRepo.findById(id);
		if(byId.isPresent()) {
			BeanUtils.copyProperties(byId.get(), dto);
		}
		return dto;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO product,Long id) {
		// find existing product
	    ProductEntity existing = productRepo.findById(id)
	        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	    // copy fields from DTO → entity, but exclude id
	    BeanUtils.copyProperties(product, existing, "id");
	 // save back
	    ProductEntity updated = productRepo.save(existing);
	 // return updated DTO
	    ProductDTO response = new ProductDTO();
	    BeanUtils.copyProperties(updated, response);
	    return response;
	    
		
		
//		ProductEntity productEntity = new ProductEntity();
//		BeanUtils.copyProperties(product, productEntity);
//		ProductEntity update = productRepo.save(productEntity);
//		BeanUtils.copyProperties(update, product);
//		return product;
	}
	

	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
		
	}

}
