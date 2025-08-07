package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.practice.serviceImpl.HDFC;
import com.practice.serviceImpl.SBI;
//import com.practice.util.InterestCal;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		
//		InterestCal interestCal = run.getBean(InterestCal.class);
//		interestCal.calculateIntrest(5000, 2);
//		InterestCal interestCal1 = run.getBean(InterestCal.class);
//		System.out.println(interestCal.hashCode());
//		System.out.println(interestCal1.hashCode());
		
		HDFC hdfcBean = run.getBean(HDFC.class);
		HDFC hdfcBean1 = run.getBean(HDFC.class);
		hdfcBean.calculateIntrest(100000, 2, 8);
		System.out.println("this is singleton instance: " + (hdfcBean == hdfcBean1));
		SBI sbiBean1 = run.getBean(SBI.class);
		SBI sbiBean2 = run.getBean(SBI.class);
		SBI sbiBean3 = run.getBean(SBI.class);
		sbiBean1.calculateIntrest(20000, 3, 4);
		System.out.println("this is singleton instance: " + (sbiBean1 == sbiBean3));
	}

}
