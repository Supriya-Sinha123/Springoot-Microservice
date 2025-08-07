package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.practice.util.SBIBankAccount;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		System.out.println("run .get bean method we are going to call");
		SBIBankAccount bankAccount = run.getBean(SBIBankAccount.class);
		bankAccount.account(5000, "saving Account", "SBI");
	}

}
