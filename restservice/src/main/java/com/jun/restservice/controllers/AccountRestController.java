package com.jun.restservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.restservice.dto.AccountUpdateRequest;
import com.jun.restservice.entities.Account;
import com.jun.restservice.services.AccountService;

@RestController
@CrossOrigin
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts/{id}")
	public Account findAccountById(@PathVariable("id") Long id) {
		return accountService.getAccountById(id);
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountService.getAllAccounts();
		return accounts;
	}
	
	@PostMapping("/accounts")
	public Account updateAccount(@RequestBody AccountUpdateRequest request) {
		Account account = accountService.getAccountById(request.getId());
		account.setBalance(request.getBalance());
		return accountService.saveAccount(account);
	}
	
	@PostMapping("/accounts/save")
	public Account saveAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}
	
}
