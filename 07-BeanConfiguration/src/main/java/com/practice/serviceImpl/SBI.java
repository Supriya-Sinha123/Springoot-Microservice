package com.practice.serviceImpl;

import com.practice.service.RBI;

public class SBI implements RBI{

	public SBI() {
		System.out.println("SBI----0-paramconstrtcor");
	}
	
	@Override
	public void calculateIntrest(int p, int t, int r) {
		double SI=(p*t*r)/100;
        System.out.println("SBI INTREST: "+ SI);

	}
}
