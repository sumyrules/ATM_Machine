package com.jnj.data;
/**
 * This is a POJO class that stores the details of each Transaction in a session
 * 
 * @author Sumanth Shindgi
 *
 */
public class TransactionBean {
	private long accountNumber;
	private AccountDetails accountDetails;
	private int actualPIN;
	private int enteredPIN;
	private Operations operation;
	private long amountToWithdraw;
	

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}

	public int getActualPIN() {
		return actualPIN;
	}
	public void setActualPIN(int actualPIN) {
		this.actualPIN = actualPIN;
	}
	public int getEnteredPIN() {
		return enteredPIN;
	}
	public void setEnteredPIN(int enteredPIN) {
		this.enteredPIN = enteredPIN;
	}
	public Operations getOperation() {
		return operation;
	}
	public void setOperation(Operations operation) {
		this.operation = operation;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getAmountToWithdraw() {
		return amountToWithdraw;
	}

	public void setAmountToWithdraw(long amountToWithdraw) {
		this.amountToWithdraw = amountToWithdraw;
	}
	

}
