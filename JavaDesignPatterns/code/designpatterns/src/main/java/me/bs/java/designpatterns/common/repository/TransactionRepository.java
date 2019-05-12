package me.bs.java.designpatterns.common.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import me.bs.java.designpatterns.common.model.TransactionRequest;

public class TransactionRepository {

	public static List<TransactionRequest> transactionList;
	public static final String[] transactionTypeArray = {"SELL", "BUY"};
	
	public static void insert(TransactionRequest transactionRequest) {
		transactionList.add(transactionRequest);
	}
	
	public static void delete(TransactionRequest transactionRequest) {
		
		if(transactionList.contains(transactionRequest)) {
			transactionList.remove(transactionRequest);
		}
	}
	
	public static List<TransactionRequest> select() {
		return transactionList;
	}
	
	public static BigDecimal selectAmountByDate() {
		
		BigDecimal amountByDate = transactionList
			.stream()
			.filter(s -> s.getCreatedDate().equals(LocalDate.now()))
			.map(TransactionRequest::getAmount)
			.reduce(BigDecimal.ZERO , BigDecimal::add)
			;
		return amountByDate;
	}
	
	public static BigDecimal selectAmountByMonth() {
		
		BigDecimal amountByMonth = transactionList
			.stream()
			.filter(s -> s.getCreatedDate().getMonth().equals(LocalDate.now().getMonth()))
			.map(TransactionRequest::getAmount)
			.reduce(BigDecimal.ZERO , BigDecimal::add)
			;
		return amountByMonth;
	}
	
	public static BigDecimal selectAmountByYear() {
		
		BigDecimal amountByYear = transactionList
			.stream()
			.filter(s -> s.getCreatedDate().getYear()==(LocalDate.now().getYear()))
			.map(TransactionRequest::getAmount)
			.reduce(BigDecimal.ZERO , BigDecimal::add)
			;
		return amountByYear;
	}
	
	public static TransactionRequest createRandomTransaction() {
		TransactionRequest transactionRequest = new TransactionRequest();
		TransactionRequest newTransactionRequest = new TransactionRequest();
		if(transactionList==null) {
			transactionList = new ArrayList<TransactionRequest>();
			newTransactionRequest.setId(1L);
		}else {
			Optional<TransactionRequest> firstRecord = transactionList.stream()
				.max(Comparator.comparing(TransactionRequest::getId));
			if(firstRecord.isPresent()) {
				newTransactionRequest.setId(firstRecord.get().getId() + 1L);
			}else {
				newTransactionRequest.setId(1L);
			}
			//transactionRequest.getId() + 1
		}
		newTransactionRequest.setProxy(UUID.randomUUID().toString());
		newTransactionRequest.setType(transactionTypeArray[new Random().nextInt(2)]);
		newTransactionRequest.setAmount(generateRandomBigDecimalFromRange(1,15));
		newTransactionRequest.setCreatedDate(LocalDate.now());
		newTransactionRequest.setUpdatedDate(LocalDate.now());
		
		return newTransactionRequest;
	}
	
	public static BigDecimal generateRandomBigDecimalFromRange(int min, int max) {
		BigDecimal minBigDecimal = new BigDecimal (min);
		BigDecimal maxBigDecimal = new BigDecimal (max);
	    BigDecimal randomBigDecimal = minBigDecimal.add(new BigDecimal(Math.random()).multiply(maxBigDecimal.subtract(minBigDecimal)));
	    return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	
}
