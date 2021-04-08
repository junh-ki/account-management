package com.jun.cashdeposit.entities;

import javax.persistence.Entity;

@Entity
public class Deposit extends AbstractEntity {
	
	private Account account;
	private Double amount;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
