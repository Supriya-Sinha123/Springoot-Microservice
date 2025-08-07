package com.practice.serviceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.practice.service.WithdrawAmount;

@Service("SBI ATM")
@Primary
public class SBIAtm implements WithdrawAmount{

	public SBIAtm() {
		System.out.println("SBI :: 0-parameterialzed constructor");
	}
	
	public void withdraw(int amount, String depositeAcc) {
		System.out.println("SBI.withdraw()");
		System.out.println("Amount is " + amount + " deposited from " + depositeAcc + " successfully");
		
	}
}
