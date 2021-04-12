package com.jun.restservice.entities;

import javax.persistence.Entity;

@Entity
public class Deposit extends AbstractEntity {
	
	private Long accountId;
	private Double amount;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
