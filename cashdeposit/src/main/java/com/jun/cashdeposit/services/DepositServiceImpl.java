package com.jun.cashdeposit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.cashdeposit.controllers.AccountRestController;
import com.jun.cashdeposit.dto.AccountUpdateRequest;
import com.jun.cashdeposit.dto.DepositRequest;
import com.jun.cashdeposit.entities.Account;
import com.jun.cashdeposit.entities.Deposit;
import com.jun.cashdeposit.repos.DepositRepository;

@Service
public class DepositServiceImpl implements DepositService {
	
	@Autowired
	private DepositRepository depositRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountRestController accountRestController;
	
	@Override
	public Deposit depositCash(DepositRequest request) {
		// Save deposit
		Long accountId = request.getAccountId();
		Double amount = request.getAmount();
		Deposit deposit = new Deposit();
		deposit.setAccountId(accountId);
		deposit.setAmount(amount);
		// Renew balance & Update account with the renewed balance
		Account account = accountService.getAccountById(accountId);
		Double newBalance = account.getBalance() + amount;
		AccountUpdateRequest accountUpdateRequest = new AccountUpdateRequest();
		accountUpdateRequest.setId(accountId);
		accountUpdateRequest.setBalance(newBalance);
		accountRestController.updateAccount(accountUpdateRequest);
		return depositRepository.save(deposit);
	}

}
