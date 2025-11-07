package com.practice.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

//	@GetMapping(value="/hello")
//	public Mono<String> hello(){
//		return Mono.just("hello reactive world");
//	}
	
	
	@GetMapping(value="/hello")
	public Mono<List<Employee>> hello(){
		Employee emp = new Employee("Supriya", 9876584, "Hyderabad");
		Employee emp1 = new Employee("Raga", 9876524, "UK");
		List<Employee> list = new ArrayList<>();
		list.add(emp);
		list.add(emp1);
		return Mono.just(list);
	}
	
	
	@GetMapping(value="/flux")
	public Flux<Integer> numbers(){
		return Flux.range(1, 10).delayElements(Duration.ofSeconds(1));
	}
}
