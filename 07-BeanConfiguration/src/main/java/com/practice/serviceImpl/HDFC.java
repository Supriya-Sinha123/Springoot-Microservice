package com.practice.serviceImpl;

import com.practice.service.RBI;

public class HDFC implements RBI{

	public HDFC() {
		System.out.println("HDFC::0-param constrtcor");
	}
	
	@Override
	public void calculateIntrest(int p, int t, int r) {
		double SI=(p*t*r)/100;
        System.out.println("HDFC INTREST: "+ SI);

	}
}
