package com.jnj.data;

import java.util.ArrayList;
import java.util.List;
/**
 * This is a POJO class that contains the list of Transaction Beans along with the initial and total withdrawal amount
 * 
 * @author Sumanth Shindgi
 *
 */
public class SessionBean {
	
		private long atmInitialCashAmount=0;

		public void setAtmInitialCashAmount(long atmInitialCashAmount) {
			this.atmInitialCashAmount = atmInitialCashAmount;
		}

		private List<TransactionBean> listOfTransaction = new ArrayList<TransactionBean>();

		public long getAtmInitialCashAmount() {
			return atmInitialCashAmount;
		}

		public void setAtmInitialCashAmount(int atmInitialCashAmount) {
			this.atmInitialCashAmount = atmInitialCashAmount;
		}

		public List<TransactionBean> getListOfTransaction() {
			return listOfTransaction;
		}

		public void setListOfTransaction(List<TransactionBean> listOfTransaction) {
			this.listOfTransaction = listOfTransaction;
		}
}
