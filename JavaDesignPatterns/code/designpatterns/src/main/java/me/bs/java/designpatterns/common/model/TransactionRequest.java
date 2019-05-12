package me.bs.java.designpatterns.common.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionRequest {


	private Long id;
	private String proxy;
	private BigDecimal amount;
	private String type;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProxy() {
		return proxy;
	}
	public void setProxy(String proxy) {
		this.proxy = proxy;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "TransactionRequest [id=" + id + ", proxy=" + proxy + ", amount=" + amount + ", type=" + type
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	

	
}
