package com.jun.restservice.services;

import java.util.List;

import com.jun.restservice.entities.Deposit;

public interface DepositService {
	
	public Deposit findDepositById(Long id);
	public List<Deposit> getAllDeposits();
	public Deposit saveDeposit(Deposit deposit);
	
}
