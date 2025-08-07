package com.practice.serviceImpl;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.practice.service.WithdrawAmount;

@Service("HDFC ATM")

public class HDFCAtm implements WithdrawAmount{

	public HDFCAtm() {
		System.out.println("HDFC :: 0-parameterialzed constructor");
	}
	
	public void withdraw(int amount, String depositeAcc) {
		System.out.println("HDFC.withdraw()");
		System.out.println("Amount is " + amount + " deposited from " + depositeAcc + " successfully");
		
	}
}
