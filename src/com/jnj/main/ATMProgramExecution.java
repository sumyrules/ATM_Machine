package com.jnj.main;

import com.jnj.data.SessionBean;
import com.jnj.process.ATMProcessor;
/**
 * This is the main program that has to be run
 * 
 * @author Sumanth Shindgi
 *
 */
public class ATMProgramExecution {

/**
 *  This is the main method that needs to be run at the start
 *  The {@link processAndValidateInputFile} method is called
 * @param args
 */
	public static void main(String[] args) {
		ATMProcessor atmProcessor = new ATMProcessor();
		SessionBean sessionBean = new SessionBean();
		// Though the sessionBean object is not used currently, it can be used in this class in future for additional functionalities
		// as the sessionBean contains the data from the inputFile in a structured data format
		sessionBean = atmProcessor.processAndValidateInputFile();

	}

}