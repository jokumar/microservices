package com.sample.conversion.service.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {
	public CurrencyConversion(){
		
	}
	
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal quantity;
	private BigDecimal convertedRate;
	private String conversionRate;
	private String port;
	
	

	public CurrencyConversion(String from, String to , BigDecimal quantity,String conversionRate,String port){
		this.fromCurrency=from;
		this.toCurrency=to;
		this.quantity=quantity;
		if(quantity!=null)
		this.convertedRate=quantity.multiply(new BigDecimal(conversionRate)) ;
		this.conversionRate=conversionRate;
		this.port=port;
	}
	

	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getConvertedRate() {
		return convertedRate;
	}


	public void setConvertedRate(BigDecimal convertedRate) {
		this.convertedRate = convertedRate;
	}


	public String getConversionRate() {
		return conversionRate;
	}


	public void setConversionRate(String conversionRate) {
		this.conversionRate = conversionRate;
	}
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
}
