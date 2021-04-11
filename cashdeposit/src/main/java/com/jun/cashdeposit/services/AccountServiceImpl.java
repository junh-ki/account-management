package com.jun.cashdeposit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.cashdeposit.entities.Account;
import com.jun.cashdeposit.repos.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}
	
	@Override
	public Account getAccountById(Long accountId) {
		return accountRepository.findById(accountId).get();
	}
	
	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts;
	}
	
	@Override
	public List<Account> getAccountsOfUser(Long userId) {
		List<Account> accounts = accountRepository.findAccounts(userId);
		return accounts;
	}
	
}
