package me.bs.java.designpatterns.common.limit;

import java.math.BigDecimal;

import me.bs.java.designpatterns.common.exception.ValidationException;
import me.bs.java.designpatterns.common.model.LimitConfiguration;
import me.bs.java.designpatterns.common.repository.TransactionRepository;

public class DailyLimitCalculation implements LimitCalculation {

	@Override
	public boolean validateLimit(BigDecimal amount, LimitConfiguration limitConfiguration) throws ValidationException {
		BigDecimal dailyAggreateAmount = null;
		boolean result=false;
		if(amount==null) {
			throw new ValidationException("amount is Null");
		} else {
			dailyAggreateAmount = getAggregateTransactions(amount, limitConfiguration);
		}
		if (limitConfiguration==null) {
			throw new ValidationException("limitConfiguration is Null");
		}
		if(limitConfiguration.getType().equalsIgnoreCase("DAILY")) {

			if(limitConfiguration.getLimitMaxValue().compareTo(dailyAggreateAmount)>0)
			{
				result = true;
			}
			
		}
		else{
			throw new ValidationException("INVALID LIMIT CONFIGURATION TYPE FOR DAILY LIMIT");
		}
		System.out.println(
		"LimitType=" + limitConfiguration.getType()
		+ " limitMaxValue=" + limitConfiguration.getLimitMaxValue()
		+ " dailyAggreateAmount=" + dailyAggreateAmount
		+ " result="
		+ result);
		return result;
	}

	@Override
	public BigDecimal getAggregateTransactions(BigDecimal amount, LimitConfiguration limitConfiguration) throws ValidationException {
		return TransactionRepository.selectAmountByDate().add(amount);
	}

}
