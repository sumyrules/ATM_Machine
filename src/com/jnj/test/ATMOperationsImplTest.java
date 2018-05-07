package com.jnj.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jnj.operations.ATMOperations;
import com.jnj.operations.ATMOperationsImpl;
/**
 * This class contains the test case for testing the ATM operations - display and withdraw functionalities
 * 
 * @author Sumanth Shindgi
 *
 */
class ATMOperationsImplTest {
	
	ATMOperations atmOperations = new ATMOperationsImpl();

	@Test
	void withdrawCashTest() {
		long balanceResult = atmOperations.withdrawCash(1000, 90);
		assertEquals(910, balanceResult);
	}

}
