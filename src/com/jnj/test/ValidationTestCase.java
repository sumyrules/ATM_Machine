package com.jnj.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jnj.validate.Validation;
/**
 * This class contains the test cases for the Validation Class with positive and negative scenarios
 * 
 * @author Sumanth Shindgi
 *
 */
class ValidationTestCase {
	
	Validation validate = new Validation();
	@Test
	void validateATMCashTest_Positive() {

		boolean result = validate.validateATMCash(1000, 900);
		assertEquals(true, result);
	}
	
	@Test
	void validateATMCashTest_Negative() {

		boolean result = validate.validateATMCash(700, 800);
		assertEquals(false, result);
	}
	
	@Test
	void validateUserFunds_Positive() {

		boolean result = validate.validateUserFunds(1000, 100, 600);
		assertEquals(true, result);
	}
	
	@Test
	void validateUserFunds_Negative() {
		
		boolean result = validate.validateUserFunds(400, 0, 700);
		assertEquals(false, result);
	}
	
	@Test
	void validateUserPIN_Positive() {
		boolean result = validate.validateUserPIN(5543, 5543);
		assertEquals(true, result);
	}
	
	@Test
	void validateUserPIN_Negative() {
		boolean result = validate.validateUserPIN(1234, 4321);
		assertEquals(false, result);
	}
	

}
