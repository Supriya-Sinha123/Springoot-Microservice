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
//		
		ProductEntity updateProduct = bean.updateProduct();
		System.out.println(updateProduct);
		
		bean.deleteProduct(1l);
		
		ProductEntity selectProductById = bean.fetchProductById(52l);
		System.out.println(selectProductById);
		
		System.out.println("===================All Data===============================");
		
		bean.fetchAll().forEach(data -> {
			System.out.print(data);
		});
	}

}
