package me.bs.java.designpatterns.common.limit;

import java.math.BigDecimal;

import me.bs.java.designpatterns.common.contants.Constants;
import me.bs.java.designpatterns.common.exception.ValidationException;
import me.bs.java.designpatterns.common.model.LimitConfiguration;

public class TransactionalLimitCalculation implements LimitCalculation {

	@Override
	public boolean validateLimit(BigDecimal amount, LimitConfiguration limitConfiguration) throws ValidationException {
		boolean result=false;
		if(amount==null) {
			throw new ValidationException("amount is Null");
		}
		if (limitConfiguration==null) {
			throw new ValidationException("limitConfiguration is Null");
		}
		if(limitConfiguration.getType().equalsIgnoreCase(Constants.TRANSACTIONAL_LIMIT)) {
			/*
			System.out.println(
					"limitConfiguration.getLimitMaxValue=" + limitConfiguration.getLimitMaxValue()
					+ " amount=" + amount
					+ " limitConfiguration.getLimitMaxValue().compareTo(amount)="
					+ limitConfiguration.getLimitMaxValue().compareTo(amount));
			*/
			if(limitConfiguration.getLimitMaxValue().compareTo(amount)>0 
					&& limitConfiguration.getLimitMinValue().compareTo(amount)<0)
			{
				result= true;
			}
		}
		else{
			throw new ValidationException("INVALID LIMIT CONFIGURATION TYPE FOR TRANSACTIONAL LIMIT");
		}
		
		System.out.println(
		"LimitType=" + limitConfiguration.getType()
		+ " limitMinValue=" + limitConfiguration.getLimitMinValue()
		+ " limitMaxValue=" + limitConfiguration.getLimitMaxValue()
		+ " amount=" + amount
		+ " result="
		+ result);
		return result;
	}

	@Override
	public BigDecimal getAggregateTransactions(BigDecimal amount, LimitConfiguration limitConfiguration) throws ValidationException {
		// TODO Auto-generated method stub
		return amount;
	}

}
