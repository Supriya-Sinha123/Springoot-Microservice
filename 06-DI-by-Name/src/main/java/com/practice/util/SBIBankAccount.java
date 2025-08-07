package com.practice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.practice.service.WithdrawAmount;

@Component
public class SBIBankAccount {

	@Autowired
	  @Qualifier("HDFC ATM")
	   private WithdrawAmount hdfcATM;

	
	  @Autowired
	  @Qualifier("SBI ATM")
	   private WithdrawAmount sbiATM;
	  
	  public void withdrawAcc(int amount, String depositeAcc) {
			hdfcATM.withdraw(amount, depositeAcc);
		}
	  public void withdrawAcc1(int amount, String depositeAcc) {
			sbiATM.withdraw(amount, depositeAcc);
		}
}
