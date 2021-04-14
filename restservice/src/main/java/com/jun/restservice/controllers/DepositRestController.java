package com.jun.restservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/deposits/{id}")
	public Deposit findDepositById(@PathVariable("id") Long id) {
		return depositService.findDepositById(id);
	}
	
	@GetMapping("/deposits")
	public List<Deposit> getAllDeposits() {
		return depositService.getAllDeposits();
	}
	
	@PostMapping("/deposits")
	public Deposit saveDeposit(@RequestBody Deposit deposit) {
		return depositService.saveDeposit(deposit);
	}
	
}
