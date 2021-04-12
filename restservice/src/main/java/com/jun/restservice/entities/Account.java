package com.jun.restservice.entities;

import javax.persistence.Entity;

@Entity
public class Account extends AbstractEntity {
	
	private Long holderId;
	private String currency;
	private Double balance;
	
	public Long getHolderId() {
		return holderId;
	}

	public void setHolderId(Long holderId) {
		this.holderId = holderId;
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
