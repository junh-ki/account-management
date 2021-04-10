package com.jun.cashdeposit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jun.cashdeposit.dto.AccountUpdateRequest;
import com.jun.cashdeposit.entities.Account;
import com.jun.cashdeposit.repos.AccountRepository;

@RestController
@CrossOrigin
public class AccountRestController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping("/accounts/{id}")
	public Account findAccount(@PathVariable("id") Long id) {
		return accountRepository.findById(id).get();
	}
	
	@RequestMapping("/accounts")
	public Account updateAccount(@RequestBody AccountUpdateRequest request) {
		Account account = accountRepository.findById(request.getId()).get();
		account.setBalance(request.getBalance());
		return accountRepository.save(account);
	}
	
}
