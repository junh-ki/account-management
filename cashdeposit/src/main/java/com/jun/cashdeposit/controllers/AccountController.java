package com.jun.cashdeposit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.cashdeposit.entities.Account;
import com.jun.cashdeposit.services.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping("/showCreate")
	public String createAccount(@RequestParam("userId") Long id, ModelMap modelMap) {
		modelMap.addAttribute("holderId", id);
		return "createAccount";
	}

	@RequestMapping("/saveAcc")
	public String saveAccount(@ModelAttribute("account") Account account, ModelMap modelMap) {
		Account accountSaved = accountService.saveAccount(account);
		String msg = "Account saved with id: " + accountSaved.getId();
		modelMap.addAttribute("msg", msg);
		modelMap.addAttribute("holderId", accountSaved.getHolderId());
		return "createAccount";
	}

	@RequestMapping("/displayAccs")
	public String displayAccounts(@RequestParam("holderId") Long id, ModelMap modelMap) {
		List<Account> accounts = accountService.getAccountsOfUser(id);
		modelMap.addAttribute("accounts", accounts);
		return "displayAccounts";
	}

}
