package com.jun.cashdeposit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jun.cashdeposit.repos.AccountRepository;
import com.jun.cashdeposit.services.DepositService;

@Controller
public class DepositController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private DepositService depositService;
	
	//TODO: RequestMapped methods need to be implemented from here
	
}
