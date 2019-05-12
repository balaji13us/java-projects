package me.bs.java.designpatterns.common.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import me.bs.java.designpatterns.common.model.LimitConfiguration;

public class TransactionLimitConfigRepository {

	public static List<LimitConfiguration> transactionLimitConfigurationList;
	
	public static void insert(LimitConfiguration transactionRequest) {
		transactionLimitConfigurationList.add(transactionRequest);
	}
	
	public static void delete(LimitConfiguration transactionRequest) {
		
		if(transactionLimitConfigurationList.contains(transactionRequest)) {
			transactionLimitConfigurationList.remove(transactionRequest);
		}
	}
	
	public static List<LimitConfiguration> select() {
		return transactionLimitConfigurationList;
	}
	
	public static  void createTransactionListConfigList() {
		transactionLimitConfigurationList = new ArrayList<LimitConfiguration>();
		LimitConfiguration limitConfiguration= null;
		
		limitConfiguration = new LimitConfiguration("TRANSACTIONAL",new BigDecimal(5),new BigDecimal(10));
		transactionLimitConfigurationList.add(limitConfiguration);
		

		limitConfiguration = new LimitConfiguration("DAILY",null,new BigDecimal(50));
		transactionLimitConfigurationList.add(limitConfiguration);
		
	}
	
}
