package com.jnj.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.jnj.data.AccountDetails;
import com.jnj.data.Operations;
import com.jnj.data.TransactionBean;
import com.jnj.data.SessionBean;
import com.jnj.operations.ATMOperations;
import com.jnj.operations.ATMOperationsImpl;
import com.jnj.validate.Validation;
/**
 * This class reads, validates and processes the Input File
 * 
 * @author Sumanth Shindgi
 *
 */
public class ATMProcessor {

	private static final String DATA_SEPARATOR = " ";
	public static String LINE_SEPARATOR = System.lineSeparator();

	Validation validate = new Validation();
	long atmCashAmount = 0;
	ATMOperations atmProcessing = new ATMOperationsImpl();
	
	/**
	 * This method reads the input File, stores the data in the Transaction Bean and finally returns the Session Bean
	 * @return Session Bean
	 */

	public SessionBean processAndValidateInputFile() {
		SessionBean session = new SessionBean();
		//Providing the Input File path
		String filePath = new File("src/com/jnj/input/inputFile.txt").getAbsolutePath();
		File inputfile = new File(filePath);
		// As there could be more than one Transaction in a single Session, i.e in a Input File, we are considering the 
		// list of Transaction Beans
		List<TransactionBean> listOfTransactions = new ArrayList<TransactionBean>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputfile));
			boolean isCashAmountSet = false; //Boolean variable to check if the initial ATM cash amount is set or not
			int transactionReadCounter = 0; //counter to read the lines in a transaction
			String data = null;
			TransactionBean transactionBean = null;
			while ((data = br.readLine()) != null) { // Reading the file line by line

				// if the line separator is encountered, set the transaction read counter to zero
				if (LINE_SEPARATOR.equalsIgnoreCase(data) || data.isEmpty()) {
					transactionReadCounter = 0;
					addTransactionBean(listOfTransactions, transactionBean);
					transactionBean = null;
					continue;
				}

				// Initialize the first line of the Input File as the ATM Cash amount
				if (!isCashAmountSet && data != null) {
					atmCashAmount = Integer.parseInt(data);
					session.setAtmInitialCashAmount(atmCashAmount);
					isCashAmountSet = true;
					continue;
				}

				// Parse each line of a transaction and set the relevant information in the bean
				if (transactionReadCounter == 0) {
					transactionBean = new TransactionBean();
					setAccountInformation(data, transactionBean);
					transactionReadCounter++;
				} else if (transactionReadCounter == 1) {
					setAccountBalance(data, transactionBean);
					transactionReadCounter++;
				} else if (transactionReadCounter >= 2) {
					setOperationData(data, transactionBean);
				}
			}
			// add the last transaction bean as the line separator might not be present in the end of the file
			addTransactionBean(listOfTransactions, transactionBean);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Add the list of the Transactions to the SessionBean
		session.setListOfTransaction(listOfTransactions);

		return session;


	}
/**
 * This method adds the TransactionBean objects to the listofTransactionBeans
 * 
 * @param listOfTransaction
 * @param transactionBean
 */
	private void addTransactionBean(List<TransactionBean> listOfTransaction, TransactionBean transactionBean) {
		if (transactionBean != null) {
			listOfTransaction.add(transactionBean);
		}
	}
/**
 * This method identifies the Operation requested and performs validation based on the Operation selected
 * 
 * @param data
 * @param transactionBean
 */
	private void setOperationData(String data, TransactionBean transactionBean) {
		String[] dataArray = data.split(DATA_SEPARATOR);
		Operations operation = Operations.getOperation(dataArray[0]);
		transactionBean.setOperation(operation);
		long amountToWithdraw = 0; 
		long totalWithdrawalAmount =0; //calculates the total Withdrawal amount in a session - Useful for validating the ATM Cash
		long balance = transactionBean.getAccountDetails().getBalance();
		if (operation == null) {
			// Only B or W are allowed in the InputFile
			throw new IllegalArgumentException(
					"Only Withdrawal and Balance check are supported Expected values are B or W");
		} 
		// If B is the requested Operation, validate the PIN and print the balance
		if(operation == Operations.BALANCE_ENQUIRY){
			if(validate.validateUserPIN(transactionBean.getActualPIN(), transactionBean.getEnteredPIN())) {
				atmProcessing.displayBalance(balance);
			}
		// If W is chosen, then, validate the PIN, ATM Cash, Funds Cash and then print the balance
		} else if (operation == Operations.CASH_WITHDRAWAL) {
			amountToWithdraw = Long.parseLong(dataArray[1]);
			totalWithdrawalAmount = totalWithdrawalAmount + amountToWithdraw;
			transactionBean.setAmountToWithdraw(amountToWithdraw);
			if(validate.validateAll(transactionBean, atmCashAmount, totalWithdrawalAmount)) {
				long updatedBalance = atmProcessing.withdrawCash(balance,amountToWithdraw);
				atmCashAmount = atmCashAmount - amountToWithdraw; //
				AccountDetails accountDetails = new AccountDetails(updatedBalance);
				transactionBean.setAccountDetails(accountDetails);
			}
		} 
	}
/**
 * This method sets the Account BalanceDetails - Balance and OverDraft
 * 
 * @param data
 * @param transactionBean
 */
	private void setAccountBalance(String data, TransactionBean transactionBean) {
		String[] dataArray = data.split(DATA_SEPARATOR);
		long balance = Long.parseLong(dataArray[0]);
		long overDraft = Long.parseLong(dataArray[1]);
		AccountDetails accountDetails = new AccountDetails(balance, overDraft);
		transactionBean.setAccountDetails(accountDetails);
	}
/**
 * This method sets the AccountDetails
 * 
 * @param data
 * @param transactionBean
 */
	private void setAccountInformation(String data, TransactionBean transactionBean) {
		String[] dataArray = data.split(DATA_SEPARATOR);
		long accountNumber = Long.parseLong(dataArray[0]);
		transactionBean.setAccountNumber(accountNumber);
		int actualPIN = Integer.parseInt(dataArray[1]);
		transactionBean.setActualPIN(actualPIN);
		int enteredPIN = Integer.parseInt(dataArray[2]);
		transactionBean.setEnteredPIN(enteredPIN);
	}

}
