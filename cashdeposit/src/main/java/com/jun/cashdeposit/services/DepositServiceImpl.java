package com.jun.cashdeposit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.cashdeposit.dto.DepositRequest;
import com.jun.cashdeposit.entities.Account;
import com.jun.cashdeposit.entities.Deposit;
import com.jun.cashdeposit.repos.AccountRepository;
import com.jun.cashdeposit.repos.DepositRepository;

@Service
public class DepositServiceImpl implements DepositService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private DepositRepository depositRepository;
	
	@Override
	public Deposit depositCash(DepositRequest request) {
		Long accountId = request.getAccountId();
		
		//TODO: REST Controller for findAccount and updateAccount 
		// or updateAccount?
		// account.setBalance();
		Account account = accountRepository.findById(accountId).get();
		Double amount = request.getAmount();
		
		Deposit deposit = new Deposit();
		deposit.setAccountId(accountId);
		deposit.setAmount(amount);
		
		return depositRepository.save(deposit);
	}

}
