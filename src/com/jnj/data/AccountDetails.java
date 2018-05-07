package com.jnj.data;
/**
 * This is a POJO class which holds the balance and overDraft values
 * 
 * @author Sumanth Shindgi
 *
 */
public class AccountDetails {

	private long balance;
	private long overDraftLimit;
	
	public AccountDetails(long balance) {
		this.balance= balance;
	}
	
	public AccountDetails(long balance, long overDraftLimit) {
		 this.balance= balance;
		 this.overDraftLimit = overDraftLimit;
	}
	
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getOverDraftLimit() {
		return overDraftLimit;
	}
	public void setOverDraftLimit(long overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}
	
}
