
package com.practice.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.practice.dto.ProductDTO;
import com.practice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private final RestClient restClient;
	
	public ProductServiceImpl(RestClient restClient) {
		this.restClient = restClient;
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		ProductDTO[] body = restClient.get()
		                .uri("listProduct")
//		                .header("Accept", "application/xml") (note:if i dont want keep default header then we can go for method level header like this)
		                .retrieve()
		                .body(ProductDTO[].class);  
		List<ProductDTO> asList = Arrays.asList(body);
		return asList;
	}

	@Override
	public ProductDTO getProductById(Long id) {
		ProductDTO body = restClient.get()
		                            .uri("/edit/{id}", id)
		                            .retrieve()
		                            .body(ProductDTO.class);
		return body;
	}

	@Override
	public ProductDTO registerProduct(ProductDTO product) {
		ProductDTO body = restClient.post()
		                            .uri("/register")
		                            .body(product)
		                            .retrieve()
		                            .body(ProductDTO.class);
		return body;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO product, Long id) {
		ProductDTO body = restClient.put()
                                    .uri("/register")
                                    .body(product)
                                    .retrieve()
                                    .body(ProductDTO.class);
        return body;
	}

	@Override
	public String deleteProduct(Long id) {
		ResponseEntity<Void> bodilessEntity = restClient.delete()
		.uri("/delete/{id}", id)
		.retrieve()
		.toBodilessEntity();
		return null;
	}

}
