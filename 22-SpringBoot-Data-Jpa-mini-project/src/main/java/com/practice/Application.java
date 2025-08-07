package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.practice.component.ProductComponent;
import com.practice.entity.ProductEntity;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		ProductComponent bean  = run.getBean(ProductComponent.class);
		bean.createProduct();
		
		ProductEntity updateProduct = bean.updateProduct();
		System.out.println(updateProduct);
		
		ProductEntity selectProductById = bean.selectProductById();
		System.out.println(selectProductById);
		
		bean.deleteProduct();
		
		System.out.println("===================All Data===============================");
		
		bean.fetchAllProduct().forEach(data -> {
			System.out.print(data);
		});
	}

}
