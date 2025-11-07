package com.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestHostingConfig {

	@Bean
	public RestClient restClient() {
		return RestClient.builder()
				.baseUrl("http://localhost:4545/")
				.defaultHeader("Accept", "application/xml")
				.build();
	}
}
