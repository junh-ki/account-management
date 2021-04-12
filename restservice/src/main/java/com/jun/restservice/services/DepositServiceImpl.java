package com.jun.restservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.restservice.entities.Deposit;
import com.jun.restservice.repos.DepositRepository;

@Service
public class DepositServiceImpl implements DepositService {
	
	@Autowired
	private DepositRepository depositRepository;
	
	@Override
	public Deposit saveDeposit(Deposit deposit) {
		return depositRepository.save(deposit);
	}

}
