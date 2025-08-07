package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.practice.util.SBIBankAccount;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		SBIBankAccount bankAccount = run.getBean(SBIBankAccount.class);
		bankAccount.withdrawAcc(2000, "current Account");
	}

}
