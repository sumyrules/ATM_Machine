package com.jnj.operations;
/**
 * This class is the implementation of the interface {@link ATMOperations} that implements the displayBalance
 * and withDrawCash functionalities.
 * 
 * @author Sumanth Shindgi
 *
 */
public class ATMOperationsImpl implements ATMOperations {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void displayBalance(long balance) {
		// Prints the account Balance
		System.out.println(balance);

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public long withdrawCash(long balance, long withdrawAmount) {
		// check user has balance + overdraft equals or less than withdrawal amount 
		// process transaction
		balance = balance - withdrawAmount;
		displayBalance(balance);
		
		return balance;
	}

}
