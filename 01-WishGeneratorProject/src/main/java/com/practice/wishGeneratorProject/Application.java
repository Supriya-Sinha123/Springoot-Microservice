package com.practice.wishGeneratorProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.practice.wishGeneratorProject.service.PrintMsg;
import com.practice.wishGeneratorProject.service.WishGenerator;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		WishGenerator wishMsg = run.getBean(WishGenerator.class);
		PrintMsg printMsg = run.getBean(PrintMsg.class);
		
		wishMsg.wishGenerator();
		printMsg.printMsg();
	}

}
