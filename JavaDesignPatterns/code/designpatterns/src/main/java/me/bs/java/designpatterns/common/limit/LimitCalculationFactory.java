package me.bs.java.designpatterns.common.limit;

import java.util.ArrayList;
import java.util.HashMap;

import me.bs.java.designpatterns.common.contants.Constants;
import me.bs.java.designpatterns.common.exception.ValidationException;

public class LimitCalculationFactory {
	
	private static HashMap<String, LimitCalculation> LimitCalculationHM;
		
	public LimitCalculation getLimitObject(String LimitType) throws ValidationException {

		if (LimitType == null) {
			throw new ValidationException("LimitType is null");
		}
		if(LimitCalculationHM==null) {
			LimitCalculationHM = new HashMap<String, LimitCalculation>();
		}
		
		if(LimitType.equalsIgnoreCase(Constants.DAILY_LIMIT)){
			if(!LimitCalculationHM.containsKey(Constants.DAILY_LIMIT)) {
				LimitCalculationHM.put(Constants.DAILY_LIMIT, new DailyLimitCalculation());
			}
			return LimitCalculationHM.get(Constants.DAILY_LIMIT);
	         
	      } else if(LimitType.equalsIgnoreCase(Constants.TRANSACTIONAL_LIMIT)){
	    	  if(!LimitCalculationHM.containsKey(Constants.TRANSACTIONAL_LIMIT)) {
					LimitCalculationHM.put(Constants.TRANSACTIONAL_LIMIT, new TransactionalLimitCalculation());
				}
				return LimitCalculationHM.get(Constants.TRANSACTIONAL_LIMIT);        
	      } else {
	    	  throw new ValidationException("LimitType is invalid");
	      }
	}

}
