package com.practice.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class GenerateId implements IdentifierGenerator{
	
	private static final long serialVersionUID=2341;
	
	private static final String PREFIX="product_";
	private static long counter=100l;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		return PREFIX+(counter++);
	}

}
