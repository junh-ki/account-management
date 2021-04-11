package com.jun.cashtransaction.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.cashtransaction.integration.AccountRestClient;
import com.jun.cashtransaction.integration.dto.Account;

@Controller
public class AccountController {

	@Autowired
	private AccountRestClient accountRestClient;

	@RequestMapping("/saveAcc")
	public String saveAccount(@ModelAttribute("account") Account account, ModelMap modelMap) {
		
		
		// = accountRestClient.updateAccount(account);
		
		//Account accountSaved = accountService.saveAccount(account);
		//String msg = "Account saved with id: " + accountSaved.getId();
		//modelMap.addAttribute("msg", msg);
		//modelMap.addAttribute("holderId", accountSaved.getHolderId());
		return "createAccount";
	}

	@RequestMapping("/displayAccs")
	public String displayAccounts(@RequestParam("holderId") Long id, ModelMap modelMap) {
		List<Account> accounts = accountRestClient.findAccountsByHolderId(id);
		modelMap.addAttribute("accounts", accounts);
		return "displayAccounts";
	}

}
