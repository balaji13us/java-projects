package me.bs.java.designpatterns.behavioral.strategy;

import me.bs.java.designpatterns.common.contants.Constants;
import me.bs.java.designpatterns.common.exception.ValidationException;
import me.bs.java.designpatterns.common.limit.LimitCalculation;
import me.bs.java.designpatterns.common.limit.LimitCalculationFactory;
import me.bs.java.designpatterns.common.limit.LimitContext;
import me.bs.java.designpatterns.common.model.LimitConfiguration;
import me.bs.java.designpatterns.common.model.TransactionRequest;
import me.bs.java.designpatterns.common.repository.TransactionLimitConfigRepository;
import me.bs.java.designpatterns.common.repository.TransactionRepository;

public class LimitCalculatorStrategy {

	
	/**
	 * This Class uses following Design Patterns
	 * Factory Pattern to Create Limit Configuration Objects
	 * Flyweight pattern to restrict and reuse Limit Configuration Objects 
	 * Strategy Pattern to Switch between Limit Configuration Types
	 * 
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {

		LimitCalculationFactory limitCalculationFactory = new LimitCalculationFactory();
		TransactionLimitConfigRepository.createTransactionListConfigList();
		LimitCalculation limitCalculation = null;
		LimitContext limitContext = null;
		boolean validationResult = false;
		try {

			for (int i = 1; i <= 30; i++) {
				System.out.println("Transaction-" + i);
				
				//Generate a Random Transaction
				TransactionRequest transactionRequest = TransactionRepository.createRandomTransaction();

				for (LimitConfiguration limitConfiguration : TransactionLimitConfigRepository.select()) {
					
					//Uses Strategy Pattern to Switch the Context. 
					/*limitContext = new LimitContext(limitCalculationFactory.getLimitObject(limitConfiguration.getType()));
					validationResult = limitContext.validateLimit(transactionRequest.getAmount(), limitConfiguration);
					*/
					
					//Uses Factory Pattern & Flyweight Pattern to get the Limit Configuration Object
					limitCalculation = limitCalculationFactory.getLimitObject(limitConfiguration.getType());
					validationResult = limitCalculation.validateLimit(transactionRequest.getAmount(), limitConfiguration);
					
					if(!validationResult) {
						break;
					}
				}
				if(validationResult) {
					TransactionRepository.insert(transactionRequest);

				}

			}

		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
