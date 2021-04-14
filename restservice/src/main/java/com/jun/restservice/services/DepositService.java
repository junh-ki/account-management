package com.jun.restservice.services;

import com.jun.restservice.entities.Deposit;

public interface DepositService {
	
	public Deposit findDepositById(Long id);
	public Deposit saveDeposit(Deposit deposit);
	
}
