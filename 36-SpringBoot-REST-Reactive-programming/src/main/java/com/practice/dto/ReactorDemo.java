package com.practice.dto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorDemo {
	
	public static void main(String[] args) {
		MsgDTO dto = new MsgDTO("welcome to reactive programming");
//		System.out.println(dto.msg());
		
		Mono<String> mono = Mono.just(dto.msg());
		mono.subscribe(System.out::println);
		
		Flux<String> flux = Flux.just("A","B","C");
		flux.subscribe(System.out::println);
		
//		transformation on java stream but non-blocking
		
		Flux<Integer> number = Flux.range(1, 10);
				               number.map(n -> n*2)
				               .filter(n -> n > 5)
				               .subscribe(data -> {
				            	   System.out.println(data);
				               });
	}
}
