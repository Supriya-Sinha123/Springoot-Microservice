package com.practice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.service.HDFCAtm;
//import com.practice.service.SBIAtm;

@Component
public class SBIBankAccount {

	//field injection
//	@Autowired
	private HDFCAtm hdfcATM;
//	@Autowired
//	private SBIAtm sbiATM;
	
	
	public SBIBankAccount() {
		System.out.println("SBIBankAccount :: 0-paramerailzed constructor");
	}
	
	//constructor injection
//	public SBIBankAccount(HDFCAtm hdfcATM, SBIAtm sbiATM) {
//		System.out.println("SBIBankAccount :: parameterailzed constructor");
//		this.hdfcATM = hdfcATM;
//		this.sbiATM = sbiATM;
//	

	//setter inject
	@Autowired
	public void setHDFCAtm(HDFCAtm hdfcAtm) {
		this.hdfcATM=hdfcAtm;
	}
	
	public void account(int amount,String depositeAcc, String atm) {
		System.out.println("SBIBankAccount.account()");
		if(atm.equalsIgnoreCase("HDFC")) {
//			sbiATM.withdraw(amount, depositeAcc);
//		}else {
			hdfcATM.withdraw(amount, depositeAcc);
		}else {
			System.out.println("Account not found");
		}
		
	}
	
	
	
}
