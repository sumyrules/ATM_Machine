package com.jnj.data;

/**
 * This is an ENUM that contains the two operations - Balance and Withdrawal
 * 
 * @author Sumanth Shindgi
 *
 */
public enum Operations {
	BALANCE_ENQUIRY("B"),
	CASH_WITHDRAWAL("W");
	String operation;
	private Operations(String operation) {
		this.operation = operation;
	} 
	
	public static Operations getOperation(String operation){
		if("B".equalsIgnoreCase(operation)){
			return BALANCE_ENQUIRY;
		}else if ("W".equalsIgnoreCase(operation)){
			return CASH_WITHDRAWAL;
		}else {
			return null;
		}
	}

}


