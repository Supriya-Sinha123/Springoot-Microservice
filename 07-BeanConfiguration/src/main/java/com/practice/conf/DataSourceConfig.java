package com.practice.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.practice.serviceImpl.HDFC;
import com.practice.serviceImpl.SBI;

@Configuration
public class DataSourceConfig {
	
	public DataSourceConfig() {
		System.out.println("DSC 0-paramConstructor");
	}

    @Bean
    @Scope("prototype")
    HDFC getHdfc() {
		   System.out.println("DSC::getHdfc is executed");
		   return new HDFC();
	   }

    @Bean
    @Scope("prototype")
    SBI getSbi() {
		   System.out.println("DSC::getSbi is executed");
		   return new SBI();
	   }
}
