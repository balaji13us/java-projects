package me.bs.java.designpatterns.common.limit;

import java.math.BigDecimal;

import me.bs.java.designpatterns.common.exception.ValidationException;
import me.bs.java.designpatterns.common.model.LimitConfiguration;

public interface LimitCalculation {


	public boolean validateLimit(BigDecimal amount, LimitConfiguration limitConfiguration) throws ValidationException;
	public BigDecimal getAggregateTransactions(BigDecimal amount, LimitConfiguration limitConfiguration) throws ValidationException;
}
