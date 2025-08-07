package com.practice.service;

import org.springframework.stereotype.Service;

@Service
public class SBIAtm {
	
	public SBIAtm() {
		System.out.println("SBI Atm.............");
	}

	public void withdraw(int amount, String depositeAcc) {
		System.out.println("money is deposited from your account (sbiAtm)..");
		System.out.println("Amount " + amount + " is deposited from " + depositeAcc + " successfully");
	}
}
