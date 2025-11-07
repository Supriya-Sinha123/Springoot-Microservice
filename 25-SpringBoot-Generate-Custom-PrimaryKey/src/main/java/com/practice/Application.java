package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.practice.component.ProductComponent;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run =SpringApplication.run(Application.class, args);
		ProductComponent bean = run.getBean(ProductComponent.class);
		bean.createProduct();
	}

}
