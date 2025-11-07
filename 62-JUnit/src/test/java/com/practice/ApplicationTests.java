package com.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	
	
	static CalculatorService calService;
	
	@BeforeAll
	static void initAll() {
		
		calService = new CalculatorService();
		
		System.out.println("before All start test suint..");
	}
	
	
	@Test
	void testAdd() {
		int output = calService.add(2, 3);
		assertEquals(5, output);
	}
	
	
	@Test
	void testAdd1() {
		int output = calService.add(2, 3);
		assertNotEquals(15, output);
	}
	
	@Test
	void testSub() {
		int output = calService.sub(3, 2);
		assertEquals(1, output);
	}
	
	@Test
	void testMul() {
		int output = calService.mul(2, 3);
		assertEquals(6, output);
	}
	
	@Test
	void testDiv() {
		int output = calService.div(12, 3);
		assertEquals(4, output);
	}
	
	@Test
	void testDivException() {
		assertThrows(ArithmeticException.class, () -> calService.div(10, 0));
	}
	
	@AfterEach
	void testAfterEach() {
		System.out.println("After each method ... ");
	}
	
	@AfterAll
	static void testAfterAll() {
		System.out.println("After All method..");
	}

	@Test
	void contextLoads() {
	}

}
