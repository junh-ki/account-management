package com.jun.cashdeposit.dto;

import com.jun.cashdeposit.entities.Account;

public class DepositRequest {

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
