package com.cc.CurrencyConvertor.model;

public class Currency {

	private double amount;
	private String fromcurrency;
	private String tocurrency;
	
	
	public double finalamount(double desiredamount) {
		
		return this.amount*desiredamount;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getFromcurrency() {
		return fromcurrency;
	}
	public void setFromcurrency(String fromcurrency) {
		this.fromcurrency = fromcurrency;
	}
	public String getTocurrency() {
		return tocurrency;
	}
	public void setTocurrency(String tocurrency) {
		this.tocurrency = tocurrency;
	}
	
	
	
}
