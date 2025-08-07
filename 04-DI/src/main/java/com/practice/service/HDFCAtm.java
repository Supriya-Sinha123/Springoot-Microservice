package com.practice.service;

import org.springframework.stereotype.Service;

@Service
public class HDFCAtm {

	
	public HDFCAtm() {
		System.out.println("HDFC Atm.........");
	}
	
	public void withdraw(int amount, String depositeAcc) {
		System.out.println("money is deposited from your account (hdfcAtm)..");
		System.out.println("Amount " + amount + " is deposited from " + depositeAcc + " successfully");
	}
}
