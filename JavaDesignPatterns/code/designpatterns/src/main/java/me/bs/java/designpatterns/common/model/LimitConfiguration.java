package me.bs.java.designpatterns.common.model;

import java.math.BigDecimal;

public class LimitConfiguration {

	public LimitConfiguration(String type, BigDecimal limitMinValue, BigDecimal limitMaxValue) {
		super();
		this.type = type;
		this.limitMinValue = limitMinValue;
		this.limitMaxValue = limitMaxValue;
	}
	public LimitConfiguration() {
		super();
	}
	private String type;
	private BigDecimal limitMinValue;
	private BigDecimal limitMaxValue;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getLimitMinValue() {
		return limitMinValue;
	}
	public void setLimitMinValue(BigDecimal limitMinValue) {
		this.limitMinValue = limitMinValue;
	}
	public BigDecimal getLimitMaxValue() {
		return limitMaxValue;
	}
	public void setLimitMaxValue(BigDecimal limitMaxValue) {
		this.limitMaxValue = limitMaxValue;
	}
	@Override
	public String toString() {
		return "LimitConfiguration [type=" + type + ", limitMinValue=" + limitMinValue + ", limitMaxValue="
				+ limitMaxValue + "]";
	}
	
	
}
