package com.jnj.validate;

import com.jnj.data.TransactionBean;
/**
 * This class provides the validation functionalities for the ATM program
 * 
 * @author Sumanth Shindgi
 *
 */
public class Validation {
	
	/**
	 *  This method aggregates all the three different validation checks ({@link validateATMCash},
	 * {@link validateUserFunds}, {@link validateUserPIN})
	 * 
	 * @param sessionBean
	 * @param initialATMCash
	 * @param totalWithdrawalCash
	 * @return true - if all the three validation checks are true;
	 * 		   false - any of the three validation checks
	 */
	public boolean validateAll(TransactionBean sessionBean, long initialATMCash, long totalWithdrawalCash) {
		
		if (validateUserPIN(sessionBean.getActualPIN(),sessionBean.getEnteredPIN()) && validateUserFunds(sessionBean.getAccountDetails().getBalance(),
				sessionBean.getAccountDetails().getOverDraftLimit(), sessionBean.getAmountToWithdraw()) && validateATMCash(initialATMCash, totalWithdrawalCash) ){
			return true;
		}
		
		return false;	
	}
	
	/**
	 * This method checks if the ATM has enough cash to dispense before the withdrawal functionality is called
	 * 
	 * @param initialATMCash
	 * @param totalWithdrawalCash
	 * @return true - if sufficient cash in ATM is available to dispense the request cash amount; 
	 * 		   false - if requested cash amount is more than the cash in the ATM
	 */
	public boolean validateATMCash(long initialATMCash, long totalWithdrawalCash) {
		
		if (initialATMCash >= totalWithdrawalCash) {
			 return true;
		} else {
			System.out.println("ATM_ERR");
			return false;
		}
		
		

	}

	/**
	 * This method validates if the user has sufficient funds to withdraw
	 * 
	 * @param balance
	 * @param overDraftLimit
	 * @param withdrawAmount
	 * @return true - if the user has sufficient funds to withdraw;
	 * 		   false - if the user request has less funds than the sum of the balance and the overDraft amount 
	 */
	public boolean validateUserFunds(long balance, long overDraftLimit, long withdrawAmount){
		
		if((balance + overDraftLimit) >= withdrawAmount) {
			return true;
		}
		else {
			System.out.println("FUNDS_ERR");
			return false;
		}
			
	}
	
	/**
	 *  This method checks if the ATM PIN entered is correct or not
	 * @param actualPIN
	 * @param enteredPIN
	 * @return true - if the entered PIN matches the actual PIN;
	 * 		   false - if the entered PIN doesn't match
	 */
	public boolean validateUserPIN(int actualPIN, int enteredPIN){
		
		if (actualPIN == enteredPIN)
		{
			return true;
		} else {
			System.out.println("ACCOUNT_ERR");
		return false;
		}
	}
}
