package com.jun.cashdeposit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jun.cashdeposit.dto.AccountUpdateRequest;
import com.jun.cashdeposit.entities.Account;
import com.jun.cashdeposit.services.AccountService;

@RestController
@CrossOrigin
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts/{id}")
	public Account findAccountById(@PathVariable("id") Long id) {
		return accountService.getAccountById(id);
	}
	
	@RequestMapping("/accounts")
	public Account updateAccount(@RequestBody AccountUpdateRequest request) {
		Account account = accountService.getAccountById(request.getId());
		account.setBalance(request.getBalance());
		return accountService.saveAccount(account);
	}
	
}
