package me.bs.java.designpatterns.common.limit;

import java.math.BigDecimal;

import me.bs.java.designpatterns.common.exception.ValidationException;
import me.bs.java.designpatterns.common.model.LimitConfiguration;

public class LimitContext {

	private LimitCalculation limitCalculation;

	public LimitContext(LimitCalculation limitCalculation) {
		super();
		this.limitCalculation = limitCalculation;
	}
	
	public boolean validateLimit(BigDecimal amount, LimitConfiguration limitConfiguration) throws ValidationException{
		return limitCalculation.validateLimit(amount, limitConfiguration);
	}
	
	
}
