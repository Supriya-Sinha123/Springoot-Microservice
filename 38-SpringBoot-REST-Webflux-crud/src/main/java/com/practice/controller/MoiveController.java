package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.MoiveDTO;
import com.practice.service.MoiveService;

import reactor.core.publisher.Flux;

@RestController
public class MoiveController {

	@Autowired
	private MoiveService service;
	
	@GetMapping(value="/allmoives")
	public Flux<String> getAllData(){
		Flux<String> allMoivesData = service.getAllMoivesData();
		return allMoivesData;
	}
}
