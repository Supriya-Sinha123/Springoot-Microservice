package com.practice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.practice.service.WithdrawAmount;

@Component
public class SBIBankAccount {

	//using Qualifier
//	@Autowired
//	@Qualifier("HDFC ATM") private WithdrawAmount withdrawAmount;
	
//	public SBIBankAccount(@Qualifier("SBI ATM") WithdrawAmount withdrawAmount) {
//		this.withdrawAmount=withdrawAmount;
//	}
	
	@Autowired
	private WithdrawAmount withdrawAmount;
	public void setWithdrawAmount(@Qualifier("SBI ATM") WithdrawAmount withdrawAmount) {
		this.withdrawAmount=withdrawAmount;
	}
	
	
	public void withdrawAcc(int amount, String depositeAcc) {
		withdrawAmount.withdraw(amount, depositeAcc);
	}
}
