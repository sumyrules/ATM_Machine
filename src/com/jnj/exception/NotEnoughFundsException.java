package com.jnj.exception;
/**
 * This is a customized Exception Class that could be used in future.
 * 
 * (This Class is not used [as yet] in the execution of this program)
 * 
 * @author Sumanth Shindgi
 *
 */
public class NotEnoughFundsException extends Exception{

	/**
	 *  Default SerialVersionId
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor with Error Message
	 * 
	 * @param message
	 */
	public NotEnoughFundsException(String message) {
		System.out.println("FUNDS_ERR");
	}

} 