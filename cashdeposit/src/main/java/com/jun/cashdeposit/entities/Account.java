package com.jun.cashdeposit.entities;

import javax.persistence.Entity;

@Entity
public class Account extends AbstractEntity {
	
	private String holderName;
	private String currency;
	private Double balance;
	
	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
