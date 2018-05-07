package com.jnj.operations;
/**
 * This is the interface that holds the operations performed in the ATM.
 * In future, additional methods like depositCash can be added in this interface
 * 
 * @author Sumanth Shindgi
 *
 */
public interface ATMOperations {
	
	/**
	 * This method prints the balance on the Command prompt
	 * 
	 * @param balance
	 */
	public void displayBalance(long balance);
	
	/**
	 * This method performs the subtraction of the balance with the withDrawAmount and returns the updated balance
	 * 
	 * @param balance
	 * @param withdrawAmount
	 * @return updatedBalance
	 */
	public long withdrawCash(long balance, long withdrawAmount);

}
