package com.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.practice.dto.MoiveDTO;

import reactor.core.publisher.Flux;

@Service
public class MoiveService {

	WebClient webClient;

	public MoiveService(WebClient webClient) {
		this.webClient = webClient;
	}
	
	//fetch all moives
	public Flux<String> getAllMoivesData(){
		Flux<String> bodyToFlux = webClient.get()
		.uri("/movies")
		.retrieve()
		.bodyToFlux(String.class);
		
		return bodyToFlux;
	}
	
}
