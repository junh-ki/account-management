package com.jun.cashdeposit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.cashdeposit.entities.Account;
import com.jun.cashdeposit.repos.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}
	
	@Override
	public List<Account> getAccountsOfUser(Long userId) {
		// TODO: query for this should be defined in a AccountRepository method
		return null;
	}
	
}