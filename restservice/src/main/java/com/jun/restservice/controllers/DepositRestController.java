package com.jun.restservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.restservice.entities.Deposit;
import com.jun.restservice.services.DepositService;

@RestController
@CrossOrigin
public class DepositRestController {

	@Autowired
	private DepositService depositService;
	
	@PostMapping("/deposits")
	public Deposit saveDeposit(@RequestBody Deposit deposit) {
		return depositService.saveDeposit(deposit);
	}
	
}
