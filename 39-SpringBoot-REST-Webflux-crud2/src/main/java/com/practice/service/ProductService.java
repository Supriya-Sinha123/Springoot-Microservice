package com.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.practice.dto.ProductDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductService {

	WebClient webClient;

	public ProductService(WebClient webClient) {
		this.webClient = webClient;
	}
	
	public Flux<ProductDTO> getAllProduct(){
		Flux<ProductDTO> bodyToFlux = webClient.get()
		.uri("listProduct")
		.retrieve()
		.bodyToFlux(ProductDTO.class);
		return bodyToFlux;
	}
	

	public Mono<ProductDTO> getProductById(Long id){
		Mono<ProductDTO> bodyToFlux = webClient.get()
		.uri("/edit/{id}", id)
		.retrieve()
		.bodyToMono(ProductDTO.class);
		return bodyToFlux;
	}
	
	public Mono<ProductDTO> createProduct(ProductDTO product){
		Mono<ProductDTO> bodyToMono = webClient.post()
		.uri("/register")
		.bodyValue(product)
		.retrieve()
		.bodyToMono(ProductDTO.class);
		return bodyToMono;
	}
	
	public Mono<ProductDTO> updateProduct(ProductDTO product){
		Mono<ProductDTO> bodyToMono = webClient.post()
		.uri("/update")
		.bodyValue(product)
		.retrieve()
		.bodyToMono(ProductDTO.class);
		System.out.println("welcome");
		return bodyToMono;
	}
}
