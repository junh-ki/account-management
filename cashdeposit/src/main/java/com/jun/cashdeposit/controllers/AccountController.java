package com.jun.cashdeposit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.cashdeposit.integration.dto.Account;
import com.jun.cashdeposit.integration.dto.Deposit;
import com.jun.cashdeposit.integration.AccountRestClient;
import com.jun.cashdeposit.integration.DepositRestClient;

@Controller
public class AccountController {

	@Autowired
	private AccountRestClient accountRestClient;
	
	@Autowired
	private DepositRestClient depositRestClient;

	@RequestMapping("/showCreate")
	public String createAccount(@RequestParam("userId") Long id, ModelMap modelMap) {
		modelMap.addAttribute("holderId", id);
		return "createAccount";
	}

	@RequestMapping("/saveAcc")
	public String saveAccount(@ModelAttribute("account") Account account, ModelMap modelMap) {
		Account accountSaved = accountRestClient.saveAccount(account);
		String msg = "Account saved with id: " + accountSaved.getId();
		Double initialBalance = accountSaved.getBalance();
		if (initialBalance > 0) {
			Deposit deposit = new Deposit();
			deposit.setAccountId(accountSaved.getId());
			deposit.setAmount(initialBalance);
			Deposit savedDeposit = depositRestClient.saveDeposit(deposit);
			msg = msg + " / The initial deposit amount of " + initialBalance + " " 
					+ accountSaved.getCurrency() + " / Initial Deposit ID: " + savedDeposit.getId();
		}
		modelMap.addAttribute("msg", msg);
		modelMap.addAttribute("holderId", accountSaved.getHolderId());
		return "createAccount";
	}

	@RequestMapping("/displayAccs")
	public String displayAccounts(@RequestParam("holderId") Long id, ModelMap modelMap) {
		List<Account> accounts = accountRestClient.findAccountsByHolderId(id);
		modelMap.addAttribute("accounts", accounts);
		return "displayAccounts";
	}

}
