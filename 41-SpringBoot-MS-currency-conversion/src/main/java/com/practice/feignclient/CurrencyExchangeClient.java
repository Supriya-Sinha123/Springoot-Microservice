package com.practice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="exchange-currency-service", url="http://localhost:4545")
public interface CurrencyExchangeClient {

	@GetMapping("/inr-to-dollar/{amount}")
	String getInrToDollar(@PathVariable double amount);
	
	@GetMapping("/dollar-to-inr/{amount}")
	String getDollarToInr(@PathVariable double amount);
}
